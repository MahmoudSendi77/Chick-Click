/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import chick_click.Entite.User;
import chick_click.Service.ServiceUser;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import GUI.SignInController;
import chick_click.Service.ControleSaisie;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author mahmoud
 */
public class SignUpController implements Initializable {

    @FXML
    private AnchorPane signup;
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
    private Label mailm;
    @FXML
    private Label pseudom;
    @FXML
    private Label passwdm;
    @FXML
    private Label cpasswdm;
    @FXML
    private Label phonem;
    private Label empty;
    @FXML
    private Label countrym;
    @FXML
    private Label genderm;
    @FXML
    private Label interstm;

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
            
            empty.setText("PLEASE MAKE SURE TO FILL ALL FIELDS");
        return false;
        }
        if(!ControleSaisie.isEmail(supemail.getText())){
            mailm.setText("PLEASE ENTER A VALID EMAIL");
            return false;
        }
        if(!ControleSaisie.isPasswor(suppasword.getText())){
            passwdm.setText("PLEASE ENTER A ALPHANUMERIC PASSWORD > 6 ");
            return false;
        }else if(suppasword.getText().equals(suppasswordcheck.getText())){
            cpasswdm.setText("PASSWORD DO NOT MUCH");
            return false;
        }
        if(!ControleSaisie.isPhone(supphone.getText())){
            phonem.setText("PLEASE ENTER A VALID PHONE NUMBER");
            return false;
        }
        if(gender.getValue()==null){
            genderm.setText("PLEASE SELECT YOUR GENDER");
         return false;   
        }
        if(interrest.getValue()==null){
            interstm.setText("PLEASE SELECT YOUR INTERREST");
         return false;   
        }
        if(supcountry.getText().trim().length()<3){
            countrym.setText("PLEASE ENTER YOUR COUNTRY AT LEAST 3 CARACTER");
         return false;   
        }
        
        return true;
    }
    @FXML
    private void switchToSignInPage(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../chick_click/GUI/SignIn.fxml"));
       
           
            Parent root =loader.load();
            SignInController ac = loader.getController();
            supemail.getScene().setRoot(root);
    }

    @FXML
    private void signUp(ActionEvent event) {
//           private TextField suppseudo;
//    @FXML
//    private TextField supemail;
//    @FXML
//    private TextField suppasword;
//    @FXML
//    private TextField suppasswordcheck;
//    @FXML
//    private TextField supphone;
//    @FXML
//    private TextField supcountry;
//    @FXML
//    private ComboBox<String> gender;
//    @FXML
//    private ComboBox<String> interrest;
//        
        
        if(verification()){
         User u = new User();
         
         u.setEmail(supemail.getText());
         u.setPassword(suppasword.getText());
         
         Timestamp date = new Timestamp(new java.util.Date().getTime());
         u.setDate_creation(date);
         
         
         u.setGender(gender.getValue());
         u.setInterrest(interrest.getValue());
         u.setCountry(supcountry.getText());
         
         u.setPseudo(suppseudo.getText());  
         u.setRole("simple_user");

        ServiceUser sp = new ServiceUser();

        try {
            sp.addUser(u);
            // if user add add account with status active not verified
             FXMLLoader loader = new FXMLLoader(getClass().getResource("../chick_click/GUI/HomePage.fxml"));
       
             
             
           
            Parent root =loader.load();
            SignInController ac = loader.getController();
            supemail.getScene().setRoot(root);
          
        } catch (SQLException ex) {
            
           // Logger.getLogger(AjouterPersoneFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (IOException ex) { 
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }
    }
    
}
