import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter account balance: ");
            double balance = sc.nextDouble();

            try {
                System.out.print("Enter withdrawal amount: ");
                double amount = sc.nextDouble();

                if (amount <= 0) {
                    throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
                }

                if (amount > balance) {
                    throw new ArithmeticException("Insufficient balance.");
                }

                System.out.println("Withdrawal successful.");
                System.out.println("Remaining balance: " + (balance - amount));

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid withdrawal amount: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Transaction failed: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }

        sc.close();
    }
}
