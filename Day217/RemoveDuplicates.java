/*
26. Remove Duplicates from Sorted Array (Slow/Fast Pointers - DAY 218!)

This solution removes duplicates in-place from a sorted array.
Time Complexity: O(N) using a single pass.
Space Complexity: O(1) auxiliary space.

Senior Twist: Variable Minimization & Pointer Unification.
The "manager/employee" mental model is excellent. We refine it by 
realizing the `insertIndex` (manager) naturally tracks BOTH the placement 
position for the next unique element AND the total count of unique 
elements. By using a standard `for` loop for the fast pointer (employee), we 
eliminate all redundant tracking variables and reduce the logic to a 
perfectly minimal, highly readable 4-line core.
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        // 'insertIndex' acts as both the 'manager' and the final 'result' length
        int insertIndex = 1;
        
        // 'i' is the 'employee' scanning the array starting from index 1
        for (int i = 1; i < nums.length; i++) {
            
            // When the employee finds a completely new unique value
            if (nums[i] != nums[i - 1]) {
                
                // Manager records it at the current insertion spot and moves forward
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        
        // The insertIndex perfectly represents the number of unique elements
        return insertIndex;
    }
}