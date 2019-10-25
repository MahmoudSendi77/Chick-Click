/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import chick_click.Entite.Events;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author mahmoud
 */
public class FashionEventController implements Initializable {

   
    @FXML
    private Label addenvetLabel;
    @FXML
    private AnchorPane eventShow;
    @FXML
    private GridPane listEventShow;
    @FXML
    private ImageView eventImg;
    @FXML
    private Text eventdecription;
    @FXML
    private TextField eventCountry;
    @FXML
    private TableView<?> pseudo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // listEventShow.addRow(1,);
      
        
        
       
        // TODO
    }    

    @FXML
    private void toAddEventPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddEvent.fxml"));
            Parent root =loader.load();
      //      AddEventtController ac = loader.getController();
            addenvetLabel.getScene().setRoot(root);
    }
    
}
