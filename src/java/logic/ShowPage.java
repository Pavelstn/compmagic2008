/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import logic.DatabaseWork;
import java.sql.*;
import ru.perm.kefir.bbcode.BBProcessor;

/**
 *
 * @author pavel
 */
public class ShowPage {

    public String queryString = "";
    public DatabaseWork mytable = new DatabaseWork();
    protected String titlepage = "";
    protected String anonspage = "";
    protected String textpage = "";
    private String page_id = "";
    private String parentmenu_id = "";
   

    public void ShowPage(String page_id) {
        
        this.mytable.connect();
        this.queryString = "SELECT page_id, parentmenu_id, titlepage, anonspage, textpage FROM pages WHERE page_id='" + page_id + "' LIMIT 1";
        try {
            ResultSet rs = mytable.executeSelect(this.queryString);
            while (rs.next()) {
                this.page_id = rs.getString(1);
                this.parentmenu_id = rs.getString(2);
                this.titlepage = rs.getString(3);
                this.anonspage = rs.getString(4);
                this.textpage = rs.getString(5);
            }
        } catch (Exception e) {
            System.out.println("SQL execute");
        }
    }

    public String showPage_id() {
        return this.page_id;
    }

    public String showParentmenu_id() {
        return this.parentmenu_id;
    }

    public String showTitlePage() {
            return this.titlepage;
    }

    public String showAnonsPage() {
            return this.anonspage;
    }

    public String showTextPage() {
            return this.textpage;
    }
}


