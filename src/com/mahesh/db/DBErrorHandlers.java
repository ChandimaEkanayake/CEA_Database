/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahesh.db;

import java.sql.SQLException;

/**
 *
 * @author CST Labs
 */
public class DBErrorHandlers {

    public static void DriverFailError(ClassNotFoundException ex) {
        MessagingCore.showErrorMessage("Database Driver Failure!\nContact Technical Support For More Details ", "Critical System Error!");
        ErrorLog.getInstance().logDriverFailError(ex);
        System.exit(0);
    }

    public static void SQLException(SQLException ex) {
        MessagingCore.showErrorMessage("Database Connectivity Error!\nPlease Check The Internet Connection.\nError: " + ex.getMessage(), "Database Connection Error!");
        ErrorLog.getInstance().logSQLError(ex);
        ConnectionManager.getInstance().closeConnection();
    }
}
