/*
22. Generate Parentheses (Optimized Backtracking - DAY 145!)

This solution generates all well-formed combinations of n pairs of parentheses 
with a time complexity bounded by the n-th Catalan number O(4^n / sqrt(n)).

Senior Twist: Dynamic Validation Pruning.
By tracking the counts of `openCount` and `closeCount`, the algorithm guarantees 
validity on the fly. It restricts the addition of closing parentheses strictly 
to states where an unmatched open parenthesis exists (`closeCount < openCount`), 
preventing the exploration of mathematically invalid strings.
*/
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> validCombinations = new ArrayList<>();
        exploreCombinations(validCombinations, new StringBuilder(), 0, 0, n);
        return validCombinations;
    }

    private void exploreCombinations(List<String> result, StringBuilder currentSequence, 
                                     int openCount, int closeCount, int maxPairs) {
        
        // Base case: The sequence length reaches exactly 2 * n characters
        if (currentSequence.length() == maxPairs * 2) {
            result.add(currentSequence.toString());
            return;
        }

        // Branch 1: Add an open parenthesis if we haven't reached the limit
        if (openCount < maxPairs) {
            currentSequence.append('(');
            exploreCombinations(result, currentSequence, openCount + 1, closeCount, maxPairs);
            currentSequence.deleteCharAt(currentSequence.length() - 1); // Backtrack
        }

        // Branch 2: Add a close parenthesis strictly if it balances an existing open one
        if (closeCount < openCount) {
            currentSequence.append(')');
            exploreCombinations(result, currentSequence, openCount, closeCount + 1, maxPairs);
            currentSequence.deleteCharAt(currentSequence.length() - 1); // Backtrack
        }
    }
}