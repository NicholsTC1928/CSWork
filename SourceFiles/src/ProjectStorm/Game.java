package ProjectStorm;

import java.awt.EventQueue;
import java.awt.*; //Used for Dimension value type and Toolkit (Screen Resolution)
import javax.swing.*;
import java.awt.event.*;
//import java.lang.Math;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import ProjectStorm.InitializeWindow;

/*
The following PC port necessities HAVE BEEN properly implemented:
    -FPS Counter
    -Fullscreen Mode

The following PC port necessities NEED TO BE properly implemented:
    -Key Bindings
    -FPS Cap (Potentially Implemented - Testing Required)
    -Resolution Scaling
*/

public class Game extends JPanel implements Runnable {
    //The following two variables are used for key bindings.
    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    private static JLabel input = new JLabel();
    private boolean isInGame = false;
    private boolean isDebugModeOn;
    private boolean displayFPSCount;
    private boolean gameIsPaused;
    private final double SCALE_X;
    private final double SCALE_Y;
    private final double INV_SCALE_X;
    private final double INV_SCALE_Y;
    private Thread runnerAnim;
    volatile boolean running = true;
    private final int DELAY = 25;
    private int totalFramesCount = 0;
    private int framesToDisplay = 0;
    private final int FPS_CAP = 60;
    private boolean isBlack = true;
    private final long OPTIMAL_TIME = (1000000000 / FPS_CAP);
    private boolean gameIsRunning = true;
    public LinkedList<Object> currentEntities = new LinkedList<Object>();
    
    //The following consists of key binding variables. The non-final variables could be changed by reading a 
    //configuration value.
    private final String MOVE_UP = "Move Up";
    private final String MOVE_DOWN = "Move Down";
    private final String MOVE_LEFT = "Move Left";
    private final String MOVE_RIGHT = "Move Right";
    private final String SHOOT_UP = "Shoot Up";
    private final String SHOOT_DOWN = "Shoot Down";
    private final String SHOOT_LEFT = "Shoot Left";
    private final String SHOOT_RIGHT = "Shoot Right";
    private final String INTERACT = "Interact/Use";
    private final String HEAL = "Heal";
    private final String MELEE = "Melee";
    private final String PREVIOUS_WEAPON = "Previous Weapon";
    private final String NEXT_WEAPON = "Next Weapon";
    private final String WEAPON_1 = "Weapon 1";
    private final String WEAPON_2 = "Weapon 2";
    private final String WEAPON_MULE_KICK = "Weapon 3 (Mule Kick Weapon)";
    private final String CONSOLE = "Developer Console";
    //------------------------------------------------------------------//
    private String moveUpKey = "W";
    private String moveDownKey = "S";
    private String moveLeftKey = "A";
    private String moveRightKey = "D";
    private String shootUpKey = "UP";
    private String shootDownKey = "DOWN";
    private String shootLeftKey = "LEFT";
    private String shootRightKey = "RIGHT";
    private String interactKey = "F"; //More often than not, people will use "E" for this. Hence, key bindings are essential.
    private String healKey = "E";
    private String meleeKey = "V";
    private String previousWeaponKey = "X";
    private String nextWeaponKey = "C";
    private String weapon1Key = "1";
    private String weapon2Key = "2";
    private final String weaponMuleKickKey = "3";
    private String consoleKey = "`";

    private Timer timerForFPS = new Timer();
    private TimerTask updateFPS = new TimerTask(){
        @Override public void run(){
            if(!displayFPSCount) return;
            framesToDisplay = (totalFramesCount / 2);
            //I don't know why, but dividing the totalFramesCount by 2 fixes the FPS display.
            //Setting a variable to display the current frame count every second makes sure that the counter is only
            //printed once every second.
            repaint(0,0,70,20); //This paints only the part of the screen displaying the frame rate counter rectangle.
            totalFramesCount = 0;
        }
    };


    public Game(){
        initGameBoard();
        //startThreadForAnimation();
        //Could this thread fix the FPS fluctuations by forcing Java to use a high-resolution timer?
        Thread consistencyCheck = new Thread(){
            public void run(){
                try{
                    Thread.sleep(Long.MAX_VALUE);
                }
                catch(Exception e){}
            }
        };
        consistencyCheck.start();
        
        this.isDebugModeOn = InitializeWindow.getDebugModeState();
        this.displayFPSCount = InitializeWindow.getFPSCountState();
        this.SCALE_X = InitializeWindow.getScaleX();
        this.INV_SCALE_X = (1.0 / SCALE_X);
        this.SCALE_Y = InitializeWindow.getScaleY();
        this.INV_SCALE_Y = (1.0 / SCALE_Y);
        if(this.isDebugModeOn){
            this.isInGame = true;
            System.out.println("Debug Mode has been successfully activated.");
            //Debug Methods
            //Method 1: Mouse click prints mouse location to the console
            addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                System.out.println("Mouse Location: (" + e.getX() + ", " + e.getY() + ")");
            }
            });
            //End Method 1
        }
        timerForFPS.scheduleAtFixedRate(updateFPS,1000,1000);
    }

    @Override public void addNotify(){
        super.addNotify();
        runnerAnim = new Thread(this);
        runnerAnim.start();
    }

    @Override public void paintComponent(Graphics g){
        super.paintComponent(g);
        //FPSCheckDebug(g,this.isBlack);
        if(this.displayFPSCount){
        //drawFPSRect(g); - Is the rectangle really necessary with such a high-contrast FPS counter?
        drawFPSCount(g);
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.scale(SCALE_X,SCALE_Y); //The graphics scaling uses 1920 x 1080 as the default resolution. Keep this in
        //mind when determining how to scale certain objects.
        
        //Supposedly, scaling by the inverse of the normal scales fixes mouse coordinates.
        //g.scale(INV_SCALE_X,INV_SCALE_Y); //Remove the comment marks in order to test the aforementioned theory.
    }
    
    private void drawFPSRect(Graphics g){
        int alpha = 127; //This variable controls transparency, with 127 being ~50% of the total (255).
        Color FPSRectangle = new Color(0,0,0,alpha); //This creates a black color with 50% transparency.
        //g.setColor(FPSRectangle);
        g.setColor(Color.RED);
        g.fillRect(0,0,70,20);
        Toolkit.getDefaultToolkit().sync();
    }

    private void FPSCheckDebug(Graphics g,boolean isBlack){
        if(isBlack){
            g.setColor(Color.RED);
            this.isBlack = false;
        }
        else{
            g.setColor(Color.BLACK);
            this.isBlack = true;
        }
        g.fillRect(0,0,1920,975);
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawFPSCount(Graphics g){
        String currentFrameRate = this.framesToDisplay + " FPS";
        Font fpsDisplay = new Font("Helvetica",Font.PLAIN,18);
        g.setColor(Color.GREEN);
        g.setFont(fpsDisplay);
        g.drawString(currentFrameRate,0,15);
        Toolkit.getDefaultToolkit().sync();
    }

    private void startThreadForAnimation(){
        if(runnerAnim == null){
            runnerAnim = new Thread(this);
            runnerAnim.start();
        }
    }

    private void stopThread(){
        runnerAnim = null;
    }

    @Override public void run(){
        long beforeTime = System.nanoTime();
        //Animation Loop (Main Game Loop?)
        while(gameIsRunning){
            long now = System.nanoTime();
            long updateLength = now - beforeTime;
            beforeTime = now;
            double dt = (updateLength / (double)OPTIMAL_TIME);

            //Update the game logic here, using dt to determine the change in time.
            if(!gameIsPaused) updateGameLogic(dt);
            repaint();
            totalFramesCount++;
            
            //timeDiff = System.currentTimeMillis() - beforeTime;
            //sleep = DELAY - timeDiff;
            //if(sleep < 0) sleep = 2;
            try{
                Thread.sleep((System.nanoTime() - beforeTime + OPTIMAL_TIME) / 1000000);
                //if(fpsCap != 0) Thread.sleep((2 / fpsCap) * 1000); //This may be a successful implementation of an FPS cap.
                /*
                FPS Tips:
                    -Time is proportional to (1 / FPS)
                    -1 second (1000 ms) gives 2 FPS
                    -.5 seconds (500 ms) gives 4 FPS
                    -.25 seconds (250 ms) gives 8 FPS
                */
                //else Thread.sleep(sleep); //For an uncapped frame rate, should it be "Thread.sleep(0)" instead?
            }
            catch(InterruptedException e){}
            //beforeTime = System.currentTimeMillis();
        }
    }

    private void updateGameLogic(double dt){
        /*
        In this method, change the physics (speed of objects, etc.) by multiplying each physics-related variable by dt.
        This would mean having to make sure that each physics-related variable is a double (recommended), or that dt is
        cast as a type that is compatible with each physics-related variable.
        */
    }
    
    private void initGameBoard(){
        setBackground(Color.BLACK);
        //Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
        //int width = 1920;
        //int height = 975;
        //Dimension tempDimension = new Dimension(1920,975);
        //setPreferredSize(resolution);
    }
    
    private void initializeGameSpawn(){
        //The first thing that should be done is to scale the in-game measurement units with the screen resolution.
        double worldTopLeftX = 0.0;
        double worldTopLeftY = 0.0;
        double worldBottomRightX = 400.0;
        double worldBottomRightY = 400.0;
        double scaleWorldXToScreen = ((this.SCALE_X * 1920.0) / worldBottomRightX);
        double scaleWorldYToScreen = ((this.SCALE_Y * 1080.0) / worldBottomRightY);
        Player player = new Player();
        if (!isDebugModeOn) {
            //Load an image of the background if the player is not currently in debug mode.
        }
        else{
            //For debugging, use a white rectangle to represent the player.
        }

    }
    
    private void setInputMap(String key,String action){
        input.getInputMap(IFW).put(KeyStroke.getKeyStroke(key),action);
    }
    
    private void setActionMap(String action,AbstractAction actionObject){
        input.getActionMap().put(action,actionObject);
    }
    
    private void rebindKey(KeyEvent ke,String oldKey){
        input.getInputMap(IFW).remove(KeyStroke.getKeyStroke(oldKey));
        input.getInputMap(IFW).put(KeyStroke.getKeyStrokeForEvent(ke),input.getInputMap(IFW).get(KeyStroke.getKeyStroke(oldKey)));
    }
}
