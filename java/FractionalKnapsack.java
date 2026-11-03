
import java.util.*;

public class FractionalKnapsack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        double[] weight = new double[n];
        double[] profit = new double[n];
        double[] ratio = new double[n];

        // Read weight and profit
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight: ");
            weight[i] = sc.nextDouble();

            System.out.print("Enter profit: ");
            profit[i] = sc.nextDouble();

            // Calculate profit/weight ratio
            ratio[i] = profit[i] / weight[i];
        }

        System.out.print("Enter capacity: ");
        double capacity = sc.nextDouble();

        // Sort items by profit/weight ratio
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (ratio[i] < ratio[j]) {

                    double temp = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = temp;

                    temp = weight[i];
                    weight[i] = weight[j];
                    weight[j] = temp;

                    temp = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp;
                }
            }
        }

        double totalProfit = 0;

        // Select items according to highest ratio
        for (int i = 0; i < n; i++) {

            if (capacity >= weight[i]) {

                // Take complete item
                capacity -= weight[i];
                totalProfit += profit[i];

            } else {

                // Take fractional part of item
                totalProfit += ratio[i] * capacity;
                break;
            }
        }

        System.out.println("Maximum Profit: " + totalProfit);
    }
}
