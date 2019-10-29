/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import chick_click.Utils.CurrentUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import sun.nio.cs.ext.GBK;

/**
 * FXML Controller class
 *
 * @author mahmoud
 */
public class HomePageController implements Initializable {

    @FXML
    private TextField searchp;
    @FXML
    private Label usernamelabel;
    private GridPane publicationgrid;
    @FXML
    private ScrollPane pubpane;
    @FXML
    private GridPane homepagegrid;
    private int currentUserID;
    @FXML
    private ImageView userimg;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            // profileimg.setImage(new Image("file:..\\..\\..\\..\\..\\..\\..\\..\\wamp64\\www\\Images\\profile-adam-levine.png"));
           // pubpane.add();
           
           CurrentUser cu=CurrentUser.getInstance();
           int iduser=cu.getIdcurrentuser();
           
         try {
             int i;
             int m;
             
//                 HBox hb = new HBox();
//                 
//                 GridPane gp = new GridPane();
//                hb.getChildren().add(gp);    
                 for(i=4;i<100;i=i+3){
                     int l;
                     l=i;
                 Label tf=new Label();
                 homepagegrid.getColumnConstraints();
                 homepagegrid.getRowConstraints();
            homepagegrid.add(tf ,1,l);
            int j=0;
            j++;
            tf.setText("publication "+j+" \n azertyuazertyuazaz \n azertyuiolnbvfdf");
            tf.setStyle("-fx-background-color: transparent;");
            tf.setPrefWidth(100);
            tf.setPrefHeight(100);
            tf.setPrefSize(100, 100);
            tf.setMinHeight(80);
            tf.setMinSize(80, 80);
            ImageView img = new ImageView();
            l=i+1;
            homepagegrid.getColumnConstraints();
            homepagegrid.add( img,1,l);
            img.setImage(new Image("file:..\\..\\..\\..\\..\\..\\..\\..\\wamp64\\www\\Images\\logo.png"));
            img.setFitHeight(200.0);
            img.setFitWidth(250.0);
          
            //img.setPickOnBounds(true);
            //img.setPreserveRatio(true);
            
            l=i+2;
            Button bt =new Button();
            homepagegrid.getColumnConstraints();
                 homepagegrid.getRowConstraints();
                 homepagegrid.add(bt ,1,l);
                 bt.setText("comments");
                 
     
//                 Button bt = new Button();
//                publicationgrid.add(tf ,1,i+2);
               
               bt.setMinSize(30, 30);
                 System.out.println("7777777777777777777777777777777777777777777");
            //listEventShow.addRow(6, new TextField());
            
             }
           
            
        } catch (Exception e) {
             System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        }
        
    }    
    
    public void setCurrentUserID(int i){
    this.currentUserID=i;
    }

    @FXML
    private void toEventPage(ActionEvent event) throws IOException {
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../chick_click/GUI/FashionEvent.fxml"));
            Parent root =loader.load();
            FashionEventController ac = loader.getController();
            searchp.getScene().setRoot(root);
           
    
}

    @FXML
    private void toProfilePage(ActionEvent event) throws IOException {
        
          FXMLLoader loader = new FXMLLoader(getClass().getResource("../chick_click/GUI/HomePage.fxml"));
            Parent root =loader.load();
            FashionEventController ac = loader.getController();
            searchp.getScene().setRoot(root);
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        System.out.println(currentUserID);
    }

    @FXML
    private void toSettingPage(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("../chick_click/GUI/SettingProfile.fxml"));
            Parent root =loader.load();
            FashionEventController ac = loader.getController();
            searchp.getScene().setRoot(root);
    }
}