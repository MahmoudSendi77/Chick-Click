/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import GUI.SignUpController;
import chick_click.Service.ServiceUser;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author mahmoud
 */
public class SignInController implements Initializable {
  
    @FXML
    private TextField sintfemail;
    @FXML
    private TextField sintfpassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToSignUpPage(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
            System.out.println("mechi lel sign up");
       
           
            Parent root =loader.load();
            System.out.println("mechi lel sign up2");
            SignUpController ac = loader.getController();
            System.out.println("mechi lel sign up3");
            sintfemail.getScene().setRoot(root);
            System.out.println("mechi lel sign up4");
    }

    @FXML
    private void signIn(ActionEvent event) throws SQLException {
        ServiceUser su =new ServiceUser();
        
        Boolean verified = su.verifyLogin(sintfemail.getText(), sintfpassword.getText());
        System.out.println(verified);
        if(verified){
             FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            System.out.println("mechi lel sign up");
       
           
            Parent root;
            try {
             root = loader.load();
            System.out.println("mechi lel Hmoe");
            HomePageController ac = loader.getController();
            System.out.println("mechi lel sign up3");
            sintfemail.getScene().setRoot(root);
            System.out.println("mechi lel sign up4");
            } catch (IOException ex) {
                Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        }
        else System.out.println("arja3 8odwa"); 
            
    }
    
}
