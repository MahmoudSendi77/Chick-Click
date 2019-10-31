/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import chick_click.Entite.Account;
import chick_click.Entite.User;
import chick_click.Service.ControleSaisie;
import chick_click.Service.ServiceAccount;
import chick_click.Service.ServiceUser;
import chick_click.Utils.CurrentUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author mahmoud
 */
public class SettingProfileController implements Initializable {

    @FXML
    private ImageView userimg;
    @FXML
    private Label username;
    @FXML
    private VBox adduserhvbox;
    @FXML
    private TextField suppseudo1;
    @FXML
    private TextField supemail1;
    @FXML
    private TextField suppasword1;
    @FXML
    private TextField suppasswordcheck1;
    @FXML
    private TextField supphone1;
    @FXML
    private TextField supcountry1;
    @FXML
    private TextField suppseudo11;
    @FXML
    private TextField suppseudo21;
    @FXML
    private VBox modifyvbox;
    @FXML
    private TextField suppseudo;
    @FXML
    private TextField supemail;
    @FXML
    private TextField suppasword;
    @FXML
    private TextField suppasswordcheck;
    @FXML
    private TextField supphone;
    @FXML
    private TextField supcountry;
    @FXML
    private ComboBox<String> gender;
    @FXML
    private ComboBox<String> interrest;
    @FXML
    private Button shadd;

    ServiceUser sp;
    @FXML
    private Label message;
    @FXML
    private TextField photoprf;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         gender.getItems().addAll("MALE","FEMALE"
       ,"OTHER");
       gender.setValue("MALE");
         interrest.getItems().addAll("SPORT","SPORT"
       ,"OTHER");
       interrest.setValue("SPORT");
       
        sp = new ServiceUser();
    }    

    @FXML
    private void showAdd(ActionEvent event) {
    }
    private boolean verification(){
        
        
        if(!(ControleSaisie.isString(suppseudo.getText())&&
                ControleSaisie.isString(supcountry.getText())&&
                    ControleSaisie.isString(supemail.getText())&&
                        ControleSaisie.isString(suppasword.getText())&&
                            ControleSaisie.isString(suppasswordcheck.getText())&&
                                ControleSaisie.isString(supphone.getText())&&
                                    ControleSaisie.isString(gender.getValue())&&
                                        ControleSaisie.isString(interrest.getValue())
                   
               )){
            
           // empty.setText("PLEASE MAKE SURE TO FILL ALL FIELDS");
        return false;
        }
        try {
            if(sp.verifyPseudo(suppseudo.getText())){
             message.setText("PSEUDO ALREADY USED ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!ControleSaisie.isEmail(supemail.getText())){
            message.setText("PLEASE ENTER A VALID EMAIL");
            return false;
        }else{
            try {
                if(sp.verifyEmail(supemail.getText())){
                     message.setText("EMAIL ALREADY USED ");
            return false;
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(!ControleSaisie.isPasswor(suppasword.getText())){
            message.setText("PLEASE ENTER A ALPHANUMERIC PASSWORD > 6 ");
            return false;
        }else if(suppasword.getText().equals(suppasswordcheck.getText())){
            message.setText("PASSWORD DO NOT MUCH");
            return false;
        }
        if(!ControleSaisie.isPhone(supphone.getText())){
            message.setText("PLEASE ENTER A VALID PHONE NUMBER");
            return false;
        }
        if(gender.getValue()==null){
            message.setText("PLEASE SELECT YOUR GENDER");
         return false;   
        }
        if(interrest.getValue()==null){
            message.setText("PLEASE SELECT YOUR INTERREST");
         return false;   
        }
        if(supcountry.getText().trim().length()<3){
            message.setText("PLEASE ENTER YOUR COUNTRY AT LEAST 3 CARACTER");
         return false;   
        }
        
        return true;
    }

    @FXML
    private void addAdmin(ActionEvent event) {
    }

    @FXML
    private void modifC(ActionEvent event) {
            if(verification()){
                
            
                CurrentUser cc =CurrentUser.getInstance();
                int idu =cc.getIdcurrentuser();
         User u = new User();   
         u.setUser_id(idu);
         u.setEmail(supemail.getText());
         u.setPassword(suppasword.getText());
         
         Timestamp date = new Timestamp(new java.util.Date().getTime());
         u.setDate_creation(date);
         
         
         u.setGender(gender.getValue());
         u.setInterrest(interrest.getValue());
         u.setCountry(supcountry.getText());
         
         u.setPseudo(suppseudo.getText());  
         u.setRole("simple_user");

        

        try {
            sp.updateUser(u);
            
                Account acc =new Account();
                ServiceAccount sa =new ServiceAccount();
                acc.setPhone(supphone.getText());
                acc.setUser_id(idu);
                acc.setStatus("active");
                acc.setPhoto_profile(photoprf.getText());
                
                sa.updateUser(acc);
                
            // if user add add account with status active not verified
             FXMLLoader loader = new FXMLLoader(getClass().getResource("../chick_click/GUI/HomePage.fxml"));
            Parent root =loader.load();
            HomePageController ac = loader.getController();
            supemail.getScene().setRoot(root);
          
        } catch (SQLException ex) {
            
           // Logger.getLogger(AjouterPersoneFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (IOException ex) { 
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }
    }
}
