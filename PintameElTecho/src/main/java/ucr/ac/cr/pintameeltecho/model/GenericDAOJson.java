/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class GenericDAOJson <T>{
    
    private String fileName;
    private Gson gson;
    private Type type;

    public GenericDAOJson() {
    }

    public GenericDAOJson(String fileName, Type type) {
        this.fileName = fileName;
        this.type = type;
        gson=new GsonBuilder().setPrettyPrinting().create();// Formato del Gson
    }
    
    
    
    
    public ArrayList<T> getAll(){
       try (FileReader reader= new FileReader(fileName)){
           T[] elements = gson.fromJson(reader, type);
           if (elements==null) {
               return new ArrayList<>();
           }else{
               return new ArrayList<>(Arrays.asList(elements));
           }
       }
       catch (IOException e){
           return new ArrayList<> ();
       } 
    }
    
    
    public void writeJson(ArrayList<T> elements) {
        try (FileWriter writer = new FileWriter(fileName)){
            gson.toJson(elements.toArray(),writer);
        } catch (IOException ex) {
            Logger.getLogger(GenericDAOJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String add(T element) {
        ArrayList<T> elements=getAll();
        if (elements.add(element)) {
            writeJson(elements);
            return "El usuario fue registrado exitosamente."; 
        }
        return "Hubo un problema en la ejecución.";
    }
    

    public int search(T element) {
        ArrayList<T> elements =getAll();
        for (int index = 0; index < elements.size(); index++) {
            if (elements.get(index).equals(element)) {
                return index;
            }
        }
        return -1;
    }
    
    public String delete(T element) {
        ArrayList<T> elements =getAll();
        int index = search(element);
        if (index == -1) {
            return "Ese elemento no se encuentra registrado.";
        } else {
            elements.remove(index);
            writeJson(elements);
            
        }
        return "El elememto fue eliminado.";
    }
    
    public String edit(T element){
        ArrayList<T> elements= getAll();
        int index=search(element);
        elements.set(index, element);
        writeJson(elements);
        return "Los datos han sido modificados.";
    }


    
}// Fin de clase
    
    

