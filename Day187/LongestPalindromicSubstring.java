/*
5. Longest Palindromic Substring (Center Expansion - DAY 187!)

This solution finds the longest palindromic substring in O(N^2) time 
and optimal O(1) space.

Senior Twist: Duplicate Center Skip Optimization.
Instead of calling `expandAroundCenter` twice for odd and even lengths, 
we can treat identical adjacent characters as a single "center block" (e.g., 
"bb" in "abba"). We fast-forward the `i` pointer past these duplicates. 
This naturally handles both odd and even palindromes in a single pass, 
and drops the time complexity for uniform strings (like "bbbbbb") 
from O(N^2) down to a blistering O(N)!
*/
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int maxLength = 0;
        int start = 0;

        for (int i = 0; i < s.length(); ) {
            int left = i;
            int right = i;

            // 1. Skip duplicate characters to form a solid center block
            // This naturally handles even-length palindromes and optimizes uniform strings
            while (right < s.length() - 1 && s.charAt(right) == s.charAt(right + 1)) {
                right++;
            }
            
            // Next iteration can safely start AFTER this identical block
            i = right + 1;

            // 2. Expand outwards from the edges of our center block
            while (left > 0 && right < s.length() - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            }

            // 3. Update the maximum palindrome boundary
            int currentLength = right - left + 1;
            if (currentLength > maxLength) {
                start = left;
                maxLength = currentLength;
            }
        }

        return s.substring(start, start + maxLength);
    }
}