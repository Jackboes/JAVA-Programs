import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Assignment24 extends JFrame {

    JTextField tId = new JTextField(), tName = new JTextField(),
            tIssue = new JTextField(), tReturn = new JTextField();
    DefaultTableModel model = new DefaultTableModel(
            new String[]{"Book ID", "Student Name", "Issue Date", "Return Date"}, 0);
    JTable table = new JTable(model);

    public Assignment24() {
        setTitle("Library - Book Issue Tracking System");
        setSize(650, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));
        form.add(new JLabel("Book ID:"));                      form.add(tId);
        form.add(new JLabel("Student Name:"));                 form.add(tName);
        form.add(new JLabel("Issue Date (yyyy-mm-dd):"));      form.add(tIssue);
        form.add(new JLabel("Return Date (yyyy-mm-dd):"));     form.add(tReturn);

        JButton add = new JButton("Add"), upd = new JButton("Update"),
                del = new JButton("Delete"), view = new JButton("View All"),
                clr = new JButton("Clear");
        JPanel btns = new JPanel();
        btns.add(add); btns.add(upd); btns.add(del); btns.add(view); btns.add(clr);

        JPanel top = new JPanel(new BorderLayout());
        top.add(form, BorderLayout.CENTER);
        top.add(btns, BorderLayout.SOUTH);
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        add.addActionListener(e -> run("INSERT INTO book_issue VALUES (?, ?, ?, ?)",
                tId.getText(), tName.getText(), tIssue.getText(), ret()));
        upd.addActionListener(e -> run(
                "UPDATE book_issue SET student_name=?, issue_date=?, return_date=? WHERE book_id=?",
                tName.getText(), tIssue.getText(), ret(), tId.getText()));
        del.addActionListener(e -> run("DELETE FROM book_issue WHERE book_id=?", tId.getText()));
        view.addActionListener(e -> loadData());
        clr.addActionListener(e -> clearFields());

        table.getSelectionModel().addListSelectionListener(e -> {
            int r = table.getSelectedRow();
            if (r >= 0) {
                tId.setText(String.valueOf(model.getValueAt(r, 0)));
                tName.setText(String.valueOf(model.getValueAt(r, 1)));
                tIssue.setText(String.valueOf(model.getValueAt(r, 2)));
                Object rd = model.getValueAt(r, 3);
                tReturn.setText(rd == null ? "" : rd.toString());
            }
        });

        loadData();
    }

    String ret() {
        return tReturn.getText().trim().isEmpty() ? null : tReturn.getText().trim();
    }

    void clearFields() {
        tId.setText(""); tName.setText(""); tIssue.setText(""); tReturn.setText("");
    }

    void run(String sql, Object... params) {
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) ps.setObject(i + 1, params[i]);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Operation successful!");
            clearFields();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
        loadData();
    }

    void loadData() {
        model.setRowCount(0);
        try (Connection c = DBConnection.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM book_issue")) {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4)});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Assignment24().setVisible(true));
    }
}
