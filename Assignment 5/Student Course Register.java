import java.util.ArrayList;
public class Experiment_5_Ex_2{ 
    public static void main(String[] args) {
        ArrayList<String> courses = new ArrayList<>();

        courses.add("Java");
        courses.add("Data Structures");
        courses.add("Database Management");
        courses.add("Operating Systems");
        
        courses.remove("Operating Systems");

        StringBuffer sb = new StringBuffer();
        sb.append("Registered Courses\n");
        for (int i = 0; i < courses.size(); i++) {
            sb.append((i + 1) + ". " + courses.get(i) + "\n");
        }

        System.out.println(sb);
    }
}
