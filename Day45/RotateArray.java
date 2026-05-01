/*
189. Rotate Array (Triple Reverse & Guard Clauses - Day 45)

This solution uses the highly optimal "Triple Reverse" algorithm to 
rotate the array in-place, achieving O(N) time and O(1) space. 
To make it enterprise-ready, a fail-fast guard clause is added at 
the top to immediately return if no rotation is mathematically needed, 
saving valuable CPU cycles.
*/

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        
        // Senior Twist: Fail-fast guard clause.
        // If the array has 1 or fewer elements, or if k is exactly a 
        // multiple of the array length, the array doesn't visually change!
        if (n <= 1 || k == 0) {
            return;
        }

        // 1. Reverse the entire array
        reverse(nums, 0, n - 1);

        // 2. Reverse the first k elements
        reverse(nums, 0, k - 1);

        // 3. Reverse the remaining elements
        reverse(nums, k, n - 1);
    }
    
    // Helper method to reverse a specific portion of the array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            
            start++;
            end--;
        }
    }
}