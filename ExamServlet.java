package yourApp.exams;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ExamServlet extends HttpServlet {

    private static final List<Exam> exams = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        BufferedReader reader = req.getReader();
        StringBuilder json = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            json.append(line);
        }

        // Simple JSON parsing (no libraries)
        String body = json.toString();
        String subject = body.split("\"subject\":\"")[1].split("\"")[0];
        String date = body.split("\"examDate\":\"")[1].split("\"")[0];

        Exam exam = new Exam(subject, LocalDate.parse(date));
        exams.add(exam);

        String alert = AlertGenerator.generateAlert(exam);
        ReminderLogger.log(alert);

        resp.setContentType("application/json");
        resp.getWriter().write(
            "{\"alert\":\"" + alert + "\"}"
        );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("application/json");
        StringBuilder out = new StringBuilder("[");
        for (int i = 0; i < exams.size(); i++) {
            Exam e = exams.get(i);
            out.append("{\"subject\":\"")
               .append(e.getSubject())
               .append("\",\"examDate\":\"")
               .append(e.getExamDate())
               .append("\"}");
            if (i < exams.size() - 1) out.append(",");
        }
        out.append("]");

        resp.getWriter().write(out.toString());
    }
}
