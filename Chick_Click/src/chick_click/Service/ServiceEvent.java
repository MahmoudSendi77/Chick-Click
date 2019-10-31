/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chick_click.Service;

import chick_click.Entite.CommentDeatils;
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
    
    
    

   
    public int addEvent(Events e) throws SQLException{
        
        System.out.println("addd service event77777770000000000000000000000077777777");
        String requete = "INSERT INTO `events` (`event_id`,`user_id`,`event_start_date`, `address`, `event_description`,`event_title`,`event_picture`,`event_end_date`,`country`,`categories`,`event_houre`) "
              + "VALUES (NULL, '"+e.getUser_id()+"','"+e.getEvent_date()+"','"+e.getAddress()+"','"+e.getEvent_description()+"','"+e.getEvent_title()+"','"+e.getEvent_picture()+"','"+e.getEvent_end_date()+"','"+e.getCountry()+"','"+e.getCategories()+"', '"+e.getEvent_houre()+"');";
    
        ste.executeUpdate(requete, Statement.RETURN_GENERATED_KEYS);
        ResultSet keyResultSet = ste.getGeneratedKeys();
        int newId = 0;
        if (keyResultSet.next()) {
            newId = (int) keyResultSet.getInt(1);
        }
        System.out.println(newId);
       return newId;
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
    
    
    
//     public Events getEventByCountry(String id){
//        Events e =null;
//                  String query = "select * from events where event_id = ?;";
//     
//        try {
//             PreparedStatement preparedStmt = con.prepareStatement(query);
//             preparedStmt.setString(1, id);
//            ResultSet res=preparedStmt.executeQuery();
//
//            while (res.next()) {
//                e =new Events(res.getInt(1), res.getInt(2),res.getDate(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getDate(8),res.getString(9),res.getString(10),res.getString(11));
//                
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return e;
//    }
    

    public void deleteEvent(int id) throws SQLException{
    
      String query = "delete from events where event_id = ?;";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt(1, id);

      // execute the preparedstatement
      preparedStmt.execute();
        System.out.println("delete done !!!!!!!");
    }
    
    public List<Events> foundBYName(String name) throws SQLException{
    List<Events> list=new ArrayList<>();
    //String query ="select * from events where `envent_name` = ?;";
    ResultSet res=ste.executeQuery("select * from events where `envent_name` Like '%\" & name & \" %'\"");//Like '%" & TxtPrenom.Text & " %'"

      // execute the preparedstatement
    
    
    Events e=null;
    while (res.next()) {  
     e =new Events(res.getInt(1), res.getInt(2),res.getDate(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getDate(8),res.getString(9),res.getString(10),res.getString(11));
                
        list.add(e);
        }
        System.out.println(list);
    return list;
    }
    
    public List<Events> foundBYDesc(String name) throws SQLException{
    List<Events> list=new ArrayList<>();
    String query ="select * from events where lower(event_description) LIKE ? ";
    PreparedStatement preparedStmt = con.prepareStatement(query);
    preparedStmt.setString(1, "%" + name + "%");
    System.out.println("errrrrrrrrrrrrrrrrr");
     //preparedStmt.setString(1, name);

      // execute the preparedstatement
     ResultSet res=preparedStmt.executeQuery();
    
    Events e=null;
    while (res.next()) {  
     e =new Events(res.getInt(1), res.getInt(2),res.getDate(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getDate(8),res.getString(9),res.getString(10),res.getString(11));
                
        list.add(e);
        }
        System.out.println(list.toString());
    return list;
    }
    public List<Events> foundBYCountry(String name) throws SQLException{
    List<Events> list=new ArrayList<>();
    String query ="select * from events where `country` like %"+name+"%;";
    PreparedStatement preparedStmt = con.prepareStatement(query);
     // preparedStmt.setString(1, name);

      // execute the preparedstatement
     ResultSet res=preparedStmt.executeQuery();
    
    Events e=null;
    while (res.next()) {  
     e =new Events(res.getInt(1), res.getInt(2),res.getDate(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getDate(8),res.getString(9),res.getString(10),res.getString(11));
                
        list.add(e);
        }
    return list;
    }
     public List<Events> getEventBYCountry(String name) throws SQLException{
    List<Events> list=new ArrayList<>();
     Events e=null;
    String query ="select * from events where `country` = %"+name+"%;";
    PreparedStatement preparedStmt = con.prepareStatement(query);
     // preparedStmt.setString(1, name);

      // execute the preparedstatement
     ResultSet res=preparedStmt.executeQuery();
    
   
    while (res.next()) {  
     e =new Events(res.getInt(1), res.getInt(2),res.getDate(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getDate(8),res.getString(9),res.getString(10),res.getString(11));
                
        list.add(e);
        }
    String query1 ="select * from events where `country` <> %"+name+"%;";
    PreparedStatement preparedStmt1 = con.prepareStatement(query1);
     // preparedStmt1.setString(1, name);

      // execute the preparedstatement
     ResultSet res1=preparedStmt1.executeQuery();
    
   
    while (res1.next()) {  
     e =new Events(res1.getInt(1), res1.getInt(2),res1.getDate(3),res1.getString(4),res1.getString(5),res1.getString(6),res1.getString(7),res1.getDate(8),res1.getString(9),res1.getString(10),res1.getString(11));
                
        list.add(e);
        }
    return list;
    }
    
    public List<Events> foundBYDate(String name) throws SQLException{
    List<Events> list=new ArrayList<>();
    String query ="select * from events where `event_start_date` = %"+name+"%;";
    PreparedStatement preparedStmt = con.prepareStatement(query);
     // preparedStmt.setString(1, name);

      // execute the preparedstatement
     ResultSet res=preparedStmt.executeQuery();
    
    Events e=null;
    while (res.next()) {  
     e =new Events(res.getInt(1), res.getInt(2),res.getDate(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getDate(8),res.getString(9),res.getString(10),res.getString(11));
                
        list.add(e);
        }
    return list;
    }
    
    
    
    
    
    
    
    
    
    
    
    public void updateEvent(Events ev) throws SQLException{
 //UPDATE `events` SET `Event_start_date`=[value-3],`Address`=[value-4],`Event_description`=[value-5],`Event_title`=[value-6],`Event_picture`=[value-7],`Event_end_date`=[value-8],`country`=[value-9],`categories`=[value-10],`event_houre`=[value-11] WHERE 1
        
        String query = "UPDATE `events` SET `event_id`=?,`user_id`=?,`Event_start_date`= ?,`Address`=?,`Event_description`=?,"
                + "`Event_title`=?,`Event_picture`=?,`Event_end_date`=?,`country`=?,"
                + "`categories`=?,`event_houre`=? WHERE `event_id` = ?" +
"    ;";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt(12, ev.getEvent_id());
      preparedStmt.setInt(1, ev.getEvent_id());
      preparedStmt.setInt(2, ev.getUser_id());
      preparedStmt.setDate(3, ev.getEvent_date());
      preparedStmt.setString(4, ev.getAddress());
      preparedStmt.setString(5, ev.getEvent_description());
      preparedStmt.setString(6, ev.getEvent_title());
      preparedStmt.setString(7, ev.getEvent_picture());
      preparedStmt.setDate(8, ev.getEvent_end_date());
      preparedStmt.setString(9, ev.getCountry());
      
      preparedStmt.setString(10, ev.getCategories());
      preparedStmt.setString(11, ev.getEvent_houre());
    

      // execute the java preparedstatement
      preparedStmt.executeUpdate();
    }
    

    
}
