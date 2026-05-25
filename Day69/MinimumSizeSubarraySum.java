/*
209. Minimum Size Subarray Sum (O(N log N) Follow-Up - Day 69)

The original Sliding Window approach perfectly achieves the optimal 
O(N) time complexity and O(1) space complexity.

Senior Twist: Conquering the Interview Follow-up.
Interviewers will sometimes intentionally ask for a "worse" O(N log N) 
solution to test your algorithmic breadth. Because the array only contains 
positive integers, a Prefix Sum array will be strictly increasing (sorted). 
This means we can iterate through the prefix sums and use Binary Search 
to find the exact ending index where the required target sum is met!
*/

import java.util.Arrays;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        
        // Step 1: Create a prefix sum array. 
        // Size is n + 1 to handle subarrays starting from index 0 cleanly.
        int[] prefixSums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }
        
        // Step 2: Iterate through each starting point
        for (int i = 0; i < n; i++) {
            // This is the exact sum we need to find in the prefix array
            int requiredSum = target + prefixSums[i];
            
            // Step 3: Binary search for the required sum
            // Arrays.binarySearch returns (-(insertion point) - 1) if the exact match isn't found
            int bound = Arrays.binarySearch(prefixSums, requiredSum);
            
            if (bound < 0) {
                bound = -bound - 1; // Convert back to the actual insertion point index
            }
            
            // If the bound is within our array limits, we found a valid subarray!
            if (bound <= n) {
                minLen = Math.min(minLen, bound - i);
            }
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}