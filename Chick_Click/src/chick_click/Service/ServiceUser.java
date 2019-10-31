/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chick_click.Service;

import chick_click.Entite.Events;
import chick_click.Entite.ProfileUser;
import chick_click.Entite.User;
import chick_click.Utils.CurrentUser;
import chick_click.Utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
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

   
    public int addUser(User u) throws SQLException{
        
      String requete ="INSERT INTO `user`(`user_id`, `email`, `password`, `pseudo`, `gender`, `date_creation`, `role`, `country`, `interrest`)"
              + " VALUES (NULL, '"+u.getEmail()+"', '"+u.getPassword()+"', '"+u.getPseudo()+"', '"+u.getGender()+"', '"+u.getDate_creation()+"', '"+u.getRole()+"', '"+u.getCountry()+"', '"+u.getInterrest()+"');";

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
    
    public List<User> readAll() throws SQLException
    {List<User> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from user");
    User user=null;
    while (res.next()) {  
      user =new User(res.getInt(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getDate(7),res.getString(8),res.getString(9));
      list.add(user);
        }
    return list;
    } 
    
    public int verifyLogin(String email ,String password) throws SQLException{
       String requete="select user_id,email,password from user ;";
        PreparedStatement preparedStmt = con.prepareStatement(requete);
      // execute the preparedstatement
        ResultSet rs = preparedStmt.executeQuery();
        
        while(rs.next()){
            if((rs.getString(2).equals(email))&& (rs.getString(3).equals(password))){
                
            return rs.getInt(1);
           // break ;
            }
        }
      
    return -1;
    }
    public boolean verifyPseudo(String pseudo) throws SQLException{
       String requete="select pseudo from user ;";
        PreparedStatement preparedStmt = con.prepareStatement(requete);
      // execute the preparedstatement
        ResultSet rs = preparedStmt.executeQuery();
        
        while(rs.next()){
            if((rs.getString(1).equals(pseudo))){
                
            return false;
           // break ;
            }
            
        }
      
    return true;
    }
    public boolean verifyEmail(String mail) throws SQLException{
       String requete="select email from user ;";
        PreparedStatement preparedStmt = con.prepareStatement(requete);
      // execute the preparedstatement
        ResultSet rs = preparedStmt.executeQuery();
        
        while(rs.next()){
            if((rs.getString(1).equals(mail))){
                
            return false;
           // break ;
            }
            
        }
      
    return true;
    }
    
    
    public String  getUserRole(int id) throws SQLException{
        String s="", requete="select role from user where user_id=? ;";
        PreparedStatement preparedStmt = con.prepareStatement(requete);
        preparedStmt.setInt(1, id);
        ResultSet rs =preparedStmt.executeQuery();
        if(rs.next()){
        return rs.getString(1);
        }
        return s;
        
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
    
//    public void updateEvent(Events ev) throws SQLException{
//       // event_id`,`user_id`,`event_date`, `address`, `event_description`,`event_title`,`event_picture
//        String query = "update events set event_date = ? where event_id = ?;";
//      PreparedStatement preparedStmt = con.prepareStatement(query);
//      preparedStmt.setInt   (2, ev.getEvent_id());
//      preparedStmt.setString(1, ev.getEvent_date());
//
//      // execute the java preparedstatement
//      preparedStmt.executeUpdate();
//    }
    
    public void loadProfile(int id){
        CurrentUser profile =CurrentUser.getInstance();
    String query = "select `email`, `pseudo`, `gender`, `role`, `photo_profile`, `phone` from user u inner join account a on a.user_id = u.user_id= where u.user_id =?;";
      PreparedStatement preparedStmt=null;
      
         try {
             preparedStmt = con.prepareStatement(query);
             preparedStmt.setInt(1, id);
             ResultSet rs = preparedStmt.executeQuery();
             while(rs.next()){
                 profile.setIdcurrentuser(id);
                  profile.setEmail(rs.getString(1));
                   profile.setPseudo(rs.getString(2));
                    profile.setGender(rs.getString(3));                     
                      profile.setRole(rs.getString(4));
                       profile.setPhoto_profile(rs.getString(5));
                        profile.setPhone(rs.getString(6));
                        
 
             
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
             
         }
    
    } 
    
    
      public void updateUser(User ev) throws SQLException{
          
        
        String query = "UPDATE `user` SET `user_id`=?,`email`=?,`password`=?,`pseudo`=?,"
                + "`gender`=?,`date_creation`=?,`role`=?,"
                + "`country`=?,`interrest`=? WHERE `user_id` = ?" +
"    ;";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt(10, ev.getUser_id());
      preparedStmt.setInt(1, ev.getUser_id());

      preparedStmt.setString(2, ev.getEmail());
      preparedStmt.setString(3, ev.getPassword());
      preparedStmt.setString(4, ev.getPseudo());
      preparedStmt.setString(5, ev.getGender());
      preparedStmt.setDate(6, (Date) ev.getDate_creation());
     
      preparedStmt.setString(7, ev.getRole());
      
      preparedStmt.setString(8, ev.getCountry());
      preparedStmt.setString(9, ev.getInterrest());
    

      // execute the java preparedstatement
      preparedStmt.executeUpdate();
    }
    
}
