/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import chick_click.Entite.EventLocation;
import chick_click.Entite.Events;
import chick_click.Service.ControleSaisie;
import chick_click.Service.ServiceEvent;
import chick_click.Service.ServiceLocationEvent;
import chick_click.Utils.MyHundlerEvent;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mahmoud
 */
public class ModifyLocationController implements Initializable ,MapComponentInitializedListener{

    @FXML
    private GoogleMapView gmap;
    @FXML
    private Label titleLocation;
    @FXML
    private TextField o;
    @FXML
    private TextField t;

    private GoogleMap map;
    private DecimalFormat formatter = new DecimalFormat("###.00000");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            MyHundlerEvent mh =MyHundlerEvent.getInstance();
        int idev=mh.getId();
        ServiceEvent se =new ServiceEvent();
        Events ev =new Events();
        ev=se.getEventByID(idev);
        gmap.addMapInializedListener( this);
         
         titleLocation.setText("ADD LOCATION TO \n" + ev.getEvent_title());
    }    

      @Override
    
    public void mapInitialized(){
        MapOptions mapOptions = new MapOptions();
        mapOptions.center(new LatLong(47.6097, -122.3331))
                .mapType(MapTypeIdEnum.ROADMAP)
                .zoom(9);
        map = gmap.createMap(mapOptions, false);
        map.addMouseEventHandler(UIEventType.click, (GMapMouseEvent event) -> {
            LatLong location = event.getLatLong();
            o.setText(formatter.format(location.getLatitude()));
            t.setText(formatter.format(location.getLongitude()));
            setPositionMArker(location);
            
        });
    }
    
    public void toHome() throws IOException{
    
             FXMLLoader loader = new FXMLLoader(getClass().getResource("../chick_click/GUI/FashionEvent.fxml"));
            System.out.println("mechi lel sign up");

            Parent root =loader.load();
            
            FashionEventController ac = loader.getController();
            
            titleLocation.getScene().setRoot(root);
}
      int count =0;
    public void setPositionMArker(LatLong location){
        count++;
   // LatLong joeSmithLocation = new LatLong( (double) 47.6197,(double) -122.3231);
         MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(location);
        
    
        
        Marker locationMark = new Marker(markerOptions);
     
        if(count==1){
        map.addMarker( locationMark );
      
        
        InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
        infoWindowOptions.content("<h2>Event_Title</h2>"
                                + "add location <br>"
                                + "thanks" );

        InfoWindow fredWilkeInfoWindow = new InfoWindow(infoWindowOptions);
    
        fredWilkeInfoWindow.open(map, locationMark);
        }
        if(count==2){
            map.clearMarkers();
            count=0;
        }
    
    }
    @FXML
    private void cancel(ActionEvent event) {
    }

    @FXML
    private void save(ActionEvent event) {
        if(verify()){
            try {
                MyHundlerEvent mh =MyHundlerEvent.getInstance();
                int id= mh.getId();
                EventLocation el=new EventLocation();
                el.setEvent_id(id);
                el.setLattitude(Double.parseDouble(o.getText()));
                el.setLongitude(Double.parseDouble(o.getText()));
                ServiceLocationEvent sl =new ServiceLocationEvent();
                 sl.updateLocation(el); 
                toHome();
            } catch (SQLException ex) {
                Logger.getLogger(LocationEventController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(LocationEventController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     public boolean verify(){
        if (!(ControleSaisie.isString(o.getText())&&ControleSaisie.isString(t.getText())) ){
            //message.setText("PLEASE SELECT A LOCATION OR CANCEL")
            return false;
        }
        return true;
    }
    
}
