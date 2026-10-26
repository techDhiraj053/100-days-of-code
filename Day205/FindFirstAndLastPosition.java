/*
34. Find First and Last Position of Element in Sorted Array (DAY 205)

This solution finds the starting and ending positions of a target value.
Time Complexity: O(log N) - Runs two independent binary searches.
Space Complexity: O(1).

Senior Twist: The DRY Principle (Don't Repeat Yourself).
Instead of writing two almost identical binary search functions (`findFirst` 
and `findLast`), we combine them into a single, modular helper function: `findBound`.
By passing a boolean flag `isFirst`, we dictate which direction the search 
should collapse when a target match is found. This cuts the code size in half 
and demonstrates highly professional, maintainable engineering standards.
(Also using the bitwise shift `>>> 1` for overflow-safe mid calculation!)
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Find the lower bound (first occurrence)
        int first = findBound(nums, target, true);
        
        // Optimization: If the first occurrence isn't found, the last won't be either
        if (first == -1) {
            return new int[]{-1, -1};
        }
        
        // Find the upper bound (last occurrence)
        int last = findBound(nums, target, false);

        return new int[]{first, last};
    }

    // Single modular binary search function
    private int findBound(int[] nums, int target, boolean isFirst) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            // Unsigned bitwise shift for overflow-safe division by 2
            int mid = (low + high) >>> 1;

            if (nums[mid] == target) {
                ans = mid; // Record the potential answer
                
                // If looking for the first occurrence, squeeze the right bound
                if (isFirst) {
                    high = mid - 1;
                } 
                // If looking for the last occurrence, squeeze the left bound
                else {
                    low = mid + 1;
                }
            } 
            else if (nums[mid] < target) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        return ans;
    }
}