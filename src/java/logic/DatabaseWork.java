/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.*;
//import java.sql.*;
//import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pavel
 */
public class DatabaseWork {

    private String database = "20081581_1";
    private String user = "b20081581_1";
    private String password = "sFGieCgb";
    private String SQLString;
    private Statement stmt = null;
    public ResultSet rs = null;
    private Connection conn;

    public void connect() {
        String connString = "jdbc:mysql://localhost/" + this.database + "?" +
                "user=" + this.user + "&password=" + this.password;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception sqe) {
            System.out.println("Unexpected exception : " + sqe.toString());
            System.out.println("Load SQL Driver");
            System.exit(1);
        }
        try {

            this.conn = DriverManager.getConnection(connString);

        // Do something with the Connection
            stmt = conn.createStatement();

        // ...
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            System.out.println(connString);
        }

    }

    public ResultSet  executeSelect(String SQLString) {
        try {
            if (stmt.execute(SQLString)) {
                rs = stmt.getResultSet();
            }

        } catch (Exception e) {
            System.out.println("SQL executeSelect");
        }
        return (rs) ;
    }

    public void executeUpdate(String SQLString) {
        try {
            stmt.executeUpdate(SQLString);
          //  System.out.println(SQLString);


        } catch (Exception e) {
            System.out.println("SQL executeUpdate");
            System.out.println(SQLString);
        }
    }

    /*
    public void execute2(String SQLString) {
    try {
    
    if (stmt.execute(SQLString)) {
    this.rs = stmt.getResultSet();
    }
    } catch (Exception e) {
    System.out.println("SQL execute2");
    }
    }
     */
    /*
    public ResultSet getSQL(String queryString) {
    try {
    rs = stmt.executeQuery(queryString);
    } catch (Exception ex) {
    System.out.println("getSQL");
    ex.printStackTrace();
    }
    return (rs);
    }
     */
    public void disconnect() {
        try {
            //rs.close();
           // stmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println("disconnect");
        }
    }
}
