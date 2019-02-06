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
import java.lang.reflect.*;
import java.util.Iterator;

/*
The following PC port necessities HAVE BEEN properly implemented:
    -FPS Counter
    -Fullscreen Mode
    -FPS Cap (The physics remain constant, regardless of the frame rate! (Just be sure to add methods to the
    updateGameLogic(dt) method that modify all physics-related variables.))

The following PC port necessities NEED TO BE properly implemented:
    -Key Bindings
    -Resolution Scaling
    -V-Sync Toggle
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
    private final double SCALE_WORLD_X_TO_PIXELS;
    private final double SCALE_WORLD_Y_TO_PIXELS;
    private Thread runnerAnim;
    volatile boolean running = true;
    private final int DELAY = 25;
    private int totalFramesCount = 0;
    private int framesToDisplay = 0;
    private final int FPS_CAP = 60;
    private boolean isBlack = true;
    private final long OPTIMAL_TIME = (1000000000 / (FPS_CAP / 2)); //I don't know why, but dividing FPS_CAP by 2 caps
    //the game at the specified frame rate cap.
    private final double OPTIMAL_TIME_FOR_PHYSICS = (1000000000.0 / 60.0); //This means that the base physics should
    //be programmed with 60 FPS in mind, although testing with varying frame rates will be required.
    private boolean gameIsRunning = true;
    public LinkedList<MovableObject> currentEntities = new LinkedList<MovableObject>();
    public LinkedList<Projectile> currentProjectiles = new LinkedList<Projectile>();
    Player player = new Player();
    private boolean isMovingUp = false;
    private boolean isMovingDown = false;
    private boolean isMovingLeft = false;
    private boolean isMovingRight = false;
    private boolean isFacingUp = false;
    private boolean isFacingDown = true;
    private boolean isFacingLeft = false;
    private boolean isFacingRight = false;
    private boolean hasShotWeapon1 = false;
    private boolean hasShotWeapon2 = false;
    private boolean hasShotWeapon3 = false;
    private boolean weapon1Cooldown = false;
    private boolean weapon2Cooldown = false;
    private boolean weapon3Cooldown = false;
    
    //The following consists of key binding variables. The non-final variables could be changed by reading a 
    //configuration value.
    private final String MOVE_UP = "Move Up";
    private final String MOVE_UP_STOP = "Stop Move Up";
    private final String MOVE_DOWN = "Move Down";
    private final String MOVE_DOWN_STOP = "Stop Move Down";
    private final String MOVE_LEFT = "Move Left";
    private final String MOVE_LEFT_STOP = "Stop Move Left";
    private final String MOVE_RIGHT = "Move Right";
    private final String MOVE_RIGHT_STOP = "Stop Move Right";
    private final String SHOOT_UP = "Shoot Up";
    private final String SHOOT_DOWN = "Shoot Down";
    private final String SHOOT_LEFT = "Shoot Left";
    private final String SHOOT_RIGHT = "Shoot Right";
    private final String SLIDE = "Slide";
    private final String DOLPHIN_DIVE = "Dolphin Dive (Ph.D. Flopper)";
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
    private String slideKey = "SHIFT";
    private String dolphinDiveKey = "CONTROL";
    private String interactKey = "F"; //More often than not, people will use "E" for this. Hence, key bindings are essential.
    private String healKey = "E";
    private String meleeKey = "V";
    private String previousWeaponKey = "X";
    private String nextWeaponKey = "C";
    private String weapon1Key = "1";
    private String weapon2Key = "2";
    private final String weaponMuleKickKey = "3";
    private String consoleKey = "BACK_QUOTE"; //Supposedly, BACK_QUOTE represents `.

    private Timer timerForFPS = new Timer();
    private TimerTask updateFPS = new TimerTask(){
        @Override public void run(){
            if(!displayFPSCount) return;
            framesToDisplay = (totalFramesCount);
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

        //The following is a list of inputs that are assigned as the game starts.
        //Move Up
        setInputMap(moveUpKey,false,MOVE_UP); //input.getInputMap(IFW).put(moveUpKey,MOVE_UP);
        setActionMap(MOVE_UP,new MoveUpAction()); //input.getActionMap().put(MOVE_UP,new MoveUpAction());
        setInputMap(moveUpKey,true,MOVE_UP_STOP);
        setActionMap(MOVE_UP_STOP,new MoveUpRelease());
        //Move Down
        setInputMap(moveDownKey,false,MOVE_DOWN);
        setActionMap(MOVE_DOWN,new MoveDownAction());
        setInputMap(moveDownKey,true,MOVE_DOWN_STOP);
        setActionMap(MOVE_DOWN_STOP,new MoveDownRelease());
        //Move Left
        setInputMap(moveLeftKey,false,MOVE_LEFT);
        setActionMap(MOVE_LEFT,new MoveLeftAction());
        setInputMap(moveLeftKey,true,MOVE_LEFT_STOP);
        setActionMap(MOVE_LEFT_STOP,new MoveLeftRelease());
        //Move Right
        setInputMap(moveRightKey,false,MOVE_RIGHT);
        setActionMap(MOVE_RIGHT,new MoveRightAction());
        setInputMap(moveRightKey,true,MOVE_RIGHT_STOP);
        setActionMap(MOVE_RIGHT_STOP,new MoveRightRelease());
        //Shoot Up
        setInputMap(shootUpKey,false,SHOOT_UP);
        setActionMap(SHOOT_UP,new ShootUpAction());
        //Shoot Down
        setInputMap(shootDownKey,false,SHOOT_DOWN);
        setActionMap(SHOOT_DOWN,new ShootDownAction());
        //Shoot Left
        setInputMap(shootLeftKey,false,SHOOT_LEFT);
        setActionMap(SHOOT_LEFT,new ShootLeftAction());
        //Shoot Right
        setInputMap(shootRightKey,false,SHOOT_RIGHT);
        setActionMap(SHOOT_RIGHT,new ShootRightAction());
        //Weapon 1
        setInputMap(weapon1Key,false,WEAPON_1);
        setActionMap(WEAPON_1,new SwapEquippedWeapon(0));
        //Weapon 2
        setInputMap(weapon2Key,false,WEAPON_2);
        setActionMap(WEAPON_2,new SwapEquippedWeapon(1));
        //Weapon 3 (Mule Kick Weapon)
        setInputMap(weaponMuleKickKey,false,WEAPON_MULE_KICK);
        setActionMap(WEAPON_MULE_KICK,new SwapEquippedWeapon(2));
        
        /*
        The following inputs still need to be assigned:
            -Shoot Up/Down/Left/Right
            -Slide
            -Dolphin Dive
            -Interact
            -Heal
            -Melee
            -Previous Weapon
            -Next Weapon
            -Developer Console
        */
        add(input);
        
        setActionMap(MOVE_UP,new MoveUpAction());
        this.isDebugModeOn = InitializeWindow.getDebugModeState();
        this.displayFPSCount = InitializeWindow.getFPSCountState();
        this.SCALE_X = InitializeWindow.getScaleX();
        this.INV_SCALE_X = (1.0 / SCALE_X);
        this.SCALE_Y = InitializeWindow.getScaleY();
        this.INV_SCALE_Y = (1.0 / SCALE_Y);
        this.SCALE_WORLD_X_TO_PIXELS = (SCALE_X * 1920.0) / 400.0;
        this.SCALE_WORLD_Y_TO_PIXELS = (SCALE_Y * 1080.0) / 400.0;
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
        Graphics2D g2 = (Graphics2D) g;
        g2.scale(SCALE_X,SCALE_Y); //The graphics scaling uses 1920 x 1080 as the default resolution. Keep this in
        //mind when determining how to scale certain objects.

        //Supposedly, scaling by the inverse of the normal scales fixes mouse coordinates.
        //g.scale(INV_SCALE_X,INV_SCALE_Y); //Remove the comment marks in order to test the aforementioned theory.
        //FPSCheckDebug(g,this.isBlack);
        if(this.displayFPSCount){
        //drawFPSRect(g); - Is the rectangle really necessary with such a high-contrast FPS counter?
        drawFPSCount(g);
        }
        if(this.isInGame){
            drawPlayer(g);
            drawProjectiles(g);
        }

    }

    private void drawPlayer(Graphics g){
        //Replace the rectangle with the image of the player when it is ready.
        g.setColor(Color.BLACK);

        g.setColor(Color.WHITE);
        g.fillRect(scaleWorldToPixelsX(player.getCurrentXPos()),scaleWorldToPixelsY(player.getCurrentYPos()),50,70);
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawProjectiles(Graphics g){
        //Replace the rectangle with the image of the respective projectile.
        g.setColor(Color.BLUE);
        Iterator<Projectile> i = this.currentProjectiles.iterator();
        while(i.hasNext()){
            Projectile temp = i.next();
            g.fillRect(scaleWorldToPixelsX(temp.getCurrentXPos()),scaleWorldToPixelsY(temp.getCurrentYPos()),20,20);
            Toolkit.getDefaultToolkit().sync();
        }
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
            //System.out.println(updateLength);
            beforeTime = now;
            double dt = (updateLength / OPTIMAL_TIME_FOR_PHYSICS);
            if(dt == 0) dt = (60.0 / FPS_CAP); //This line prevents the physics from stalling if the game is running too fast (i.e.,
            //now - beforeTime ~= 0). In order for this to happen, the frame rate must be the same as the cap (hence
            //the calculation of FPS_CAP / 60).
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
        player.setSpeedX(player.getSpeedX() * player.getSpeedMultiplier() * dt);
        player.setSpeedY(player.getSpeedY() * player.getSpeedMultiplier() * dt);
        if(this.isDebugModeOn){
            System.out.println("dt: " + dt);
            //System.out.println(player.getSpeedX() + " / " + player.getSpeedY());
        }
        if(this.isMovingUp && !this.isMovingDown){
            player.changeCurrentYPosBy(player.getSpeedY() * -1.0);
            changeFacingDirection("Up");
        }
        else if(this.isMovingDown && !this.isMovingUp){
            player.changeCurrentYPosBy(player.getSpeedY());
            changeFacingDirection("Down");
        }
        if(this.isMovingLeft && !this.isMovingRight){
            player.changeCurrentXPosBy(player.getSpeedX() * -1.0);
            changeFacingDirection("Left");
        }
        else if(this.isMovingRight && !this.isMovingLeft){
            player.changeCurrentXPosBy(player.getSpeedX());
            changeFacingDirection("Right");
        }
        //The following two methods are required so that on the next loop of the updateGameLogic() method, the
        //preceding setSpeedX() and setSpeedY() methods set the speed based on its original value, rather than
        //what the loop set it to. (In other words, without these next two methods, the speed of the player
        //object would continue to decrease, approaching 0.)
        player.setSpeedX(player.getInitialSpeedX());
        player.setSpeedY(player.getInitialSpeedY());
        //Similar methods must be added for EVERY physics-related object; otherwise, the aforementioned problem will
        //occur.
        Iterator<Projectile> i = this.currentProjectiles.iterator();
        //LinkedList<Projectile> toRemove = new LinkedList<Projectile>();
        while(i.hasNext()){
            Projectile temp = i.next();
            double initialSpeedX = temp.getSpeedX();
            double initialSpeedY = temp.getSpeedY();
            temp.setSpeedX(temp.getSpeedX() * dt);
            temp.setSpeedY(temp.getSpeedY() * dt);
            temp.changeCurrentXPosBy(temp.getSpeedX());
            temp.changeCurrentYPosBy(temp.getSpeedY());
            temp.setSpeedX(initialSpeedX);
            temp.setSpeedY(initialSpeedY);
            if(temp.getCurrentXPos() <= -10.0 || temp.getCurrentXPos() >= 410.0 || temp.getCurrentYPos() <= -10.0 || temp.getCurrentYPos() > 410.0) temp = null;
        }
        //this.currentProjectiles.removeAll(toRemove);
    }
    
    private void initGameBoard(){
        setBackground(Color.BLACK);
        //Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
        //int width = 1920;
        //int height = 975;
        //Dimension tempDimension = new Dimension(1920,975);
        //setPreferredSize(resolution);
    }

    private int scaleWorldToPixelsX(double worldValue){
        return (int)(worldValue * SCALE_WORLD_X_TO_PIXELS);
    }

    private int scaleWorldToPixelsY(double worldValue){
        return (int)(worldValue * SCALE_WORLD_Y_TO_PIXELS);
    }

    private double scalePixelsToWorldX(double pixelValue){
        return (pixelValue * SCALE_X);
    }

    private double scalePixelsToWorldY(double pixelValue){
        return (pixelValue * SCALE_Y);
    }

    private void initializeGameSpawn(){
        //The first thing that should be done is to scale the in-game measurement units with the screen resolution.
        double worldTopLeftX = 0.0;
        double worldTopLeftY = 0.0;
        double worldBottomRightX = 400.0;
        double worldBottomRightY = 400.0;
        double scaleWorldXToScreen = (worldBottomRightX / (this.SCALE_X * 1920.0));
        double scaleWorldYToScreen = (worldBottomRightY / (this.SCALE_Y * 1080.0));
        if (!isDebugModeOn) {
            //Load an image of the background if the player is not currently in debug mode.
        }
        else{
            //For debugging, use a white rectangle to represent the player.
        }
        //The default player speed should allow the player to travel 200.0 units in 1 second. (?)
        
    }
    
    private void setInputMap(String key,boolean isReleaseAction,String action){
        this.input.getInputMap(IFW).put(KeyStroke.getKeyStroke(getKeyCodeFromString(key),0,isReleaseAction),action);
    }
    
    private void setActionMap(String action,AbstractAction actionObject){
        this.input.getActionMap().put(action,actionObject);
    }
    
    /*
    private void rebindKey(KeyEvent ke,String oldKey){
        this.input.getInputMap(IFW).remove(KeyStroke.getKeyStroke(oldKey));
        this.input.getInputMap(IFW).put(KeyStroke.getKeyStrokeForEvent(ke),input.getInputMap(IFW).get(KeyStroke.getKeyStroke(oldKey)));
    }
    */
    
    private int getKeyCodeFromString(String key){
        try{
            Field field = KeyEvent.class.getDeclaredField("VK_" + key);
            return field.getInt(null);
        }
        catch(NoSuchFieldException e){
            System.out.println("ERROR: The KeyEvent field specified does not exist. Did you type in the correct" +
                    "letter/name for the key? (See the moveUpKey, moveDownKey, etc. fields for correct examples.)");
            return -1;
        }
        catch(IllegalAccessException e){
            System.out.println("ERROR: Access to the field's integer value has been denied. If you are seeing this" +
                    "error, then you may need to implement a new method for defining keys.");
            return -1;
        }
    }

    private void changeFacingDirection(String direction){
        if(direction.equals("Up")){
            this.isFacingUp = true;
            this.isFacingDown = false;
            this.isFacingLeft = false;
            this.isFacingRight = false;
        }
        else if(direction.equals("Down")){
            this.isFacingUp = false;
            this.isFacingDown = true;
            this.isFacingLeft = false;
            this.isFacingRight = false;
        }
        else if(direction.equals("Left")){
            this.isFacingUp = false;
            this.isFacingDown = false;
            this.isFacingLeft = true;
            this.isFacingRight = false;
        }
        else{
            this.isFacingUp = false;
            this.isFacingDown = false;
            this.isFacingLeft = false;
            this.isFacingRight = true;
        }
    }

    private void createProjectilePlayer(String weaponName,int playerDY,int playerDX){
        /*
        The default constructor for a Projectile object is as follows:
        
        public Projectile(boolean isExplosive,double speedX,double speedY,double currentXPos,double currentYPos,int damage,double radius){
            ...
        }
        
        -------------------------------------------------------------------------------
        
        Alternatively, the following constructor can be used for non-explosive weapons:
        
        public Projectile(double speedX,double speedY,double currentXPos,double currentYPos,int damage){
            [This constructor refers to the first constructor, setting isExplosive to false and radius to -1.0.]
        }
        */
        switch(weaponName){
            case "M1911":
                currentProjectiles.add(new Projectile(false,(4.0 * playerDX),(4.0 * playerDY),player.getCurrentXPos(),player.getCurrentYPos(),15,-1.0));
                break;
                //return new Projectile(false,speedX,speedY,player.getCurrentXPos(),player.getCurrentYPos(),15,-1.0);
            default:
                break; //This should never happen.
        }
    }

    private void setWeaponShotState(){
        switch(player.getEquippedWeaponIndex()){
            case 0:
                this.hasShotWeapon1 = true;
        }
    }

    private class MoveUpAction extends AbstractAction{
        @Override public void actionPerformed(ActionEvent e){
            Game.this.isMovingUp = true;
            //player.changeCurrentYPosBy(player.getSpeedY() * direction);
        }
    }
    
    private class MoveUpRelease extends AbstractAction{
        @Override public void actionPerformed(ActionEvent e){
            Game.this.isMovingUp = false;
            if(Game.this.isDebugModeOn) player.printCurrentPositionInWorld();
        }
    }
    
    private class MoveDownAction extends AbstractAction{
        @Override public void actionPerformed(ActionEvent e){
            Game.this.isMovingDown = true;
        }
    }
    
    private class MoveDownRelease extends AbstractAction{
        @Override public void actionPerformed(ActionEvent e){
            Game.this.isMovingDown = false;
            if(Game.this.isDebugModeOn) player.printCurrentPositionInWorld();
        }
    }
    
    private class MoveLeftAction extends AbstractAction{
        @Override public void actionPerformed(ActionEvent e){
            Game.this.isMovingLeft = true;
        }
    }
    
    private class MoveLeftRelease extends AbstractAction{
        @Override public void actionPerformed(ActionEvent e){
            Game.this.isMovingLeft = false;
            if(Game.this.isDebugModeOn) player.printCurrentPositionInWorld();
        }
    }
    
    private class MoveRightAction extends AbstractAction{
        @Override public void actionPerformed(ActionEvent e){
            Game.this.isMovingRight = true;
        }
    }
    
    private class MoveRightRelease extends AbstractAction{
        @Override public void actionPerformed(ActionEvent e){
            Game.this.isMovingRight = false;
            if(Game.this.isDebugModeOn) player.printCurrentPositionInWorld();
        }
    }

    private class ShootUpAction extends AbstractAction{
        boolean hasShotEquippedWeapon = false;

        @Override public void actionPerformed(ActionEvent e){
            try {
                Field equippedWeaponShotCheck = Game.class.getDeclaredField("hasShotWeapon" + (player.getEquippedWeaponIndex() + 1));
                hasShotEquippedWeapon = equippedWeaponShotCheck.getBoolean(this);
            }
            catch(NoSuchFieldException ex){
                System.out.println("The specified field does not exist. (Is there a typo in the equippedWeaponShotCheck declaration?)");
            }
            catch(IllegalAccessException ex){
                System.out.println("Access to the hasShotWeaponX field has been denied. The program will likely crash now.");
            }
            if(!player.getIsEquippedWeaponAutomatic()){
                if(!hasShotEquippedWeapon){
                    createProjectilePlayer(player.getEquippedWeapon(),-1,0);
                }
                
            }
            else{
                
            }
        }
    }
    
    private class ShootUpRelease extends AbstractAction{
        @Override public void actionPerformed(ActionEvent e){
            
        }
    }
    
    private class ShootDownAction extends AbstractAction{
        @Override public void actionPerformed(ActionEvent e){
            createProjectilePlayer(player.getEquippedWeapon(),1,0);
        }
    }
    
    private class ShootLeftAction extends AbstractAction{
        @Override public void actionPerformed(ActionEvent e){
            createProjectilePlayer(player.getEquippedWeapon(),0,-1);
        }
    }
    
    private class ShootRightAction extends AbstractAction{
        @Override public void actionPerformed(ActionEvent e){
            createProjectilePlayer(player.getEquippedWeapon(),0,1);
        }
    }

    private class SwapEquippedWeapon extends AbstractAction{
        private int newIndex;

        public SwapEquippedWeapon(int newIndex){
            this.newIndex = newIndex;
        }

        @Override public void actionPerformed(ActionEvent e){
            player.swapEquippedWeapon(newIndex);
        }
    }
    
    /*
    private class MoveXAction extends AbstractAction{
        private double direction;
        
        public MoveXAction(double direction){
            this.direction = direction;
        }
        
        @Override public void actionPerformed(ActionEvent e){
            player.changeCurrentXPosBy(player.getSpeedX() * direction);
            if(Game.this.isDebugModeOn) player.printCurrentPositionInWorld();
    }
    */
}
