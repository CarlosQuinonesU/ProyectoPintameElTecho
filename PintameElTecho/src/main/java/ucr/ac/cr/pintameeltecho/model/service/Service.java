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
    
    private String name, description, socio, calificacion;
//    private String icon;
//    private String aproximatePrice;
//    private double totalPrice;
//    private Review review;
    
    public static final String LABELS_SERVICE[]={"Nombre","Descripción","Socio", "Calificación"};

    public Service() {
    }

    public Service(String name, String description, String socio) {
        this.name = name;
        this.description = description;
//        this.aproximatePrice=aproximatePrice;
        this.socio=socio;
        calificacion= "Buena";
    }

//    public Service(String name, String icon, String description, String aproximatePrice, double totalPrice, Review review) {
//        this.name = name;
//        this.icon = icon;
//        this.description = description;
//        this.aproximatePrice = aproximatePrice;
//        this.totalPrice = totalPrice;
//        this.review = review;
//    }
    

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

//    public Review getReview() {
//        return review;
//    }
//
//    public void setReview(Review review) {
//        this.review = review;
//    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getIcon() {
//        return icon;
//    }
//
//    public void setIcon(String icon) {
//        this.icon = icon;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getAproximatePrice() {
//        return aproximatePrice;
//    }
//
//    public void setAproximatePrice(String aproximatePrice) {
//        this.aproximatePrice = aproximatePrice;
//    }

//    public double getTotalPrice() {
//        return totalPrice;
//    }
//
//    public void setTotalPrice(double totalPrice) {
//        this.totalPrice = totalPrice;
//    }
//    
    public String getProperty(int index){
        switch (index) {
            case 0:
                return name;
            case 1:
                return description;
            case 2:
                return socio;
            case 3:
                return calificacion;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Service{" + "name=" + name + ", description=" + description + ", socio=" + socio + ", calificacion=" + calificacion + '}';
    }


    
    
    
}
