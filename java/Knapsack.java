
import java.util.*;

public class Knapsack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Step 1: Read the number of items
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        // Arrays to store weight and profit of items
        int[] weight = new int[n];
        int[] profit = new int[n];

        // Step 2: Read weight and profit of each item
        for (int i = 0; i < n; i++) {

            System.out.print("Enter weight of item " + (i + 1) + ": ");
            weight[i] = sc.nextInt();

            System.out.print("Enter profit of item " + (i + 1) + ": ");
            profit[i] = sc.nextInt();
        }

        // Step 3: Read the maximum capacity of the bag
        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        // Step 4: Create a DP table
        // Rows represent items and columns represent bag capacity
        int[][] dp = new int[n + 1][capacity + 1];

        // Step 5: Fill the DP table using Dynamic Programming
        for (int i = 1; i <= n; i++) {

            for (int w = 1; w <= capacity; w++) {

                // Check whether the current item can fit in the bag
                if (weight[i - 1] <= w) {

                    // Option 1: Include the current item
                    int include = profit[i - 1]
                            + dp[i - 1][w - weight[i - 1]];

                    // Option 2: Do not include the current item
                    int exclude = dp[i - 1][w];

                    // Select the option that gives maximum profit
                    dp[i][w] = Math.max(include, exclude);

                } else {

                    // If item cannot fit, do not include it
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Step 6: Display the maximum profit
        System.out.println("Maximum Profit: " + dp[n][capacity]);

        sc.close();
    }
}
