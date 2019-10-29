/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import chick_click.Utils.MyHundlerEvent;
import chick_click.Entite.Events;
import chick_click.Service.ServiceEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author mahmoud
 */

public class EventDetailsController implements Initializable {

    @FXML
    private AnchorPane eventShow;
    @FXML
    private ImageView profileimg;
    
    private int eventId;
    @FXML
    private ImageView eventimg;
    @FXML
    private Label nbrSubscription;
    @FXML
    private Label nbrLike;
    @FXML
    private Label nbrMsg;
    @FXML
    private TextArea description;
    @FXML
    private Label username;

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        // System.out.println(ev.getEvent_description());
        this.eventId=MyHundlerEvent.getInstance().getId();
        System.out.println("fmqfkndsmjvnsvknsmlksdnvmlsdkvndsmlvnsdmlvknsdmlvkdsnvldsn");
        loadDetail();
    }    
    
    
    
    public void loadDetail(){
        Events ev =new Events();     
        ServiceEvent se=new ServiceEvent();
      
        ev=se.getEventByID(eventId);
        description.setText(ev.getEvent_description());
        try {
            eventimg.setImage(new Image(ev.getEvent_picture()));
  
        } catch (Exception e) {
            eventimg.setImage(new Image("file:..\\..\\..\\..\\..\\..\\..\\..\\wamp64\\www\\Images\\No-Image-Available.jpg"));
        }   
        
        
    }

    @FXML
    private void toHomePage(ActionEvent event) {
        System.out.println(eventId);
    }
    
    

    @FXML
    private void toAddEventPage(ActionEvent event) {
    }

    @FXML
    private void SubscribeToEvent(ActionEvent event) {
        System.out.println(eventId);
    }
    
}
