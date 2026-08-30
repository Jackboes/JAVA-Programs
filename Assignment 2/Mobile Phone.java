public class MobilePhone {
    String brand;
    String model;
    double price;
    int quantity;

    // Default constructor
    MobilePhone() {
        brand = "N/A";
        model = "N/A";
        price = 0.0;
        quantity = 0;
    }

    // Parameterized constructor
    MobilePhone(String brand, String model, double price, int quantity) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
    }

    // Copy constructor
    MobilePhone(MobilePhone m) {
        this.brand = m.brand;
        this.model = m.model;
        this.price = m.price;
        this.quantity = m.quantity;
    }

    void display() {
        System.out.println("Brand: " + brand + ", Model: " + model +
                ", Price: " + price + ", Quantity: " + quantity);
    }

    public static void main(String[] args) {
        MobilePhone m1 = new MobilePhone(); // default
        MobilePhone m2 = new MobilePhone("Samsung", "Galaxy S23", 74999.0, 10); // parameterized
        MobilePhone m3 = new MobilePhone(m2); // copy constructor - duplicate record

        m3.quantity = 5; // modify duplicate to prove independence

        System.out.println("Default Phone Record:");
        m1.display();

        System.out.println("\nOriginal Phone Record:");
        m2.display();

        System.out.println("\nDuplicated Phone Record (Copy Constructor, quantity updated):");
        m3.display();
    }
}
