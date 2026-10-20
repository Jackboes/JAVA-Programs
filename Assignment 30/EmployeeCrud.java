import java.util.*;

// Console simulation of employee.jsp (in-memory list replaces the MySQL table)
public class EmployeeCrud {

    static class Employee {
        int id; String name, dept; double salary;
        Employee(int id, String name, String dept, double salary) {
            this.id = id; this.name = name; this.dept = dept; this.salary = salary;
        }
    }

    static List<Employee> table = new ArrayList<>();

    static void create(int id, String n, String d, double s) {          // INSERT
        table.add(new Employee(id, n, d, s));
        System.out.println("Employee added: " + id);
    }

    static void update(int id, String n, String d, double s) {          // UPDATE
        for (Employee e : table) {
            if (e.id == id) {
                e.name = n; e.dept = d; e.salary = s;
                System.out.println("Employee updated: " + id);
                return;
            }
        }
        System.out.println("Employee not found: " + id);
    }

    static void delete(int id) {                                        // DELETE
        System.out.println(table.removeIf(e -> e.id == id) ? "Employee deleted: " + id : "Employee not found: " + id);
    }

    static void view() {                                                // SELECT
        System.out.println("ID\tName\t\tDept\t\tSalary");
        for (Employee e : table)
            System.out.println(e.id + "\t" + e.name + "\t" + e.dept + "\t\t" + e.salary);
        System.out.println();
    }

    public static void main(String[] args) {
        create(1, "Amit", "IT", 50000);
        create(2, "Sneha", "HR", 45000);
        create(3, "Rohan", "Finance", 55000);
        view();
        update(2, "Sneha", "Admin", 48000);
        delete(3);
        view();
    }
}
