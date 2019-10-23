/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chick_click.Service;

import chick_click.Entite.Events;
import chick_click.Entite.User;
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
public class ServiceUser {
     private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceUser() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }

   
    public void addUser(User u) throws SQLException{
        
      String requete ="INSERT INTO `user`(`user_id`, `email`, `password`, `pseudo`, `gender`, `date_creation`, `role`)"
              + " VALUES (NULL, '"+u.getEmail()+"', '"+u.getPassword()+"', '"+u.getPseudo()+"', '"+u.getGender()+"', '"+u.getDate_creation()+"', '"+u.getRole()+"');";

         int rs = ste.executeUpdate(requete);
         System.out.println(rs);
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
    public boolean verifyLogin(String email ,String password) throws SQLException{
       String requete="select count(*) from user where email = ? and password = ?;";
        PreparedStatement preparedStmt = con.prepareStatement(requete);
        preparedStmt.setString(1, email);
        preparedStmt.setString(2, password);

      // execute the preparedstatement
        ResultSet rs = preparedStmt.executeQuery();
        if(rs.next()){
            return true;
        }
        else
       
    return false;
    }
    
    public void deleteUser(int id) throws SQLException{
    
        String query = "delete from user where user_id = ?;";
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
    
}