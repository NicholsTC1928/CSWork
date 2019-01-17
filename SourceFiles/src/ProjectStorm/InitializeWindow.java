package ProjectStorm;

import javax.swing.*;
import java.awt.*;

public class InitializeWindow extends JFrame{
    public InitializeWindow(){
        initUI();
    }

    private void initUI(){
        add(new Game());
        setResizable(false);
        pack();
        setTitle("Project Storm (Debug Build)");
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Perhaps I could change this, so that it asks to save the game.
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            JFrame window = new InitializeWindow();
            window.setExtendedState(JFrame.MAXIMIZED_BOTH);
            window.setUndecorated(true);
            window.setVisible(true);
        });
    }
}
