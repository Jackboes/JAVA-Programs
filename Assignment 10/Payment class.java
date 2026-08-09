abstract class Payment {
    abstract void makePayment(double amount);

    void paymentMessage() {
        System.out.println("Payment processing...");
    }
}

class CreditCard extends Payment {
    @Override
    void makePayment(double amount) {
        System.out.println("Credit Card Payment: ₹" + amount);
    }
}

class UPI extends Payment {
    @Override
    void makePayment(double amount) {
        System.out.println("UPI Payment: ₹" + amount);
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        Payment p1 = new CreditCard();
        p1.paymentMessage();
        p1.makePayment(1500);

        Payment p2 = new UPI();
        p2.paymentMessage();
        p2.makePayment(800);
    }
}
