/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chick_click.Utils;

/**
 *
 * @author mahmoud
 */
public class CurrentUser {
     private static CurrentUser currentuser ;
     private int idcurrentuser;
      private CurrentUser() {
    }

    public int getIdcurrentuser() {
        return idcurrentuser;
    }

    public void setIdcurrentuser(int idcurrentuser) {
        this.idcurrentuser = idcurrentuser;
    }
      
       public static CurrentUser getInstance() {
        if (currentuser == null) {
            currentuser = new CurrentUser();
        }
        return currentuser;
    }
       
}
