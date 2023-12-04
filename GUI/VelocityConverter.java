/* Develop a swing application  that allows to input velocity in Kilometers/Hour, convert and
display in Meters/Second. */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VelocityConverter extends JFrame implements ActionListener {
    private JTextField kmPerHourTextField;
    private JTextField metersPerSecondTextField;

    public VelocityConverter() {
        // Set Frame Properties
        setTitle("Velocity Converter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Create and add Components
        JLabel kmPerHourLabel = new JLabel("Velocity (km/h):");
        kmPerHourTextField = new JTextField();
        JLabel metersPerSecondLabel = new JLabel("Velocity (m/s):");
        metersPerSecondTextField = new JTextField();
        metersPerSecondTextField.setEditable(false); // Make it non-editable

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(this);

        panel.add(kmPerHourLabel);
        panel.add(kmPerHourTextField);
        panel.add(metersPerSecondLabel);
        panel.add(metersPerSecondTextField);
        panel.add(new JLabel()); // Empty label for layout
        panel.add(convertButton);

        add(panel);
        
        // Center the frame on the screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VelocityConverter converter = new VelocityConverter();
            converter.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
            // Convert Velocity from km/h to m/s
            double kmPerHour = Double.parseDouble(kmPerHourTextField.getText());
            double metersPerSecond = kmPerHour * 1000 / 3600; // Conversion formula

            // Display the result in the Meters/Second TextField with two decimal places
            metersPerSecondTextField.setText(String.format("%.2f", metersPerSecond));
        
    }
}
