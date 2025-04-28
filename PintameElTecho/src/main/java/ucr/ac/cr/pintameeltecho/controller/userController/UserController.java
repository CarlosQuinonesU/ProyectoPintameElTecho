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
import ucr.ac.cr.pintameeltecho.model.user.RegularUser;
import ucr.ac.cr.pintameeltecho.model.user.UserRecord;
import ucr.ac.cr.pintameeltecho.view.GUIMain;
import ucr.ac.cr.pintameeltecho.view.panels.DataTable;
import ucr.ac.cr.pintameeltecho.view.user.GUIRegistration;
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
    private MainController mainController;
    private GUIUserMaintenance guiUserMaintenance;
    private DataTable dataTable;
    private int option;

    //Seccion de constructores
    
    public UserController() {
        userRegister=new UserRecord();
        guiRegistration = new GUIRegistration();
        guiRegistration.listen(this);
        guiUserMaintenance=new GUIUserMaintenance(this);
        dataTable = guiUserMaintenance.getDataTable();
        dataTable.listenKeyBoard(this);
        dataTable.listenMouse(this);
        dataTable.setData(userRegister.getData(), RegularUser.LABELS_USER);
        option=0;
    }
    
    //Seccion de set's and get's

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

    // Seccion de metodos de accion
    
    public String validate() { //Este metodo posiblemente varie en futuro para controlar lo que se está ingresando,por el momento solo que no esté vacío.
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
            datos="Campos llenos";
        }
        return datos;
    }//fin validate

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Registrar":
                String usuarioValido = "Campos llenos";
                String mail = guiRegistration.getTxtMail();
                String name = guiRegistration.getTxtName();
                String direction = guiRegistration.getTxtDirection();
                String rol = guiRegistration.getJcbRol();
                String password = guiRegistration.getTxtPassword();
                guiRegistration.showMessage(validate());

                if (validate() == usuarioValido) {
                    if (option==1||option==0) {
                        user = new RegularUser(mail, name, direction, rol, password);
                        guiRegistration.showMessage(userRegister.add(user)+"\n\nAhora inicie sesion para acceder a su cuenta");
                        option=0;
                        guiRegistration.dispose();
                        guiRegistration.clean();
                        if (option==0) {
                            guiUserMaintenance.setVisible(true);
                        }else{
                            guiMain.setVisible(true);
                        }
                    } else {
                        user.setNameUser(guiRegistration.getTxtName());
                        user.setDirection(guiRegistration.getTxtDirection());
                        user.setRol(guiRegistration.getJcbRol());
                        String currentMail = guiRegistration.getTxtMail();
                        if (!currentMail.equals(user.getMail())) {
                            guiRegistration.showMessage("El correo no puede ser modificado, porfavor coloque el correo registrado.");
                        } else {
                            guiRegistration.showMessage(userRegister.edit(user));
                            guiRegistration.dispose();
                            option = 0;
                            guiUserMaintenance.setVisible(true);
                        }
                    }
                    dataTable.setData(userRegister.getData(), RegularUser.LABELS_USER);

                }
                break;
            case "Cancelar":
                guiRegistration.dispose();
                if (option == 1) {
                    guiUserMaintenance.setVisible(true);
                    option=0;
                } else {
                    guiMain.setVisible(true);
                }
                ;
                break;
            case "Salir":
                System.exit(0);
                break;
            case "Agregar":
                option=1;
                guiRegistration.setVisible(true);
                break;
            case "Editar":
                option=2;
                if (user!=null) {
                    guiRegistration.setTxtMail(user.getMail());
                    guiRegistration.setTxtName(user.getNameUser());
                    guiRegistration.setTxtDirection(user.getDirection());
                    guiRegistration.setJcbRol(user.getRol());
                    guiRegistration.setTxtPassword(user.getPassword());
                    guiRegistration.setTxtPasswordAgain(user.getPassword());
                    guiRegistration.setVisible(true);
//                    user=null;
                }else{
                    guiRegistration.showMessage("Debe seleccionar un usuario para poder modificarlo.");
                }
                
                break;
            case "Eliminar":
                if (user!=null) {
                    guiRegistration.showMessage(userRegister.delete(user.getMail()));
                    dataTable.setData(userRegister.getData(), RegularUser.LABELS_USER);
                    user=null;
                }else{
                    guiRegistration.showMessage("Debe seleccionar un usuario para poder borrarlo.");
                }
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
        String[] userRow= dataTable.getRowSelected();
        user= userRegister.search(userRow[0]);
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
        dataTable.filterByMail();
    }

}//fin class
