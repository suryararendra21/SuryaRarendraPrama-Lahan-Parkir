import controller.ParkirController;
import model.AdminModel;
import view.MenuAdmin;

public class Main {
    public static void main(String[] args) {
        ParkirController parkirController = new ParkirController();
        MenuAdmin menuAdmin = new MenuAdmin(parkirController);
        AdminModel.dataAdmin();
        menuAdmin.AdminLogin();
    }
}
