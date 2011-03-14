/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import logic.DatabaseWork;
import java.sql.*;

public class Public {

    public String queryString = "";
    public DatabaseWork mytable = new DatabaseWork();

    public String Public() {

        this.queryString = "SELECT page_id FROM public LIMIT 1";
        String result = "";
        try {
            this.mytable.connect();
            ResultSet rs = mytable.executeSelect(this.queryString);
            while (rs.next()) {
                result += rs.getString(1);
            }
            this.mytable.disconnect();
        } catch (Exception e) {
            System.out.println("SQL execute Public");
        }
        return result;
    }

    public void writePublic(String page_id) {
        try {
            this.mytable.connect();
            this.queryString = "DELETE FROM public ";
            mytable.executeUpdate(this.queryString);
            this.queryString = "INSERT INTO public (page_id) values ('" + page_id + "')";
            mytable.executeUpdate(this.queryString);
            this.mytable.disconnect();
        } catch (Exception e) {
            System.out.println("SQL execute writePublic");
        }
    }

    public void createTable() {
        try {
            this.mytable.connect();
            this.queryString = "DROP TABLE IF EXISTS public";
            mytable.executeUpdate(this.queryString);
            this.queryString = "CREATE TABLE public (page_id VARCHAR(1024) )";
            mytable.executeUpdate(this.queryString);
            this.mytable.disconnect();
        } catch (Exception e) {
            System.out.println("SQL execute");
        }
    }
}
