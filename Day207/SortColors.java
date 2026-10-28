/*
75. Sort Colors (Dutch National Flag Algorithm - DAY 207!)

This solution sorts an array of 0s, 1s, and 2s in-place.
Time Complexity: O(N) using a single pass.
Space Complexity: O(1) constant extra space.

Senior Twist: Single Responsibility Principle (SRP) Refactoring.
The core algorithm is Dijkstra's famous 3-pointer Dutch National Flag approach. 
To make the code enterprise-ready, the repetitive inline swapping logic is 
extracted into a private helper method. This declutters the main routing 
logic, allowing the state transitions inside the `while` loop to read cleanly 
and explicitly.
*/
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap 0 to the front and advance both pointers
                swap(nums, low, mid);
                low++;
                mid++;
            } 
            else if (nums[mid] == 1) {
                // 1 is in the correct middle region, just advance mid
                mid++;
            } 
            else {
                // Swap 2 to the back and shrink the high boundary
                // We do NOT advance mid here because the swapped element needs evaluation
                swap(nums, mid, high);
                high--;
            }
        }
    }

    // Helper method isolates the mutation logic for cleaner code
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}