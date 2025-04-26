/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.controller.userController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.pintameeltecho.model.user.RegularUser;
import ucr.ac.cr.pintameeltecho.view.GUIMain;
import ucr.ac.cr.pintameeltecho.view.GUIRegistration;

/**
 *
 * @author Admin
 */
public class UserController implements ActionListener {
    
    private GUIMain guiMain;
    private GUIRegistration guiRegistration;
    private RegularUser user;
    public UserController() {
        guiMain = new GUIMain();
        guiMain.listen(this);
        guiMain.setVisible(true);
        guiRegistration = new GUIRegistration();
        guiRegistration.listen(this);
    }
    
    public String validate(){
        if(guiRegistration.getTxtMail().equals("")){
            if(guiRegistration.getTxtName().equals("")){
                if(guiRegistration.getTxtDirection().equals("")){
                    if(guiRegistration.getTxtPassword().equals("")){
                        if(guiRegistration.getTxtPasswordAgain().equals(guiRegistration.getTxtPassword())){
                            return "Debe tener ingresar la misma contraseña";
                        }//if password again
                        return "Debe rellenar campo (CONTRASEÑA)";
                    }//if password
                    return "Debe rellenar campo (DIRECCION)";
                }//if direction
                return "Debe rellenar campo (NOMBRE)";
            }//if name
            return "Debe rellenar campo (CORREO)";
        }//if mail
        return "Se ha registrado correctamente";
    }//fin validate
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Registrarse":
                System.out.println("Se quiere registrar");
                guiMain.dispose();
                guiRegistration.setVisible(true);
                break;
            case "Ingresar":
                System.out.println("Quiere ingresar");
                break;
            case "Registrar":
                String usuarioValido="Se ha registrado correctamente";
                String mail=guiRegistration.getTxtMail();
                String name=guiRegistration.getTxtName();
                String direction=guiRegistration.getTxtDirection();
                String rol=guiRegistration.getjCbRol();
                String password=guiRegistration.getTxtPassword();
                guiRegistration.showMessage(validate());
                if(validate()==usuarioValido){
                    
                    user.setMail(mail);
                    user.setNameUser(name);
                    user.setDirection(direction);
                    user.setRol(rol);
                    user.setPassword(password);
                }
                //System.out.println(user.toString());
                break;
            case "Cancelar":
                System.out.println("Lo cancelo");
                guiRegistration.dispose();
                guiMain.setVisible(true);
                break;
            case "Salir":
                    System.exit(0);
                break;
            default:
                throw new AssertionError();
        }//fin switch
    }//fin ActionPerformed

    
}//fin class
