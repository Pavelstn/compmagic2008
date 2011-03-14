/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.util.*;

/**
 *
 * @author pavel
 */
public class list {

    private String ru;
    private String en;

    list(String ru, String en) {
        this.en = en;
        this.ru = ru;
    }

    public String getEn() {
        return this.en;
    }

    public String getRu() {
        return this.ru;
    }
}
