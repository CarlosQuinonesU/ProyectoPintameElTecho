/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.model.service;

/**
 *
 * @author Admin
 */
public class Review {
    
    private int stars;
    private String textReview, workType, date, userName;

    public Review() {
    }

    public Review(int stars, String textReview, String workType, String date, String userName) {
        this.stars = stars;
        this.textReview = textReview;
        this.workType = workType;
        this.date = date;
        this.userName = userName;
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

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Review{" + "stars=" + stars + ", textReview=" + textReview + ", workType=" + workType + ", date=" + date + ", userName=" + userName + '}';
    }
    
    
}
