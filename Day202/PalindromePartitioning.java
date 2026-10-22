/*
131. Palindrome Partitioning (DP + Backtracking - DAY 202!)

This solution finds all possible palindrome partitionings of a string.
Time Complexity: O(N * 2^N) bounded, but heavily optimized.
Space Complexity: O(N^2) for DP table + O(N) for recursion stack.

Senior Twist: O(1) DP Palindrome Lookups.
Instead of calling `substring()` and manually verifying if the string is a 
palindrome on every single recursive branch (which costs O(N) time and 
generates massive Garbage Collection overhead), we precompute all possible 
palindromes in a 2D boolean array using Dynamic Programming. 
Inside the DFS loop, we can now check if the partition is a valid palindrome 
in strict O(1) time before choosing to branch down it!
*/
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        // Precompute all palindromes using DP
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // A substring is a palindrome if the outer characters match AND 
                // the inner substring is also a palindrome (or length is <= 2)
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result, dp);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, 
                           List<List<String>> result, boolean[][] dp) {
        
        // Base case: we have successfully partitioned the entire string
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Try partitioning the string at every possible 'end' index
        for (int end = start; end < s.length(); end++) {
            
            // O(1) Check: Is the segment from 'start' to 'end' a palindrome?
            if (dp[start][end]) {
                // 1. Choose
                path.add(s.substring(start, end + 1));
                
                // 2. Explore
                backtrack(s, end + 1, path, result, dp);
                
                // 3. Un-choose (Backtrack)
                path.remove(path.size() - 1);
            }
        }
    }
}