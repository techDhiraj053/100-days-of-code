/*
80. Remove Duplicates from Sorted Array II (Clean Code & Generalization - Day 43)

This solution utilizes an optimal Two-Pointer approach. Instead of keeping a manual 
tally of duplicate occurrences, it leverages the fact that the array is sorted. 
By comparing the current element being read to the element 'k' positions behind the 
write pointer (where k is the allowed frequency, in this case, 2), we gracefully 
filter out excess duplicates in O(N) time and O(1) space.
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        // Base case: If the array length is 2 or less, it's already valid
        if (nums.length <= 2) {
            return nums.length;
        }

        // The first two elements are always valid, so we start writing at index 2
        int insertIndex = 2;

        // Iterate through the array starting from the 3rd element
        for (int i = 2; i < nums.length; i++) {
            
            // If the current element is different from the element 2 spaces 
            // behind our write pointer, it means we haven't exceeded our pair limit!
            if (nums[i] != nums[insertIndex - 2]) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        
        return insertIndex;
    }
}