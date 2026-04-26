/*
88. Merge Sorted Array (Clean Code Review - Day 40)

This solution utilizes the optimal "Reverse Three-Pointer" pattern. 
By starting from the end of both arrays and working backwards, we safely 
merge the elements in-place within nums1 without needing to allocate an 
auxiliary array. This achieves an optimal O(m+n) time complexity and 
O(1) space complexity. Variable names are optimized for readability.
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // p1 tracks the last valid, unmerged element in nums1
        int p1 = m - 1;
        // p2 tracks the last unmerged element in nums2
        int p2 = n - 1;
        // pMerge tracks the placement index at the very end of nums1
        int pMerge = m + n - 1;

        // We only need to loop while there are still elements in nums2 to merge.
        // If p2 runs out first, the remaining elements in nums1 are already sorted!
        while (p2 >= 0) {
            // If nums1 still has elements, and the current nums1 element is larger
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[pMerge] = nums1[p1];
                p1--;
            } else {
                // Otherwise, nums2's element is larger (or equal), so place it
                nums1[pMerge] = nums2[p2];
                p2--;
            }
            // Decrement the placement pointer
            pMerge--;
        }
    }
}