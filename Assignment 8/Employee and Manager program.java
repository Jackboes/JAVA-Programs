class Employee {

    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {

        Manager m = new Manager("Arinjay", 60000, "IT");

        m.displayManagerDetails();
    }
}

class Manager extends Employee {

    String department;

    Manager(String name, double salary, String department) {

        super(name, salary);

        this.department = department;
    }

    void displayManagerDetails() {

        super.displayDetails();

        System.out.println("Department: " + department);
    }
}
