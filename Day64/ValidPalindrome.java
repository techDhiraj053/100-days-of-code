/*
125. Valid Palindrome (Clean Code & Guard Clauses - Day 64)

This solution uses the highly optimal Two-Pointer approach, achieving O(N) 
time and O(1) space complexity. By checking characters in-place from both 
ends and skipping non-alphanumeric characters, we avoid the heavy O(N) space 
penalty of creating a brand new cleaned string or using Regex.

Senior Twist: Improved variable naming (left/right) for self-documenting 
code, and a fast-failing guard clause for null/empty inputs.
*/

class Solution {
    public boolean isPalindrome(String s) {
        // Enterprise Guard Clause: Fast exit for empty or null strings
        if (s == null || s.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            
            // Skip non-alphanumeric characters from the left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            
            // Skip non-alphanumeric characters from the right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            // Compare characters (converted to lower case for case-insensitivity)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            // Move pointers inward for the next comparison
            left++;
            right--;
        }
        
        return true;
    }
}