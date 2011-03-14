/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

/**
 *
 * @author pavel
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class filter__ implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if ((session != null) && (session.getAttribute("access") != null)) {
            String param = session.getAttribute("access").toString();
            if (param.equals("granted")) {
                chain.doFilter(request, response);
            }
        } else {
            if (req.getRequestURI().equals(contextPath + "/admin/index.jsp") ||
                    req.getRequestURI().equals(contextPath + "/admin/editpage.jsp") ||
                    req.getRequestURI().equals(contextPath + "/admin/leftsidemenu.jsp") ||
                    req.getRequestURI().equals(contextPath + "/admin/makepages.jsp") ||
                    req.getRequestURI().equals(contextPath + "/admin/public.jsp") ||
                    req.getRequestURI().equals(contextPath + "/admin/showpage.jsp") ||
                    req.getRequestURI().equals(contextPath + "/admin") ||
                    req.getRequestURI().equals(contextPath + "/admin/listpages.jsp")) 
                
            {

                session.setAttribute("loginpath", req.getRequestURI());
               // res.sendRedirect(contextPath + "/login.jsp"); //редирект на логин
                res.sendRedirect(contextPath + "/servlet/login"); //редирект на логин
            } else {
                chain.doFilter(request, response);
            }
        }

    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
    }
}


