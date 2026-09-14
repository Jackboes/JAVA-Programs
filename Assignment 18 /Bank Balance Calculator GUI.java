import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * BankBalanceCalculator.java
 * Demonstrates button click event handling in Java Swing.
 * User enters initial balance and a transaction amount.
 * Deposit button adds the amount; Withdraw button subtracts it.
 */
public class BankBalanceCalculator extends JFrame implements ActionListener {

    private JTextField balanceField, transactionField;
    private JLabel currentBalanceLabel;
    private JButton depositButton, withdrawButton;

    private double currentBalance = 0.0;
    private boolean balanceInitialized = false;

    public BankBalanceCalculator() {
        setTitle("Bank Balance Calculator");
        setSize(400, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));
        setLocationRelativeTo(null);

        // Initial balance input
        JLabel balanceLabel = new JLabel("Initial Balance:");
        balanceField = new JTextField();

        // Transaction amount input
        JLabel transactionLabel = new JLabel("Transaction Amount:");
        transactionField = new JTextField();

        // Buttons
        depositButton = new JButton("Deposit (+)");
        withdrawButton = new JButton("Withdraw (-)");

        // Display current balance
        JLabel infoLabel = new JLabel("Current Balance:");
        currentBalanceLabel = new JLabel("0.0");
        currentBalanceLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Register event listeners
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        // Add components to frame
        add(balanceLabel);
        add(balanceField);
        add(transactionLabel);
        add(transactionField);
        add(depositButton);
        add(withdrawButton);
        add(infoLabel);
        add(currentBalanceLabel);

        setVisible(true);
    }

    // This method runs automatically whenever a registered button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Set the initial balance only once, from the balance field
            if (!balanceInitialized) {
                currentBalance = Double.parseDouble(balanceField.getText());
                balanceInitialized = true;
            }

            double transactionAmount = Double.parseDouble(transactionField.getText());

            if (e.getSource() == depositButton) {
                currentBalance += transactionAmount;
            } else if (e.getSource() == withdrawButton) {
                if (transactionAmount > currentBalance) {
                    JOptionPane.showMessageDialog(this,
                            "Insufficient balance for this withdrawal.",
                            "Transaction Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                currentBalance -= transactionAmount;
            }

            // Update the displayed balance
            currentBalanceLabel.setText(String.valueOf(currentBalance));

            // Clear transaction field for next entry
            transactionField.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numeric values.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(BankBalanceCalculator::new);
    }
}
