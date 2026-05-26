/*
3. Longest Substring Without Repeating Characters (ASCII Map Optimization - Day 70)

This solution utilizes the highly optimal Sliding Window approach. 

Senior Twist: Instead of using a HashSet (which requires hashing overhead and 
an inner while loop to inch the left pointer forward), we use a fixed-size 
integer array to map ASCII characters to their last seen index. 

When a duplicate is encountered, instead of stepping the left pointer forward 
one by one, we use Math.max() to instantly "jump" the left pointer immediately 
past the duplicate's previous index. This guarantees a strict single-pass O(N) 
time complexity and absolute O(1) space complexity!
*/

import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Strict O(1) space: An array to hold the last seen index of all 128 ASCII characters
        int[] charIndexMap = new int[128];
        
        // Initialize the array with -1 to indicate the character hasn't been seen yet
        Arrays.fill(charIndexMap, -1);
        
        int left = 0;
        int maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If we have seen this character BEFORE, and its last seen position 
            // is inside our current window, we must shrink the window.
            if (charIndexMap[currentChar] >= left) {
                // Instantly JUMP the left pointer past the duplicate!
                left = charIndexMap[currentChar] + 1;
            }
            
            // Record the most recent index of the current character
            charIndexMap[currentChar] = right;
            
            // Calculate the max length of our valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}