/*
63. Unique Paths II (1D Space-Optimized DP - DAY 186!)

This solution finds the number of unique paths in a grid with obstacles.
Time Complexity: O(m * n) where m is rows and n is columns.
Space Complexity: O(n) using a single 1D DP array.

Senior Twist: 1D State Compression & Immutability.
Instead of an O(m * n) matrix, we use a single O(n) array. As we iterate, 
`dp[j]` naturally holds the value from the row above, and `dp[j-1]` holds 
the newly updated value from the left. 
If an obstacle is encountered, we instantly set `dp[j] = 0`, gracefully 
blocking all paths attempting to pass through it from above or left.
*/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        
        // Base case: if the starting cell is an obstacle, no paths exist
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        
        // Iterate through each row in the grid
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < n; j++) {
                
                if (row[j] == 1) {
                    // An obstacle zeroes out all paths through this cell
                    dp[j] = 0;
                } else if (j > 0) {
                    // Paths = paths from top (existing dp[j]) + paths from left (dp[j-1])
                    dp[j] += dp[j - 1];
                }
            }
        }
        
        return dp[n - 1];
    }
}