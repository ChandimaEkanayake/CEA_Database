/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ims.ui.report;

import com.mahesh.db.ConnectionManager;
import data_dao.dbconnmanager;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ananda_Ekanayake
 */
public class MyiReportViewer extends javax.swing.JInternalFrame {

    public MyiReportViewer() 
{ 
super("Report Viewer",true,true,true,true); 
initComponents(); 
setBounds(10,10,600,500); 
setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
}

public MyiReportViewer(String fileName,HashMap parameter) 
{ 
this(); 
try {


    dbconnmanager dbconnmanager = new dbconnmanager();
    Connection con = dbconnmanager.connect();

JasperPrint print = JasperFillManager.fillReport(fileName, parameter, con);  

            JRViewer viewer = new JRViewer(print);
            Container c = getContentPane();
            c.setLayout(new BorderLayout());
            c.add(viewer); 
} 
catch(JRException jre) 
{ 
jre.printStackTrace(); 
} 


}

public void generateReports(String name, Map param, int id) {
      
        String print = name.substring(1);
        System.out.println("Type=" +print);
        JRDataSource con;
        Connection con2 = null;
        try {
            String source = "./report/" + name + ".jrxml";

            if (!new File(source).exists()) {
                System.out.println("AAAA"+source);
                return;
            }
            

            if (print.equals("1")) {
                con = new JREmptyDataSource();
                JasperReport jasperReport = JasperCompileManager.compileReport(source);
                
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, con);

                // System.out.println("Daone well");
                if (id == 0) {
                    JasperViewer.viewReport(jasperPrint, false);
                } else {
                    jasperPrint.setOrientation((byte) 1);
                    JasperPrintManager.printReport(jasperPrint, false);
                }
            } else {
                con2 =ConnectionManager.getInstance().getConnection();
                JasperReport jasperReport = JasperCompileManager.compileReport(source);
                
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, con2);

                
                if (id == 0) {
                    JasperViewer.viewReport(jasperPrint, false);
                } else {
                    jasperPrint.setOrientation((byte) 1);
                    JasperPrintManager.printReport(jasperPrint, false);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public MyiReportViewer(String fileName) 
{ 
this(fileName,null); 
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
