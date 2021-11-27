import javax.swing.*;

import java.awt.*;

public class banque {
    private JButton button1;
    private JTextField textField1;
    private JTextArea textArea1;
    private JPanel jpmain;
    private JMenu operation;
    private JMenu modification;
    private JMenuItem Créditer;
    private JLabel etat;

    public banque() {
        button1.setVisible(false);
        textArea1.setVisible(false);
        textField1.setVisible(false);
        etat.setVisible(false);



    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("uipendu");
        frame.setContentPane(new banque().jpmain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(10000,10000);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);



    }
}
