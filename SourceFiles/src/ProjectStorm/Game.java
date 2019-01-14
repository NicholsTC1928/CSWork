package ProjectStorm;

import java.awt.EventQueue;
import java.awt.*; //Used for Dimension value type and Toolkit (Screen Resolution)
import javax.swing.*;

public class Game extends JFrame implements Runnable {
    Thread runner;
    volatile boolean running = true;

    public Game(){
        initUI();
    }

    private void startThread(){
        if(runner == null){
            runner = new Thread(this);
            runner.start();
        }
    }

    private void stopThread(){
        running = false;
    }

    private void initUI(){
        add(new Window());
        Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
        double width = resolution.getWidth();
        double height = resolution.getHeight();
        setSize((int) width,(int) height);
        setTitle("Project Storm - Debug v0.0.0");
        setBackground(Color.black);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Perhaps I could change this, so that it asks to save the game.
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Game game = new Game();
            game.setVisible(true);
        });
    }
}
