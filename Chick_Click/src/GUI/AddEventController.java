/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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


import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;

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
    
      // mapgoogle.createMap();
//      mapgoogle.addMapInializedListener((MapComponentInitializedListener) this);
        // TODO
        
       
    }    
    
    
//    public void mapInitialized() {
//        LatLong joeSmithLocation = new LatLong(0, 0);
//        LatLong joshAndersonLocation = new LatLong(47.6297, -122.3431);
//        LatLong bobUnderwoodLocation = new LatLong(47.6397, -122.3031);
//        LatLong tomChoiceLocation = new LatLong(47.6497, -122.3325);
//        LatLong fredWilkieLocation = new LatLong(47.6597, -122.3357);
//        
//        
//        //Set the initial properties of the map.
//        MapOptions mapOptions = new MapOptions();
//        
//        mapOptions.center(new LatLong(47.6097, -122.3331))
//                .mapType(MapTypeIdEnum.ROADMAP)
//                .overviewMapControl(false)
//                .panControl(false)
//                .rotateControl(false)
//                .scaleControl(false)
//                .streetViewControl(false)
//                .zoomControl(false)
//                .zoom(12);
//                   
//        map = mapgoogle.createMap(mapOptions, false);
//
//        //Add markers to the map
//        MarkerOptions markerOptions1 = new MarkerOptions();
//        markerOptions1.position(joeSmithLocation);
//        
//        MarkerOptions markerOptions2 = new MarkerOptions();
//        markerOptions2.position(joshAndersonLocation);
//        
//        MarkerOptions markerOptions3 = new MarkerOptions();
//        markerOptions3.position(bobUnderwoodLocation);
//        
//        MarkerOptions markerOptions4 = new MarkerOptions();
//        markerOptions4.position(tomChoiceLocation);
//        
//        MarkerOptions markerOptions5 = new MarkerOptions();
//        markerOptions5.position(fredWilkieLocation);
//        
//        Marker joeSmithMarker = new Marker(markerOptions1);
//        Marker joshAndersonMarker = new Marker(markerOptions2);
//        Marker bobUnderwoodMarker = new Marker(markerOptions3);
//        Marker tomChoiceMarker= new Marker(markerOptions4);
//        Marker fredWilkieMarker = new Marker(markerOptions5);
//        
//        map.addMarker( joeSmithMarker );
//        map.addMarker( joshAndersonMarker );
//        map.addMarker( bobUnderwoodMarker );
//        map.addMarker( tomChoiceMarker );
//        map.addMarker( fredWilkieMarker );
//        
//        InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
//        infoWindowOptions.content("<h2>Fred Wilkie</h2>"
//                                + "Current Location: Safeway<br>"
//                                + "ETA: 45 minutes" );
//
//        InfoWindow fredWilkeInfoWindow = new InfoWindow(infoWindowOptions);
//        fredWilkeInfoWindow.open(map, fredWilkieMarker);
//    }   

    
    
    
    
    
    
    
    public boolean verificationAddEvent(){
        boolean isnotnull;
        int val=1;
       if(!(ControleSaisie.isString(eventTitle.getText())&&
               ControleSaisie.isString(eventDescription.getText())&&
               ControleSaisie.isString(eventCountry.getText())&&
                       (eventStartDate.getValue()!=null)&&
                         (eventendDate.getValue()!=null)&&
                               !ControleSaisie.isString(eventHoure.getText())&&
                                       !ControleSaisie.isString(eventImageC.getText())&&
                                            comboboxevent.getValue()!=null&&
                                               ControleSaisie.isString(eventAdress.getText()))){
           
           
       verifcationtext.setText("PLEASE MAKE SURE TO FILL ALL FIELDS !!!!");
       verifcationtext.setStyle("-fx-background-color: red;");
       Timer asd = new Timer(1000,null);
       asd.setDelay(30000000);
           System.out.println("4444444");
       asd.start();
           System.out.println("55555555555");
       verifcationtext.setVisible(false);
       
        return false;
       }
       if(!ControleSaisie.isValidHour(eventHoure.getText())){
           houremessage.setText("PLEASE RESPECT THE PATTERN HH:MM LIKE 17:30");
           houremessage.setStyle("-fx-background-color: red;");
       return false;
       }
       if(eventStartDate.getValue().compareTo(eventendDate.getValue())==-1){
          datemessage.setText("PLEASE CHOOSE LATER DATE THAN + "+eventStartDate.getValue()+" !!!!");
           return false;
       }
       
      return true;
       
    }


    @FXML
    private void addEvent(ActionEvent event) {
        
      if(verificationAddEvent()){
      
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
              sv.addEvent(e);
          } catch (SQLException ex) {
              Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          
          
          
      }
        // if(verificationAddEvent());
       
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
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(eventCountry.getScene().getWindow());
        eventImageC.setText(file.getAbsolutePath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.toURI());
        System.out.println(file.toURI().toString());
        
    }

    private void see(MouseEvent event) {
        
      //  mapInitialized();
    }
    
    
    
}
