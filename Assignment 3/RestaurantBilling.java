public class RestaurantBilling {
    static int totalOrders = 0; // static variable tracks total orders across all objects

    // Overloaded billing methods
    double calculateBill(double amount) { // Dine-in
        totalOrders++;
        return amount;
    }

    double calculateBill(double amount, double packagingCharge) { // Takeaway
        totalOrders++;
        return amount + packagingCharge;
    }

    double calculateBill(double amount, double deliveryCharge, boolean isDelivery) { // Delivery
        totalOrders++;
        return amount + deliveryCharge;
    }

    static void showTotalOrders() {
        System.out.println("Total orders processed: " + totalOrders);
    }

    public static void main(String[] args) {
        RestaurantBilling billing = new RestaurantBilling();

        double dineInBill = billing.calculateBill(500.0);
        System.out.println("Dine-in Bill: Rs. " + dineInBill);

        double takeawayBill = billing.calculateBill(450.0, 20.0);
        System.out.println("Takeaway Bill: Rs. " + takeawayBill);

        double deliveryBill = billing.calculateBill(600.0, 50.0, true);
        System.out.println("Delivery Bill: Rs. " + deliveryBill);

        RestaurantBilling.showTotalOrders();
    }
}
