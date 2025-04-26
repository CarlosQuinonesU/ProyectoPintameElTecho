/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.pintameeltecho.controller.serviceController.ServiceController;
import ucr.ac.cr.pintameeltecho.controller.userController.UserController;
import ucr.ac.cr.pintameeltecho.model.user.RegularUser;
import ucr.ac.cr.pintameeltecho.view.GUIMain;
import ucr.ac.cr.pintameeltecho.view.GUIRegistration;
import ucr.ac.cr.pintameeltecho.view.GUIServiceRegister;

/**
 *
 * @author Admin
 */
public class MainController implements ActionListener{
    private GUIMain guiMain;
    private GUIRegistration guiRegistration;
    private UserController userController;
    private ServiceController serviceController;
    private GUIServiceRegister guiServiceRegister;

    public MainController() {
        guiMain = new GUIMain();
        guiMain.listen(this);
        guiMain.setVisible(true);
        userController = new UserController();
        userController.setGuiMain(guiMain);
        serviceController = new ServiceController();
        serviceController.setGuiMain(guiMain);
    }

    public GUIMain getGuiMain() {
        return guiMain;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Registrarse":
                System.out.println("Se quiere registrar");
                guiMain.dispose();
                userController.getGuiRegistration().setVisible(true);
                break;
            case "Ingresar":
                System.out.println("Quiere ingresar");
                break;
            case "Servicio":
                System.out.println("Quiere registrar una chamba");
                guiMain.dispose();
                serviceController.getGuiServiceRegister().setVisible(true);
                break;
            case "Salir":
                System.exit(0);
                break;
            default:
                throw new AssertionError();
        }
    }
    
    
    
    
}
