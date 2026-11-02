/*
153. Find Minimum in Rotated Sorted Array (Early-Exit Binary Search - DAY 212!)

This solution finds the minimum element in a rotated sorted array.
Time Complexity: O(log N) using Binary Search.
Space Complexity: O(1).

Senior Twist: The Early-Exit & Overflow Safety.
The standard approach continuously halves the array until `left == right`. 
However, if at any point during the search `nums[left] < nums[right]`, 
we know definitively that the current search window is perfectly sorted 
(zero internal rotations). We can instantly halt the search and return 
`nums[left]`, skipping unnecessary logarithmic iterations. 
Coupled with the `>>> 1` unsigned bitwise shift, this code is enterprise-grade.
*/
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Loop runs as long as the search space has at least 2 elements
        while (left < right) {
            
            // SENIOR TWIST: Early Exit!
            // If the current sub-array is strictly increasing, it means it is 
            // perfectly sorted without any rotation. The minimum is simply the first element.
            if (nums[left] < nums[right]) {
                return nums[left];
            }

            // Unsigned bitwise shift for overflow-safe division by 2
            int mid = (left + right) >>> 1;

            if (nums[mid] > nums[right]) {
                // The anomaly (rotation pivot) must be in the right half
                left = mid + 1;
            } else {
                // The minimum is either at mid or in the left half
                right = mid;
            }
        }

        // When left == right, we have locked onto the minimum element
        return nums[left];
    }
}