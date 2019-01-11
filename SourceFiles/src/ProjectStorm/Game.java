package ProjectStorm;

import java.awt.EventQueue;
import java.awt.*; //Used for Dimension value type and Toolkit (Screen Resolution)
import javax.swing.*;

import static java.awt.Color.black;

public class Game extends JFrame {
    public Game(){
        initUI();
    }

    private void initUI(){
        add(new Window());
        Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
        double width = resolution.getWidth();
        double height = resolution.getHeight();
        setSize((int) width,(int) height);
        setTitle("Project Storm - Debug v0.0.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Perhaps I could change this, so that it asks to save the game.
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Game game = new Game();
            game.setVisible(true);
        });
    }
}
