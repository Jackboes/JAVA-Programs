import java.sql.*;

public class Assignment19 {
    public static void main(String[] args) {
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement()) {

            System.out.println("===== STUDENT RECORDS =====");
            try (ResultSet rs = st.executeQuery("SELECT * FROM student")) {
                while (rs.next()) {
                    System.out.println("Roll No: " + rs.getInt(1) + " | Name: " + rs.getString(2));
                }
            }

         
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
