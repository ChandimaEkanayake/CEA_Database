/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahesh.db;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author CST Labs
 */
public class ErrorLog {

    private static ErrorLog instance;
    private String filePath = "System Log\\log.fits";

    private ErrorLog() {

        instance = this;
    }

    public synchronized static ErrorLog getInstance() {

        if (instance == null) {
            new ErrorLog();

        }
        return instance;
    }

    private void writeLog(String message) {

        try {
            new File("System Log").mkdir();
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true)));
            out.write(message + "\r\n");
            out.close();
        } catch (IOException exception) {
            //MsgCore
        }
    }

    public void logSQLError(SQLException ex) {

        String message = prepareDateTimeString() + " -SQL Exception- " + ex.getMessage();
        System.out.println(message);
        writeLog(message);

    }

    public void logFileSystemError(Exception ex) {

        String message = prepareDateTimeString() + " -IO Exception- " + ex.getMessage();
        System.out.println(message);
        writeLog(message);

    }

    public void logDriverFailError(ClassNotFoundException ex) {

        String message = prepareDateTimeString() + " -File System Exception- " + ex.getMessage();
        System.out.println(message);
        writeLog(message);

    }

    private String prepareDateTimeString() {

        Calendar dateTime = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy - HH:mm:ss");
        return df.format(dateTime.getTime());

    }
}
