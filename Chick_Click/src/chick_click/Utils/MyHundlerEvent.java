/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chick_click.Utils;

import GUI.EventDetailsController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
//import 

/**
 *
 * @author mahmoud
 */
public class MyHundlerEvent implements EventHandler<ActionEvent>{
    private  Label label;
    private  int id=0;
    private String searchPatern="";
    private String destination="";
    static MyHundlerEvent mh;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSearchPatern() {
        return searchPatern;
    }

    public void setSearchPatern(String searchPatern) {
        this.searchPatern = searchPatern;
    }
    
    private MyHundlerEvent() {
        
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    private String toPage(){
        String page ="../GUI/";
        return page =page+destination+".fxml";
    }
   
    @Override
    public void handle(ActionEvent e) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(toPage()));
            Parent root =loader.load();
            EventDetailsController ed = loader.getController();
            label.getScene().setRoot(root); 
            System.out.println(id);
      
        } catch (IOException ex) {
            Logger.getLogger(MyHundlerEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getEventID(){
        return this.id;
    }
    public static MyHundlerEvent getInstance() {
        if (mh == null) {
            mh = new MyHundlerEvent() ;
        }
        return mh;
    }
    
}
//public class ButtonHandler implements EventHandler<ActionEvent> {
//    
//}