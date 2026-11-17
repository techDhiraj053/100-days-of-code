/*
Longest Substring with K Uniques (Variable Sliding Window - DAY 224!)

This solution finds the longest substring containing exactly K unique characters.
Time Complexity: O(N) where N is the length of the string. Each char is visited at most twice.
Space Complexity: O(1) since the alphabet array size is strictly fixed at 26.

Senior Twist: Primitive Array Hashing & Autoboxing Avoidance.
Your logical "Hire and Fire" window mechanics are perfect. To push this to 
extreme enterprise performance, we replace `HashMap<Character, Integer>` with 
a simple `int[26]` frequency array. This eliminates the heavy overhead of 
Java Object autoboxing and hash computations, drastically boosting execution 
speed by leveraging pure CPU cache locality!
*/
class Solution {
    public int longestKSubstr(String s, int k) {
        // Fixed size array for 26 lowercase English letters
        int[] charCount = new int[26];
        int uniqueCount = 0;
        
        int low = 0;
        int maxLength = -1; // Default to -1 as required if no substring is found

        for (int high = 0; high < s.length(); high++) {
            char ch = s.charAt(high);
            
            // Hire: Add new character to the window
            if (charCount[ch - 'a'] == 0) {
                uniqueCount++; // A brand new unique character entered the window
            }
            charCount[ch - 'a']++;

            // Fire: If we exceed k unique characters, shrink the window from the left
            while (uniqueCount > k) {
                char leftChar = s.charAt(low);
                charCount[leftChar - 'a']--;
                
                if (charCount[leftChar - 'a'] == 0) {
                    uniqueCount--; // We completely fired a unique character
                }
                low++;
            }

            // Record the maximum length if we have EXACTLY k unique characters
            if (uniqueCount == k) {
                maxLength = Math.max(maxLength, high - low + 1);
            }
        }

        return maxLength;
    }
}