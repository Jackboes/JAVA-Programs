package student;

public class Student {
    public void displayStudent() {
        System.out.println("Student Name: Arinjay");
        System.out.println("Roll No: 101");
        System.out.println("Course: Computer Science");
    }
}


package faculty;

public class Faculty {
    public void displayFaculty() {
        System.out.println("Faculty Name: Dr. Sharma");
        System.out.println("Faculty ID: F101");
        System.out.println("Department: Computer Science");
    }
}


import student.Student;
import faculty.Faculty;

public class Main {
    public static void main(String[] args) {

        Student s = new Student();
        Faculty f = new Faculty();

        System.out.println("----- Student Details -----");
        s.displayStudent();

        System.out.println();

        System.out.println("----- Faculty Details -----");
        f.displayFaculty();
    }
}
