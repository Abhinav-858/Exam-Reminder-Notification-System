package yourApp.exams;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam {

   
    static class Exam {
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

        public void displayExam() {
            System.out.println("Subject: " + subject +
                               ", Exam Date: " + examDate);
        }
    }

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Exam> examList = new ArrayList<>();

        System.out.print("Enter number of exams: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details for Exam " + i);

            System.out.print("Enter subject name: ");
            java.lang.String subject = sc.nextLine();

            System.out.print("Enter exam date (YYYY-MM-DD): ");
            java.lang.String dateInput = sc.nextLine();
            LocalDate examDate = LocalDate.parse((CharSequence) dateInput);

            examList.add(new Exam(subject, examDate));
        }

        
        System.out.println("\nExam Schedule:");
        for (Exam exam : examList) {
            exam.displayExam();
        }

        sc.close();
    }
}
