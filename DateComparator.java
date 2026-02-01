package yourApp.exams;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import String;
import module1;
import module1.Exam;

public class DateComparator {

    
    public static java.lang.String compareExamDate(module1.Exam exam) {

        LocalDate today = LocalDate.now();
        LocalDate examDate = exam.getExamDate();

        if (examDate.isEqual(today)) {
            return exam.getSubject() + ": Exam is today!";
        } 
        else if (examDate.isAfter(today)) {
            long daysLeft = ChronoUnit.DAYS.between(today, examDate);
            return exam.getSubject() + ": Exam is in " + daysLeft + " day(s).";
        } 
        else {
            return exam.getSubject() + ": Exam date has already passed.";
        }
    }

    
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter subject name: ");
            java.lang.String subject = scanner.nextLine();
            
            
            System.out.print("Enter exam year (YYYY): ");
            int year = scanner.nextInt();
            
            System.out.print("Enter exam month (1-12): ");
            int month = scanner.nextInt();
            
            System.out.print("Enter exam day (1-31): ");
            int day = scanner.nextInt();
            
            
            module1.Exam exam = new module1.Exam(
                    subject,
                    LocalDate.of(year, month, day)
            );
            
            
            String result = compareExamDate(exam);
            
            
            System.out.println(result);
        }
    }
}
