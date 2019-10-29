/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chick_click.GUI;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.DirectionsPane;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.service.directions.DirectionsService;
import static java.lang.ProcessBuilder.Redirect.to;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import static jdk.nashorn.internal.objects.NativeJava.to;
//import javafx.scene.web.WebView;



import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import com.lynden.gmapsfx.service.directions.*;

import java.net.URL;

import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mahmoud
 */
public class LocationEventController implements Initializable {

    @FXML
    private TextField t;
    @FXML
    private TextField o;
    @FXML
    private GoogleMapView gmap;
    
    protected DirectionsService directionsService;
    protected DirectionsPane directionsPane;

    protected StringProperty from = new SimpleStringProperty();
    protected StringProperty to = new SimpleStringProperty();
    GoogleMap map;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
         gmap.addMapInializedListener((MapComponentInitializedListener) this);
      //   gmap.addMapInializedListener(this);
     //   to.bindBidirectional(t.textProperty());
      //  from.bindBidirectional(o.textProperty());
    }    
    
     public void mapInitialized() {
        //MapOptions options = new MapOptions();
        
         MapOptions options = new MapOptions();
        options
            .center(new LatLong(40.7127, -74.0059))
            .mapType(MapTypeIdEnum.ROADMAP)
            .zoom(12);
        map = gmap.createMap(options);
        
       // gmap.setId("gmap");

        options.center(new LatLong(47.606189, -122.335842))
                .zoomControl(true)
                .zoom(12)
                .overviewMapControl(false)
                .mapType(MapTypeIdEnum.ROADMAP);
        GoogleMap map = gmap.createMap(options);
        
     //   directionsService = new DirectionsService();
     //    directionsPane = gmap.getDirec();
    }
     
     
      private void toTextFieldAction(ActionEvent event) {
        DirectionsRequest request = new DirectionsRequest(from.get(), to.get(), TravelModes.DRIVING);
        directionsService.getRoute(request, (DirectionsServiceCallback) this, new DirectionsRenderer(true, gmap.getMap(), directionsPane));
    }

    @FXML
    private void save(ActionEvent event) {
    }
    
}
