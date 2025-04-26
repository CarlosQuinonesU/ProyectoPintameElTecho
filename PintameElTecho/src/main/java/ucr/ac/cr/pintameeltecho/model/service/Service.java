/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.model.service;

/**
 *
 * @author Admin
 */
public class Service {
    
    private String name, icon, description;
    private double aproximatePrice, totalPrice;
    private Review review;

    public Service() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAproximatePrice() {
        return aproximatePrice;
    }

    public void setAproximatePrice(double aproximatePrice) {
        this.aproximatePrice = aproximatePrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Service{" + "name=" + name + ", icon=" + icon + ", description=" + description + ", aproximatePrice=" + aproximatePrice + ", totalPrice=" + totalPrice + ", review=" + review + '}';
    }
    
    
    
}
