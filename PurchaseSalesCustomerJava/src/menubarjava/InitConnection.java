/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menubarjava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class InitConnection {
    
    static Connection conn = null;
    
    public static Connection getConn() throws ClassNotFoundException, SQLException {
        try{
            // Open the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create InitConnection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "");
        } catch (Exception error) {
            System.out.println(" -- error :- " + error);
        }
        return conn;
    }
}
