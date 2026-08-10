import java.io.*;

public class EmployeeFile {
    public static void main(String[] args) {

        // Writing employee details to file
        try {
            FileWriter writer = new FileWriter("employee.txt");

            writer.write("Employee ID: 101\n");
            writer.write("Name: Rahul\n");
            writer.write("Department: Computer Science\n");
            writer.write("Salary: 50000\n");

            writer.close();

            System.out.println("Employee details written successfully.");

        } catch (IOException e) {
            System.out.println("Error while writing file.");
        }

        // Reading employee details from file
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("employee.txt"));

            String line;

            System.out.println("\nEmployee Details:");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error while reading file.");
        }
    }
}
