/*Java program that uses two textfields and a button. The first textfield accepts temperature 
  in Celsius. When the ‘Convert’ button is clicked the second textfield displays the temperature 
  in Fahrenheit. Use appropriate Swing components and event handling techniques. F=(C*9/5)+32*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter extends JFrame implements ActionListener {
    private JTextField celsiusTextField;
    private JTextField fahrenheitTextField;

    TemperatureConverter() {
        // Set Frame Properties
        setTitle("Temperature Converter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Create and add Components
        JLabel celsiusLabel = new JLabel("Celsius");
        celsiusTextField = new JTextField();
        JLabel fahrenheitLabel = new JLabel("Fahrenheit");
        fahrenheitTextField = new JTextField();
        fahrenheitTextField.setEditable(false);
        JButton convertButton = new JButton("Convert");

        // Register the Button -> ActionListener
        convertButton.addActionListener(this);

        panel.add(celsiusLabel);
        panel.add(celsiusTextField);
        panel.add(fahrenheitLabel);
        panel.add(fahrenheitTextField);
        panel.add(new JLabel()); // Empty label for layout
        panel.add(convertButton);

        add(panel);
        
        // Center the frame on the screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Create and display the GUI on the EDT
        SwingUtilities.invokeLater(() -> {
            TemperatureConverter converter = new TemperatureConverter();
            converter.setVisible(true);
        });
    }

    public void actionPerformed(ActionEvent e) {
       
            // Convert Celsius to Fahrenheit when the 'Convert' button is clicked
            double celsius = Double.parseDouble(celsiusTextField.getText());
            double fahrenheit = (celsius * 9 / 5) + 32;
            
            // Display the result in the Fahrenheit TextField with two decimal places
            fahrenheitTextField.setText(String.format("%.2f", fahrenheit));
        
    }
}
