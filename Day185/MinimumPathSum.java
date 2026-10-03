/*
64. Minimum Path Sum (1D Space-Optimized DP - DAY 185!)

This solution finds the path with the minimum sum from top-left to bottom-right.
Time Complexity: O(m * n) where m is rows and n is columns.
Space Complexity: O(n) using a single 1D DP array.

Senior Twist: 1D State Compression.
Instead of maintaining a full 2D matrix which costs O(m * n) memory, we only 
need to track the current row. As we iterate left to right, `dp[j]` acts as the 
value from the row directly above, and `dp[j - 1]` acts as the value from the 
cell immediately to the left. This perfectly evaluates `Math.min(top, left)` 
while dynamically updating the array in place, keeping space to a strict O(n).
*/
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // O(n) space array representing the current row's minimum path sums
        int[] dp = new int[n];
        
        // Initialize the starting cell
        dp[0] = grid[0][0];
        
        // Initialize the first row (can only come from the left)
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        
        // Process the remaining rows
        for (int i = 1; i < m; i++) {
            
            // The first column can only come from directly above
            dp[0] += grid[i][0];
            
            for (int j = 1; j < n; j++) {
                // dp[j] is currently the value from the row above (top)
                // dp[j-1] is the newly calculated value from this row (left)
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }
        
        return dp[n - 1];
    }
}