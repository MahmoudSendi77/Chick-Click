///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package chick_click.Service;
//
//
//import chick_click.Entite.Events;
//import chick_click.Entite.User;
//import chick_click.Utils.DataSource;
////import fxml.AuthentificationController;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.time.Instant;
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
////import utils.DataSource;
//
///**
// *
// * @author Houssem
// */
//public class EvennementService {
//
//   Connection c = DataSource.getInstance().getConnection();
//    Statement ste;
//  
//    
//      public EvennementService() {
//        try {
//            ste = c.createStatement();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
//  
//      public void creerEvennement(Events e) throws SQLException{
//         
//// String req2 = "select role from user where user_id = '"+AuthentificationController.test+"'  ";
////    String req2 =select
////     ResultSet  res =  ste.executeQuery(req2);
////    while(res.next()){
////   System.out.println(res.getString(1)); 
////if ("ka".equals(res.getString(1)))  {String req1="INSERT INTO `evenement` (`Descr_Event`, `Image_Event`,"
////              + " `Titre_Event`, `DATED_EVENT`, `DATEF_EVENT`,`EMPLACEMENT`,"
////              + "`Id_User`,`categorie_Event`,`nbr_place_E`) VALUES ('"+u.getDescr_Event()+"', "
////              + "'"+u.getImage_Event()+"', '"+u.getTitre_Event()+"','"+u.getDATED_EVENT()+"', '"+u.getDATEF_EVENT()+"', '"+u.getLocalisation()+"', '"+AuthentificationController.test+"', '"+u.getCategorie_Event()+"','"+u.getNbr_place_E()+"');  ";
////            ste.executeUpdate(req1);
////            System.out.println("elment inste");
////break;
////}
////else 
////    System.out.println("nnnn");
////    }
////         
//    }
//      
//       private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
//        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
//        return sDate;
//    }
//       
//       
//       
//       
//       public List<Events> showEvent() {
//      
//      List<Events> evennement = new ArrayList<>();
//      Events e = null ;
//      String req2="select * from events";
//      try {
//         
//         
//          ResultSet res=  ste.executeQuery(req2);
//          while (res.next()) { 
//              e = new Events();
////                      e.setId_Event(res.getInt("Id_Event"));
////                      e.setDescr_Event(res.getString("Descr_Event") );
////                      e.setImage_Event(res.getString("Image_Event") );
////                      e.setTitre_Event(res.getString("Titre_Event") );
////                      e.setLocalisation(res.getString("EMPLACEMENT") );
////                      e.setId_User(res.getInt("Id_User") );
////                     
////                      e.setCategorie_Event(res.getString("Categorie_Event") );
//                      Date d1 =res.getDate("DATED_EVENT"); 
//                      Date d2 =res.getDate("DATEF_EVENT"); 
//                      Instant instant = Instant.ofEpochMilli(d1.getTime());
//                      Instant instant1 = Instant.ofEpochMilli(d2.getTime());
//                      LocalDate date = instant.atZone(ZoneId.systemDefault()).toLocalDate();
//                      LocalDate date1 = instant1.atZone(ZoneId.systemDefault()).toLocalDate();
//              System.out.println(date);
//
//                   
//        
////                      e.setDATED_EVENT(date);
////                      e.setDATEF_EVENT(date1);
//              evennement.add(e);
//          }
//          
//      } catch (SQLException ex) {
//          System.out.println(ex.getMessage());
//      } 
//        
//     return evennement;
//    }
//
//   
//   
//       
//       
//        
////  public ArrayList<Evennement> getAllP() throws SQLException{
////        ArrayList<Evennement> retour = new ArrayList<Evennement>();
////        Statement stm = c.createStatement();
////        Evennement per=null;
////        String req = "SELECT * FROM `evenement` " ;
////        ResultSet resultat = stm.executeQuery(req);
////      while (resultat.next()) {   
////           Date d1 =resultat.getDate("DATED_EVENT"); 
////                      Date d2 =resultat.getDate("DATEF_EVENT"); 
////                      Instant instant = Instant.ofEpochMilli(d1.getTime());
////                      Instant instant1 = Instant.ofEpochMilli(d2.getTime());
////                      LocalDate date = instant.atZone(ZoneId.systemDefault()).toLocalDate();
////                      LocalDate date1 = instant1.atZone(ZoneId.systemDefault()).toLocalDate();
////                      
////      per=new Evennement(resultat.getString(2),resultat.getString(3),resultat.getString(4),date,date1,resultat.getString(7),resultat.getString(9),resultat.getInt(10));
////  
////      retour.add(per);
////        }
////  
////  return retour;
////  }
//       
//       
//       
////  public ArrayList<Evennement> getAllP1() throws SQLException{
////        ArrayList<Evennement> retour = new ArrayList<Evennement>();
////        Statement stm = c.createStatement();
////        Evennement per=null;
////        String req = "SELECT * FROM `evenement` where Id_User = '"+AuthentificationController.test+"' " ;
////        ResultSet resultat = stm.executeQuery(req);
////      while (resultat.next()) {   
////           Date d1 =resultat.getDate("DATED_EVENT"); 
////                      Date d2 =resultat.getDate("DATEF_EVENT"); 
////                      Instant instant = Instant.ofEpochMilli(d1.getTime());
////                      Instant instant1 = Instant.ofEpochMilli(d2.getTime());
////                      LocalDate date = instant.atZone(ZoneId.systemDefault()).toLocalDate();
////                      LocalDate date1 = instant1.atZone(ZoneId.systemDefault()).toLocalDate();
////                      
////      per=new Evennement(resultat.getString(2),resultat.getString(3),resultat.getString(4),date,date1,resultat.getString(7),resultat.getString(9),resultat.getInt(10));
////  
////      retour.add(per);
////        }
////  
////  return retour;
////  }     
//       
//       
//       
//     
//        public void supprimerEvennement(Evennement p) {
//            
//        
//        try { 
//            String req="DELETE FROM `evenement` WHERE `evenement`.`Titre_Event` = ?";
//            PreparedStatement ps = c.prepareStatement(req);
//            ps.setString(1, p.getTitre_Event());
//            ps.executeUpdate();
//            System.out.println("element supprimer");
//         
//        } catch (SQLException ex) {
//            Logger.getLogger(EvennementService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//   
//       
//       
//       
//       
//       
//       
//       
//       
//       
//       
//  /*public ArrayList<Evennement> getAllP() throws SQLException {
//        ArrayList<Evennement> retour = new ArrayList<>();
//        Statement stm = c.createStatement();
//        Evennement per=null;
//        String req = "SELECT * FROM `evenement`" ;
//        ResultSet resultat = stm.executeQuery(req);
//      while (resultat.next()) {    
//          
//          Instant instant = Instant.ofEpochMilli(d1.getTime());
//                      Instant instant1 = Instant.ofEpochMilli(d2.getTime());
//      per=new Evennement(resultat.getString(2), resultat.getString(3),resultat.getString(4),resultat.getDate(5),resultat.getDate(6),resultat.getString(7),resultat.getString(9),resultat);
//      retour.add(per);
//        }}
//        */
//     public List<User> readAll(Evennement u) throws SQLException
//    {List<User> list=new ArrayList<>();
//    ResultSet res=ste.executeQuery("select * from user where `Id_User`='"+u.getId_User()+"' ");
//    User per=null;
//    while (res.next()) {            
//      per=new User(res.getInt(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getString(9));
//      list.add(per);
//        }
//    return list;
//    }
//
//       
//       
//       
//       
//       public void modifierevenement(Evennement e) {
//        String sql = "UPDATE evenement SET `DATED_EVENT` =? where Id_Event="+e.getId_Event();
// 
//        PreparedStatement ps;
//        try {
//            ps = c.prepareStatement(sql);
//       
//          Date date1 = Date.from(e.getDATED_EVENT().atStartOfDay(ZoneId.systemDefault()).toInstant());
//       
//
//        ps.setDate(1, convertUtilToSql(date1));
//       
//        int rowsUpdated = ps.executeUpdate();
//          if (rowsUpdated > 0) {
//            System.out.println("L'ev a été modifier avec succès");
//          }
//          } catch (SQLException ex) {
//                     System.out.println("Erreur"+ex.getMessage());
// 
//          }
//    }
//    
//       
//       
//       
//       
//       
//      
//      
//    /*
//    public List<Evennement> readAll() throws SQLException
//    {List<Evennement> list=new ArrayList<>();
//    ResultSet res=ste.executeQuery("select * from evenement");
//    Evennement per=null;
//    while (res.next()) {            
//      per=new Evennement(res.getInt(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6));
//      list.add(per);
//        }
//    return list;
//    } 
//   
//      public void supprimerEvennement(Evennement p) {
//            
//        
//        try { 
//            String req="DELETE FROM `evenement` WHERE `evenement`.`Id_Event` = ?";
//            PreparedStatement ps = c.prepareStatement(req);
//            ps.setInt(1, p.getId_Event());
//            ps.executeUpdate();
//            System.out.println("element supprimer");
//         
//        } catch (SQLException ex) {
//            Logger.getLogger(EvennementService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//   
//      public void modifierEvennement(Evennement p) {
//        
//         
//        
//   String sql="UPDATE evenement SET `Descr_Event`=?,`Image_Event`=?,`Titre_Event`=?,`Date_Event`=?,`Localisation`=? WHERE Id_Event="+p.getId_Event();
//   PreparedStatement ps;
//        try {
//            ps = c.prepareStatement(sql);
//            ps.setString(1, p.getDescr_Event());
//            ps.setString(2, p.getImage_Event());
//            
//            ps.setString(3, p.getTitre_Event());
//            ps.setString(4, p.getDate_Event());
//            
//            ps.setString(5, p.getLocalisation());
//            
//                
//            ps.executeUpdate();
//            int rowsUpdated=ps.executeUpdate();
//            if (rowsUpdated>0){
//            System.out.println("La modification d'evenement "+p.getId_Event()+" a été éffectué avec succée ");
//            }}
//        catch (SQLException ex) {
//            Logger.getLogger(EvennementService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//     */
//      
//      public boolean rechercherparNom(String nom) {
//        boolean test=false;
//        String req = "SELECT * from evenement where Titre_Event='"+nom+"'";
//            
//     
//        try {
//           
//            ResultSet stp=ste.executeQuery(req);
//            stp.last();
//            if(stp.getRow()!=0)
//            {
//                test=true;
//                System.out.println(test+"evenement trouver");
//            }
//            else
//            {
//                test=false;
//                System.out.println(test+"evenement non trouver");
//            }
//        }
//            catch (SQLException ex) {
//            Logger.getLogger(EvennementService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return test;
//        
//    }
//     
//      
//      
//}
