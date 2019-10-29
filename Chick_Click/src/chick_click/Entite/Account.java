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
public class Account {
    
    private String photo_profile ;
    private String Status;
    private int user_id;
    private int phone;

    public Account() {
    }

    public Account(String photo_profile, String Status, int user_id, int phone) {
        this.photo_profile = photo_profile;
        this.Status = Status;
        this.user_id = user_id;
        this.phone = phone;
    }

    public String getPhoto_profile() {
        return photo_profile;
    }

    public void setPhoto_profile(String photo_profile) {
        this.photo_profile = photo_profile;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }


   
    
}
