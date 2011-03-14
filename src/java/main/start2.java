/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import core.abstractTemplateServlet;

import logic.ShowRenderPage;
import logic.Public;


public class start2 extends abstractTemplateServlet {

    public void startTemplate() {
        /////Текст первой страницы
        ShowRenderPage showPage = new ShowRenderPage();
        Public pub = new Public();
        String page_id = "";
        page_id = pub.Public();
        showPage.ShowRenderPage(page_id);

////////Левое меню
        LeftMenu menuList = new LeftMenu();

////////Модель
       // Map root = new HashMap();
        root.put("menuList", menuList.getList());
        root.put("message", "ПРЕВЕД!!!");
        root.put("mainText", showPage.showTextPage());

        templateFile="index2.html";
    }
}
