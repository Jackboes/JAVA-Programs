class Vehicle {
    String name;
    int speed;

    Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    // Inner class
    class VehicleDetails {
        void displayDetails() {
            System.out.println("Vehicle: " + name);
            System.out.println("Speed: " + speed + " km/h");
        }
    }

    public static void main(String[] args) {

        Vehicle v = new Vehicle("BMW", 200);

        // Creating object of inner class
        VehicleDetails details = v.new VehicleDetails();
        details.displayDetails();

        // Anonymous class
        Runnable action = new Runnable() {
            public void run() {
                System.out.println("Vehicle is starting...");
            }
        };

        action.run();
    }
}
