package admin;

import core.abstractTemplateServlet;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class admin extends abstractTemplateServlet {

    private String mode;
    private String action;
    private String id;

    private void process() {
        String acss = cleanSession.getParam("access");
        if (!acss.equals("granted")) {
            redirect();
        }
    }

    private void process2() {
        this.mode = cleanRequest.getParam("mode");
        this.action = cleanRequest.getParam("action");
        this.id = cleanRequest.getParam("id");

        System.out.print(this.mode);
        System.out.print(this.action);
        System.out.print(this.id);
    }

    private void defaultAdmin() {
        templateFile = "admin.html";
        root.put("message", this.mode);
    }

    private void mainPage() {
        templateFile = "setmainpage.html";

        root.put("mode", this.mode);
    }

    private void pagework() {
        templateFile = "addpage.html";
        root.put("mode", this.mode);

        String titlepage = cleanRequest.getParam("titlepage");
        String anonspage = cleanRequest.getParam("anonspage");
        String textpage = cleanRequest.getParam("textpage");
        String addpage = cleanRequest.getParam("addpage");

        if (this.mode.equals("add")) {//Добавление новой страницы
            root.put("action", " ");
            root.put("titlepage", " ");
            root.put("anonspage", " ");
            root.put("textpage", " ");
        }

        if (this.mode.equals("add") && (!addpage.equals(""))) {//Сохранение новой страницы
            root.put("action", " ");
            root.put("titlepage", titlepage);
            root.put("anonspage", anonspage);
            root.put("textpage", textpage);
        }


//        if (!textpage.equals("")) {
//            root.put("action", textpage);
//            root.put("titlepage", titlepage);
//            root.put("anonspage", anonspage);
//            root.put("textpage", textpage);
//        } else {
//            root.put("action", this.action);
//        }

    }

    private void menuWork() {
        templateFile = "leftmenuadmin.html";
        root.put("mode", this.mode);
        root.put("action", this.action);
    }

    public void startTemplate() {
        process();
        process2();






//        if(this.mode.equals("page")){
//            templateFile = "addpage.html";
//            root.put("mode", this.mode);
//            root.put("action", this.action);
//        }else {
//            templateFile = "admin.html";
//            //templateFile = "addpage.html";
//            root.put("message", "dfgfg");
//          //  root.put("mode", mode);
//           // root.put("action", action);
//        }


//        switch (this.mode){
//            case "page": pagework();
//                break;
//            case "menu": menuWork();
//            default: defaultadmin();
//        }
        if (this.mode.equals("page")) {
            pagework();
        }
        if (this.mode.equals("menu")) {
            menuWork();
        }

        if (this.mode.equals("mainpage")) {
            mainPage();
        }

        if (this.mode.equals("admin")) {
            defaultAdmin();
        }


    }
}