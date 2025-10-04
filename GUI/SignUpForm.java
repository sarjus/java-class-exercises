import javax.swing.*;
import java.awt.*;

public class SignUpForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sign Up Form");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10)); // rows, cols, hgap, vgap
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // margin around panel

        // Labels and Controls
        JLabel nameLabel = new JLabel("   Name:");  // extra space before text
        JTextField nameField = new JTextField();

        JLabel emailLabel = new JLabel("   Email:");
        JTextField emailField = new JTextField();

        JLabel genderLabel = new JLabel("   Gender:");
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(male);
        genderPanel.add(female);

        JLabel countryLabel = new JLabel("   Country:");
        String[] countries = {"India", "USA", "UK", "Canada", "Australia"};
        JComboBox<String> countryBox = new JComboBox<>(countries);

        JLabel addressLabel = new JLabel("   Address:");
        JTextArea addressArea = new JTextArea(3, 15);

        JButton submitButton = new JButton("Submit");

        // Add components
        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(emailLabel);
        panel.add(emailField);

        panel.add(genderLabel);
        panel.add(genderPanel);

        panel.add(countryLabel);
        panel.add(countryBox);

        panel.add(addressLabel);
        panel.add(new JScrollPane(addressArea));

        panel.add(new JLabel("")); // Empty space
        panel.add(submitButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
