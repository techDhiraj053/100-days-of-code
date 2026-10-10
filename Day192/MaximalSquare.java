/*
221. Maximal Square (1D Space-Optimized DP - DAY 192!)

This solution finds the area of the largest square of 1s in a binary matrix.
Time Complexity: O(M * N) where M and N are the matrix dimensions.
Space Complexity: O(N) using a strictly 1D DP array.

Senior Twist: 1D State Compression & Explicit Resetting.
We crush the O(M * N) 2D DP matrix down to an O(N) 1D array by tracking 
the top-left diagonal in a `prev` variable (just like Edit Distance). 
CRITICAL FIX: Unlike a 2D matrix which naturally initializes to 0, 
our 1D array reuses values from the row above. If the current matrix cell 
is '0', we MUST explicitly overwrite `dp[j] = 0` to destroy the previous 
row's state, preventing phantom squares from forming.
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        
        // Use an array of size n + 1 to avoid bounds checking on the left edge (j=0)
        int[] dp = new int[n + 1];
        int maxSide = 0;
        int prev = 0; // Tracks the top-left diagonal (dp[i-1][j-1])

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Save the current 'top' value before it gets overwritten.
                // This becomes the 'top-left diagonal' for the next column.
                int temp = dp[j];
                
                if (matrix[i - 1][j - 1] == '1') {
                    // dp[j] is Top, dp[j-1] is Left, prev is Diagonal
                    dp[j] = 1 + Math.min(dp[j], Math.min(dp[j - 1], prev));
                    maxSide = Math.max(maxSide, dp[j]);
                } else {
                    // CRITICAL: We must explicitly reset to 0 because the array is reused
                    dp[j] = 0;
                }
                
                // Shift the diagonal variable forward for the next iteration
                prev = temp;
            }
        }

        return maxSide * maxSide;
    }
}