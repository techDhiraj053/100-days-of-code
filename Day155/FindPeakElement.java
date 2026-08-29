/*
162. Find Peak Element (Gradient/Slope Binary Search - DAY 155!)

This solution finds a local peak in an unsorted array in O(log n) time 
and O(1) space complexity.

Senior Twist: Semantic Gradient Tracking.
This proves that Binary Search doesn't require a globally sorted array—it only 
requires a predictable discard criteria. By checking the local slope between `mid` 
and `mid + 1`, we can guarantee that moving in the direction of the upward slope 
will eventually lead us to a peak (since the out-of-bounds elements are -∞).
*/
class Solution {
    public int findPeakElement(int[] nums) {
        int leftBound = 0;
        int rightBound = nums.length - 1;

        // Loop invariant: leftBound and rightBound will eventually converge on a peak
        while (leftBound < rightBound) {
            int midIndex = leftBound + (rightBound - leftBound) / 2;

            if (nums[midIndex] < nums[midIndex + 1]) {
                // We are on an ascending slope. The peak MUST be to our right.
                // Since midIndex is strictly less than the next element, midIndex cannot be the peak.
                leftBound = midIndex + 1;
            } else {
                // We are on a descending slope. The peak is either AT midIndex or to the left.
                // We do not do `midIndex - 1` because midIndex itself might be the peak.
                rightBound = midIndex;
            }
        }

        // When leftBound == rightBound, they have converged on the peak element
        return leftBound;
    }
}