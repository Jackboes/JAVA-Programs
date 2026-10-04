import java.sql.*;

public class Assignment23 {

    // Prints the current row (all columns)
    static void row(ResultSet rs, String label) throws SQLException {
        int cols = rs.getMetaData().getColumnCount();
        StringBuilder sb = new StringBuilder(label + ": ");
        for (int i = 1; i <= cols; i++) sb.append(rs.getString(i)).append(" | ");
        System.out.println(sb);
    }

    static void navigate(Connection con, String table) throws SQLException {
        // Scrollable ResultSet allows previous(), first(), last(), absolute()
        try (Statement st = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = st.executeQuery("SELECT * FROM " + table)) {

            System.out.println("--- Forward (next) ---");
            while (rs.next()) row(rs, "Row " + rs.getRow());

            if (rs.last())       row(rs, "last()");
            if (rs.previous())   row(rs, "previous()");
            if (rs.first())      row(rs, "first()");
            if (rs.absolute(2))  row(rs, "absolute(2)");
            if (rs.relative(1))  row(rs, "relative(1)");
        }
    }

    public static void main(String[] args) {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("===== Exercise 1: STUDENT table =====");
            navigate(con, "student");

            System.out.println("\n===== Exercise 2: EMPLOYEE table (ID, Name, Dept, Salary) =====");
            navigate(con, "employee");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
