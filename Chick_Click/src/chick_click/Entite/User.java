/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chick_click.Entite;

//import java.sql.Date;

import java.util.Date;


/**
 *
 * @author mahmoud
 */
public class User {
    private int user_id;
    private String role;
    private String email;
    
    private String password;
    private String pseudo;
    private String gender;
    
    private Date date_creation;
    private String country;
    private String interrest;
    
    
    public User() {
    }

    public User(String role, String email, String password, String pseudo, String gender, Date date_creation, String country, String interrest) {
        this.role = role;
        this.email = email;
        this.password = password;
        this.pseudo = pseudo;
        this.gender = gender;
        this.date_creation = date_creation;
        this.country = country;
        this.interrest = interrest;
    }

    public User(int user_id, String role, String email, String password, String pseudo, String gender, Date date_creation, String country, String interrest) {
        this.user_id = user_id;
        this.role = role;
        this.email = email;
        this.password = password;
        this.pseudo = pseudo;
        this.gender = gender;
        this.date_creation = date_creation;
        this.country = country;
        this.interrest = interrest;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInterrest() {
        return interrest;
    }

    public void setInterrest(String interrest) {
        this.interrest = interrest;
    }

  
    
}
