import java.sql.*;
import java.util.Scanner;

public class Assignment22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Connection con = DBConnection.getConnection()) {

           
            

            System.out.println("\n===== HOSPITAL STAFF LOGIN =====");
            System.out.print("Login ID: ");
            String id = sc.nextLine();
            System.out.print("Password: ");
            String pw = sc.nextLine();

            String q2 = "SELECT role FROM hospital_staff WHERE login_id = ? AND password = ?";
            try (PreparedStatement ps = con.prepareStatement(q2)) {
                ps.setString(1, id);
                ps.setString(2, pw);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String role = rs.getString("role");
                        System.out.println("Access GRANTED. Welcome, " + role + " (" + id + ").");
                        if (role.equalsIgnoreCase("Doctor")) System.out.println("You can view and update patient treatment.");
                        else System.out.println("You can view patient records and vitals.");
                    } else {
                        System.out.println("Access DENIED. Invalid Login ID or password.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
