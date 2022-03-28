package view;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static Controleur.DataClient.comptClient;
import static Controleur.DataClient.getUsers;



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
    private JScrollPane test;
    private JTable showClient;
    private String num;
    private String nom;
    private String prenom;
    private String adrss;



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
                    user sf = new user();
                    sf.User.setVisible(true);
                    sf.textField1.setText(num);
                    sf.textField2.setText(nom);
                    sf.textField3.setText(prenom);
                    sf.textField4.setText(adrss);
                    toto = true;
                }
                //set les champs text

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
                num =  showTable.getValueAt(showTable.getSelectedRow(),0).toString();
                nom =  showTable.getValueAt(showTable.getSelectedRow(),1).toString();
                prenom =  showTable.getValueAt(showTable.getSelectedRow(),2).toString();
                adrss =  showTable.getValueAt(showTable.getSelectedRow(),3).toString();
                System.out.println(num+ " " + nom +" " + prenom +" " + adrss);

                try {
                    showClient.setModel(comptClient(Integer.parseInt(num)));
                }catch (Exception h){
                    System.out.println(h);
                }


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
