package model;
import entity.AdminEntity;

import java.util.ArrayList;

public class AdminModel {
    private static ArrayList <AdminEntity> AdminList = new ArrayList<>();
    public static ArrayList<AdminEntity> arrayAdmin(){
        return AdminList;
    }
    public static void dataAdmin(){
        AdminList.add(new AdminEntity("surya","07548"));
    }

    public static boolean loginAdmin(String username, String password) {
        for (AdminEntity objAdmin : AdminList) {
            if (objAdmin.getUsername().equals(username) && objAdmin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
