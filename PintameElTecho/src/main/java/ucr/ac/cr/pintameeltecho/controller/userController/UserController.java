/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.controller.userController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.pintameeltecho.controller.MainController;
import ucr.ac.cr.pintameeltecho.controller.serviceController.ServiceController;
import ucr.ac.cr.pintameeltecho.model.user.RegularUser;
import ucr.ac.cr.pintameeltecho.view.GUIMain;
import ucr.ac.cr.pintameeltecho.view.GUIRegistration;
import ucr.ac.cr.pintameeltecho.view.GUIServiceRegister;

/**
 *
 * @author Admin
 */
public class UserController implements ActionListener {

    private GUIMain guiMain;
    private GUIRegistration guiRegistration;
    private RegularUser user;
//    private ServiceController serviceController;
    private GUIServiceRegister guiServiceRegister;
    private MainController mainController;
    
    public UserController() {
        guiRegistration = new GUIRegistration();
        guiRegistration.listen(this);
//        guiServiceRegister.listen(serviceController);
//        serviceController = new ServiceController();
    }

    public GUIRegistration getGuiRegistration() {
        return guiRegistration;
    }
    
    public void setGuiMain(GUIMain guiMain) {
        this.guiMain = guiMain;
    }
    

    public String validate() {
        if (guiRegistration.getTxtMail().equals("")) {
            return "Debe rellenar campo (CORREO)";
        } else if (guiRegistration.getTxtName().equals("")) {
            return "Debe rellenar campo (NOMBRE)";
        } else if (guiRegistration.getTxtDirection().equals("")) {
            return "Debe rellenar campo (DIRECCION)";
        } else if (guiRegistration.getTxtPassword().equals("")) {
            return "Debe rellenar campo (CONTRASEÑA)";
        } else if (!(guiRegistration.getTxtPasswordAgain().equals(guiRegistration.getTxtPassword()))) {
            return "Debe tener ingresar la misma contraseña";
        }
        return "Se ha registrado correctamente";
        
    }//fin validate

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Registrar":
                String usuarioValido = "Se ha registrado correctamente";
                String mail = guiRegistration.getTxtMail();
                String name = guiRegistration.getTxtName();
                String direction = guiRegistration.getTxtDirection();
                String rol = guiRegistration.getjCbRol();
                String password = guiRegistration.getTxtPassword();
                guiRegistration.showMessage(validate());

                if (validate() == usuarioValido) {
                    user = new RegularUser(mail, name, direction, rol, password);

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
            default:
                throw new AssertionError();
        }//fin switch
    }//fin ActionPerformed

}//fin class
