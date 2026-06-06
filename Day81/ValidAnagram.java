/*
242. Valid Anagram (Zero-Sum Array Optimization - Day 81)

The HashMap approach is the perfect architectural answer to the Unicode 
follow-up question, as it handles massive, sparse character sets efficiently.

Senior Twist: Base Constraint Optimization.
For the base constraints (lowercase English letters only), a HashMap introduces 
unnecessary overhead. Instead, we use a single direct-access array of size 26.
Because the lengths are equal, we can use a single loop to increment the count 
for characters in 's' and decrement the count for characters in 't'. If they 
are valid anagrams, every single bucket will perfectly balance back to 0. 
This yields a blistering fast O(N) execution with strict O(1) space!
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        // Fast-fail guard clause: Anagrams must be the exact same length
        if (s.length() != t.length()) {
            return false;
        }

        // Direct-access array for the 26 lowercase English letters
        int[] count = new int[26];

        // Single loop: increment for 's', decrement for 't'
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Verify that all buckets balanced perfectly back to 0
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}