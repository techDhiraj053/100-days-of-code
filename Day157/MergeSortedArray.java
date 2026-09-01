/*
88. Merge Sorted Array (In-Place Reverse Merge - DAY 157!)

This solution merges two sorted arrays in O(m + n) time complexity 
and a perfectly optimal O(1) space complexity.

Senior Twist: Three-Pointer Reverse Merge.
Instead of creating a new array and copying elements (which costs O(m+n) space), 
we take advantage of the empty buffer space at the end of `nums1`. By starting 
our pointers at the back of both arrays and working backwards, we safely place 
the largest elements in their final sorted positions without overwriting any 
unmerged data in `nums1`.
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;         // Pointer for the actual data in nums1
        int p2 = n - 1;         // Pointer for nums2
        int pMerge = m + n - 1; // Pointer for the placement in nums1

        // Merge backwards starting from the absolute largest elements
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[pMerge] = nums1[p1];
                p1--;
            } else {
                nums1[pMerge] = nums2[p2];
                p2--;
            }
            pMerge--;
        }

        // If elements remain in nums2, copy them over.
        // (Note: If elements remain in nums1, we don't need a while loop 
        // because they are already sitting in their exact correct positions!)
        while (p2 >= 0) {
            nums1[pMerge] = nums2[p2];
            p2--;
            pMerge--;
        }
    }
}