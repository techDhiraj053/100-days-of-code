/*
392. Is Subsequence (Two-Pointer & Follow-Up Analysis - Day 65)

This solution utilizes a highly optimal Two-Pointer approach to verify the 
subsequence in O(N) time and O(1) space. The strings are converted to char 
arrays to bypass the overhead of repeated .charAt() method calls in Java.

Senior Twist: Addressing the Follow-Up!
If an enterprise system had 1 billion 's' strings to check against a static 't', 
running O(N) a billion times is inefficient. We would PRECOMPUTE 't'. 
We would create a Map storing a list of indices for every character in 't' 
(e.g., 'a' -> [0, 5, 8]). Then, for each incoming 's', we iterate through its 
characters and use Binary Search to find the next valid index in 't', 
dropping the search time to O(|s| * log |t|)!
*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        // Fast-fail guard clause: an empty string is always a subsequence
        if (s.length() == 0) return true;
        
        int i = 0;
        int j = 0;
        
        // Micro-optimization: char arrays are slightly faster to access than .charAt()
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        while (i < sArr.length && j < tArr.length) {
            // If the characters match, advance the 's' pointer
            if (sArr[i] == tArr[j]) {
                i++;
            }
            // Always advance the 't' pointer
            j++;
        }
        
        // If 'i' reached the end of the 's' array, every character was found in order
        return i == sArr.length;
    }
}