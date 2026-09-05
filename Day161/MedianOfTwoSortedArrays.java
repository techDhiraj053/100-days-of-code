/*
4. Median of Two Sorted Arrays (Partition Binary Search - DAY 161!)

This solution finds the median of two sorted arrays in O(log(min(m, n))) time 
complexity and O(1) space complexity.

Senior Twist: Semantic Partition Tracking.
By renaming the variables to explicitly reflect the X and Y array partitions 
and their respective max/min boundary values, the complex mathematical 
cross-comparisons become entirely self-documenting.
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Guarantee that we always run the binary search on the smaller array 
        // to maintain O(log(min(m, n))) and prevent out-of-bounds indexing.
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int xLength = nums1.length;
        int yLength = nums2.length;
        int totalLeftHalfLength = (xLength + yLength + 1) / 2;

        int low = 0;
        int high = xLength;

        while (low <= high) {
            int partitionX = low + (high - low) / 2;
            int partitionY = totalLeftHalfLength - partitionX;

            // Handle edge cases using "Virtual Infinity" when partitions fall on the boundaries
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == xLength) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == yLength) ? Integer.MAX_VALUE : nums2[partitionY];

            // Have we found the perfect partition?
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                
                // If the combined length is odd, the median is just the max of the left halves
                if ((xLength + yLength) % 2 == 1) {
                    return Math.max(maxLeftX, maxLeftY);
                }
                
                // If the combined length is even, we average the two middle elements
                return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                
            } else if (maxLeftX > minRightY) {
                // We took too many elements from the right side of X. Shrink the boundary left.
                high = partitionX - 1;
            } else {
                // We took too few elements from the left side of X. Expand the boundary right.
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not properly sorted.");
    }
}