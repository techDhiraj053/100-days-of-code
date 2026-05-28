/*
76. Minimum Window Substring (ASCII Map & Raw Count Optimization - Day 72)

This solution handles one of the most famous Sliding Window problems. By expanding 
the right boundary to find a valid window, and then shrinking the left boundary 
to optimize it, we achieve the requested O(m + n) time complexity.

Senior Twist: We replace the HashMaps with a direct-access ASCII array (int[128]) 
for strict O(1) space and zero hashing overhead. Additionally, we simplify the 
tracking logic. Instead of tracking unique character frequencies, we simply track 
the raw number of characters 'required'. This makes the expanding and shrinking 
logic incredibly lean and fast.
*/

class Solution {
    public String minWindow(String s, String t) {
        // Guard Clause
        if (s == null || s.length() < t.length()) {
            return "";
        }

        // ASCII array to store the required frequencies of characters in 't'
        int[] need = new int[128];
        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        
        // Track the total raw number of characters we still need to find
        int required = t.length();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            
            // If this character is needed, decrement our required count
            if (need[rightChar] > 0) {
                required--;
            }
            
            // Decrement the frequency in our map (unneeded chars become negative)
            need[rightChar]--;
            right++;

            // When required == 0, our window contains all characters from 't'
            while (required == 0) {
                
                // Record the new minimum window
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);
                
                // Put the left character back into our required map
                need[leftChar]++;
                
                // If it becomes > 0, it means we just dropped a character we actually need
                if (need[leftChar] > 0) {
                    required++;
                }
                
                left++;
            }
        }

        // Return the substring, or an empty string if no valid window was found
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}