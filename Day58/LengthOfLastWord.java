/*
58. Length of Last Word (Single Pass Optimization - Day 58)

While built-in methods like .split() or .trim() can solve this problem, 
they create unnecessary String objects in memory, leading to O(N) space. 
This solution utilizes a manual Right-to-Left traversal to achieve strict 
O(1) space complexity.

Senior Twist: Loop Consolidation. By checking the state of the 'count' 
variable inside a single for-loop, we can gracefully skip trailing spaces 
and immediately break out of the loop the moment the last word ends, 
eliminating the need for multiple while loops.
*/

class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        
        // Traverse the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            
            if (s.charAt(i) != ' ') {
                // If it's a character, increment our word length
                count++;
            } else if (count > 0) {
                // If it's a space AND we've already started counting a word, 
                // it means we've reached the beginning of the last word. Stop looping!
                break;
            }
        }
        
        return count;
    }
}