/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data_dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;



public class dbconnmanager {
    
    String sourceURL = new String();
    
   
        
    public dbconnmanager () {
        try {
            // Load JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Connection URL.
            sourceURL = null;
             System.out.println("database not found");
            sourceURL = "jdbc:mysql://localhost:3306/cea";
              System.out.println("database found");
             

        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println(classNotFoundException + "-----------Unable to load database driver classes");
        }
    }

    public Connection connect() {
        
        Connection dbConn = null;
        String name = "root";
        String password = "123";
        try {
            System.out.println("ready to get the connection");
            dbConn = DriverManager.getConnection(sourceURL, name, password);
            System.out.println("got connection");
            
        } catch (SQLException sQLException) {
            System.out.println(sQLException + "DB connection failure");
              
        }
        return dbConn;
    }

    public void con_close(Connection dbConn) {
        try {
            dbConn.close();
        } catch (SQLException sQLException) {
            System.out.println(sQLException + "DB connection closing failure"); 
        }
    }
    
}
