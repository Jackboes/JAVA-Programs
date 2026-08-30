public class StudentMarks {
    public static void main(String[] args) {
        String mathsStr = "85";
        String scienceStr = "90";
        String englishStr = "78";

        int maths = Integer.parseInt(mathsStr);
        int science = Integer.parseInt(scienceStr);
        int english = Integer.parseInt(englishStr);

        int total = maths + science + english;

        System.out.println("Maths Marks: " + maths);
        System.out.println("Science Marks: " + science);
        System.out.println("English Marks: " + english);
        System.out.println("Total Marks: " + total);

        double average = total / 3.0;
        System.out.println("Average Marks: " + average);
    }
}
