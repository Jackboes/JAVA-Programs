import java.util.Scanner;

public class Employee {
    Integer employeeId;
    Double basicSalary;
    Double bonus;

    Employee(String id, String salary, String bonus) {
        this.employeeId = Integer.valueOf(id);     // parsing to wrapper Integer
        this.basicSalary = Double.valueOf(salary); // parsing to wrapper Double
        this.bonus = Double.valueOf(bonus);
    }

    boolean isValidSalary() {
        return basicSalary > 0 && bonus >= 0;
    }

    double calculateNetSalary() {
        return basicSalary + bonus;
    }

    void display() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Basic Salary: Rs. " + basicSalary);
        System.out.println("Bonus: Rs. " + bonus);
        if (isValidSalary()) {
            System.out.println("Net Salary: Rs. " + calculateNetSalary());
        } else {
            System.out.println("Invalid salary/bonus values entered!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        String idInput = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        String salaryInput = sc.nextLine();

        System.out.print("Enter Bonus Amount: ");
        String bonusInput = sc.nextLine();

        Employee emp = new Employee(idInput, salaryInput, bonusInput);

        System.out.println("\n--- Payroll Slip ---");
        emp.display();

        sc.close();
    }
}
