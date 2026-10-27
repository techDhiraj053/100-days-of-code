/*
35. Search Insert Position (DAY 206)

This solution finds the target or its insertion index in a sorted array.
Time Complexity: O(log N) using Binary Search.
Space Complexity: O(1).

Senior Twist: Loop Invariant & Bitwise Shift.
We use `(left + right) >>> 1` for an overflow-safe midpoint calculation. 
The true beauty of this algorithm lies in the Loop Invariant: when the 
`while (left <= right)` loop terminates, the pointers have crossed (`left > right`). 
At this exact moment, the `left` pointer mathematically represents the total 
number of elements in the array that are strictly less than the target. 
Therefore, `left` is perfectly equal to the exact 0-based index where the 
target should be inserted!
*/
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // Unsigned bitwise shift for overflow-safe division by 2
            int mid = (left + right) >>> 1;

            if (nums[mid] == target) {
                return mid; // Target found
            } 
            else if (nums[mid] < target) {
                left = mid + 1; // Target is in the right half
            } 
            else {
                right = mid - 1; // Target is in the left half
            }
        }

        // Loop invariant guarantees 'left' is the correct insertion index
        return left;
    }
}