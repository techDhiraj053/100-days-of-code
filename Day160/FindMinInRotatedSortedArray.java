/*
153. Find Minimum in Rotated Sorted Array (Binary Search - DAY 160!)

This solution finds the absolute minimum in a rotated sorted array in O(log n) time 
and O(1) space complexity by comparing the midpoint strictly to the right boundary.

Senior Twist: Semantic Bounds and Predictable Discard Criteria.
Comparing `mid` to `rightBound` is the ultimate trick here. If `midValue` > `rightValue`, 
the array wraps around in the right half, meaning the minimum is strictly to the right. 
If `midValue` <= `rightValue`, the right half is sorted, meaning the minimum is either 
at `mid` or to its left. We do NOT use `rightBound = midIndex - 1` because `midIndex` 
itself might be the minimum element.
*/
class Solution {
    public int findMin(int[] nums) {
        int leftBound = 0;
        int rightBound = nums.length - 1;

        // The loop terminates when leftBound == rightBound, converging on the minimum.
        while (leftBound < rightBound) {
            int midIndex = leftBound + (rightBound - leftBound) / 2;

            if (nums[midIndex] > nums[rightBound]) {
                // The inflection point (cliff) is to the right.
                // The minimum is strictly greater than midIndex.
                leftBound = midIndex + 1;
            } else {
                // The right side of the array is perfectly sorted.
                // The minimum could be at midIndex, or to its left.
                rightBound = midIndex;
            }
        }

        // Both bounds have converged on the exact index of the minimum element.
        return nums[leftBound];
    }
}