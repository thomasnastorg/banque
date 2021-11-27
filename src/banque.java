import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class banque {

    private JButton button1;
    private JTextField textField1;
    private JTextArea textArea1;
    private  JPanel jpmain;
    private JLabel etat;
    private JMenuBar myMenuBar;
    private JMenu MenuOperation;
    private JMenu MenuModification;
    private JMenuItem myDebiter;
    public JMenuItem myCredit;
    private JMenuItem myDecouvert;
    private JMenuItem myClient;
    private Boolean toto = false;

    public banque() {
        button1.setVisible(false);
        textField1.setVisible(false);
        etat.setVisible(false);


        myCredit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etat.setVisible(true);
                etat.setText("Montant a craditer");
                textField1.setVisible(true);
                button1.setVisible(true);
                button1.setText("crediter");
            }

        });
        myDebiter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etat.setVisible(true);
                etat.setText("Montant a debiter");
                textField1.setVisible(true);
                button1.setVisible(true);
                button1.setText("Debiter");
            }
        });

        myClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(toto == false ) {
                    JFrame frame1 = new JFrame("User");
                    frame1.setContentPane(new user().jpuser);
                    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame1.setSize(10000, 10000);
                    frame1.pack();
                    frame1.setVisible(true);
                    frame1.setLocationRelativeTo(null);
                    toto = true;
                }
            }
        });



    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Banque");
        frame.setContentPane(new banque().jpmain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(10000,10000);
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
