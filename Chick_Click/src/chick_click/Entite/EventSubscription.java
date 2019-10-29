/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chick_click.Entite;

/**
 *
 * @author mahmoud
 */
public class EventSubscription {
    
    private int event_id;
    private int user_id;
    private String like;
    private int subcribe;

    public EventSubscription(int event_id, int user_id, String like, int subcribe) {
        this.event_id = event_id;
        this.user_id = user_id;
        this.like = like;  
        this.subcribe = subcribe;
    }

    public EventSubscription(int event_id, int user_id, String like) {
        this.event_id = event_id;
        this.user_id = user_id;
        this.like = like;
    }
     public EventSubscription(int event_id, int user_id, int subcribe) {
        this.event_id = event_id;
        this.user_id = user_id;
        this.subcribe = subcribe;
    }
    public EventSubscription() {
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

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public int getSubcribe() {
        return subcribe;
    }

    public void setSubcribe(int subcribe) {
        this.subcribe = subcribe;
    }
    
    
}
