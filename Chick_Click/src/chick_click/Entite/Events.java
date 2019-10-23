/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chick_click.Entite;

import java.sql.Date;

/**
 *
 * @author mahmoud
 */
public class Events {
    
    private int event_id;
    private int user_id;
    private String event_date;
    private String address;
    private String event_description;
    private String event_title;
    private String event_picture;

    public Events(int event_id, int user_id, String event_date, String address, String event_description, String event_title, String event_picture) {
        this.event_id = event_id;
        this.user_id = user_id;
        this.event_date = event_date;
        this.address = address;
        this.event_description = event_description;
        this.event_title = event_title;
        this.event_picture = event_picture;
    }

    public Events(int user_id, String event_date, String address, String event_description, String event_title, String event_picture) {
        this.user_id = user_id;
        this.event_date = event_date;
        this.address = address;
        this.event_description = event_description;
        this.event_title = event_title;
        this.event_picture = event_picture;
    }

    public Events() {
    }

    public Events(String event_title) {
        this.event_title = event_title;
    }

    @Override
    public String toString() {
        return "Events{" + "event_id=" + event_id + ", user_id=" + user_id + ", event_date=" + event_date + ", address=" + address + ", event_description=" + event_description + ", event_title=" + event_title + ", event_picture=" + event_picture + '}';
    }


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public void setEvent_picture(String event_picture) {
        this.event_picture = event_picture;
    }

    public int getEvent_id() {
        return event_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getEvent_date() {
        return event_date;
    }

    public String getAddress() {
        return address;
    }

    public String getEvent_description() {
        return event_description;
    }

    public String getEvent_title() {
        return event_title;
    }

    public String getEvent_picture() {
        return event_picture;
    }
    
    
    
}
