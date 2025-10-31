import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Calendar {
    public static void main (String [] args) {
        Scanner Sc = new Scanner(System.in);

        System.out.print("Enter year: ");
        int year = Sc.nextInt();
        System.out.print("\n");
        
        System.out.print("Enter month (1 - 12): ");
        int month = Sc.nextInt();
        System.out.println();
        
        LocalDate date = LocalDate.of(year, month, 1);
        String MonthName = date.getMonth().toString().substring(0,1).substring(1).toLowerCase();
        
        System.out.println("\nCalendar for the month of " + MonthName + ", " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        int StartDay = date.getDayOfWeek().getValue();

        if(StartDay == 7) {
            StartDay = 0;
        }
        for(int i = 0; i < StartDay; i++) {
            System.out.print("   ");
        }
        int DaysInMonth = date.lengthOfMonth();
        for(int day = 1; day <= DaysInMonth; day++)
        {
            System.out.print(" " + day);
            if((day + StartDay) % 7 == 0)
            System.out.println();
        }
        Sc.close();
    }
}