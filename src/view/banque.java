package view;

import Model.Client;
import Model.Compte;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

import static Model.Sql.getUsers;


public class banque {

    private JButton button1;
    private JTextField textField1;
    private JTextArea textArea1;
    public JPanel jpmain;
    private JLabel etat;
    private JMenuBar myMenuBar;
    private JMenu MenuOperation;
    private JMenu MenuModification;
    private JMenuItem myDebiter;
    public JMenuItem myCredit;
    private JMenuItem myDecouvert;
    private JMenuItem myClient;
    private JButton update;
    private JTable showTable;
    private JTable table1;
    private JTable table;



    public JPanel getRootPanel(){
        return jpmain;
    }




    private void toto(){


        DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new Object[4];
        columnsName[0] = "num";
        columnsName[1] = "nom";
        columnsName[2] = "prenom";
        columnsName[3] = "adess";

        model.setColumnIdentifiers(columnsName);

        Object[] rowData = new Object[4];

        for (int i = 0; i < getUsers().size(); i++){
            rowData[0] = getUsers().get(i).getNum();
            rowData[1] = getUsers().get(i).getNom();
            rowData[2] = getUsers().get(i).getPrenom();
            rowData[3] = getUsers().get(i).getAdresse();

            model.addRow(rowData);
        }

        //System.out.println(getUsers().size());
        //System.out.println(getUsers().get(1));

        try {
            showTable.setModel(model);
        }catch (Exception h){
            System.out.println(h);
        }



    }


    private Boolean toto = false;
    private ArrayList<Compte> Lc = new ArrayList<Compte>();



    public banque() {

        button1.setVisible(false);
        textField1.setVisible(false);
        etat.setVisible(false);


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
                toto();
            }
        });
        //toto();

        showTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String num =  showTable.getValueAt(showTable.getEditingRow(),1).toString();
                String nom =  showTable.getValueAt(showTable.getEditingRow(),2).toString();
                String prenom =  showTable.getValueAt(showTable.getEditingRow(),3).toString();
                String adrs =  showTable.getValueAt(showTable.getEditingRow(),4).toString();


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


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
