/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.*;

import java.util.*;
import freemarker.template.*;

import logic.ShowRenderPage;
import logic.Public;

import core.CleanREQ;
import core.CleanSES;

public abstract class abstractTemplateServlet extends HttpServlet {

    protected Configuration cfg;
    protected HttpServletRequest req;
    protected HttpServletResponse res;
    protected HttpSession session;
    protected String templateFile;
    protected Writer out;
    // protected Template t;
    protected Map root;
//    protected TemplateException e;
    protected CleanREQ cleanRequest;
    protected CleanSES cleanSession;

    @Override
    public void init() {
        cfg = new Configuration();
        cfg.setServletContextForTemplateLoading(getServletContext(), "WEB-INF/templates");
    }

//    protected void setRes(HttpServletResponse res) {
//        this.res = res;
//    }
        protected void redirect() {
        try {
            res.sendRedirect("./login");
        } catch (IOException ex) {
            Logger.getLogger(abstractTemplateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    abstract public void startTemplate();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.req = (HttpServletRequest) request;
        this.res = (HttpServletResponse) response;
        this.session = req.getSession();
        //this.out = response.getWriter();
        this.root = new HashMap();

        cleanRequest = new CleanREQ();
        cleanRequest.setResponce(req);

        cleanSession = new CleanSES();
        cleanSession.setResponce(session);


        //try {
        this.startTemplate();


        // Template t = cfg.getTemplate("index2.html");
        Template t = cfg.getTemplate(templateFile);

        response.setContentType("text/html; charset=" + t.getEncoding());
        //response.setContentType("text/html; charset=UTF-8");
        // Writer out = response.getWriter();
        this.out = response.getWriter();
        try {
            t.process(root, out);
        } catch (TemplateException e) {
            throw new ServletException("Error while processing FreeMarker template", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
            IOException {
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
            throws ServletException,
            IOException {
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
