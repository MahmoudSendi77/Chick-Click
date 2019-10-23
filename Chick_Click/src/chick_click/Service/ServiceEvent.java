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
        
        
      String requete = "INSERT INTO `events` (`event_id`,`user_id`,`event_date`, `address`, `event_description`,`event_title`,`event_picture`) "
              + "VALUES (NULL,5,'12/12/2012', '"+e.getAddress()+"', '"+e.getEvent_description()+"','exemple','image');";
   ste.executeUpdate(requete);
        System.out.println("elment inste");
    }
    public List<Events> readAll() throws SQLException
    {List<Events> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from events");
    Events event=null;
    while (res.next()) {  
      event =new Events(res.getInt(1), res.getInt(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7));
      list.add(event);
        }
    return list;
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
       // event_id`,`user_id`,`event_date`, `address`, `event_description`,`event_title`,`event_picture
        String query = "update events set event_date = ? where event_id = ?;";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt   (2, ev.getEvent_id());
      preparedStmt.setString(1, ev.getEvent_date());

      // execute the java preparedstatement
      preparedStmt.executeUpdate();
    }
    
//  public void ajouterPersonne2(Personne p) throws SQLException{  
//  String req="INSERT INTO `events` ( `nom`, `age`) VALUES (?,?)";
//  PreparedStatement pres=con.prepareStatement(req);
//  pres.setString(1, p.getNom());
//  pres.setInt(2, p.getAge());
//  
//  
//  pres.executeUpdate();
//      System.out.println("element inserer");
//  
//  }
    
}
