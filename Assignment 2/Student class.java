public class Student {
    String name;
    int rollNo;

    // Default constructor
    Student() {
        name = "Unknown";
        rollNo = 0;
    }

    // Parameterized constructor
    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    void display() {
        System.out.println("Name: " + name + ", Roll No: " + rollNo);
    }

    public static void main(String[] args) {
        Student s1 = new Student(); // default constructor
        Student s2 = new Student("Aditi Sharma", 21); // parameterized constructor

        System.out.println("Student 1 (Default Constructor):");
        s1.display();

        System.out.println("Student 2 (Parameterized Constructor):");
        s2.display();
    }
}
