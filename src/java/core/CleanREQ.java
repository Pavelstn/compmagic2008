/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author pavel
 */
import javax.servlet.http.*;
import java.util.*;

public class CleanREQ {

    public Map<String, String> allParams = new HashMap<String, String>();
    public boolean existParams = false;

    public void setResponce(HttpServletRequest request) {
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);

            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() == 0) {
                } else {
                    this.existParams = true;
                    allParams.put(paramName, paramValue);
                }
            }
        }
    }

    public String getParam(String paramName) {
        String out = "";
        if (this.existParams && this.allParams.containsKey((paramName))) {
            out += this.allParams.get(paramName);
        }
        return (out);
    }

    public String showAllParam() {
        String out = "";
        //allParams.size())
        for (int i = 1; i <= this.allParams.size(); i++) {
            out += this.allParams.get(i);
            out += "<br>\n";
        }
        return (out);
    }
}

