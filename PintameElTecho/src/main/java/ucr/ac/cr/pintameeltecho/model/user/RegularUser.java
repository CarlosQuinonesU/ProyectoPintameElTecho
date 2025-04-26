/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.model.user;

/**
 *
 * @author Admin
 */
public class RegularUser {
    
    
    private String mail, nameUser, direction, rol, password;
    
    public static final String LABELS_USER[]={"Correo","Nombre","Rol", "Dirección"};

    public RegularUser() {
    }

    public RegularUser(String mail, String nameUser, String direction, String rol, String password) {
        this.mail = mail;
        this.nameUser = nameUser;
        this.direction = direction;
        this.rol = rol;
        this.password = password;
    }
    
    
    
    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getProperty(int index) {
        switch (index) {
            case 0:
                return mail;
            case 1:
                return nameUser;
            case 2:
                return direction;
            case 3:
                return rol;
            default:
                throw new AssertionError();
        }
    }
    

    @Override
    public String toString() {
        return "RegularUser{" + "mail=" + mail + ", nameUser=" + nameUser + ", direction=" + direction + ", rol=" + rol + '}';
    }
    
    @Override
    public boolean equals(Object obj){
        if (this==obj) {
            return true;
        }
        if (obj==null||getClass()!=obj.getClass()) {
            return false;
        }
        RegularUser user=(RegularUser)obj;
        return mail.equals(user.mail);
    }



}
