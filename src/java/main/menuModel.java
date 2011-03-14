/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

/**
 *
 * @author pavel
 */
public class menuModel {
   
    private String text;
    private String link;
    menuModel(String text, String link){
        this.text= text;
        this.link= link;
    }

    public String getText(){
        return this.text;
    }

    public String getLink(){
        return this.link;
    }
}
