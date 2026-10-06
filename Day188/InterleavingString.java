/*
97. Interleaving String (1D Space-Optimized DP - DAY 188!)

This solution checks if s3 is an interleaving of s1 and s2.
Time Complexity: O(N * M) where N and M are the lengths of s1 and s2.
Space Complexity: O(M) using a strictly 1D DP array.

Senior Twist: 1D State Compression.
Just like in grid pathfinding, `dp[i][j]` only relies on the cell directly 
above it and directly to its left. We can compress the O(N * M) 2D matrix 
into a single O(M) 1D array. As we iterate left to right, `dp[j]` naturally 
holds the result from the row above (representing a match using s1), and 
`dp[j-1]` holds the updated result from the left (representing a match using s2).
*/
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();

        // Fast fail: Lengths must match perfectly
        if (n + m != s3.length()) {
            return false;
        }

        // O(M) Space optimization: We only need the length of s2 columns
        boolean[] dp = new boolean[m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else {
                    int k = i + j - 1;
                    boolean matchS1 = false;
                    boolean matchS2 = false;

                    // Can we form it by taking the current character from s1? (Requires dp[j] from previous row to be true)
                    if (i > 0) {
                        matchS1 = dp[j] && s1.charAt(i - 1) == s3.charAt(k);
                    }

                    // Can we form it by taking the current character from s2? (Requires dp[j-1] from current row to be true)
                    if (j > 0) {
                        matchS2 = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(k);
                    }

                    // Update the cell in place
                    dp[j] = matchS1 || matchS2;
                }
            }
        }

        return dp[m];
    }
}