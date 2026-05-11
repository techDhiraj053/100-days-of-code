/*
42. Trapping Rain Water (O(1) Two-Pointer Optimization - Day 55)

While the Dynamic Programming approach uses O(N) space to store prefix 
and suffix maximums, this solution utilizes the highly optimal Two-Pointer 
strategy to achieve O(1) auxiliary space. 

By placing pointers at both ends of the array and moving the pointer with 
the lower height inward, we are mathematically guaranteed that the trapped 
water depends solely on the current side's tracked maximum. This allows us 
to calculate the trapped water on the fly in a single O(N) pass.
*/

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            // Water is always bottlenecked by the smaller height
            if (height[left] < height[right]) {
                // If the current left block is taller than our tracked leftMax, update the max
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // Otherwise, it must be a valley! Fill it with water.
                    totalWater += leftMax - height[left];
                }
                left++; // Move the left pointer inward
            } else {
                // If the right block is smaller or equal, we process the right side
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // It's a valley on the right side! Fill it with water.
                    totalWater += rightMax - height[right];
                }
                right--; // Move the right pointer inward
            }
        }

        return totalWater;
    }
}