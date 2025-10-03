import javax.swing.*;
import java.awt.*;

public class LayoutDemo {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Swing Layout Manager Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(2, 2)); // Divide frame into 2x2 grid

        // Panel 1: FlowLayout
        JPanel flowPanel = new JPanel(new FlowLayout());
        flowPanel.setBorder(BorderFactory.createTitledBorder("FlowLayout"));
        flowPanel.add(new JButton("Button 1"));
        flowPanel.add(new JButton("Button 2"));
        flowPanel.add(new JButton("Button 3"));

        // Panel 2: BorderLayout
        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.setBorder(BorderFactory.createTitledBorder("BorderLayout"));
        borderPanel.add(new JButton("North"), BorderLayout.NORTH);
        borderPanel.add(new JButton("South"), BorderLayout.SOUTH);
        borderPanel.add(new JButton("East"), BorderLayout.EAST);
        borderPanel.add(new JButton("West"), BorderLayout.WEST);
        borderPanel.add(new JButton("Center"), BorderLayout.CENTER);

        // Panel 3: GridLayout
        JPanel gridPanel = new JPanel(new GridLayout(2, 2));
        gridPanel.setBorder(BorderFactory.createTitledBorder("GridLayout"));
        gridPanel.add(new JButton("1"));
        gridPanel.add(new JButton("2"));
        gridPanel.add(new JButton("3"));
        gridPanel.add(new JButton("4"));

        // Panel 4: BoxLayout
        JPanel boxPanel = new JPanel();
        boxPanel.setBorder(BorderFactory.createTitledBorder("BoxLayout (Y_AXIS)"));
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
        boxPanel.add(new JButton("Button A"));
        boxPanel.add(new JButton("Button B"));
        boxPanel.add(new JButton("Button C"));

        // Add all panels to frame
        frame.add(flowPanel);
        frame.add(borderPanel);
        frame.add(gridPanel);
        frame.add(boxPanel);

        // Set visible
        frame.setVisible(true);
    }
}
