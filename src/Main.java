import view.banque;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        banque ui = new banque();
        JPanel root = ui.getRootPanel();
        JFrame frame = new JFrame("Banque");
        frame.setContentPane(root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000,500 ));
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);



/*
        JMenuBar myMenuBar = new JMenuBar();
        frame.add(myMenuBar);
        myMenuBar.setBounds(0,0,1000,1000);
        JMenu MenuOperation = new JMenu("Operation");
        myMenuBar.add(MenuOperation);
        frame.setVisible(true);

*/

    }
}
