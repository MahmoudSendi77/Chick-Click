/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chick_click.Service;

import chick_click.Entite.Events;
import chick_click.Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author mahmoud
 */
public class ServiceEvent {
    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceEvent() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }

   
    public void addEvent(Events e) throws SQLException{
        
        
      String requete = "INSERT INTO `events` (`event_id`,`user_id`,`event_start_date`, `address`, `event_description`,`event_title`,`event_picture`,`event_end_date`,`country`,`categories`,`event_houre`) "
              + "VALUES (NULL, '"+e.getUser_id()+"','"+e.getEvent_date()+"','"+e.getAddress()+"','"+e.getEvent_description()+"','"+e.getEvent_title()+"','"+e.getEvent_picture()+"','"+e.getEvent_end_date()+"','"+e.getCountry()+"','"+e.getCategories()+"', '"+e.getEvent_houre()+"');";
   ste.executeUpdate(requete);
        System.out.println("elment inste");
    }
    public List<Events> getAll() throws SQLException
    {List<Events> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from events");
    Events event=null;
    while (res.next()) {  
      event =new Events(res.getInt(1), res.getInt(2),res.getDate(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getDate(8),res.getString(9),res.getString(10),res.getString(11));
      list.add(event);
        }
    return list;
    } 
    
    public Events getEventByID(int id){
        Events e =null;
                  String query = "select * from events where event_id = ?;";
     
        try {
             PreparedStatement preparedStmt = con.prepareStatement(query);
             preparedStmt.setInt(1, id);
            ResultSet res=preparedStmt.executeQuery();
            
            while (res.next()) {
                e =new Events(res.getInt(1), res.getInt(2),res.getDate(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getDate(8),res.getString(9),res.getString(10),res.getString(11));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    
    public void deleteEvent(int id) throws SQLException{
    
        String query = "delete from events where event_id = ?;";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt(1, id);

      // execute the preparedstatement
      preparedStmt.execute();
        System.out.println("delete done !!!!!!!");
    }
    
//    public List<Events> readBYName(String name){
//    List<Events> list=new ArrayList<>();
//    ResultSet res=ste.executeQuery("select * from events where `envent_name` = '"+name+"';");
//    Events event=null;
//    while (res.next()) {  
//      event =new Events(res.getInt(1), res.getInt(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7));
//      list.add(event);
//        }
//    return list;
//    }
    
    public void updateEvent(Events ev) throws SQLException{
 //UPDATE `events` SET `Event_start_date`=[value-3],`Address`=[value-4],`Event_description`=[value-5],`Event_title`=[value-6],`Event_picture`=[value-7],`Event_end_date`=[value-8],`country`=[value-9],`categories`=[value-10],`event_houre`=[value-11] WHERE 1
        
        String query = "UPDATE `events` SET `Event_start_date`= ?,`Address`=?,`Event_description`=?,"
                + "`Event_title`=?,`Event_picture`=?,`Event_end_date`=?,`country`=?,"
                + "`categories`=?,`event_houre`=? WHERE `event_id` = ?" +
"    ;";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt   (9, ev.getEvent_id());
      preparedStmt.setDate(1, ev.getEvent_date());
      preparedStmt.setString(2, ev.getEvent_description());
      preparedStmt.setString(3, ev.getEvent_title());
      preparedStmt.setString(4, ev.getEvent_picture());
      preparedStmt.setDate(5, ev.getEvent_end_date());
      preparedStmt.setString(6, ev.getCountry());
      
      preparedStmt.setString(7, ev.getCategories());
      preparedStmt.setString(8, ev.getEvent_houre());
    

      // execute the java preparedstatement
      preparedStmt.executeUpdate();
    }
    

    
}
