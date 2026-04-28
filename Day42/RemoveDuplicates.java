/*
26. Remove Duplicates from Sorted Array (Clean Code Review - Day 42)

This solution utilizes an optimal Two-Pointer (Reader/Writer) approach. 
Because the array is sorted, duplicates are adjacent. The 'reader' pointer (i) 
scans the array, while the 'insertIndex' pointer tracks where the next unique 
element should be placed. This allows the array to be modified in-place, 
achieving O(N) time complexity and O(1) space complexity.
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        // The first element is always strictly unique, so we start writing at index 1
        int insertIndex = 1; 

        // The 'i' pointer acts as our fast reader, scanning the array
        for (int i = 1; i < nums.length; i++) {
            
            // If the current element is different from the one right behind it, it's unique!
            if (nums[i] != nums[i - 1]) {
                nums[insertIndex] = nums[i]; // Write the unique element to our slow pointer
                insertIndex++;               // Move the slow pointer forward
            }
        }
        
        // The insertIndex naturally represents the total count of unique elements
        return insertIndex;
    }
}