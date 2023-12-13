/*Write a Java program that simulates a traffic light. The program lets the user select one of
three lights: red, yellow, or green. When a radio button is selected, the light is turned on,
and only one light can be on at a time. No light is on when the program starts*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightSimulator extends JFrame implements ActionListener {
    private JRadioButton redButton, yellowButton, greenButton;
    private TrafficLightPanel lightPanel;

    public TrafficLightSimulator() {
        setTitle("Traffic Light Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 400);
        setLayout(new BorderLayout());

        redButton = new JRadioButton("Red");
        yellowButton = new JRadioButton("Yellow");
        greenButton = new JRadioButton("Green");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(redButton);
        buttonGroup.add(yellowButton);
        buttonGroup.add(greenButton);

        redButton.addActionListener(this);
        yellowButton.addActionListener(this);
        greenButton.addActionListener(this);

        JPanel controlPanel = new JPanel();
        controlPanel.add(redButton);
        controlPanel.add(yellowButton);
        controlPanel.add(greenButton);

        lightPanel = new TrafficLightPanel();

        add(controlPanel, BorderLayout.NORTH);
        add(lightPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == redButton) {
            lightPanel.setColors(Color.RED, Color.LIGHT_GRAY, Color.LIGHT_GRAY);
        } else if (e.getSource() == yellowButton) {
            lightPanel.setColors(Color.LIGHT_GRAY, Color.YELLOW, Color.LIGHT_GRAY);
        } else if (e.getSource() == greenButton) {
            lightPanel.setColors(Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.GREEN);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TrafficLightSimulator::new);
    }
}

class TrafficLightPanel extends JPanel {
    private Color color1, color2, color3;

    public TrafficLightPanel() {
        setPreferredSize(new Dimension(100, 300));
        setColors(Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY);
    }

    public void setColors(Color c1, Color c2, Color c3) {
        color1 = c1;
        color2 = c2;
        color3 = c3;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int diameter = 80;
        int x = getWidth() / 2 - diameter / 2;
        int y = getHeight() / 6;

        g.setColor(color1);
        g.fillOval(x, y, diameter, diameter);

        g.setColor(color2);
        g.fillOval(x, y + diameter + 10, diameter, diameter);

        g.setColor(color3);
        g.fillOval(x, y + 2 * (diameter + 10), diameter, diameter);
    }
}
