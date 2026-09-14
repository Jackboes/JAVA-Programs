import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * GUICalculator.java
 * Demonstrates button click event handling in Java Swing.
 * Performs Addition and Subtraction of two numbers.
 */
public class GUICalculator extends JFrame implements ActionListener {

    private JTextField num1Field, num2Field, resultField;
    private JButton addButton, subButton;

    public GUICalculator() {
        // Frame setup
        setTitle("GUI Calculator - Add / Subtract");
        setSize(350, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));
        setLocationRelativeTo(null);

        // Labels and text fields
        JLabel label1 = new JLabel("Enter Number 1:");
        num1Field = new JTextField();

        JLabel label2 = new JLabel("Enter Number 2:");
        num2Field = new JTextField();

        // Buttons
        addButton = new JButton("Add (+)");
        subButton = new JButton("Subtract (-)");

        // Result field
        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);

        // Register event listeners
        addButton.addActionListener(this);
        subButton.addActionListener(this);

        // Add components to frame
        add(label1);
        add(num1Field);
        add(label2);
        add(num2Field);
        add(addButton);
        add(subButton);
        add(resultLabel);
        add(resultField);

        setVisible(true);
    }

    // Event handling method - called automatically when a button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subButton) {
                result = num1 - num2;
            }

            resultField.setText(String.valueOf(result));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numeric values in both fields.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(GUICalculator::new);
    }
}
