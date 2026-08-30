/*
33. Search in Rotated Sorted Array (Binary Search - DAY 156!)

This solution finds a target in a rotated sorted array in O(log n) time 
and O(1) space complexity.

Senior Twist: Semantic Variable Naming & Strict Boundary Checks.
The algorithm hinges on determining which half of the split is strictly sorted. 
The crucial detail is `nums[leftBound] <= midValue`. The `<=` is necessary 
because when the search space narrows down to 2 elements, `leftBound` and `midIndex` 
will point to the exact same element, which qualifies as a "sorted half" of size 1.
*/
class Solution {
    public int search(int[] nums, int target) {
        int leftBound = 0;
        int rightBound = nums.length - 1;

        while (leftBound <= rightBound) {
            int midIndex = leftBound + (rightBound - leftBound) / 2;
            int midValue = nums[midIndex];

            // Base case: Target acquired
            if (midValue == target) {
                return midIndex;
            }

            // Scenario A: The left half is perfectly sorted
            if (nums[leftBound] <= midValue) {
                
                // Is the target mathematically bounded within this sorted left half?
                if (nums[leftBound] <= target && target < midValue) {
                    rightBound = midIndex - 1;
                } else {
                    // It must be in the unsorted right half
                    leftBound = midIndex + 1;
                }
            } 
            // Scenario B: The right half is perfectly sorted
            else {
                
                // Is the target mathematically bounded within this sorted right half?
                if (midValue < target && target <= nums[rightBound]) {
                    leftBound = midIndex + 1;
                } else {
                    // It must be in the unsorted left half
                    rightBound = midIndex - 1;
                }
            }
        }

        return -1; // Target does not exist in the array
    }
}