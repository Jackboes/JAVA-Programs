class Vehicle {

    String vehicleNumber;
    String vehicleType;

    Vehicle(String vehicleNumber, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    void displayVehicleDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Type: " + vehicleType);
    }

    public static void main(String[] args) {

        CarInsurance car = new CarInsurance(
            "MH12AB1234",
            "Car",
            15000
        );

        car.displayInsuranceDetails();
    }
}

class CarInsurance extends Vehicle {

    double premium;

    CarInsurance(String vehicleNumber, String vehicleType, double premium) {

        super(vehicleNumber, vehicleType);

        this.premium = premium;
    }

    void displayInsuranceDetails() {

        super.displayVehicleDetails();

        System.out.println("Insurance Premium: " + premium);
    }
}
