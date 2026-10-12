/*
22. Generate Parentheses (Backtracking - DAY 194!)

This solution generates all combinations of well-formed parentheses.
Time Complexity: O(4^n / sqrt(n)) - bounded by the nth Catalan number.
Space Complexity: O(n) for the recursion stack and StringBuilder.

Senior Twist: Mathematical Pruning (Catalan Properties).
Instead of generating all random permutations of '(' and ')' and validating 
them at the end, we enforce mathematical validity at every branch. 
Because a valid sequence can never have more closing brackets than opening 
brackets at any given index, `close < open` inherently prunes invalid trees 
immediately. Using a mutable `StringBuilder` keeps the memory strictly O(n).
*/
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        
        // Use a single mutable StringBuilder for O(1) appending/deleting
        backtrack(result, new StringBuilder(), 0, 0, n);
        
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int n) {
        // Base case: If the length is exactly 2 * n, we have used all pairs
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Branch 1: Add an opening bracket if we haven't reached the limit 'n'
        if (open < n) {
            current.append('(');
            backtrack(result, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1);
        }

        // Branch 2: Add a closing bracket ONLY if it mathematically balances an open one
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
}