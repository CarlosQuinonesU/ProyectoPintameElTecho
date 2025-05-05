/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.model.review;

import ucr.ac.cr.pintameeltecho.model.review.Review;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import ucr.ac.cr.pintameeltecho.model.GenericDAOJson;

/**
 *
 * @author Carlos
 */
public class ReviewRecord {
    
    private ReviewList list;// añadir reviewlist
    private GenericDAOJson reviewsList;
    
    public ReviewRecord(){
        Type reviewListType = new TypeToken<ReviewList[]>() {}.getType();
        reviewsList= new GenericDAOJson("reviewsList.json", reviewListType);
        
    }
    
    public String add(ReviewList list){
        
        return reviewsList.add(list);
    }
    
    public ReviewList search(String listName) {
        ArrayList<ReviewList> localReviewsList = reviewsList.getAll();
        for (int index = 0; index < localReviewsList.size(); index++) {
            list = (ReviewList) localReviewsList.get(index);
            if (list.getListName().equalsIgnoreCase(listName)) {
                return list;
            }
        }
        return null;
    }

    public String edit(ReviewList list) {
        return reviewsList.edit(list);
    }
    
    

    public String delete(String name) {
        list = search(name);
        return reviewsList.delete(name);
    }

    public String[][] getData() {
        ArrayList<ReviewList> localReviews = reviewsList.getAll();
        String data[][] = new String[localReviews.size()][Review.LABELS_REVIEW.length];
        for (int row = 0; row < localReviews.size(); row++) {
            for (int column = 0; column < Review.LABELS_REVIEW.length; column++) {
                data[row][column] = localReviews.get(row).getReview(column).getProperty(column);// revisar
            }
        }

        return data;
    }

    @Override
    public String toString() {
        return reviewsList.toString();
    }
    
}
