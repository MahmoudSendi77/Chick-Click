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
public class ProfileUser {
    
    private String email;
     private String pseudo;
      private String gender;
       private String role;
        private String photo_profile;
         private String phone;

    public ProfileUser() {
    }

         
    public ProfileUser(String email, String pseudo, String gender, String role, String photo_profile, String phone) {
        this.email = email;
        this.pseudo = pseudo;
        this.gender = gender;
        this.role = role;
        this.photo_profile = photo_profile;
        this.phone = phone;
    }
         

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoto_profile() {
        return photo_profile;
    }

    public void setPhoto_profile(String photo_profile) {
        this.photo_profile = photo_profile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
         
         
      
    
}
