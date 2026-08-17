/*
39. Combination Sum (Optimized Backtracking with Pruning - DAY 143!)

This solution finds all unique combinations that sum to a target.

Senior Twist: Sorted Aggressive Pruning.
By sorting the candidate array before initiating the DFS traversal ($O(N \log N)$), 
we unlock the ability to brutally prune the state-space tree. The moment a candidate 
exceeds the remaining target, we `break` the loop, skipping all larger candidates 
and saving massive amounts of redundant recursion overhead.
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> validCombinations = new ArrayList<>();
        
        // Sort candidates to enable early stopping (branch pruning)
        Arrays.sort(candidates);
        
        exploreCombinations(candidates, target, 0, new ArrayList<>(), validCombinations);
        
        return validCombinations;
    }

    private void exploreCombinations(int[] candidates, int remainingTarget, int startIndex, 
                                     List<Integer> currentCombination, List<List<Integer>> result) {
        
        // Base case: Exact target match achieved
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // Iterate through candidates starting from startIndex to avoid duplicate permutations
        for (int i = startIndex; i < candidates.length; i++) {
            
            // Because candidates are sorted, if the current element exceeds the target,
            // all subsequent elements will also exceed it. Break entirely.
            if (candidates[i] > remainingTarget) {
                break;
            }

            // 1. Choose
            currentCombination.add(candidates[i]);

            // 2. Explore (Pass 'i' to allow unlimited reuse of the same candidate)
            exploreCombinations(candidates, remainingTarget - candidates[i], i, currentCombination, result);

            // 3. Undo (Backtrack)
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}