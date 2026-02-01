package yourApp.exams;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReminderLogger {

    public static void log(String message) {
        try (FileWriter fw = new FileWriter("reminder_log.txt", true)) {
            fw.write(message + System.lineSeparator());
            System.out.println("Reminder saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing log file.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter reminder message: ");
        String message = scanner.nextLine();

        log(message);

        scanner.close();
    }
}
