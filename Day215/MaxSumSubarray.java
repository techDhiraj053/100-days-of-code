/*
Max Sum Subarray of Size K (Fixed Sliding Window - DAY 215!)

Time Complexity: O(N) strictly single pass.
Space Complexity: O(1).

Senior Twist: Pointer Minimization.
Instead of manually maintaining 'low' and 'high' pointers with multiple 
while loops, we use a streamlined single loop. After building the initial 
window of size K, we simply slide it by adding the new element `arr[i]` 
and subtracting the element that fell out of the window `arr[i - k]`.
*/
class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int maxSum = 0;
        int currentSum = 0;
        
        // Build the first window of size K
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        maxSum = currentSum;
        
        // Slide the window across the rest of the array
        for (int i = k; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - k]; // Add new element, remove old element
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}