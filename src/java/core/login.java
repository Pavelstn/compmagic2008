package core;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.servlet.http.HttpServletResponse;
import core.abstractTemplateServlet;
import logic.Hash;
import core.CleanREQ;
import core.CleanSES;

public class login extends abstractTemplateServlet {

   // private HttpServletResponse resp;

    public void process() {
        try {

            String login = cleanRequest.getParam("login");
            String password = cleanRequest.getParam("password");

           // CleanSES cleanSession = new CleanSES();
           // cleanSession.setResponce(session);

            Hash hashString = new Hash();
            String param = "";
           // resp= new HttpServletResponse();

                    if (login != null && password != null) {
                if (hashString.Hash("user") == hashString.Hash(login) && hashString.Hash("ultktnbv") == hashString.Hash(password)) {
                    session.setAttribute("access", "granted");
                    param = cleanSession.getParam("loginpath");
                    if (!param.equals("")) {
                        try {
                            res.sendRedirect(param);
                        } catch (IOException ex) {
                            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            res.sendRedirect("./admin");
                        } catch (IOException ex) {
                            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

        } finally {
            //out.close();
        }
    }

    public void startTemplate() {
        
        process();
        templateFile = "login.html";

    }
}
