/*
17. Letter Combinations of a Phone Number (DFS Backtracking - DAY 140!)

This solution generates all possible letter combinations for a given digit string 
in O(4^N * N) time complexity and O(N) auxiliary space.

Senior Twist: Mutable State Backtracking.
By utilizing a `StringBuilder` instead of immutable `String` concatenation, 
we eliminate massive object creation overhead. The core backtracking pattern is highlighted 
by explicitly appending the character, recursing, and then removing the character 
(backtracking) to restore the state for the next sibling branch.
*/
import java.util.List;
import java.util.ArrayList;

class Solution {
    // Dictionary mapping digits 0-9 to their respective phone keypad letters
    private static final String[] KEYPAD_MAPPING = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> combinationsResult = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return combinationsResult;
        }

        // Use StringBuilder for O(1) character appending/removal during backtracking
        exploreCombinations(digits, 0, new StringBuilder(), combinationsResult);

        return combinationsResult;
    }

    private void exploreCombinations(String digits, int currentIndex, StringBuilder currentCombination, List<String> result) {
        // Base Case: The combination length matches the input digits length
        if (currentIndex == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        // Retrieve the letters corresponding to the current digit
        int digitValue = digits.charAt(currentIndex) - '0';
        String possibleLetters = KEYPAD_MAPPING[digitValue];

        // Iterate through all possible letter branches
        for (char letter : possibleLetters.toCharArray()) {
            // 1. Choose: Append the letter to our current state
            currentCombination.append(letter);

            // 2. Explore: Recurse to the next digit
            exploreCombinations(digits, currentIndex + 1, currentCombination, result);

            // 3. Un-choose (Backtrack): Remove the letter to reset state for the next loop iteration
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }
}