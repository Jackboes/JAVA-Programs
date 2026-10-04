import java.sql.*;

public class Assignment19 {
    public static void main(String[] args) {
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement()) {


            System.out.println("\n===== PRODUCT DETAILS =====");
            try (ResultSet rs = st.executeQuery("SELECT pid, pname, quantity, price FROM product")) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("pid")
                            + " | Name: " + rs.getString("pname")
                            + " | Qty: " + rs.getInt("quantity")
                            + " | Price: " + rs.getDouble("price"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
