/*
51. N-Queens (O(1) State Validation - DAY 199!)

This solution finds all distinct board configurations for the N-Queens puzzle.
Time Complexity: O(N!) bounded.
Space Complexity: O(N) for the recursion stack and boolean tracking arrays.

Senior Twist: O(1) Validation via Boolean Arrays.
Instead of running O(N) loops to check the column, upper-left diagonal, and 
upper-right diagonal, we exploit the mathematical properties of a 2D matrix.
- The anti-diagonal (/) shares a constant sum: `row + col`.
- The main diagonal (\) shares a constant difference: `row - col`.
By tracking occupied lines in boolean arrays, we validate safe placements in 
strict O(1) time, dramatically speeding up the DFS traversal!
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // O(1) state tracking arrays for columns and both diagonals
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // Tracks row + col
        boolean[] diag2 = new boolean[2 * n]; // Tracks row - col + n - 1

        backtrack(0, n, board, cols, diag1, diag2, result);

        return result;
    }

    private void backtrack(int row, int n, char[][] board, 
                           boolean[] cols, boolean[] diag1, boolean[] diag2, 
                           List<List<String>> result) {
        
        // Base case: All queens have been placed successfully
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }
            result.add(solution);
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + n - 1;

            // O(1) validation check: If the column or either diagonal is taken, skip it
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }

            // 1. Choose: Place the queen and mark the tracking arrays
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            // 2. Explore: Move to the next row
            backtrack(row + 1, n, board, cols, diag1, diag2, result);

            // 3. Un-choose (Backtrack): Remove the queen and free the tracking arrays
            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}