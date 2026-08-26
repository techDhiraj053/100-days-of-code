/*
918. Maximum Sum Circular Subarray (Kadane's Duality - DAY 152!)

This solution finds the maximum circular subarray sum in O(N) time 
and O(1) space by calculating both the maximum and minimum contiguous subarrays.

Senior Twist: Mathematical Duality & State Tracking.
We leverage the principle of duality: a maximum subarray that wraps around 
the ends is mathematically equivalent to the total sum of the array minus 
the minimum contiguous subarray in the middle. By tracking both states 
simultaneously in a single pass, we achieve optimal performance.
*/
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalArraySum = 0;
        
        int currentMaxWindow = 0;
        int globalMaxSum = Integer.MIN_VALUE;
        
        int currentMinWindow = 0;
        int globalMinSum = Integer.MAX_VALUE;

        for (int num : nums) {
            // Track the maximum contiguous subarray (Standard Kadane)
            currentMaxWindow = Math.max(num, currentMaxWindow + num);
            globalMaxSum = Math.max(globalMaxSum, currentMaxWindow);

            // Track the minimum contiguous subarray (Inverted Kadane)
            currentMinWindow = Math.min(num, currentMinWindow + num);
            globalMinSum = Math.min(globalMinSum, currentMinWindow);

            totalArraySum += num;
        }

        // Edge Case: If all numbers are negative, globalMaxSum is the least negative number.
        // In this scenario, totalArraySum - globalMinSum would equal 0 (an empty array), 
        // which violates the rule that the subarray must be non-empty.
        if (globalMaxSum < 0) {
            return globalMaxSum;
        }

        // The result is the maximum of the standard max or the wrap-around max
        return Math.max(globalMaxSum, totalArraySum - globalMinSum);
    }
}