/*
139. Word Break (Dynamic Programming - DAY 181!)

This solution determines if a string can be segmented into dictionary words.
Time Complexity: O(N * L) where N is string length and L is max word length.
Space Complexity: O(N) for the DP array + O(W) for the HashSet.

Senior Twist: Maximum Length Lookback Bound.
Instead of checking every possible substring from j=0 to i, we pre-calculate 
the maximum word length in the dictionary. We then constrain our inner loop 
to only look back up to `maxLength` characters. This prevents the algorithm 
from creating and hashing massive substrings that could never possibly exist 
in the dictionary, vastly improving performance on long strings.
*/
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictSet = new HashSet<>(wordDict);
        
        // Find the length of the longest word in the dictionary
        int maxLength = 0;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Base case: empty string is valid

        for (int i = 1; i <= s.length(); i++) {
            
            // Optimization: Only look back up to the maximum dictionary word length.
            // Math.max prevents an OutOfBoundsException near the beginning of the string.
            int startBound = Math.max(0, i - maxLength);
            
            for (int j = startBound; j < i; j++) {
                
                // If the substring up to 'j' is valid, check if the rest is in the dictionary
                if (dp[j] && dictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // Short-circuit: no need to check other breaks for this index
                }
            }
        }

        return dp[s.length()];
    }
}