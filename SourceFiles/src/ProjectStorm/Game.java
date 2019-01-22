package ProjectStorm;

import java.awt.EventQueue;
import java.awt.*; //Used for Dimension value type and Toolkit (Screen Resolution)
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
/*
The following PC port necessities HAVE BEEN properly implemented:
    -FPS Counter
    -Fullscreen Mode

The following PC port necessities NEED TO BE properly implemented:
    -Key Bindings
    -FPS Cap
*/
public class Game extends JPanel implements Runnable {
    private Thread runnerAnim;
    volatile boolean running = true;
    private final int DELAY = 25;
    private int totalFramesCount = 0;
    private int framesToDisplay = 0;
    private Timer timerForFPS = new Timer();
    private TimerTask updateFPS = new TimerTask(){
        @Override public void run(){
            framesToDisplay = totalFramesCount; //Setting a variable to display the current frame count every second
            //makes sure that the counter is only printed once every second.
            repaint(0,0,70,20); //This paints only the part of the screen displaying the frame rate counter rectangle.
            totalFramesCount = 0;
        }
    };

    public Game(){
        initGameBoard();
        timerForFPS.scheduleAtFixedRate(updateFPS,0,1000);
        //Debug Methods - Mouse click prints mouse location to the console
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                System.out.println("Mouse Location: (" + e.getX() + ", " + e.getY() + ")");
            }
        });
    }

    @Override public void addNotify(){
        super.addNotify();
        runnerAnim = new Thread(this);
        runnerAnim.start();
    }

    @Override public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawFPSRect(g);
        drawFPSCount(g);
    }
    
    private void drawFPSRect(Graphics g){
        int alpha = 127; //This variable controls transparency, with 127 being ~50% of the total (255).
        Color FPSRectangle = new Color(0,0,0,alpha); //This creates a black color with 50% transparency.
        //g.setColor(FPSRectangle);
        g.setColor(Color.RED);
        g.fillRect(0,0,70,20);
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
        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();
        //Animation Loop (Main Game Loop?)
        while(true){
            repaint();
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;
            if(sleep < 0) sleep = 2;
            try{
                Thread.sleep(2000);
                /*
                FPS Tips:
                    -Time is proportional to (1 / FPS)
                    -1 second (1000 ms) gives 2 FPS
                    -.5 seconds (500 ms) gives 4 FPS
                    -.25 seconds (250 ms) gives 8 FPS
                */
            }
            catch(InterruptedException e){}
            beforeTime = System.currentTimeMillis();
            totalFramesCount++;
        }
    }

    private void initGameBoard(){
        setBackground(Color.BLACK);
        //Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
        //int width = 1920;
        //int height = 975;
        //Dimension tempDimension = new Dimension(1920,975);
        //setPreferredSize(resolution);
    }
}
