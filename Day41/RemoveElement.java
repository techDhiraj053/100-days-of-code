/*
27. Remove Element (Day 41)

This solution utilizes an optimal Two-Pointer (Reader/Writer) approach. 
The pointer 'i' reads through the array, while the pointer 'k' keeps track 
of the placement index for valid elements. This allows the array to be 
modified in-place, achieving O(N) time complexity and O(1) space complexity.
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}