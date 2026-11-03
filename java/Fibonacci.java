
import java.util.Scanner;

public class Fibonacci {

    // Recursive Fibonacci function
    static int fibRecursive(int n) {
        if (n <= 1)
            return n;

        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // Non-recursive Fibonacci function
    static void fibIterative(int n) {
        int a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");

            int c = a + b;
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        System.out.println("Recursive Fibonacci:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibRecursive(i) + " ");
        }

        System.out.println("\nNon-Recursive Fibonacci:");
        fibIterative(n);
    }
}
