/*
78. Subsets (Bitmasking Iteration - DAY 201!)

This solution generates the power set of an array.
Time Complexity: O(N * 2^N).
Space Complexity: O(1) auxiliary space (excluding output list).

Senior Twist: Bitwise Combinatorics (Zero Recursion).
Since the array size is small (N <= 10), we can map every subset directly 
to a binary number from 0 to (2^N - 1). If the j-th bit of the number is set 
(using `(i & (1 << j)) != 0`), we include `nums[j]` in the current subset.
This completely eliminates the recursive DFS stack, providing a purely 
iterative, hardware-accelerated way to generate the power set!
*/
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        
        // 1 << n is mathematically equivalent to 2^n
        int totalSubsets = 1 << n; 
        
        // Pre-allocate the exact capacity to prevent ArrayList resizing overhead
        List<List<Integer>> result = new ArrayList<>(totalSubsets);

        // Iterate through all binary numbers from 0 to 2^n - 1
        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> currentSubset = new ArrayList<>();
            
            // Check each bit of the current number 'i'
            for (int j = 0; j < n; j++) {
                
                // If the j-th bit of 'i' is 1, include nums[j]
                if ((i & (1 << j)) != 0) {
                    currentSubset.add(nums[j]);
                }
            }
            
            result.add(currentSubset);
        }

        return result;
    }
}