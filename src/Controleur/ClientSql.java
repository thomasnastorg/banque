package Controleur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClientSql {

    static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://46.105.30.38:3306/comptes", "banque", "AlwM7$!9");
        } catch (SQLException e) {
            System.out.println("pas de connection possible avec la BDD");
            e.printStackTrace();
        }
        return con;
    }
}
