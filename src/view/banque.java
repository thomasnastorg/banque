package view;

import Model.Client;
import Model.Compte;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JButton update;
    private JList list1;




    private Boolean toto = false;
    private ArrayList<Compte> Lc = new ArrayList<Compte>();

    public banque() {
        button1.setVisible(false);
        textField1.setVisible(false);
        etat.setVisible(false);

        Client cl1 = new Client(1,"nastorg","thomas","20 rue des cavee feucheurolles");
        Compte c1 = new Compte(1,cl1);

        Client cl2 = new Client(2,"cc","jj","ss");
        Compte c2 = new Compte(2,cl2);
        Compte c3 = new Compte(3,cl2);

        Lc.add(c1);
        Lc.add(c2);
        Lc.add(c3);
        System.out.println((c1.toString()));



        myCredit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etat.setVisible(true);
                etat.setText("Montant a créditer");
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


        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel listModel = new DefaultListModel();
                for (Compte c: Lc ) {
                    listModel.addElement(c.toString());
                }
                /*
                for (int i = 0; i < 10; i++) {
                    listModel.addElement("item : " + i);
                }*/
                list1.setModel(listModel);
            }
        });
    }

    private void refreceh(DefaultListModel test){
       /* for (Compte c: Lc  ) {

            test.addElement(toString());

        }
        test.addElement("toto");
        liste.setModel(test);*/
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
