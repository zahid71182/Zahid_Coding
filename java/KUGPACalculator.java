import java.util.Scanner;

public class KUGPACalculator {

    public static double getGradePoint(double marks) {
        if (marks >= 90) return 4.0;
        else if (marks >= 85) return 4.0;
        else if (marks >= 80) return 3.8;
        else if (marks >= 75) return 3.4;
        else if (marks >= 71) return 3.0;
        else if (marks >= 68) return 2.8;
        else if (marks >= 64) return 2.4;
        else if (marks >= 61) return 2.0;
        else if (marks >= 57) return 1.8;
        else if (marks >= 53) return 1.4;
        else if (marks >= 45) return 1.0;
        else return 0.0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("--- Karachi University GPA Calculator ---");
        System.out.print("Enter the number of courses: ");
        int numCourses = input.nextInt();

        double totalQualityPoints = 0;
        double totalMarks = 0;
        double totalCreditHours = 0;
        double percentage = 0;


        for (int i = 1; i <= numCourses; i++) {
            System.out.println("\nCourse #" + i + ":");
            System.out.print("Enter Marks (0-100): ");
            double marks = input.nextDouble();
            totalMarks += marks;
            
            System.out.print("Enter Credit Hours (e.g., 2 or 3): ");
            double credits = input.nextDouble();

            double gp = getGradePoint(marks);
            totalQualityPoints += (gp * credits);
            totalCreditHours += credits;
        }

        percentage = (totalMarks / (100 * numCourses));

        if (totalCreditHours > 0) {
            double gpa = totalQualityPoints / totalCreditHours;
            System.out.println("\n------------------------------------");
            System.out.printf("Total Credit Hours: %.1f\n", totalCreditHours);
            System.out.printf("Your Semester Percentage is: %.2f\n", percentage);
            System.out.printf("Your Semester GPA is: %.2f\n", gpa);
            System.out.println("------------------------------------");
        } else {
            System.out.println("No credit hours entered.");
        }

        input.close();
    }
}