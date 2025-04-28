/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ucr.ac.cr.pintameeltecho.controller.serviceController.ServiceController;
import ucr.ac.cr.pintameeltecho.controller.userController.UserController;
import ucr.ac.cr.pintameeltecho.model.service.Service;
import ucr.ac.cr.pintameeltecho.model.service.ServiceRecord;
import ucr.ac.cr.pintameeltecho.model.user.RegularUser;
import ucr.ac.cr.pintameeltecho.model.user.UserRecord;
import ucr.ac.cr.pintameeltecho.view.GUIMain;
import ucr.ac.cr.pintameeltecho.view.page.GUIInfoService;
import ucr.ac.cr.pintameeltecho.view.page.MainPage;
import ucr.ac.cr.pintameeltecho.view.page.ServiceTable;
import ucr.ac.cr.pintameeltecho.view.user.GUIRegistration;
import ucr.ac.cr.pintameeltecho.view.service.GUIServiceRegister;
import ucr.ac.cr.pintameeltecho.view.user.GUIUserMaintenance;

/**
 *
 * @author Admin
 */
public class MainController implements ActionListener, MouseListener, KeyListener {

    private GUIMain guiMain;
    private GUIRegistration guiRegistration;
    private UserController userController;
    private ServiceController serviceController;
    private GUIServiceRegister guiServiceRegister;
    private UserRecord userRecord;
    private RegularUser user;
    private GUIUserMaintenance guiUserMaintenance;
    private MainPage mainPage;
    private ServiceTable serviceTable;
    private ServiceRecord record;
    private Service service;
    private GUIInfoService guiInfoService;

    public MainController() {
        guiMain = new GUIMain();
        mainPage= new MainPage();
        serviceController = new ServiceController();
        userController = new UserController();
        record=serviceController.getRecord();
        userRecord = userController.getUserRegister();
        guiUserMaintenance = userController.getGuiUserMaintenance();
        serviceTable= mainPage.getServiceTable();
        guiInfoService=new GUIInfoService(mainPage, true);
        guiMain.listen(this);
        guiMain.setVisible(true);
        mainPage.listen(this);
        guiInfoService.listen(this);
        serviceController.setMainPage(mainPage);
        serviceController.setServiceTable(serviceTable);
        userController.setGuiMain(guiMain);
        serviceTable.listenKey(this);
        serviceTable.listenMouse(this);
        serviceTable.setData(record.getData(), Service.LABELS_SERVICE);
        user = null;
    }

    public GUIMain getGuiMain() {
        return guiMain;
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public ServiceTable getServiceTable() {
        return serviceTable;
    }
    
    
    

    public String validate() {
        String datos = "";

        if (guiMain.getTxtLogInUser().equals("")) {
            datos = "El campo del correo electrónico no puede quedar vacío.";
        } else if (guiMain.getTxtLogInPassw().equals("")) {
            datos = "El campo de la contraseña no puede quedar vacío.";
        } else {
            user = userRecord.search(guiMain.getTxtLogInUser());
            if (user == null) {
                datos = "El correo electrónico no se encuentra registrado o coincide, por favor verifique que esté correcto.";
            } else if (!user.getPassword().equals(guiMain.getTxtLogInPassw())) {
                datos = "La contraseña no coincide, por favor verificar.";
            } else {
                datos = "Los datos ingresados son correctos, Bienvenido a PINTAME EL TECHO.";
            }
        }
        return datos;
    }
    public String validateAdmin() {
        String datos = "";

        if (guiMain.getTxtLogInUser().equals("")) {
            datos = "El campo del correo electrónico no puede quedar vacío.";
        } else if (guiMain.getTxtLogInPassw().equals("")) {
            datos = "El campo de la contraseña no puede quedar vacío.";
        } else {
            if (!guiMain.getTxtLogInUser().equals("admin")) {// Se coloca de esta forma, porque se creo un usuario especifico para administar los usuarios y no se pueden crear más.
                datos = "El usuario de administrador no es correcto, por favor solicitarlo.";
            } else if (!guiMain.getTxtLogInPassw().equals("admin")) {//// Se coloca de esta forma, porque se creo un usuario especifico para administar los usuarios y no se pueden crear más.
                datos = "La contraseña de administrador no coincide, por favor verificar o solicitarla.";
            } else {
                datos = "Bienvenido administrador de usuarios.";
            }
        }
        return datos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Registrarse":
                guiMain.dispose();
                userController.getGuiRegistration().setVisible(true);
                break;
            case "Ingresar":
                String usuarioValido = "Los datos ingresados son correctos, Bienvenido a PINTAME EL TECHO.";
                guiMain.showMessage(validate());
                if (validate().equals(usuarioValido)) {
                    guiMain.dispose();
                    guiMain.clean();
                    mainPage.setVisible(true);
                }
                break;
            case "AddService":
                guiMain.dispose();
                serviceController.getGuiServiceRegister().setVisible(true);
                break;
            case "Maintenance":
                String administradorCorrect="Bienvenido administrador de usuarios.";
                guiMain.showMessage(validateAdmin());
                if (validateAdmin()==administradorCorrect) {
                    guiMain.dispose();
                    guiMain.clean();
                    guiUserMaintenance.setVisible(true);
                }
                break;
            case "Informacion":
                if (service != null) {
                    guiInfoService.getjLabelTitle().setText(service.getName());
                    guiInfoService.getjLabelDescrip().setText(service.getDescription());
                    guiInfoService.getjLabelSocioN().setText(service.getSocio());
                    guiInfoService.setJlabelIcon(service.getIcon());
                    guiInfoService.setVisible(true);
                }else{
                    guiMain.showMessage("Debe hacer click en algún servico para poder desplegar más informacón.");
                }
                break;
            case"Hire":
                guiMain.showMessage("Felicidades!\n\nUsted ha contrado el servico, nuestro socio la ha estar realizando el trabajo lo antes posible."
                        + "\nMuchas gracias por preferirnos");
                guiInfoService.dispose();
                mainPage.setVisible(true);
                break;
            case"Cancel":
                guiInfoService.dispose();
                mainPage.setVisible(true);
                break;
            case "LogOut":
                mainPage.dispose();
                guiMain.setVisible(true);
                break;
            case "Salir":
                System.exit(0);
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String [] serviceRow= serviceTable.getRowSelected();
        service= record.search(serviceRow[0]);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        serviceTable.filterByName();
    }

}
