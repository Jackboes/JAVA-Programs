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

           

            System.out.println("\n===== STUDENT RECORDS CRUD =====");
            exec(con, "DELETE FROM student_records WHERE rollno = ?", 1);
            exec(con, "INSERT INTO student_records VALUES (?, ?, ?, ?)", 1, "Riya", "BTech CSE", 85);
            System.out.println("After INSERT:"); show(con, "student_records");
            exec(con, "UPDATE student_records SET marks = ?, course = ? WHERE rollno = ?", 92, "BTech AI", 1);
            System.out.println("After UPDATE:"); show(con, "student_records");
            exec(con, "DELETE FROM student_records WHERE rollno = ?", 1);
            System.out.println("After DELETE:"); show(con, "student_records");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
