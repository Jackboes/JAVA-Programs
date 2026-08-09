class FoodDelivery {

    String food = "Pizza";
    int price = 500;

    // Inner class
    class OrderDetails {
        void displayOrder() {
            System.out.println("Food: " + food);
            System.out.println("Price: ₹" + price);
        }
    }

    public static void main(String[] args) {

        FoodDelivery order = new FoodDelivery();

        // Inner class object
        OrderDetails details = order.new OrderDetails();
        details.displayOrder();

        // Anonymous class
        DeliveryStatus status = new DeliveryStatus() {
            public void updateStatus() {
                System.out.println("Order is out for delivery.");
            }
        };

        status.updateStatus();
    }
}

// Interface
interface DeliveryStatus {
    void updateStatus();
}
