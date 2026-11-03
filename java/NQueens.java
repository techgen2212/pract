
import java.util.*;

public class NQueens {

    // This method checks whether a queen can be placed safely
    static boolean isSafe(int[][] board, int row, int col, int n) {

        // 1. Check the same column
        // No queen should be present above the current position
        for (int i = 0; i < row; i++) {

            if (board[i][col] == 1) {
                return false;
            }
        }

        // 2. Check the upper-left diagonal
        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {

            if (board[i][j] == 1) {
                return false;
            }

            i--;
            j--;
        }

        // 3. Check the upper-right diagonal
        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < n) {

            if (board[i][j] == 1) {
                return false;
            }

            i--;
            j++;
        }

        // If no queen is found in these directions,
        // the current position is safe
        return true;
    }


    // This method solves the N-Queens problem using Backtracking
    static boolean solve(int[][] board, int row, int n) {

        // Base condition:
        // If all N queens are placed, solution is found
        if (row == n) {
            return true;
        }

        // Try placing a queen in every column of the current row
        for (int col = 0; col < n; col++) {

            // Check whether the current position is safe
            if (isSafe(board, row, col, n)) {

                // Place queen at the safe position
                board[row][col] = 1;

                // Recursively place a queen in the next row
                if (solve(board, row + 1, n)) {
                    return true;
                }

                // Backtracking:
                // Remove the queen if the next row has no valid position
                board[row][col] = 0;
            }
        }

        // If no column is safe, return false
        return false;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the size of the chessboard
        System.out.print("Enter value of N: ");
        int n = sc.nextInt();

        // Create an N x N chessboard
        // 0 means empty cell and 1 means queen is placed
        int[][] board = new int[n][n];

        // Start placing queens from row 0
        if (solve(board, 0, n)) {

            System.out.println("N-Queens Solution:");

            // Display the final chessboard
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }

                System.out.println();
            }

        } else {

            // Display message if no solution exists
            System.out.println("Solution does not exist.");
        }

        sc.close();
    }
}
