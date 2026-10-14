/*
46. Permutations (In-Place Swapping - DAY 196!)

This solution generates all possible permutations of an array.
Time Complexity: O(N * N!), where N is the length of the array.
Space Complexity: O(N) for the recursion stack (ignoring output list).

Senior Twist: In-Place Swapping (Zero Extra State Allocation).
The standard approach uses a `boolean[] used` array and a temporary 
`List` that constantly grows and shrinks. To achieve maximum efficiency, 
we can eliminate the `used` array entirely. By swapping elements directly 
within the original array at a specific `startIndex`, we inherently partition 
the array into a "chosen" left side and an "unexplored" right side. 
We swap, recurse, and swap back. This is the ultimate zero-allocation backtracking!
*/
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int startIndex, List<List<Integer>> result) {
        // Base case: If startIndex reaches the end, the array itself is a valid permutation
        if (startIndex == nums.length) {
            List<Integer> currentPermutation = new ArrayList<>(nums.length);
            for (int num : nums) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }

        // Try swapping the current startIndex with every element to its right (including itself)
        for (int i = startIndex; i < nums.length; i++) {
            // 1. Choose (Swap the element into the "locked" prefix)
            swap(nums, startIndex, i);
            
            // 2. Explore (Move the boundary one step to the right)
            backtrack(nums, startIndex + 1, result);
            
            // 3. Un-choose (Backtrack by swapping the elements back to their original state)
            swap(nums, startIndex, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}