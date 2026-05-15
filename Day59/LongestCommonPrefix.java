/*
14. Longest Common Prefix (Idiomatic Java Optimization - Day 59)

This solution utilizes the highly optimal Horizontal Scanning approach, 
achieving O(S) time complexity (where S is the total number of characters) 
and O(1) space complexity. 

Senior Twist: A fail-fast guard clause is added to protect against null 
or empty arrays. Additionally, the standard .indexOf() check is replaced 
with Java's idiomatic .startsWith() method, which clearly communicates 
the developer's intent and improves code readability.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Enterprise guard clause to protect against bad inputs
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start by assuming the first string is the longest common prefix
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            
            // While the current string does NOT start with our prefix, chip away at it!
            while (!strs[i].startsWith(prefix)) {
                // Remove the last character from the prefix
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If we chipped away everything, there is no common prefix at all
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }
}