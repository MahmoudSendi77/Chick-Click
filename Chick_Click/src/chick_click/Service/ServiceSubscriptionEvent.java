/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chick_click.Service;

import chick_click.Entite.Events;
import chick_click.Utils.DataSource;
import chick_click.Utils.SubscribeEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mahmoud
 */
public class ServiceSubscriptionEvent {
    
    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    
    public ServiceSubscriptionEvent() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
    
    public void addSubscription(int ids, int ide) throws SQLException{
        
      String requete = "INSERT INTO `event_subscriptions` (`event_id`,`user_id`) "
              + "VALUES ('"+ide+"','"+ide+"');";
   int ii  = ste.executeUpdate(requete, Statement.RETURN_GENERATED_KEYS);
       
    }
    
    public void deletSubscription(SubscribeEvent se) throws SQLException{
        String query = "delete from event_subscriptions where event_id = ? and user_id = ?;";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt(1, se.getEvent_id());
      preparedStmt.setInt(2, se.getUser_id());

      // execute the preparedstatement
      preparedStmt.execute();
        System.out.println("delete done !!!!!!!");
    }
    
    public int nbrSubscriptionEvent(int id) throws SQLException{
        int i=0;
          String query = "select count(*) from event_subscriptions where event_id = ? ;";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, id);
        ResultSet res=preparedStmt.executeQuery();
        while(res.next()){
        i=res.getInt(1);
        }
        return i;
    }
    
}
