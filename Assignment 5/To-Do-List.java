import java.util.ArrayList;
public class Experiment_5_Ex_1 {
    public static void main(String[] args) {

        ArrayList<String> tasks = new ArrayList<>();

        tasks.add("Complete Java Assignment");
        tasks.add("Study Data Structures");
        tasks.add("Attend Lab");
        tasks.add("Submit Journal");

        tasks.remove("Attend Lab");

        StringBuffer sb = new StringBuffer();

        sb.append("To-Do List\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1) + ". " + tasks.get(i) + "\n");
        }

        System.out.println(sb);
    }
}
