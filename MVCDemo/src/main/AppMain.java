package main;

import model.LoginModel;
import view.LoginView;
import controller.LoginController;

// ---------- MAIN CLASS ----------
public class AppMain {
    public static void main(String[] args) {
        // Create model (handles data and database logic)
        LoginModel model = new LoginModel();

        // Create view (user interface)
        LoginView view = new LoginView();

        // Create controller (connects model and view)
        LoginController controller = new LoginController(model, view);
    }
}
