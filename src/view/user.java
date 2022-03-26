package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class user {



    private  JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton validerButton;
    public JPanel jpuser;
    private JLabel myNum;
    private JLabel muNom;
    private JLabel myPrenom;
    private JLabel myAdresse;
    private static String num1;


    user(){
    textField1.setText(num1);



    }

    public static void setData(String num){
        num1 = num;
    }
}
