package yourApp.exams;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.List;


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


class AlertGenerator {
    public static String generateAlert(Exam exam) {
        long days = DateComparator.daysLeft(exam.getExamDate());
        return "Exam: " + exam.getSubject() + "  Days left: " + days;
    }
}


class ReminderLogger {
    public static void log(String message) {
        System.out.println("[LOG] " + message);
    }
}


public class ExamViewer {

    
    public static class ExamViewer {

        public static void displayExams(List<Exam> exams) {
            for (Exam exam : exams) {
                String alert = AlertGenerator.generateAlert(exam);
                System.out.println(alert);
                ReminderLogger.log(alert);
            }
        }
    }


    public static String generateAlert(Exam exam) {
        return AlertGenerator.generateAlert(exam);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter exam subject: ");
        java.lang.String subject = scanner.nextLine();

        System.out.print("Enter exam date (YYYY-MM-DD): ");
        LocalDate examDate = LocalDate.parse(scanner.nextLine());

        Exam exam = new Exam(subject, examDate);

        String alert = generateAlert(exam);
        System.out.println(alert);

        scanner.close();
    }
}
