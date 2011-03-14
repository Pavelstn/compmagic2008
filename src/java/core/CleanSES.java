/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import javax.servlet.http.*;
import java.util.*;

/**
 *
 * @author pavel
 */
public class CleanSES extends CleanREQ {

//    @Override
    public void setResponce(HttpSession session) {
        Enumeration paramNames = session.getAttributeNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();

            String paramValue = session.getAttribute(paramName).toString();
            if (paramValue.length() == 0) {
            } else {
                this.existParams = true;
                this.allParams.put(paramName, paramValue);
            }
        }
    }
}
