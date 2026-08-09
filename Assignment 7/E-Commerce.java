class Product {

    public static void main(String[] args) {

        Electronic e = new Electronic("Laptop", 50000);
        Clothing c = new Clothing("T-Shirt", 800);
        Grocery g = new Grocery("Rice", 500);

        e.displayProduct();
        c.displayProduct();
        g.displayProduct();
    }

    void displayProduct() {
        System.out.println("Product");
    }
}

class Electronic extends Product {

    String name;
    double price;

    Electronic(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void displayProduct() {
        System.out.println("Electronic: " + name + ", Price: ₹" + price);
    }
}

class Clothing extends Product {

    String name;
    double price;

    Clothing(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void displayProduct() {
        System.out.println("Clothing: " + name + ", Price: ₹" + price);
    }
}

class Grocery extends Product {

    String name;
    double price;

    Grocery(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void displayProduct() {
        System.out.println("Grocery: " + name + ", Price: ₹" + price);
    }
}

interface ProductInterface {
    void displayProduct();
}
