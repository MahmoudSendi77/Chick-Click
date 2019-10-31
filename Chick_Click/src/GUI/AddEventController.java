/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.SignUpController;
import chick_click.Entite.Events;
import chick_click.Service.ControleSaisie;
import chick_click.Service.ServiceEvent;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import chick_click.Service.ServiceEvent;
import chick_click.Utils.CurrentUser;
import chick_click.Utils.MyHundlerEvent;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javax.swing.Timer;

/**
 * FXML Controller class
 *
 * @author mahmoud
 */
public class AddEventController implements Initializable {

    @FXML
    private AnchorPane eventAdd;
    @FXML
    private TextField eventTitle;
    @FXML
    private TextArea eventDescription;
    @FXML
    private TextField eventCountry;
    @FXML
    private TextField eventAdress;
    @FXML
    private DatePicker eventStartDate;
    @FXML
    private DatePicker eventendDate;
    @FXML
    private TextField eventHoure;
    @FXML
    private TextField searchAddEvent;
    @FXML
    private TextField eventImageC;
    @FXML
    private Label verifcationtext;
    @FXML
    private Label houremessage;
    @FXML
    private Label datemessage;
    @FXML
    private ComboBox<String> comboboxevent;
    @FXML
    private Button returnToEvent;
    @FXML
    private Button returnToProfile;
    @FXML
    private ImageView profileimg;
    @FXML
    private Label username;
    
    //private GoogleMap map;

     //private GoogleMapView mapgoogle;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
       comboboxevent.getItems().addAll("Fashion exhibitions","Fashion festivals"
       ,"Fashion weeks","Fashion show");
       comboboxevent.setValue("Fashion show");
       createProfile();
      // mapgoogle.createMap();
//      mapgoogle.addMapInializedListener((MapComponentInitializedListener) this);
        // TODO
        
       
    }   
     public void createProfile(){
        CurrentUser cu = CurrentUser.getInstance();
        username.setText(cu.getPseudo());
       
         try {
             profileimg.setImage(new Image(cu.getPhoto_profile()));
             
         } catch (Exception e) {
         }
     }
    
    
    
    
    public boolean verificationAddEvent(){
        boolean isnotnull;
        int val=1;
       if(!(ControleSaisie.isString(eventTitle.getText())&&
               ControleSaisie.isString(eventDescription.getText())&&
               ControleSaisie.isString(eventCountry.getText())&&
                       (eventStartDate.getValue()!=null)&&
                         (eventendDate.getValue()!=null)&&
                               ControleSaisie.isString(eventHoure.getText())&&
                                       ControleSaisie.isString(eventImageC.getText())&&
                                            comboboxevent.getValue()!=null&&
                                               ControleSaisie.isString(eventAdress.getText())&&
                                                    ControleSaisie.isString(eventImageC.getText())
                                                        )){
           
       verifcationtext.setText("PLEASE MAKE SURE TO FILL ALL FIELDS !!!!");
       verifcationtext.setStyle("-fx-background-color: red;");
       
           System.out.println("55555555555");
      // verifcationtext.setVisible(false);
       
        return false;
       }
       
       if(eventStartDate.getValue().compareTo(eventendDate.getValue())==1){
          datemessage.setText("PLEASE CHOOSE LATER DATE THAN + "+eventStartDate.getValue()+" !!!!");
           System.out.println("hna comare date  ");
           return false;
       }
       if(!ControleSaisie.isValidHour(eventHoure.getText().trim())){
           System.out.println(eventHoure.getText().trim());
           houremessage.setText("PLEASE RESPECT THE PATTERN HH:MM LIKE 17:30");
           houremessage.setStyle("-fx-background-color: red;");
          
       return false;
       }
       
       
      return true;
       
    }


    @FXML
    private void addEvent(ActionEvent event) {
        
      if(verificationAddEvent()){
      
          System.out.println("addddd eventtttttttttttttttt");
          Events e=new Events();
          e.setAddress(eventAdress.getText());
          e.setCategories(comboboxevent.getValue());
          e.setCountry(eventCountry.getText());
          Date d = null;
          e.setEvent_date(d.valueOf(eventStartDate.getValue()));
           Date d1 = null;
          e.setEvent_end_date(d1.valueOf(eventendDate.getValue()));
          e.setEvent_description(eventDescription.getText());
          e.setEvent_houre(eventHoure.getText());
          e.setEvent_picture(eventImageC.getText());
          CurrentUser cu=CurrentUser.getInstance();
          int id = cu.getIdcurrentuser();
          e.setUser_id(id);
          e.setEvent_title(eventTitle.getText());
          ServiceEvent sv =new ServiceEvent();
  
         
          try {
              int a =sv.addEvent(e);
              System.out.println("hedha id event elli dzed tw    "+a);
              MyHundlerEvent mh = MyHundlerEvent.getInstance();
              mh.setId(a);
               try {
              addLocationEvent();
          } catch (IOException ex) {
              Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
          }
          } catch (SQLException ex) {
              Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          
          
          
      }
        // if(verificationAddEvent());
       
    }
    
    private void addLocationEvent() throws IOException{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../chick_click/GUI/LocationEvent.fxml"));
            System.out.println("mechi lel sign up");

            Parent root =loader.load();
            
            LocationEventController ac = loader.getController();
            
            eventTitle.getScene().setRoot(root);
            
    }

    @FXML
    private void searchEvent(ActionEvent event) {
//        MapOptions mapOptions = new MapOptions();
//         mapOptions.center(new LatLong(47.6097, -122.3331))
//                .mapType(MapTypeIdEnum.TERRAIN)
//                .overviewMapControl(true)
//                .panControl(true)
//                .rotateControl(true)
//                .scaleControl(true)
//                .streetViewControl(true)
//                .zoomControl(true)
//                .zoom(12);
//         System.out.println("fdfdf");
//        map = mapgoogle.createMap(mapOptions);
//        vboxmap.getChildren().add(mapgoogle);
        
    }

    @FXML
    private void chooseImage(ActionEvent event) {
        
        try {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(eventCountry.getScene().getWindow());
            eventImageC.setText(file.getAbsolutePath());
            System.out.println(file.getAbsolutePath());
            System.out.println(file.toURI());
            System.out.println(file.toURI().toString());
        } catch (Exception e) {
        }

    }

    private void see(MouseEvent event) {
        
      //  mapInitialized();
    }
    
    
    
}
