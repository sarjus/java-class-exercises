package controller;

import model.LoginModel;
import view.LoginView;
import java.awt.event.*;

// ---------- CONTROLLER CLASS ----------
public class LoginController {
    private LoginModel model;
    private LoginView view;

    public LoginController(LoginModel model, LoginView view) {
        this.model = model;
        this.view = view;

        // Add event listener for login button
        this.view.loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = view.getUsername();
                String pass = view.getPassword();

                if (model.validateUser(user, pass)) {
                    view.showMessage("Login Successful!");
                } else {
                    view.showMessage("Invalid Username or Password!");
                }
            }
        });
    }
}
