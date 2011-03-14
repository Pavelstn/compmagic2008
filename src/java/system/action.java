/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import freemarker.template.*;
import system.list;

/**
 *
 * @author pavel
 */
public class action extends HttpServlet {

    private Configuration cfg;

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

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();


        Map root = new HashMap();
//       root.put("message", "ПРЕВЕД!!!");
//       root.put("message.ru", "ПРЕВЕД!!!");
//       root.put("message.en", "SURPRISE!!!");

//        List list = new ArrayList();
//        list.add("red");
//        list.add("green");
//        list.add("blue");
//
//        Map message = new HashMap();
//        message.put("ru", "ПРЕВЕД!!!");
//        message.put("en", "SURPRISE!!!");
//
//
//        root.put("message", message);
//        root.put("theList", list);

////////////////////////////////////////////////////////////////
//
//        Map message = new HashMap();
//        message.put("ru", "ПРЕВЕД!!!");
//        message.put("en", "SURPRISE!!!");
//
//        List list = new ArrayList();
//        list.add(message);
//        list.add(message);
//        list.add(message);
///////////////////////////////////////////////////////////////

        List list = new ArrayList();

     //   Map msg= new list("Превед", "SURPRISE!!!");
        list.add(new list("Превед", "SURPRISE!!!"));
        list.add(new list("ффффффф", "vvvvvvv"));
//        list.add(message);
//        list.add(message);
/////////////////////////////////////////////////////////////
        // root.put("message", message);
        root.put("theList", list);




        // Get the templat object
        Template t = cfg.getTemplate("test.ftl");

        // Prepare the HTTP response:
        // - Use the charset of template for the output
        // - Use text/html MIME-type
        response.setContentType("text/html; charset=" + t.getEncoding());
        Writer out = response.getWriter();
//
        // Merge the data-model and the template

        try {
//            HttpServletRequest req = (HttpServletRequest) request;
//            String contextPath = req.getContextPath();
//            HttpServletResponse res = (HttpServletResponse) response;
//            // out.print(contextPath);
//          //  res.sendRedirect(contextPath + "/preved.jsp");
//
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet action</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet action at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
            t.process(root, out);
        // System.out.println(out.toString());
        //System.out.println(t.toString());

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
