/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.model.user;

import ucr.ac.cr.pintameeltecho.model.GenericDAOJson;

/**
 *
 * @author Admin
 */
public class UserRecord {
    
    private RegularUser user;
    
    private GenericDAOJson users;

    public UserRecord() {
    }
    
    public String search(String mail){
        return null;
    } 
    
    public String delete(String mail){
        return null;
    }
    
    public String[][] getData(){
        return null;
    }

    @Override
    public String toString() {
        return "UserRecord{" + "user=" + user + ", users=" + users + '}';
    }
    
    
    
    
}
