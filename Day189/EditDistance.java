/*
72. Edit Distance (1D Space-Optimized DP - DAY 189!)

This solution finds the minimum operations to convert word1 to word2.
Time Complexity: O(M * N) where M and N are the string lengths.
Space Complexity: O(N) using a strictly 1D DP array.

Senior Twist: 1D State Compression with Diagonal Tracking.
To compress an O(M * N) matrix into a 1D array of size O(N), we iterate 
through the rows. `dp[j]` represents the cell directly above, and `dp[j-1]` 
represents the cell to the left. 
Because Edit Distance also requires the top-left diagonal cell (for replacements 
and matches), we use a temporary `prev` variable to store the old `dp[j-1]` 
before it gets updated, perfectly simulating the 2D space in 1D!
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // O(N) space array
        int[] dp = new int[n + 1];

        // Base case: Converting empty word1 to word2 requires 'j' insertions
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            // `prev` tracks the top-left diagonal value before it gets overwritten.
            // At the start of a new row, the "diagonal" for the first column 
            // is the previous row's 0th column (i.e., dp[0] from the last iteration).
            int prev = dp[0];
            
            // Base case: Converting word1 of length i to empty word2 requires 'i' deletions
            dp[0] = i;

            for (int j = 1; j <= n; j++) {
                // Save the current top value before we overwrite it (it becomes the 
                // diagonal for the NEXT iteration `j+1`)
                int temp = dp[j];

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match: Take the diagonal (no new operations needed)
                    dp[j] = prev;
                } else {
                    // Characters differ: 1 + min(Insert, Delete, Replace)
                    // dp[j-1] is Left (Insert)
                    // dp[j]   is Top (Delete)
                    // prev    is Diagonal (Replace)
                    dp[j] = 1 + Math.min(prev, Math.min(dp[j], dp[j - 1]));
                }

                // Update prev for the next column's calculation
                prev = temp;
            }
        }

        return dp[n];
    }
}