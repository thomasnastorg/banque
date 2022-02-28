package view;

import Model.Client;
import Model.Compte;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
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
    private JTable table;
    private JList list1;


     static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://46.105.30.38:3306/projetBTS", "banque", "AlwM7$!9");
        } catch (SQLException e) {
                System.out.println("pas de connection possible avec la BDD");
                e.printStackTrace();
        }
        return con;
    }


     static ArrayList<Client> getUsers(){
        ArrayList<Client> users = new ArrayList<Client>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        Client u;


        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM `banque`");
          System.out.println(rs);
            while (rs.next()){
                 u = new Client(

                         rs.getInt("id"),
                         rs.getString("nom"),
                         rs.getString("prenom"),
                         rs.getString("adress"));
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return users;
    }


    public void toto(){
        table = new JTable();
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
        table.setModel(model);
        System.out.println(getUsers().size());

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
        frame.setPreferredSize(new Dimension(500,500 ));
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
