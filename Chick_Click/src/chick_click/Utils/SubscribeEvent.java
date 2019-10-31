/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chick_click.Utils;

/**
 *
 * @author mahmoud
 */
public class SubscribeEvent {
    private int event_id;
    private int user_id;
    
   

    public SubscribeEvent(int event_id, int user_id) {
        this.event_id = event_id;
        this.user_id = user_id;
        
       
    }

    public SubscribeEvent() {
    }

    
    
    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

  
    
    
}
