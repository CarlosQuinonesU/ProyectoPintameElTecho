/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.controller.serviceController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Admin
 */
public class ServiceController implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Arte":

                break;
            case "Jardin":

                break;
            case "Reparaciones":

                break;
            case "Registrar":

                break;
            case "Cancelar":

                break;
            default:
                throw new AssertionError();
        }
    }

}
