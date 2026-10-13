/*
39. Combination Sum (Optimized Backtracking - DAY 195!)

This solution finds all unique combinations that sum up to a target.
Time Complexity: O(N^(T/M)) where T is target, M is minimum value.
Space Complexity: O(T/M) for the recursion stack.

Senior Twist: Sorting for Early Branch Pruning.
By sorting the `candidates` array upfront, we unlock the ability to prune 
invalid recursive branches instantly. Inside the loop, if subtracting the 
current candidate makes the target drop below zero, we can immediately `break`. 
Because the array is sorted, we guarantee that all subsequent candidates in 
the loop will also be too large. This prevents thousands of useless recursive 
calls on large inputs!
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Optimize: Sort the array to enable early loop termination (pruning)
        Arrays.sort(candidates);
        
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        
        return result;
    }

    private void backtrack(int[] candidates, int remain, int startIndex, 
                           List<Integer> current, List<List<Integer>> result) {
        
        // Base case: If we hit exactly 0, we found a valid combination
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // EARLY PRUNING: If the current number is strictly greater than the 
            // remaining target, stop the loop entirely. 
            // Since the array is sorted, all subsequent numbers will also be too big.
            if (remain - candidates[i] < 0) {
                break; 
            }

            // 1. Choose the current number
            current.add(candidates[i]);

            // 2. Explore further (passing 'i' allows reusing the same number, 
            // but prevents looking backwards to avoid duplicate combinations)
            backtrack(candidates, remain - candidates[i], i, current, result);

            // 3. Un-choose (Backtrack) to explore the next sibling path
            current.remove(current.size() - 1);
        }
    }
}