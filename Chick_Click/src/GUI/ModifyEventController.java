/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.AddEventController;
import chick_click.Entite.Events;
import chick_click.Service.ControleSaisie;
import chick_click.Service.ServiceEvent;
import chick_click.Utils.CurrentUser;
import chick_click.Utils.MyHundlerEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author mahmoud
 */
public class ModifyEventController implements Initializable {

    @FXML
    private AnchorPane eventAdd;
    @FXML
    private TextField searchAddEvent;
    @FXML
    private Button returnToEvent;
    @FXML
    private Button returnToProfile;
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
    private ComboBox<String> comboboxevent;
    @FXML
    private TextField eventImageC;
    @FXML
    private Label verifcationtext;
    @FXML
    private Label houremessage;
    @FXML
    private Label datemessage;
    @FXML
    private ImageView imgiventt;
    
    private int eventIddd ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MyHundlerEvent mh =MyHundlerEvent.getInstance();
       eventIddd=mh.getId();
        ServiceEvent se = new ServiceEvent();
      
        Events e = null;
        try {
            e = se.getEventByID(eventIddd);
            
            eventTitle.setText(e.getEvent_title());
            eventDescription.setText(e.getEvent_description());
            eventCountry.setText(e.getCountry());
            eventAdress.setText(e.getAddress());
            eventStartDate.setValue(e.getEvent_date().toLocalDate());
            eventendDate.setValue(e.getEvent_end_date().toLocalDate());
            eventHoure.setText(e.getEvent_houre());
            comboboxevent.setValue(e.getCategories());
            eventImageC.setText(e.getEvent_picture());
        } catch (Exception evv) {
            //return to current page with error message popup
        }
        try {
            
            imgiventt.setImage(new Image("file:" + e.getEvent_picture()));
            
        } catch (Exception eb) {
            imgiventt.setImage(new Image("file:"));
        }
       
       
       
    }    

    @FXML
    private void searchEvent(ActionEvent event) {
    }

    @FXML
    private void chooseImage(ActionEvent event) {
    try {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(eventCountry.getScene().getWindow());
            eventImageC.setText(file.getAbsolutePath());
            System.out.println(file.getAbsolutePath());
            
            System.out.println(file);
            System.out.println(file.toURI());
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
          if(true){
      
          System.out.println("addddd eventtttttttttttttttt");
          Events e=new Events();
          e.setEvent_id(eventIddd);
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
              sv.updateEvent(e);
          } catch (SQLException ex) {
              Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
          }
              try {
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("../chick_click/GUI/FashionEvent.fxml"));
                  
                  Parent root = loader.load();
                  FashionEventController ac = loader.getController();                  
                  datemessage.getScene().setRoot(root);
                  
              } catch (IOException iOException) {
              }
          
          
          
      }
    }

    @FXML
    private void cancelm(ActionEvent event) {
         try {
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("../chick_click/GUI/FashionEvent.fxml"));
                  
                  Parent root = loader.load();
                  FashionEventController ac = loader.getController();                  
                  datemessage.getScene().setRoot(root);
                  
              } catch (IOException iOException) {
              }
    }
    
}
