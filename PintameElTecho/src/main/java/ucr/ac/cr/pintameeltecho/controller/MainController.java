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

    public MainController() {
        guiMain = new GUIMain();
        guiMain.listen(this);
        guiMain.setVisible(true);
        serviceController = new ServiceController();
        serviceController.setGuiMain(guiMain);
        userController = new UserController();
        userController.setGuiMain(guiMain);
        record=serviceController.getRecord();
        userRecord = userController.getUserRegister();
        guiUserMaintenance = userController.getGuiUserMaintenance();
        mainPage= new MainPage();
        serviceTable= mainPage.getServiceTable();
        serviceTable.listenKey(userController);
        serviceTable.listenMouse(userController);
        serviceTable.setData(record.getData(), Service.LABELS_SERVICE);
        user = null;
    }

    public GUIMain getGuiMain() {
        return guiMain;
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
                datos = "Los datos ingresados son correctos, bienvenido a PINTAME EL TECHO.";
            }
        }
        return datos;
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
                String usuarioValido = "Los datos ingresados son correctos, bienvenido a PINTAME EL TECHO.";
                guiMain.showMessage(validate());
                if (validate().equals(usuarioValido)) {
                    guiMain.dispose();
                    guiMain.clean();
                    mainPage.setVisible(true);
                }
                break;
            case "Servicio":
                System.out.println("Quiere registrar una chamba");
                guiMain.dispose();
                serviceController.getGuiServiceRegister().setVisible(true);
                break;
            case "Maintenance":
                
                
                guiMain.dispose();
                guiUserMaintenance.setVisible(true);
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
    }

}
