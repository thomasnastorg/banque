package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Controleur.DataClient.*;


public class user {



    public  JTextField textField1;
    public JTextField textField2;
    public JTextField textField3;
    public JTextField textField4;
    private JButton validerButton;
    JFrame User;
    public JPanel jpuser;
    private JLabel myNum;
    private JLabel muNom;
    private JLabel myPrenom;
    private JLabel myAdresse;
    private static String num1;


    user(){
        initializa();


        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update(Integer.parseInt(textField1.getText()),textField2.getText(),textField3.getText(),textField4.getText());

            }
        });
    }

    private void initializa(){
        User = new JFrame("User");
        User.setContentPane(jpuser);
        User.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        User.setSize(10000, 10000);
        User.pack();
        User.setLocationRelativeTo(null);

    }
}
