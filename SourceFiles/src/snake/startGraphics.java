package snake;

import java.util.*;
import javax.swing.*;

public class startGraphics {
    public void createWindow(){
        JFrame f = new JFrame();
        f.getContentPane().add(emptyLabel, BorderLayout.CENTER);
        f.setSize(800,600);
        f.setLayout(null);
        f.setVisible(true);
    }
}
