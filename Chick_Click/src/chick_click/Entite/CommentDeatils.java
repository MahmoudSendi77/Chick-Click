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
public class CommentDeatils {
    private String pseudo;
    private String content;
    private String datecomment;
    private String photoProfile;

    public CommentDeatils() {
    }

    public CommentDeatils(String pseudo, String content, String datecomment, String photoProfile) {
        this.pseudo = pseudo;
        this.content = content;
        this.datecomment = datecomment;
        this.photoProfile = photoProfile;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDatecomment() {
        return datecomment;
    }

    public void setDatecomment(String datecomment) {
        this.datecomment = datecomment;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
        this.photoProfile = photoProfile;
    }
    
    
    
    
    
    
    
}
