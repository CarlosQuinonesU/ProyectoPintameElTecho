/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.model.service;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import ucr.ac.cr.pintameeltecho.model.GenericDAOJson;

/**
 *
 * @author Admin
 */
public class ServiceRecord {

    private Service service;
    private GenericDAOJson services;

    public ServiceRecord() {
        Type serviceType = new TypeToken<Service[]>() {}.getType();
        services = new GenericDAOJson("services.json", serviceType);
    }

    public String add(Service service) {
        return services.add(service);
    }

    public Service search(String name) {
        ArrayList<Service> localServices = services.getAll();
        for (int index = 0; index < localServices.size(); index++) {
            service = (Service) localServices.get(index);
            if (service.getName().equalsIgnoreCase(name)) {
                return service;
            }
        }
        return null;
    }

    public String edit(Service service) {
        return services.edit(service);
    }

    public String delete(String name) {
        service = search(name);
        return services.delete(service);
    }

    public String[][] getData() {
        ArrayList<Service> localServices = services.getAll();
        String data[][] = new String[localServices.size()][Service.LABELS_SERVICE.length];
        for (int row = 0; row < localServices.size(); row++) {
            for (int column = 0; column < Service.LABELS_SERVICE.length; column++) {
                data[row][column] = localServices.get(row).getProperty(column);
            }
        }

        return data;
    }

    @Override
    public String toString() {
        return services.toString();
    }

}
