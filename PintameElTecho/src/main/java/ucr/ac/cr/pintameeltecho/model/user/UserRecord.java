/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.model.user;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import ucr.ac.cr.pintameeltecho.model.GenericDAOJson;

/**
 *
 * @author Admin
 */
public class UserRecord {

    private RegularUser user;
    private GenericDAOJson users;

    public UserRecord() {
        Type userType = new TypeToken<RegularUser[]>() {}.getType();
        users = new GenericDAOJson("users.json", userType);
    }

    public String add(RegularUser user) {
        return users.add(user);
    }

    public RegularUser search(String mail) {
        ArrayList<RegularUser> localUsers = users.getAll();
        for (int index = 0; index < localUsers.size(); index++) {
            user = (RegularUser) localUsers.get(index);
            if (user.getMail().equalsIgnoreCase(mail)) {
                return user;
            }
        }
        return null;
    }

    public String edit(RegularUser user) {
        return users.edit(user);
    }

    public String delete(String mail) {
        user = search(mail);
        return users.delete(user);
    }

    public String[][] getData() {
        ArrayList<RegularUser> localUsers = users.getAll();
        String data[][] = new String[localUsers.size()][RegularUser.LABELS_USER.length];
        for (int row = 0; row < localUsers.size(); row++) {
            for (int column = 0; column < RegularUser.LABELS_USER.length; column++) {
                data[row][column] = localUsers.get(row).getProperty(column);
            }
        }

        return data;
    }

    @Override
    public String toString() {
        return users.toString();
    }

}// Fin de clase
