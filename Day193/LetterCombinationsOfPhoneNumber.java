/*
17. Letter Combinations of a Phone Number (Backtracking - DAY 193!)

This solution generates all possible letter combinations for a given phone number.
Time Complexity: O(4^N * N), where N is the length of digits.
Space Complexity: O(N) for the recursion stack and StringBuilder.

Senior Twist: Mutable StringBuilder Backtracking.
Instead of creating a brand new immutable `String` object in memory on every 
single recursive call (via `current + ch`), we use a single mutable `StringBuilder`. 
We follow the classic backtracking template: 
Choose (append) -> Explore (recurse) -> Un-choose (delete).
This eliminates massive Garbage Collection overhead and is the industry 
standard for high-performance combinatorial algorithms.
*/
import java.util.ArrayList;
import java.util.List;

class Solution {
    
    // Constant array for mapping digits to letters. 
    // Faster and lighter than a HashMap.
    private static final String[] KEYPAD = {
        "", "", "abc", "def", "ghi", 
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // Use a mutable StringBuilder for memory efficiency
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // Base case: If the combination length equals the digits length, we found a valid path
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Convert the char digit to an integer index
        int digitIndex = digits.charAt(index) - '0';
        String letters = KEYPAD[digitIndex];

        // Try every possible letter mapped to the current digit
        for (char ch : letters.toCharArray()) {
            
            // 1. Choose: Add the character to our current path
            current.append(ch);
            
            // 2. Explore: Move to the next digit
            backtrack(digits, index + 1, current, result);
            
            // 3. Un-choose (Backtrack): Remove the character to try the next one in the loop
            current.deleteCharAt(current.length() - 1);
        }
    }
}