/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import chick_click.Utils.MyHundlerEvent;
import chick_click.Entite.Events;
import chick_click.Service.ServiceEvent;
import chick_click.Service.ServiceSubscriptionEvent;
import chick_click.Utils.CurrentUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

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
    private Label username;
    @FXML
    private VBox zonemodif;
    @FXML
    private Label titre;
    @FXML
    private Label descriptionev;

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
        titre.setText(ev.getEvent_title());
        descriptionev.setText(ev.getEvent_description());
        try {
            eventimg.setImage(new Image(ev.getEvent_picture()));
  
        } catch (Exception e) {
            eventimg.setImage(new Image("file:..\\..\\..\\..\\..\\..\\..\\..\\wamp64\\www\\Images\\No-Image-Available.jpg"));
        }         
    }

    @FXML
    private void toHomePage(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("../chick_click/GUI/FashionEvent.fxml"));
            Parent root =loader.load();
            FashionEventController ac = loader.getController();
            nbrLike.getScene().setRoot(root);
        System.out.println(eventId);
    }
    
    


    @FXML
    private void SubscribeToEvent(ActionEvent event) throws SQLException {
        ServiceSubscriptionEvent sv =new ServiceSubscriptionEvent();
         MyHundlerEvent mh =MyHundlerEvent.getInstance();
        int id =mh.getId();
        CurrentUser cc = CurrentUser.getInstance();
        int idu=cc.getIdcurrentuser();
        sv.addSubscription(idu,id);
        
        
    }

    @FXML
    private void modifierEvent1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../chick_click/GUI/ModifyEvent.fxml"));
        
            Parent root =loader.load();
            ModifyEventController ac = loader.getController();         
            descriptionev.getScene().setRoot(root);
            
    }

    @FXML
    private void supprimerevent1(ActionEvent event) throws SQLException {
        MyHundlerEvent mh =MyHundlerEvent.getInstance();
        int id =mh.getId();
        ServiceEvent se =new ServiceEvent();
        se.deleteEvent(id);
    }
 
    
    
    
    
}
