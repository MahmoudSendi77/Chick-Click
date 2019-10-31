/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chick_click.Service;

import chick_click.Entite.EventLocation;
import chick_click.Entite.Events;
import chick_click.Utils.DataSource;
import com.lynden.gmapsfx.javascript.object.LatLong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mahmoud
 */
public class ServiceLocationEvent {
    
     private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    
    public ServiceLocationEvent() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
    
    
     public void addEventLocation(EventLocation e) throws SQLException{
        
      String requete = "INSERT INTO `event_location` (`event_id`,`lattitude`,`longitude`) "
              + "VALUES ('"+e.getEvent_id()+"','"+e.getLattitude()+"','"+e.getLongitude()+"');";
   int ide  = ste.executeUpdate(requete, Statement.RETURN_GENERATED_KEYS);
       
    }
     
     public LatLong getLocation(int id){
         LatLong l=null;
          String query = "select * from event_location where event_id = ?;";
     
        try {
             PreparedStatement preparedStmt = con.prepareStatement(query);
             preparedStmt.setInt(1, id);
            ResultSet res=preparedStmt.executeQuery();

            while (res.next()) {
               l=new  LatLong( (double) res.getDouble(2),(double) res.getDouble(3)); 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         return l;
     }
      public void updateLocation(EventLocation ev) throws SQLException{
 //UPDATE `events` SET `Event_start_date`=[value-3],`Address`=[value-4],`Event_description`=[value-5],`Event_title`=[value-6],`Event_picture`=[value-7],`Event_end_date`=[value-8],`country`=[value-9],`categories`=[value-10],`event_houre`=[value-11] WHERE 1
        
        String query = "UPDATE `events` SET `event_id`=?,`lattitude`=?,"
                + "`longitude`= ? WHERE `event_id` = ?;";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt(1, ev.getEvent_id());
      preparedStmt.setInt(4, ev.getEvent_id());
      preparedStmt.setDouble(2, ev.getLattitude());
      preparedStmt.setDouble(3, ev.getLongitude());
 
    

      // execute the java preparedstatement
      preparedStmt.executeUpdate();
    }
     
     
     
     
    
    
}
