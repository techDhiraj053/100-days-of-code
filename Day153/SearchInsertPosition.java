/*
35. Search Insert Position (Binary Search - DAY 153!)

This solution finds the target or its valid insertion point 
in O(log N) time complexity and O(1) space complexity.

Senior Twist: Semantic Boundaries & Loop Invariant Documentation.
By explicitly naming the pointers `lowerBound` and `upperBound`, the 
binary search logic becomes self-documenting. Returning `lowerBound` 
at the end leverages the loop invariant: upon termination, `lowerBound` 
always points to the smallest index where nums[index] > target, which 
is exactly the correct insertion position.
*/
class Solution {
    public int searchInsert(int[] nums, int target) {
        int lowerBound = 0;
        int upperBound = nums.length - 1;

        while (lowerBound <= upperBound) {
            // Overflow-safe midpoint calculation
            int midIndex = lowerBound + (upperBound - lowerBound) / 2;
            int midValue = nums[midIndex];

            if (midValue == target) {
                return midIndex; // Target found
            } else if (midValue < target) {
                // Target must be in the right half
                lowerBound = midIndex + 1;
            } else {
                // Target must be in the left half
                upperBound = midIndex - 1;
            }
        }

        // Target not found. 
        // upperBound crossed lowerBound. lowerBound now represents the exact insertion index.
        return lowerBound;
    }
}