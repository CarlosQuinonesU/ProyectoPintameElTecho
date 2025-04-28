/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.controller.serviceController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.pintameeltecho.model.service.Service;
import ucr.ac.cr.pintameeltecho.model.service.ServiceRecord;
import ucr.ac.cr.pintameeltecho.view.page.MainPage;
import ucr.ac.cr.pintameeltecho.view.page.ServiceTable;
import ucr.ac.cr.pintameeltecho.view.service.GUIServiceRegister;

/**
 *
 * @author Admin
 */
public class ServiceController implements ActionListener {

    private GUIServiceRegister guiServiceRegister;
    private Service service;
    private ServiceRecord record;
    private MainPage mainPage;
    private String icon;
    private ServiceTable serviceTable;
    
    //Seccion de contructores

    public ServiceController() {
        record=new ServiceRecord();
        guiServiceRegister = new GUIServiceRegister();
        guiServiceRegister.listen(this);
        icon="";
    }
    
    //Seccion de set's and get's

    public void setMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }
    
    public GUIServiceRegister getGuiServiceRegister() {
        return guiServiceRegister;
    }

    public ServiceRecord getRecord() {
        return record;
    }

    public void setServiceTable(ServiceTable serviceTable) {
        this.serviceTable = serviceTable;
    }
    
    
    //Seccion de metodos de accion

    public String validate() {
        String datos="";
        if (guiServiceRegister.getTxtName().equals("")) {
            datos= "Debe rellenar campo (NOMBRE DE SERVICIO)";
        } else if (guiServiceRegister.getTxtDescription().equals("")) {
            datos= "Debe rellenar campo (DESCRIPCION)";
        } else if (guiServiceRegister.getTxtAproximatePrice().equals("")) {
            datos= "Debe rellenar campo (PRECIO APROXIMADO)";
        } else if (guiServiceRegister.getTxtSocio().equals("")) {
            datos ="Debe rellenar campo (Socio)";
        } else if (icon.equals("")) {
            datos ="Debe selecionar una opcion de icono.";
        } else {
            datos= "Se ha registrado correctamente";
        }
        return datos;
    }//fin validate

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Arte":
                icon="src/main/resources/img/IconPaint.png";
                break;
            case "Jardin":
                icon="src/main/resources/img/IconGarden.png";
                break;
            case "Reparaciones":
                icon="src/main/resources/img/IconPlumber.png";
                break;
            case "Registrar":
                String servicioValido="Se ha registrado correctamente";
                String name=guiServiceRegister.getTxtName();
                String socio=guiServiceRegister.getTxtSocio();
                String description=guiServiceRegister.getTxtDescription();
//                String aproximatePrice=guiServiceRegister.getTxtAproximatePrice();
                guiServiceRegister.showMessage(validate());
                
                if(validate()==servicioValido){
                    service = new Service(name, description, socio, icon);
                    record.add(service);
                    icon="";
                    guiServiceRegister.dispose();
                    serviceTable.setData(record.getData(), Service.LABELS_SERVICE);
                    mainPage.setVisible(true);
                    guiServiceRegister.clean();
                }
                break;
            case "Cancelar":
                guiServiceRegister.dispose();
                guiServiceRegister.clean();
                mainPage.setVisible(true);
                break;
            default:
                throw new AssertionError();
        }
    }

}
