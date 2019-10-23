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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToSignInPage(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
       
           
            Parent root =loader.load();
            SignInController ac = loader.getController();
            supemail.getScene().setRoot(root);
    }

    @FXML
    private void signUp(ActionEvent event) {
         User u = new User();
         u.setEmail(supemail.getText());
         u.setPassword(suppasword.getText());
         Timestamp date = new Timestamp(new java.util.Date().getTime());
         u.setDate_creation(date);
         System.out.println();

        ServiceUser sp = new ServiceUser();

        try {
            sp.addUser(u);
            // if user add add account with status active not verified
          
        } catch (SQLException ex) {
            
           // Logger.getLogger(AjouterPersoneFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
