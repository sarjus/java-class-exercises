package view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    // GUI components
    public JTextField usernameField;
    public JPasswordField passwordField;
    public JButton loginButton;

    // Constructor
    public LoginView() {
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        loginButton = new JButton("Login");

        // Layout setup
        setLayout(new GridLayout(3, 2, 5, 5));
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(new JLabel());
        add(loginButton);

        // Frame settings
        setTitle("Login Form - MVC with MySQL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Getters to access text fields
    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    // Show message dialog
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
