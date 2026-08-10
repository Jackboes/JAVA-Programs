import java.io.*;

public class PatientFile {
    public static void main(String[] args) {

        // Writing patient details to file
        try {
            FileWriter writer = new FileWriter("patient.txt");

            writer.write("Patient ID: 201\n");
            writer.write("Name: Amit\n");
            writer.write("Age: 25\n");
            writer.write("Diagnosis: Fever\n");

            writer.close();

            System.out.println("Patient details written successfully.");

        } catch (IOException e) {
            System.out.println("Error while writing file.");
        }

        // Reading patient details from file
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("patient.txt"));

            String line;

            System.out.println("\nPatient Details:");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error while reading file.");
        }
    }
}
