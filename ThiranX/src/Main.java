import com.thiranx.features.Notification.NotificationView;
import com.thiranx.features.employee.details.EmployeeListView;
import com.thiranx.features.report.ReportView;
import com.thiranx.features.singin.SignInView;
import com.thiranx.features.singup.SignUpView;
import com.thiranx.features.task.TaskView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SignUpView signUpView = new SignUpView();
        SignInView signInView = new SignInView();
        EmployeeListView employeeListView = new EmployeeListView();
        ReportView reportView = new ReportView();
        NotificationView notificationView = new NotificationView();
        TaskView taskView = new TaskView();

        while (true) {
            System.out.println("\n=== ThiranX ===");
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. List Employees");
            System.out.println("4. Report");
            System.out.println("5. Notifications");
            System.out.println("6. Tasks");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    signUpView.init(sc);
                    break;
                case "2":
                    signInView.init(sc);
                    break;
                case "3":
                    employeeListView.showAllEmployees();
                    break;
                case "4":
                    reportView.showSummary();
                    break;
                case "5":
                    notificationView.menu(sc);
                    break;
                case "6":
                    taskView.menu(sc);
                    break;
                case "0":
                    System.out.println("Bye.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
