import java.util.Scanner;

public class Recursion {

    static int factorial(int x) {
        if (x == 0)
            return 1;
        else
            return x * factorial(x - 1);
    }

    static int power(int base, int exp) {
        if (exp == 0)
            return 1;
        else
            return base * power(base, exp - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n===Type 'fact' to calculate the factorial===");
        System.out.println("===Type 'exp' to calculate the exponent===");
        String inp = sc.next();

        if (inp.equalsIgnoreCase("fact")) {
            System.out.print("Enter a number to find factorial: ");
            int num = sc.nextInt();
            int f = factorial(num);
            System.out.println("Factorial of " + num + " is: " + f);
        }
        else if (inp.equalsIgnoreCase("exp")) {
            System.out.print("Enter the base: ");
            int base = sc.nextInt();
            System.out.print("Enter the exponent: ");
            int exp = sc.nextInt();
            int p = power(base, exp);
            System.out.println(base + " raised to the power " + exp + " is: " + p);
        }
        else {
            System.out.println("Exiting the program...");
        }

        sc.close();
    }
}