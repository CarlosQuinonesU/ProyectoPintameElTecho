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
    private String icon;
    private String aproximatePrice;

    public static final String LABELS_SERVICE[] = {"Nombre", "Descripción", "Socio", "Calificación"};

    public Service() {
    }

    public Service(String name, String description, String aproximatePrice, String socio, String icon) {
        this.name = name;
        this.description = description;
        this.aproximatePrice = aproximatePrice;
        this.socio = socio;
        this.icon = icon;
        calificacion = "Sin calificación";
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int starts, int tamaño) {
        String calificacion = "Sin calificación";
        int promedio =starts;
        if (tamaño != 0) {
            promedio = (int) starts / tamaño;
        }
        switch (promedio) {
            case 5:
                calificacion = "Muy buena";
                break;
            case 4:
                calificacion = "Buena";
                break;
            case 3:
                calificacion = "Normal";
                break;
            case 2:
                calificacion = "Mala";
                break;
            case 1:
                calificacion = "Muy mala";
                break;
            default:
                break;
        }
        this.calificacion = calificacion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getAproximatePrice() {
        return aproximatePrice;
    }

    public void setAproximatePrice(String aproximatePrice) {
        this.aproximatePrice = aproximatePrice;
    }

    public String getProperty(int index) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Service service = (Service) obj;
        return name.equals(service.name);
    }

}
