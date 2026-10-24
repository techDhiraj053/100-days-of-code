/*
33. Search in Rotated Sorted Array (Virtual Infinity Binary Search - DAY 204)

This solution finds the target index in a rotated sorted array.
Time Complexity: O(log N) using a single-pass binary search.
Space Complexity: O(1).

Senior Twist: The Virtual Infinity Mask.
Instead of writing complex nested conditionals to find which half is sorted, 
we check if `nums[mid]` and `target` are on the same side of the array's starting 
number `nums[0]`. If they are on opposite sides, we mask `nums[mid]` with 
infinity or negative infinity to trick the standard binary search logic into 
moving the pointers toward the correct half of the rotation.
*/
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Check if both mid and target are on the same side of the rotation pivot
            boolean amIOnTargetSide = (nums[mid] >= nums[0]) == (target >= nums[0]);
            
            int comparator;
            if (amIOnTargetSide) {
                // If they are on the same side, use the actual array value
                comparator = nums[mid];
            } else {
                // Mask with infinity to force the binary search in the correct direction
                comparator = (target >= nums[0]) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            // Standard binary search logic using the masked comparator
            if (comparator == target) {
                return mid;
            }
            
            if (comparator < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
}