abstract class FoodOrder {
    double amount;

    FoodOrder(double amount) {
        this.amount = amount;
    }

    abstract void calculateBill();
}

class DineInOrder extends FoodOrder {
    DineInOrder(double amount) {
        super(amount);
    }

    @Override
    void calculateBill() {
        double total = amount + (amount * 0.05); // 5% service charge
        System.out.println("Dine-In Bill: ₹" + total);
    }
}

class TakeAwayOrder extends FoodOrder {
    TakeAwayOrder(double amount) {
        super(amount);
    }

    @Override
    void calculateBill() {
        double total = amount + 30; // ₹30 packaging charge
        System.out.println("Take-Away Bill: ₹" + total);
    }
}

public class FoodOrderDemo {
    public static void main(String[] args) {
        FoodOrder order1 = new DineInOrder(1000);
        order1.calculateBill();

        FoodOrder order2 = new TakeAwayOrder(1000);
        order2.calculateBill();
    }
}
