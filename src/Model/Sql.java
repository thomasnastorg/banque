package Model;

import java.sql.*;
import java.util.ArrayList;

public class Sql {




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

    public Boolean update(String numero,String nom,String prenom,String adresse){
        String sql= "UPDATE client SET numero='"+numero+"',nom='"+nom+"',prenom='"+prenom+"',adresse='"+adresse+"'";
        try{
            Connection con =getConnection();
            Statement s = con.createStatement();
            s.executeQuery(sql);
            return true;


        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
