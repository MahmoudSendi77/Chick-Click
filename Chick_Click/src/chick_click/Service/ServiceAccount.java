
/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package chick_click.Service;

import chick_click.Entite.Account;
import chick_click.Entite.User;
import chick_click.Utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mahmoud
 */
public class ServiceAccount {
   private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceAccount() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
    
     public int addAccount(Account u) throws SQLException{
        
      String requete ="INSERT INTO `account`(`user_id`, `photo_profile`, `status`, `phone`)"
              + " VALUES ('"+u.getUser_id()+"', '"+u.getPhoto_profile()+"', '"+u.getStatus()+"', '"+u.getPhone()+"';";

          ste.executeUpdate(requete);

        System.out.println("elment inste");
         ResultSet keyResultSet = ste.getGeneratedKeys();
        int newId = 0;
        if (keyResultSet.next()) {
            newId = (int) keyResultSet.getInt(1);
        }
        System.out.println(newId);
        return newId;
        
    }
     
      public void updateUser(Account ev) throws SQLException{
        
        
        String query = "UPDATE `account` SET `user_id`=?,`photo_profile`=?,`status`=?,`phone`=? WHERE `user_id` = ?" +
"    ;";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt(5, ev.getUser_id());
      preparedStmt.setInt(1, ev.getUser_id());

      preparedStmt.setString(2, ev.getPhoto_profile());
      preparedStmt.setString(3, ev.getStatus());
      preparedStmt.setString(4, ev.getPhone());
      

      // execute the java preparedstatement
      preparedStmt.executeUpdate();
    }
     
     
    
     
}
