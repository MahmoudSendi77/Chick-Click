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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mahmoud
 */
public class HomePageController implements Initializable {

    @FXML
    private TextField searchp;
    @FXML
    private Label usernamelabel;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void toEventPage(ActionEvent event) throws IOException {
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FashionEvent.fxml"));
            Parent root =loader.load();
            FashionEventController ac = loader.getController();
            searchp.getScene().setRoot(root);
           
    
}
}