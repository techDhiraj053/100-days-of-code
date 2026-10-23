/*
4. Median of Two Sorted Arrays (Optimized Binary Search - DAY 203!)

This solution finds the median of two sorted arrays without merging them.
Time Complexity: O(log(min(M, N))).
Space Complexity: O(1).

Senior Twist: Bitwise Shift for Overflow Safety.
The core logic relies on partitioning the smaller array via binary search 
and mathematically deriving the partition for the larger array. 
To adhere to strict enterprise safety standards, we replace `/ 2` with the 
unsigned right bit-shift `>>> 1`. This prevents potential integer overflow 
when calculating the midpoint of massive arrays and executes slightly faster 
at the CPU level.
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary search on the smaller array to minimize the search space
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        
        int low = 0;
        int high = m;
        
        // Bitwise shift equivalent to (m + n + 1) / 2
        int halfLen = (m + n + 1) >>> 1; 

        while (low <= high) {
            // Partition in nums1 (Bitwise shift for safe division)
            int cut1 = (low + high) >>> 1;
            
            // Partition in nums2 (Corrected the syntax typo here)
            int cut2 = halfLen - cut1;

            // Handle edge cases where partitions fall out of array bounds
            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int right1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];

            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            // Valid partition found!
            if (left1 <= right2 && left2 <= right1) {
                // Odd total length: the median is simply the max of the left halves
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                // Even total length: the median is the average of the two middle elements
                int leftMax = Math.max(left1, left2);
                int rightMin = Math.min(right1, right2);
                return (leftMax + rightMin) / 2.0;
            }
            // We took too many elements from the right side of nums1, move left
            else if (left1 > right2) {
                high = cut1 - 1;
            }
            // We took too few elements from nums1, move right
            else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }
}