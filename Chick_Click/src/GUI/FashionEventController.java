/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import chick_click.Utils.MyHundlerEvent;
import chick_click.Entite.Events;
import chick_click.Service.ServiceEvent;
import chick_click.Service.ServiceUser;
import chick_click.Utils.CurrentUser;
import chick_click.Utils.SearchHundler;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import sun.java2d.loops.CustomComponent;

/**
 * FXML Controller class
 *
 * @author mahmoud
 */
public class FashionEventController implements Initializable {

   
    @FXML
    private Label addenvetLabel;
    @FXML
    private AnchorPane eventShow;
    @FXML
    private GridPane listEventShow;
    @FXML
    private ImageView eventImg;
    @FXML
    private ImageView profileimg;
    @FXML
    private Button addEventbt;
    @FXML
    private Label username;
    @FXML
    private TextField searchtext;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
      // giveAccessToAddEvent();
    
          profileimg.setImage(new Image("file:..\\..\\..\\..\\..\\..\\..\\..\\wamp64\\www\\Images\\profile-adam-levine.png"));
         createProfile();
         loadEvents();
       
        // TODO
    }    
    
    public void createProfile(){
        CurrentUser cu = CurrentUser.getInstance();
        username.setText(cu.getPseudo());
      
        try {
            profileimg.setImage(new Image(cu.getPhoto_profile()));
            
        } catch (Exception e) {
            System.out.println("mochkla fi soura fi path :(");
        }
    }
    
    private void giveAccessToAddEvent() {
        
        try {
            CurrentUser cu =CurrentUser.getInstance();
            ServiceUser su =new ServiceUser();
            String role =su.getUserRole(cu.getIdcurrentuser());
            if(!(role.equals("admin")||role.equals("super_user"))){
                addEventbt.setVisible(false);
                addenvetLabel.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FashionEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void loadEvents(){
        try {
            // int i=4;
             int j;
            ServiceEvent sv = new ServiceEvent();
            List<Events> e=sv.getAll();
            
             for(int i=4 ;i<e.size()+4;i++){
            
           
                    j=i-4;
            System.out.println("111111111111111111111");
            ImageView img = new ImageView();
            
         //   img.setImage(new Image("file:..\\chick_click.Utils\\No-Image-Available.jpg"));
                
                 try {
                     img.setImage(new Image(e.get(j).getEvent_picture()));
                     
                 } catch (Exception even) {
                     img.setImage(new Image("file:..\\..\\..\\..\\..\\..\\..\\..\\wamp64\\www\\Images\\No-Image-Available.jpg"));
                 }
            
            img.setFitHeight(150.0);
            img.setFitWidth(220.0);
            
            VBox vb0 = new VBox();
            vb0.getChildren().add(img);
            vb0.getChildren().add(new Label(""));
            
           //********************************************************************************************************
            
           
           Label title=new Label();
           
                title.setAlignment(Pos.TOP_CENTER);
                title.setText(e.get(j).getEvent_title());
                title.setStyle("-fx-background-color: transparent;  -fx-font-size: 1.6em; -fx-font-weight: bold;");
           
           Label drsc=new Label();
           
                drsc.setAlignment(Pos.TOP_CENTER);
                String ss="",st="",se="";
                st= e.get(j).getEvent_description();
                
                if(st.length()>130){
                    ss=st.substring(0, 80);
                    se=st.substring(80,120);
                }
                
                drsc.setText(ss+"\n"+se+"....");
                
                
                drsc.setStyle("-fx-background-color: transparent;  -fx-font-size: 0.9em; -fx-font-weight: bold;");
                
           Button link=new Button();
                link.setText("for more details click here ....");  
                link.setStyle("-fx-background-color: transparent; -fx-text-fill: #aeaeae; -fx-border-width: 0px 0px 2px  0px; -fx-border-color: black; -fx-font-size: 0.9em; -fx-font-weight: bold;");
               
                MyHundlerEvent mhe= MyHundlerEvent.getInstance();
                mhe.setId(e.get(j).getEvent_id());
                mhe.setLabel(username);
                mhe.setDestination("EventDetails");
                link.setOnAction(mhe); 
                
            VBox vb = new VBox();      
                 vb.setMinSize(200,139); 
                 vb.getChildren().add(title);
                 vb.getChildren().add(drsc);
                 vb.getChildren().add(link);  
           
      
           Label datesh=new Label();   
                datesh.setAlignment(Pos.TOP_RIGHT);
                String dd="";
               if(e.get(j).getEvent_date().compareTo(e.get(j).getEvent_end_date())==0){
                   dd=e.get(j).getEvent_date().toString();
               }else{
                   dd="from"+e.get(j).getEvent_date().toString()+"to"+e.get(j).getEvent_end_date().toString();
               }
               
                //String dd=e.get(j).getEvent_date().toString();
                String hh=e.get(j).getEvent_houre();
                
                datesh.setText(dd+"  at  "+hh);
                datesh.setStyle("-fx-background-color: transparent;");
            
           Label country=new Label();   
                country.setAlignment(Pos.TOP_LEFT);
                country.setText(e.get(j).getCountry()+"       ");
                country.setStyle("-fx-background-color: transparent; -fx-font-size: 1.4em; -fx-font-weight: bold;");
                
           HBox hb01 = new HBox();
         
                hb01.getChildren().add(country);
                hb01.setAlignment(Pos.CENTER_LEFT);
                 
           HBox hb00 = new HBox();
                hb01.getChildren().add(datesh);
                hb01.setAlignment(Pos.CENTER_RIGHT);
          
                         // vb.setPadding(Insets.EMPTY.);
           HBox hb2 = new HBox();
                hb2.setMinSize(50,50);
                hb2.getChildren().add(hb01);
                hb2.getChildren().add(hb00);
                
                vb.getChildren().add(hb2);

            
            HBox hb = new HBox();
                hb.setMinSize(300,200);
                
              VBox vbb = new VBox(); 
              Label lb= new Label("     ");
              vbb.getChildren().add(lb);
              
              hb.getChildren().add(vb0);
              hb.getChildren().add(vbb);
              hb.getChildren().add(vb);
            
             listEventShow.add(hb,0,i); 
             listEventShow.setPadding(new Insets(10,10,10,10));

             }

        } catch (Exception e) {
             System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        }
        
    }
   

    @FXML
    private void toAddEventPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../chick_click/GUI/AddEvent.fxml"));
            Parent root =loader.load();
      //      AddEventtController ac = loader.getController();
            addenvetLabel.getScene().setRoot(root);
    }

    @FXML
    private void toHomePage(ActionEvent event) throws IOException, SQLException {
        ServiceEvent sev=new ServiceEvent();
        List<Events> l = sev.foundBYName("Paris");
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("../chick_click/GUI/EventDetails.fxml"));
//            Parent root =loader.load();
//            SignInController ac = loader.getController();
//            username.getScene().setRoot(root);
    }

    @FXML
    private void goToEventFullDetais(MouseEvent event) {
        }

    @FXML
    private void searchEvent(ActionEvent event) throws IOException {
        SearchHundler cc =SearchHundler.getInstance();
        cc.setSearch(searchtext.getText());
        System.out.println("seaaaaaaaarch"+searchtext.getText());
          System.out.println(cc.getSearch()+ "   hhhhhhhhhhhhhhhhhhhhhhhhh");
           System.out.println(cc.getSearch());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../chick_click/GUI/SearchEventPage.fxml"));//../GUI/SearchEventPage.fxml
            System.out.println("seaaaaaaaarch"+searchtext.getText());
            Parent root =loader.load();
            System.out.println("seaaaaaaaarch"+searchtext.getText());
            System.out.println(cc.getSearch()+ "   hhhhhhhhhhhhhhhhhhhhhhhhh");
            SearchEventPageController ac = loader.getController();
            username.getScene().setRoot(root);
    }
    
}
