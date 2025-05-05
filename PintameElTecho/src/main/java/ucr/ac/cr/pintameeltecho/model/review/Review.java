/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.model.review;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Admin
 */
public class Review {

    private int stars;
    private String textReview, userName,commentDate;
//    private LocalDate date;
//    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public static final String LABELS_REVIEW[] = {"Nombre", "Fecha", "Comentario", "Estrellas"};


    public Review(int stars, String textReview, String userName) {
        this.stars = stars;
        this.textReview = textReview;
//        date= LocalDate.now();
        this.userName = userName;
//        asignarFecha();
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getTextReview() {
        return textReview;
    }

    public void setTextReview(String textReview) {
        this.textReview = textReview;
    }

//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    // mtedos de accion
    
//    public void asignarFecha(){
//        commentDate=date.format(formato);
//    }

    public String getProperty(int index) {
        switch (index) {
            case 0:
                return userName;
            case 1:
                return textReview;
            case 2:
                return String.valueOf(stars);
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Review{" + "stars=" + stars + ", textReview=" + textReview +  ", userName=" + userName + '}';
    }

}
