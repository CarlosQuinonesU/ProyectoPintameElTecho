/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.controller.serviceController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.pintameeltecho.controller.MainController;
import ucr.ac.cr.pintameeltecho.model.service.Service;
import ucr.ac.cr.pintameeltecho.model.service.ServiceRecord;
import ucr.ac.cr.pintameeltecho.view.GUIMain;
import ucr.ac.cr.pintameeltecho.view.service.GUIServiceRegister;

/**
 *
 * @author Admin
 */
public class ServiceController implements ActionListener {

    private GUIServiceRegister guiServiceRegister;
    private Service service;
    private MainController mainController;
    private GUIMain guiMain;
    private ServiceRecord record;

    public ServiceController() {
        record=new ServiceRecord();
        guiServiceRegister = new GUIServiceRegister();
        guiServiceRegister.listen(this);
        
    }
    
    public void setGuiMain(GUIMain guiMain) {
        this.guiMain = guiMain;
    }

    public GUIServiceRegister getGuiServiceRegister() {
        return guiServiceRegister;
    }

    public ServiceRecord getRecord() {
        return record;
    }
    
    

    public String validate() {
         if (guiServiceRegister.getTxtName().equals("")) {
            return "Debe rellenar campo (NOMBRE DE SERVICIO)";
        } else if (guiServiceRegister.getTxtDescription().equals("")) {
            return "Debe rellenar campo (DESCRIPCION)";
        } else if (guiServiceRegister.getTxtAproximatePrice().equals("")) {
            return "Debe rellenar campo (PRECIO APROXIMADO)";
        } 
        return "Se ha registrado correctamente";

    }//fin validate

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Arte":
                 System.out.println("Selecciono esta etiqueta");
                break;
            case "Jardin":
                System.out.println("Selecciono esta etiqueta");
                break;
            case "Reparaciones":
                System.out.println("Selecciono esta etiqueta");
                break;
            case "Registrar":
                String servicioValido="Se ha registrado correctamente";
                String name=guiServiceRegister.getTxtName();
                String socio=guiServiceRegister.getTxtSocio();
                String description=guiServiceRegister.getTxtDescription();
//                String aproximatePrice=guiServiceRegister.getTxtAproximatePrice();
                guiServiceRegister.showMessage(validate());
                
                if(validate()==servicioValido){
                    service = new Service(name, description, socio);
                    record.add(service);
                }
//                System.out.println(service.toString());
                break;
            case "Cancelar":
                guiServiceRegister.dispose();
                guiMain.setVisible(true);
                break;
            default:
                throw new AssertionError();
        }
    }

}
