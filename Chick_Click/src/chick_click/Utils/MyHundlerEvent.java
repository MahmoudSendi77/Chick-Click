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
    static MyHundlerEvent mh;
    
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
    
    

    @Override
    public void handle(ActionEvent e) {
      
        try {
            System.out.println("899999999999777777777777777777777777777777777");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/EventDetails.fxml"));
           
            Parent root =loader.load();
          
            EventDetailsController ed = loader.getController();
           // ed.setEventID(this.id);
            label.getScene().setRoot(root); 
            System.out.println("999999999999999999999999999999999999999999999");
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