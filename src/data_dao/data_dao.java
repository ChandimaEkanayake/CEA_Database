/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data_dao;

import data.data;
import data.data_2;
import data.data_3;
import data.data_4;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.Connection;

/**
 *
 * @author CHANDIMA
 */
public class data_dao {

    private dbconnmanager dbconnmanager = null;

    public data_dao() {

        dbconnmanager = new dbconnmanager();
    }

    public boolean addMember(data da) throws SQLException {

        boolean result = false;
        Connection dbconn = null;




        try {

            dbconn = dbconnmanager.connect();
            Statement stmt = dbconn.createStatement();


            String query = "insert into store (fileno,dsdivi,gndivi,e,n,industry,name,address,activity,tele,email,epl,liceense,business,local,gsmd,eplno,fro,ww,sw,hasard,air,noice,vibra,pta,remark) values ('" + da.getFile() + "','" + da.getDsdivi() + "','" + da.getGndivi() + "','" + da.getE() + "','" + da.getN() + "','" + da.getIndustry() + "','" + da.getName_of_own() + "','" + da.getAddress() + "','" + da.getActivity() + "','" + da.getTelephone() + "','" + da.getEmail() + "','" + da.getEpl() + "','" + da.getLicense() + "','" + da.getBuisness() + "','" + da.getLocal() + "','" + da.getGsmb() + "','" + da.getEplno() + "','" + da.getDuration() + "','" + da.getWastew() + "','" + da.getSolidw() + "','" + da.getHasardw() + "','" + da.getAir() + "','" + da.getNoice() + "','" + da.getVibration() + "','" + da.getPta() + "','" + da.getRemark() + "')";

            int data = stmt.executeUpdate(query);

            if (data == 1) {
                result = true;

            } else {
                result = false;
            }


        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            dbconn.close();
        }
        return result;

    }

    public boolean updateMember(data da) throws SQLException {

        boolean result = false;
        Connection dbConn = null;

        try {

            dbConn = dbconnmanager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "UPDATE store SET fileno = '" + da.getFile() + "', dsdivi = '" + da.getDsdivi() + "', gndivi = '" + da.getGndivi() + "', e = '" + da.getE() + "', n = '" + da.getN() + "', industry = '" + da.getIndustry() + "', name = '" + da.getName_of_own() + "', address = '" + da.getAddress() + "', activity = '" + da.getActivity() + "', tele = '" + da.getTelephone() + "' , email = '" + da.getEmail() + "', epl = '" + da.getEpl() + "', liceense = '" + da.getLicense() + "', business = '" + da.getBuisness() + "', local = '" + da.getLocal() + "', gsmd = '" + da.getGsmb() + "', eplno = '" + da.getEplno() + "',fro = '" + da.getDuration() + "',ww = '" + da.getWastew() + "',sw = '" + da.getSolidw() + "',hasard = '" + da.getHasardw() + "',air = '" + da.getAir() + "',noice = '" + da.getNoice() + "',vibra = '" + da.getVibration() + "',pta = '" + da.getPta() + "',remark = '" + da.getRemark() + "' where fileno = '" + da.getFile() + "' ";

            int data = stmt.executeUpdate(query);

            if (data == 1) {
                result = true;
                System.out.println("true");

            } else {
                result = false;
                System.out.println("false");
            }





        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            dbConn.close();
        }
        return result;
    }

    public boolean delMember(data da) throws SQLException {

        boolean result = false;
        Connection dbconn = null;

        try {

            dbconn = dbconnmanager.connect();
            Statement stmt = dbconn.createStatement();

            String query = "delete from store where fileno = '" + da.getFile() + "' ";

            int data = stmt.executeUpdate(query);

            if (data == 1) {
                result = true;

            } else {
                result = false;
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            dbconn.close();
        }
        return result;
    }

    public Vector viewData() {

        Vector<Vector<String>> vecName = null;
        Connection dbConn = null;

        try {
            dbConn = dbconnmanager.connect();
            Statement stmt = dbConn.createStatement();


            String query = "SELECT fileno,dsdivi,gndivi,e,n,industry,name,address,activity,tele,email,epl,liceense,business,local,gsmd,eplno,fro,ww,sw,hasard,air,noice,vibra,pta,remark  FROM store ";
            ResultSet rs = stmt.executeQuery(query);
            vecName = new Vector<Vector<String>>();

            while (rs.next()) {
                Vector<String> vec = new Vector<String>();
                vec.add(rs.getString(1));
                vec.add(rs.getString(2));
                vec.add(rs.getString(3));
                vec.add(rs.getString(4));
                vec.add(rs.getString(5));
                vec.add(rs.getString(6));
                vec.add(rs.getString(7));
                vec.add(rs.getString(8));
                vec.add(rs.getString(9));
                vec.add(rs.getString(10));
                vec.add(rs.getString(11));
                vec.add(rs.getString(12));
                vec.add(rs.getString(13));
                vec.add(rs.getString(14));
                vec.add(rs.getString(15));
                vec.add(rs.getString(16));
                vec.add(rs.getString(17));
                vec.add(rs.getString(18));
                vec.add(rs.getString(19));
                vec.add(rs.getString(20));
                vec.add(rs.getString(21));
                vec.add(rs.getString(22));
                vec.add(rs.getString(23));
                vec.add(rs.getString(24));
                vec.add(rs.getString(25));
                vec.add(rs.getString(26));


                vecName.add(vec);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException);
        }
        return vecName;
    }

    public data_2 loginUser(String user_name, String id, String authority) throws SQLException {

        data_2 u = null;
        Connection dbconn = null;

        try {

            dbconn = dbconnmanager.connect();
            Statement stmt = dbconn.createStatement();

            String query = " SELECT user_name,id,authority FROM login_user where user_name = '" + user_name + "' AND id = '" + id + "' AND authority = '" + authority + "'";

            ResultSet se = stmt.executeQuery(query);

            if (se.next()) {

                u = new data_2();

                u.setUser_name(se.getString(1));
                u.setId(se.getString(2));
                u.setUser_name(se.getString(3));

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        dbconn.close();
        return u;

    }

    public boolean signIn(data_3 daa) throws SQLException {

        boolean result = false;
        Connection dbconn = null;



        try {

            dbconn = dbconnmanager.connect();
            Statement stmt = dbconn.createStatement();


            String query = "insert into login_user (user_name,id,authority,confirm_pass,YEAR,MONTH,date) values ('" + daa.getName() + "','" + daa.getPass() + "','" + daa.getAuth() + "','" + daa.getConpass() + "','" + daa.getYear() + "','" + daa.getMonth() + "','" + daa.getDate() + "') ";

            int data = stmt.executeUpdate(query);

            if (data == 1) {
                result = true;

            } else {
                result = false;
            }


        } catch (SQLException ep) {
            System.out.println(ep);
        } finally {
            dbconn.close();
        }
        return result;


    }

    public ArrayList packData() {

        ArrayList result = null;
        Connection dbconn = null;

        try {
            dbconn = dbconnmanager.connect();
            Statement stmt = dbconn.createStatement();

            String query = "SELECT fileno FROM store";

            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            result = new ArrayList();

            while (rs.next()) {
                String catName = rs.getString(1);
                System.out.println(catName);
                result.add(catName);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            dbconnmanager.con_close(dbconn);
        }
        return result;
    }

    public ArrayList sendData(data_4 da) {

        ArrayList result = null;
        Connection dbconn = null;

        try {
            dbconn = dbconnmanager.connect();
            Statement stmt = dbconn.createStatement();

            String query = "SELECT user_name FROM login_user ";

            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            result = new ArrayList();
            while (rs.next()) {

                String file = rs.getString(1);
                System.out.println(file);
                result.add(file);


            }


        } catch (Exception e) {
            System.out.println(e);
        } finally {
            dbconnmanager.con_close(dbconn);
        }

        return result;


    }
}
