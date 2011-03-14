/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

/**
 *
 * @author pavel
 */
public class Hash {
    
    public int Hash(String val) {
    int hash = 0;
    for (char c: val.toCharArray()) {
	hash = c + (hash << 6) + (hash << 16) - hash;
    }
    return hash;
}


}
