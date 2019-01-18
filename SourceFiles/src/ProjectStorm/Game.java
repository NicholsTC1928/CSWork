package ProjectStorm;

import java.awt.EventQueue;
import java.awt.*; //Used for Dimension value type and Toolkit (Screen Resolution)
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
//FPS Counter Link: https://stackoverflow.com/questions/20769767/calculate-fps-in-java-game

public class Game extends JPanel implements Runnable {
    Thread runnerAnim;
    volatile boolean running = true;
    private final int DELAY = 25;
    int totalFramesCount = 0;
    Timer timerForFPS = new Timer();
    TimerTask updateFPS = new TimerTask(){
        @Override public void run(){
            repaint(0,0,40,10); //This paints only the part of the screen displaying the frame rate counter.
            totalFramesCount = 0;
        }
    };

    public Game(){
        initGameBoard();
        timerForFPS.scheduleAtFixedRate(updateFPS,1000,1000);
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
        drawFPS(totalFramesCount,g);
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void drawFPS(int totalFramesCount, Graphics g){
        int alpha = 127; //This variable controls transparency, with 127 being ~50% of the total (255).
        Color FPSRectangle = new Color(0,0,0,alpha); //This creates a black color with 50% transparency.
        g.setColor(FPSRectangle);
        g.fillRect(0,0,40,10);
        g.setColor(Color.GREEN);
        g.drawString(totalFramesCount + " FPS",0,0);
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
                Thread.sleep(sleep);
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
