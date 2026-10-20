import java.util.*;

// Console simulation of patient.jsp (in-memory list replaces the MySQL table)
public class PatientCrud {

    static class Patient {
        int id, age; String name, disease, status;
        Patient(int id, String name, int age, String disease, String status) {
            this.id = id; this.name = name; this.age = age; this.disease = disease; this.status = status;
        }
    }

    static List<Patient> table = new ArrayList<>();

    static void create(int id, String n, int a, String d, String s) {   // INSERT
        table.add(new Patient(id, n, a, d, s));
        System.out.println("Patient added: " + id);
    }

    static void update(int id, String n, int a, String d, String s) {   // UPDATE
        for (Patient p : table) {
            if (p.id == id) {
                p.name = n; p.age = a; p.disease = d; p.status = s;
                System.out.println("Patient updated: " + id);
                return;
            }
        }
        System.out.println("Patient not found: " + id);
    }

    static void delete(int id) {                                        // DELETE
        System.out.println(table.removeIf(p -> p.id == id) ? "Patient deleted: " + id : "Patient not found: " + id);
    }

    static void view() {                                                // SELECT
        System.out.println("ID\tName\t\tAge\tDisease\t\tStatus");
        for (Patient p : table)
            System.out.println(p.id + "\t" + p.name + "\t" + p.age + "\t" + p.disease + "\t" + p.status);
        System.out.println();
    }

    public static void main(String[] args) {
        create(101, "Ravi", 45, "Diabetes", "Under Treatment");
        create(102, "Meena", 30, "Fever", "Under Treatment");
        create(103, "Karan", 60, "Asthma", "Recovered");
        view();
        update(102, "Meena", 30, "Fever", "Recovered");
        delete(103);
        view();
    }
}
