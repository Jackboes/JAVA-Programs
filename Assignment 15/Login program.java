import java.util.Scanner;

public class Login {

    static void checkPassword(String password) throws Exception {
        if (!password.equals("admin123")) {
            throw new Exception("Invalid password!");
        }

        System.out.println("Login successful.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            checkPassword(password);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Login process completed.");
        }

        sc.close();
    }
}
