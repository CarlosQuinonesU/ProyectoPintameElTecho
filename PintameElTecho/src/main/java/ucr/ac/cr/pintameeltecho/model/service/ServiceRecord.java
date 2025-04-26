/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.model.service;

import ucr.ac.cr.pintameeltecho.model.GenericDAOJson;

/**
 *
 * @author Admin
 */
public class ServiceRecord {
    
    private Service service;
    
    private GenericDAOJson services;

    public ServiceRecord() {
    }
    
    public String search(String id){
        return null;
    } 
    
    public String delete(String id){
        return null;
    }
    
    public String[][] getData(){
        return null;
    }

    @Override
    public String toString() {
        return "ServiceRecord{" + "service=" + service + ", services=" + services + '}';
    }
    
    
    
    
}
