class Account {
    private double balance;
    Account(double balance) { this.balance = balance; }

    synchronized void deposit(double amt) {
        balance += amt;
        System.out.println(Thread.currentThread().getName() + " deposited " + amt + " | Balance = " + balance);
    }

    synchronized void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amt + " | Balance = " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " FAILED to withdraw " + amt + " (insufficient) | Balance = " + balance);
        }
    }

    synchronized double getBalance() { return balance; }
}

class DepositThread extends Thread {
    private Account acc;
    DepositThread(Account acc) { super("Deposit-Thread"); this.acc = acc; }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            acc.deposit(1000 * i);
            try { Thread.sleep(200); } catch (InterruptedException e) { }
        }
    }
}

class WithdrawThread extends Thread {
    private Account acc;
    WithdrawThread(Account acc) { super("Withdraw-Thread"); this.acc = acc; }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            acc.withdraw(700 * i);
            try { Thread.sleep(200); } catch (InterruptedException e) { }
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account acc = new Account(5000);
        System.out.println("Initial balance = " + acc.getBalance());
        Thread d = new DepositThread(acc);
        Thread w = new WithdrawThread(acc);
        d.start();
        w.start();
        d.join();
        w.join();
        System.out.println("Final balance = " + acc.getBalance());
    }
}
