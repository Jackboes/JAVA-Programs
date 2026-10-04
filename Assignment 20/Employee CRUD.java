import java.sql.*;

public class Assignment20 {

    static int exec(Connection con, String sql, Object... params) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) ps.setObject(i + 1, params[i]);
            return ps.executeUpdate();
        }
    }

    static void show(Connection con, String table) throws SQLException {
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM " + table)) {
            int cols = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                StringBuilder sb = new StringBuilder("  ");
                for (int i = 1; i <= cols; i++) sb.append(rs.getString(i)).append(" | ");
                System.out.println(sb);
            }
        }
    }

    public static void main(String[] args) {
        try (Connection con = DBConnection.getConnection()) {

            System.out.println("===== EMPLOYEE CRUD =====");
            exec(con, "DELETE FROM employee WHERE empid = ?", 101);
            exec(con, "INSERT INTO employee VALUES (?, ?, ?, ?)", 101, "Rahul", "Sales", 40000);
            System.out.println("After INSERT:"); show(con, "employee");
            exec(con, "UPDATE employee SET salary = ? WHERE empid = ?", 48000, 101);
            System.out.println("After UPDATE:"); show(con, "employee");
            exec(con, "DELETE FROM employee WHERE empid = ?", 101);
            System.out.println("After DELETE:"); show(con, "employee");

           

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
