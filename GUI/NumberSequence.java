/*Write a Java program using Swing to create a frame having three text fields,
threelabels and a button. The interface has to accept a number in the first text
field. While clicking the button, the second and third textfields have to display
the previous number and next number respectively, of the accepted input
number.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberSequence extends JFrame implements ActionListener {
    private JTextField currentTextField, previousTextField, nextTextField;

    public NumberSequence() {
        // Set Frame Properties
        setTitle("Number Sequence");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        // Create and add Components
        JLabel currentLabel = new JLabel("Enter a Number:");
        currentTextField = new JTextField();
        JLabel previousLabel = new JLabel("Previous Number:");
        previousTextField = new JTextField();
        previousTextField.setEditable(false); // Make it non-editable
        JLabel nextLabel = new JLabel("Next Number:");
        nextTextField = new JTextField();
        nextTextField.setEditable(false); // Make it non-editable

        JButton generateButton = new JButton("Generate");
        generateButton.addActionListener(this);

        panel.add(currentLabel);
        panel.add(currentTextField);
        panel.add(previousLabel);
        panel.add(previousTextField);
        panel.add(nextLabel);
        panel.add(nextTextField);
        panel.add(new JLabel()); // Empty label for layout
        panel.add(generateButton);

        add(panel);
    }

    public static void main(String[] args) {
        
            NumberSequence sequence = new NumberSequence();
            sequence.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
            int currentNumber = Integer.parseInt(currentTextField.getText());

            // Display the previous and next numbers
            previousTextField.setText(String.valueOf(currentNumber - 1));
            nextTextField.setText(String.valueOf(currentNumber + 1));
        
    }
}
