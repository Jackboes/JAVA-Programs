import java.sql.*;
import java.util.Scanner;

public class Assignment22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Connection con = DBConnection.getConnection()) {

            System.out.println("===== LOGIN =====");
            System.out.print("Username: ");
            String u = sc.nextLine();
            System.out.print("Password: ");
            String p = sc.nextLine();

            String q1 = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement ps = con.prepareStatement(q1)) {
                ps.setString(1, u);
                ps.setString(2, p);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) System.out.println("Login successful. Welcome, " + rs.getString("username") + "!");
                    else System.out.println("Invalid username or password.");
                }
            }

           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
