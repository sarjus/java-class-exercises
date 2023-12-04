/*Java Swing based program to display a GUI to accept username and password from user. 
  The GUI should contain the required UI elements and should have appropriate event handling aspects.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame implements ActionListener {
    private JTextField usernameTextField;
    private JPasswordField passwordField;

    public LoginGUI() {
        // Set Frame Properties
        setTitle("Login Form");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Create and add Components
        JLabel usernameLabel = new JLabel("Username:");
        usernameTextField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        panel.add(usernameLabel);
        panel.add(usernameTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Empty label for layout
        panel.add(loginButton);

        add(panel);
        // Center the frame on the screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
      
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.setVisible(true);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle the login button click event
        String username = usernameTextField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        // Perform login authentication (dummy check for demonstration)
        if (username.equals("user") && password.equals("password")) {
            JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Clear the password field after each login attempt
        passwordField.setText("");
    }
}
