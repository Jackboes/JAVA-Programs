import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    private JTextField empIdField, nameField, deptField, salaryField;
    private JButton submitButton, clearButton;

    public Main() {
        setTitle("Employee Registration Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel empIdLabel = new JLabel("Employee ID:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel deptLabel = new JLabel("Department:");
        JLabel salaryLabel = new JLabel("Salary:");

        empIdField = new JTextField(15);
        nameField = new JTextField(15);
        deptField = new JTextField(15);
        salaryField = new JTextField(15);

        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");

        // Row 0 - Employee ID
        gbc.gridx = 0; gbc.gridy = 0;
        add(empIdLabel, gbc);
        gbc.gridx = 1;
        add(empIdField, gbc);

        // Row 1 - Name
        gbc.gridx = 0; gbc.gridy = 1;
        add(nameLabel, gbc);
        gbc.gridx = 1;
        add(nameField, gbc);

        // Row 2 - Department
        gbc.gridx = 0; gbc.gridy = 2;
        add(deptLabel, gbc);
        gbc.gridx = 1;
        add(deptField, gbc);

        // Row 3 - Salary
        gbc.gridx = 0; gbc.gridy = 3;
        add(salaryLabel, gbc);
        gbc.gridx = 1;
        add(salaryField, gbc);

        // Row 4 - Buttons
        gbc.gridx = 0; gbc.gridy = 4;
        add(submitButton, gbc);
        gbc.gridx = 1;
        add(clearButton, gbc);

        submitButton.addActionListener(this);
        clearButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String empId = empIdField.getText().trim();
            String name = nameField.getText().trim();
            String dept = deptField.getText().trim();
            String salaryText = salaryField.getText().trim();

            if (empId.isEmpty() || name.isEmpty() || dept.isEmpty() || salaryText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please fill in all fields.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            double salary;
            try {
                salary = Double.parseDouble(salaryText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Salary must be a valid number.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String message = "Employee Registration Details\n"
                    + "------------------------------\n"
                    + "Employee ID : " + empId + "\n"
                    + "Name        : " + name + "\n"
                    + "Department  : " + dept + "\n"
                    + "Salary      : " + String.format("%.2f", salary);

            JOptionPane.showMessageDialog(this, message,
                    "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == clearButton) {
            empIdField.setText("");
            nameField.setText("");
            deptField.setText("");
            salaryField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
