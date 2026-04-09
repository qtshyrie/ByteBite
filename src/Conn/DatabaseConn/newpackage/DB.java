package Conn.DatabaseConn.newpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author RAM
 */
public class DB {

    public static Connection con = null;

    public static void loadConnection(String DBName, String username , String pass) {
        String url = "jdbc:mysql://localhost:3306/" + DBName;
        String user = username;
        String password = pass;

        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
        }
    }
}