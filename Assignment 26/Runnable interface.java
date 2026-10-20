class BankAccount {
    private double balance;
    BankAccount(double balance) { this.balance = balance; }

    synchronized void deposit(double amt) {
        balance += amt;
        System.out.println("[Deposit ] +" + amt + " | Balance = " + balance);
    }

    synchronized void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println("[Withdraw] -" + amt + " | Balance = " + balance);
        } else {
            System.out.println("[Withdraw] " + amt + " DENIED (insufficient funds) | Balance = " + balance);
        }
    }

    synchronized double getBalance() { return balance; }
}

class DepositTask implements Runnable {
    private BankAccount acc;
    DepositTask(BankAccount acc) { this.acc = acc; }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            acc.deposit(500 * i);
            try { Thread.sleep(150); } catch (InterruptedException e) { }
        }
    }
}

class WithdrawTask implements Runnable {
    private BankAccount acc;
    WithdrawTask(BankAccount acc) { this.acc = acc; }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            acc.withdraw(800 * i);
            try { Thread.sleep(150); } catch (InterruptedException e) { }
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount acc = new BankAccount(3000);
        System.out.println("Initial balance = " + acc.getBalance());
        Thread t1 = new Thread(new DepositTask(acc), "Deposit");
        Thread t2 = new Thread(new WithdrawTask(acc), "Withdraw");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final balance = " + acc.getBalance());
    }
}
