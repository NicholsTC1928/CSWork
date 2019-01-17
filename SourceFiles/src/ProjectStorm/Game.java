package ProjectStorm;

import java.awt.EventQueue;
import java.awt.*; //Used for Dimension value type and Toolkit (Screen Resolution)
import javax.swing.*;

public class Game extends JPanel implements Runnable {
    Thread runnerAnim;
    volatile boolean running = true;
    private final int DELAY = 25;

    public Game(){
        initGameBoard();
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
        while(runnerAnim != null){
            repaint();
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;
            if(sleep < 0) sleep = 2;
            try{
                Thread.sleep(sleep);
            }
            catch(InterruptedException e){}
            beforeTime = System.currentTimeMillis();
        }
    }

    private void initGameBoard(){
        setBackground(Color.BLACK);
        Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
        double width = resolution.getWidth();
        double height = resolution.getHeight();
        setPreferredSize((int) width,(int) height);
    }
}
