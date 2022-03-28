package Controleur;

import Model.Client;
import Model.Compte;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import static Controleur.ClientSql.getConnection;

public class DataClient {
    private static String num1;

    public static ArrayList<Client> getUsers(){
        ArrayList<Client> users = new ArrayList<Client>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        Client u;


        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM `client`");
            System.out.println(rs);
            while (rs.next()){
                u = new Client(

                        rs.getInt("numero"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("adresse"));
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return users;
    }
    public static ArrayList<Compte> getCompt(int numComp){
        ArrayList<Compte> comptee = new ArrayList<Compte>();
        Connection con = getConnection();
        Statement stt;
        ResultSet rss;
        Compte b;


        try {
            stt = con.createStatement();
            rss = stt.executeQuery("Select c.numCompte,c.solde,ccour.decouvert,c.numclient from compte c, comptecourant ccour where c.numcompte = ccour.numcompte and c.numClient =" + numComp);
            System.out.println(rss);
            while (rss.next()){
                b = new Compte(

                        rss.getInt("numCompte"),
                        rss.getDouble("solde"),
                        rss.getDouble("decouvert"));
                        //rs.getInt("numclient"));
                System.out.println("ggggggg " + rss.getDouble("solde"));
                comptee.add(b);
                System.out.println("toto " +comptee.get(0).getNum());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return comptee;
    }
    public static DefaultTableModel comptClient(int comptTable){
        DefaultTableModel modelCompt = new DefaultTableModel();
        Object[] columnsName = new Object[3];
        columnsName[0] = "num du Compte";

        columnsName[1] = "Solde";
        columnsName[2] = "decouvert";
        //columnsName[3] = "num client";


        modelCompt.setColumnIdentifiers(columnsName);

        Object[] rowData = new Object[3];

        for (int i = 0; i < getCompt(comptTable).size(); i++){
            rowData[0] = getCompt(comptTable).get(i).getNum();

            rowData[1] = getCompt(comptTable).get(i).getSolde();
            rowData[2] = getCompt(comptTable).get(i).getDecouvert();
            //rowData[3] = getCompt(120).get(i).getClient().getNum();

            modelCompt.addRow(rowData);
        }

        //System.out.println(getUsers().size());
        return modelCompt;

    }
    public static Boolean update(int numero,String nom,String prenom,String adresse){
        String sql= "UPDATE client SET nom= '"+nom+"' ,prenom='"+prenom+"',adresse='"+adresse+"' WHERE client.numero = '"+numero+"'";
        try{
            System.out.println(numero+ " " + nom+ " "+ prenom+ " " + adresse);
            System.out.println(sql);
            Connection con =getConnection();
            Statement s = con.createStatement();
            s.executeUpdate(sql);
            return true;


        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
            return false;
        }
    }



}
