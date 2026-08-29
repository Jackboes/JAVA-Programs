import java.util.Scanner;

public class ATM_PIN {

    static void verifyPIN(int pin) throws Exception {
        int correctPIN = 1234;

        if (pin != correctPIN) {
            throw new Exception("Invalid PIN entered.");
        }

        System.out.println("PIN verified successfully.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your ATM PIN: ");
            int pin = sc.nextInt();

            verifyPIN(pin);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("PIN verification process completed.");
        }

        sc.close();
    }
}
