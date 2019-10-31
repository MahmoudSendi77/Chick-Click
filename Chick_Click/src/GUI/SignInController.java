/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import chick_click.Utils.CurrentUser;
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
import javafx.scene.control.Label;


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
    @FXML
    private Label message;

    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToSignUpPage(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../chick_click/GUI/SignUp.fxml"));
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
        
        int id = su.verifyLogin(sintfemail.getText(), sintfpassword.getText());
        System.out.println(id);
        if(id!=-1){
             FXMLLoader loader = new FXMLLoader(getClass().getResource("../chick_click/GUI/HomePage.fxml"));
            System.out.println("mechi lel sign up");
       
           
            Parent root;
            try {
                
                CurrentUser cu = CurrentUser.getInstance();
                cu.setIdcurrentuser(id);
                
            root = loader.load();
            System.out.println("mechi lel Hmoe");
            HomePageController ac = loader.getController();
            ac.setCurrentUserID(id);
            su.loadProfile(id);
            
            sintfemail.getScene().setRoot(root);
            System.out.println("mechi lel sign up4");
            } catch (IOException ex) {
                Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        }
        else System.out.println("arja3 8odwa"); 
            
    }

    @FXML
    private void facebookAuth(ActionEvent event) {
//        String appId="2080460932055718";
//        String domain="http://www.chick-click.com/";
//        
//        String auth="https://graph.facebook.com/oauth/authorize?type=user_agent&client_id"+appId+"&redirect_uri="+domain+"&scope=user_about_le";
//        
//    
//    System.setProperty("webdriver.chrome.driver","chromedriver.exe1");
//        WebDriver driver = new ChromeDriver();
//        driver.get(auth);
//        String accessToken;
//        while(true){
//            if(!driver.getCurrentUrl().contains("facebook.com")){
//                String url = driver.getCurrentUrl();
//                accessToken =url.replaceAll(".*#access_token=(.+)&.*", "$1");
//                
//                driver.quit();
//                
//                FacebookClient fbclient = new DefaultFacebookClient(accessToken, Version.UNVERSIONED);
//                User user = fbclient.fetchObject("me",User.class);
//                
//                message.setText(user.toString());
//            }
//        }
    
    }
    
}
