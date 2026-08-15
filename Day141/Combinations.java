/*
77. Combinations (Optimized Backtracking - DAY 141!)

This solution generates all possible combinations of k numbers chosen 
from the range [1, n]. 

Senior Twist: Search Space Pruning.
Instead of looping all the way to `n`, we calculate the absolute maximum 
starting bound (`upperLimit`) that still leaves enough remaining elements 
to satisfy the combination size `k`. This eliminates dead-end recursion 
branches and drastically improves execution time.
*/
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinationsResult = new ArrayList<>();
        exploreCombinations(1, n, k, new ArrayList<>(), combinationsResult);
        return combinationsResult;
    }

    private void exploreCombinations(int startNumber, int n, int k, 
                                     List<Integer> currentCombination, 
                                     List<List<Integer>> result) {
        
        // Base case: combination is complete
        if (currentCombination.size() == k) {
            result.add(new ArrayList<>(currentCombination)); // Deep copy
            return;
        }

        // Optimization: Prune branches that cannot possibly reach size k
        int remainingNeeded = k - currentCombination.size();
        int upperLimit = n - remainingNeeded + 1;

        // Iterate only up to the maximum viable starting number
        for (int i = startNumber; i <= upperLimit; i++) {
            currentCombination.add(i);                                 // 1. Choose
            exploreCombinations(i + 1, n, k, currentCombination, result); // 2. Explore
            currentCombination.remove(currentCombination.size() - 1);  // 3. Undo (Backtrack)
        }
    }
}