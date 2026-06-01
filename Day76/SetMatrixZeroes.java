/*
73. Set Matrix Zeroes (Variable Reduction & Backwards Traversal - Day 76)

This solution satisfies the strict O(1) constant space follow-up by using 
the matrix's own first row and first column as memory markers.

Senior Twist: State Variable Reduction and Loop Consolidation.
Instead of using two boolean flags and four separate loop blocks, we reduce 
the state to a single 'col0' boolean (using matrix[0][0] to track the first row). 
Then, by iterating BACKWARDS during the update phase, we can safely overwrite 
the inner matrix and the first column simultaneously without accidentally 
erasing our marker data too early.
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // We only need one external state variable for the first column
        boolean col0 = false;

        // Step 1: Traverse forward to log the zeroes into our marker zones
        for (int i = 0; i < m; i++) {
            // Check if the first column has a zero
            if (matrix[i][0] == 0) {
                col0 = true;
            }
            
            // Check the rest of the row
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark the row
                    matrix[0][j] = 0; // Mark the column
                }
            }
        }

        // Step 2: Traverse BACKWARDS to update the matrix.
        // Going bottom-up ensures we read the markers before overwriting them!
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            
            // Finally, update the first column for this row if our boolean flagged it
            if (col0) {
                matrix[i][0] = 0;
            }
        }
    }
}