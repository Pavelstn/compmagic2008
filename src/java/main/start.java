/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import freemarker.template.*;

//import logic.DatabaseWork;
//import java.sql.*;

import logic.ShowRenderPage;
import logic.Public;

public class start extends HttpServlet {

    private Configuration cfg;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void init() {
        // Initialize the FreeMarker configuration;
        // - Create a configuration instance
        cfg = new Configuration();
        // - Templates are stoted in the WEB-INF/templates directory of the Web app.
        cfg.setServletContextForTemplateLoading(getServletContext(), "WEB-INF/templates");
    // In a real-world application various other settings should be explicitly
    // set here, but for the sake of brevity we leave it out now. See the
    // "webapp2" example for them.
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

/////Текст первой страницы
        ShowRenderPage showPage = new ShowRenderPage();
        Public pub = new Public();
        String page_id = "";
        page_id = pub.Public();
        showPage.ShowRenderPage(page_id);

////////Левое меню
        LeftMenu menuList  = new LeftMenu();

////////Модель
        Map root = new HashMap();
        root.put("menuList", menuList.getList());
        root.put("message", "ПРЕВЕД!!!");
        root.put("mainText", showPage.showTextPage());

        Template t = cfg.getTemplate("index2.html");

        response.setContentType("text/html; charset=" + t.getEncoding());
        Writer out = response.getWriter();

        try {
            t.process(root, out);
        } catch (TemplateException e) {
            throw new ServletException("Error while processing FreeMarker template", e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
