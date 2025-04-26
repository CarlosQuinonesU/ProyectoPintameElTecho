/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.controller.userController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ucr.ac.cr.pintameeltecho.controller.MainController;
import ucr.ac.cr.pintameeltecho.controller.serviceController.ServiceController;
import ucr.ac.cr.pintameeltecho.model.user.RegularUser;
import ucr.ac.cr.pintameeltecho.model.user.UserRecord;
import ucr.ac.cr.pintameeltecho.view.GUIMain;
import ucr.ac.cr.pintameeltecho.view.panels.DataTable;
import ucr.ac.cr.pintameeltecho.view.user.GUIRegistration;
import ucr.ac.cr.pintameeltecho.view.service.GUIServiceRegister;
import ucr.ac.cr.pintameeltecho.view.user.GUIUserMaintenance;

/**
 *
 * @author Admin
 */
public class UserController implements ActionListener, MouseListener, KeyListener {

    private GUIMain guiMain;
    private GUIRegistration guiRegistration;
    private RegularUser user;
    private UserRecord userRegister;
//    private ServiceController serviceController;
//    private GUIServiceRegister guiServiceRegister;
    private MainController mainController;
    private GUIUserMaintenance guiUserMaintenance;
    private DataTable dataTable;
    
    
    public UserController() {
        userRegister=new UserRecord();
        guiRegistration = new GUIRegistration();
        guiRegistration.listen(this);
        guiUserMaintenance=new GUIUserMaintenance(this);
        dataTable = guiUserMaintenance.getDataTable();
        dataTable.listenKeyBoard(this);
        dataTable.listenMouse(this);
        dataTable.setData(userRegister.getData(), RegularUser.LABELS_USER);
        
//        guiServiceRegister.listen(serviceController);
//        serviceController = new ServiceController();
    }

    public GUIRegistration getGuiRegistration() {
        return guiRegistration;
    }
    
    public void setGuiMain(GUIMain guiMain) {
        this.guiMain = guiMain;
    }

    public UserRecord getUserRegister() {
        return userRegister;
    }

    public GUIUserMaintenance getGuiUserMaintenance() {
        return guiUserMaintenance;
    }
    
    
    

    public String validate() {
        String datos="";
        if (guiRegistration.getTxtMail().equals("")) {
            datos= "Debe rellenar campo (CORREO)";
        } else if (guiRegistration.getTxtName().equals("")) {
            datos= "Debe rellenar campo (NOMBRE)";
        } else if (guiRegistration.getTxtDirection().equals("")) {
            datos= "Debe rellenar campo (DIRECCION)";
        } else if (guiRegistration.getTxtPassword().equals("")) {
            datos= "Debe rellenar campo (CONTRASEÑA)";
        } else if (!(guiRegistration.getTxtPasswordAgain().equals(guiRegistration.getTxtPassword()))) {
            datos= "Las contraseñas no coinciden, por favor verificar.";
        }else{
            datos="Se ha registrado correctamente \nAhora inicie sesion para acceder a su cuenta";
        }
        return datos;
        
    }//fin validate

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Registrar":
                String usuarioValido = "Se ha registrado correctamente \nAhora inicie sesion para acceder a su cuenta";
                String mail = guiRegistration.getTxtMail();
                String name = guiRegistration.getTxtName();
                String direction = guiRegistration.getTxtDirection();
                String rol = guiRegistration.getjCbRol();
                String password = guiRegistration.getTxtPassword();
                guiRegistration.showMessage(validate());
                
                

                if (validate() == usuarioValido) {
                    user = new RegularUser(mail, name, direction, rol, password);
                    userRegister.add(user);
                    guiRegistration.dispose();
                    guiMain.setVisible(true);
                    
                }
                System.out.println(user.toString());
                break;
            case "Cancelar":
                System.out.println("Lo cancelo");
                guiRegistration.dispose();
                guiMain.setVisible(true);
                ;
                break;
            case "Salir":
                System.exit(0);
                break;
            case "Agregar":
                break;
            case "Editar":
                break;
            case "Eliminar":
                break;
            case "Menu":
                guiUserMaintenance.dispose();
                guiMain.setVisible(true);
                break;
                
                
                
                
            default:
                throw new AssertionError();
        }//fin switch
    }//fin ActionPerformed

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

}//fin class
