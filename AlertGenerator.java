package yourApp.exams;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Exam {
    private String subject;
    private LocalDate examDate;

    public Exam(String subject, LocalDate examDate) {
        this.subject = subject;
        this.examDate = examDate;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDate getExamDate() {
        return examDate;
    }
}

class DateComparator {
    public static long daysLeft(LocalDate examDate) {
        return ChronoUnit.DAYS.between(LocalDate.now(), examDate);
    }
}

public class AlertGenerator {

    public static java.lang.String generateAlert(Exam exam) {
        long days = DateComparator.daysLeft(exam.getExamDate());

        if (days < 0) {


            return "Exam already completed: " + exam.getSubject();
        } else if (days == 0) {
            return "🚨 Exam TODAY: " + exam.getSubject();
        } else if (days <= 3) {
            return "⚠ Exam in " + days + " days: " + exam.getSubject();
        } else {
            return "Upcoming exam: " + exam.getSubject();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter exam subject: ");
        java.lang.String subject = scanner.nextLine();

        System.out.print("Enter exam date (YYYY-MM-DD): ");
        LocalDate examDate = LocalDate.parse(scanner.nextLine());

        Exam exam = new Exam( subject, examDate);
        java.lang.String alert = generateAlert(exam);

        System.out.println(alert);

        scanner.close();
    }
}


