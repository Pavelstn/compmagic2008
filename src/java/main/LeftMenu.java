/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

//import java.io.*;
import java.util.*;
import logic.DatabaseWork;
import java.sql.*;

public class LeftMenu {

    private List menuList = new ArrayList();

    LeftMenu() {
        DatabaseWork mytable = new DatabaseWork();
        try {
            mytable.connect();
            ResultSet rs = mytable.executeSelect("SELECT * FROM leftmenu");
            while (rs.next()) {
                menuList.add(new menuModel(rs.getString(4), rs.getString(3)));
            }
        } catch (Exception e) {
            System.out.println("SQL execute");
        }
    }

    public List getList() {
        return this.menuList;
    }
}
