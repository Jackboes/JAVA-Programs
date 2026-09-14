import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    private JTextField nameField, rollField, ageField, courseField;
    private JButton submitButton, clearButton;

    public Main() {
        setTitle("Student Registration Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nameLabel = new JLabel("Student Name:");
        JLabel rollLabel = new JLabel("Roll Number:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel courseLabel = new JLabel("Course:");

        nameField = new JTextField(15);
        rollField = new JTextField(15);
        ageField = new JTextField(15);
        courseField = new JTextField(15);

        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");

        // Row 0 - Name
        gbc.gridx = 0; gbc.gridy = 0;
        add(nameLabel, gbc);
        gbc.gridx = 1;
        add(nameField, gbc);

        // Row 1 - Roll Number
        gbc.gridx = 0; gbc.gridy = 1;
        add(rollLabel, gbc);
        gbc.gridx = 1;
        add(rollField, gbc);

        // Row 2 - Age
        gbc.gridx = 0; gbc.gridy = 2;
        add(ageLabel, gbc);
        gbc.gridx = 1;
        add(ageField, gbc);

        // Row 3 - Course
        gbc.gridx = 0; gbc.gridy = 3;
        add(courseLabel, gbc);
        gbc.gridx = 1;
        add(courseField, gbc);

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
            String name = nameField.getText().trim();
            String roll = rollField.getText().trim();
            String age = ageField.getText().trim();
            String course = courseField.getText().trim();

            if (name.isEmpty() || roll.isEmpty() || age.isEmpty() || course.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please fill in all fields.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String message = "Student Registration Details\n"
                    + "-----------------------------\n"
                    + "Name       : " + name + "\n"
                    + "Roll No.   : " + roll + "\n"
                    + "Age        : " + age + "\n"
                    + "Course     : " + course;

            JOptionPane.showMessageDialog(this, message,
                    "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == clearButton) {
            nameField.setText("");
            rollField.setText("");
            ageField.setText("");
            courseField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
