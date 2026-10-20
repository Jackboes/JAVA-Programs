import java.util.*;

// Console simulation of student.html -> displayStudent.jsp
public class StudentPage {
    public static void main(String[] args) {
        Map<String, String> request = new HashMap<>();      // form data
        request.put("roll", "101");
        request.put("name", "Rahul Sharma");
        request.put("course", "B.Tech CSE");
        request.put("marks", "86");

        System.out.println("<html><body>");
        System.out.println("<h2>Student Details</h2>");
        System.out.println("<p>Roll No : " + request.get("roll") + "</p>");
        System.out.println("<p>Name    : " + request.get("name") + "</p>");
        System.out.println("<p>Course  : " + request.get("course") + "</p>");
        System.out.println("<p>Marks   : " + request.get("marks") + "</p>");
        System.out.println("<p>Request served at: " + new Date() + "</p>");
        System.out.println("</body></html>");
    }
}
