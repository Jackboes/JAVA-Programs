class BankAccount {

    final long accountNumber;
    String name;
    double balance;

    BankAccount(long accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + name);
        System.out.println("Balance: ₹" + balance);
    }

    public static void main(String[] args) {

        BankAccount account =
            new BankAccount(1234567890L, "Arinjay", 50000);

        account.displayAccount();

        // account.accountNumber = 9999999999L;
        // Error: cannot assign a value to final variable
    }
}
