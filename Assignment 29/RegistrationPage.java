import java.util.*;

// Console simulation of register.html -> result.jsp
public class RegistrationPage {
    public static void main(String[] args) {
        Map<String, String> request = new HashMap<>();
        request.put("name", "Anita Patil");
        request.put("email", "anita@example.com");
        request.put("phone", "9876543210");
        request.put("password", "secret123");

        String password = request.get("password");
        StringBuilder masked = new StringBuilder();
        for (int i = 0; i < password.length(); i++) masked.append('*');   // never show real password

        System.out.println("Registration Successful");
        System.out.println("-----------------------");
        System.out.println("Name     : " + request.get("name"));
        System.out.println("Email    : " + request.get("email"));
        System.out.println("Phone    : " + request.get("phone"));
        System.out.println("Password : " + masked);
    }
}
