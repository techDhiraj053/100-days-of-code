/*
383. Ransom Note (Alphabet Array Optimization - Day 78)

This solution handles frequency counting optimally in O(M + N) time.

Senior Twist: Data Structure Selection.
Because the problem constraints guarantee only lowercase English letters, 
using a standard HashMap introduces unnecessary autoboxing and hashing overhead. 
Instead, we use a fixed-size integer array of length 26. By subtracting the 
ASCII value of 'a' from our characters, we dynamically map 'a'-'z' to indices 
0-25. This yields a massively faster execution time and strict O(1) auxiliary space!
*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Fast-fail guard clause: if the note is longer than the magazine, it's impossible
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // Direct-access array for the 26 lowercase English letters
        int[] letterCounts = new int[26];

        // Build the frequency map from the magazine
        for (char c : magazine.toCharArray()) {
            letterCounts[c - 'a']++;
        }

        // Try to construct the ransom note
        for (char c : ransomNote.toCharArray()) {
            // If the count is 0, we don't have enough of this letter available
            if (letterCounts[c - 'a'] == 0) {
                return false;
            }
            // Deplete the letter from our bank
            letterCounts[c - 'a']--;
        }

        return true;
    }
}