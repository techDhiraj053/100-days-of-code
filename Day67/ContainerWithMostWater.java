/*
11. Container With Most Water (Bypass Pruning Optimization - Day 67)

This solution utilizes the highly optimal Two-Pointer approach. By starting 
at the maximum width and systematically moving the shorter boundary inward, 
we achieve O(N) time and O(1) space complexity.

Senior Twist: Bypass Pruning. Because moving inward decreases the container's 
width, any new line that is shorter than or equal to our previous line is 
mathematically guaranteed to hold less water. We use inner while loops to 
rapidly skip past these sub-optimal lines, drastically reducing the number 
of redundant area calculations.
*/

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate the height of the water level (bottlenecked by the shorter line)
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            
            // Update max area if we found a larger container
            maxArea = Math.max(maxArea, currentHeight * currentWidth);

            // Bypass Pruning: Rapidly move the pointers inward, skipping any lines 
            // that are shorter than or equal to our current water level
            if (height[left] < height[right]) {
                while (left < right && height[left] <= currentHeight) {
                    left++;
                }
            } else {
                while (left < right && height[right] <= currentHeight) {
                    right--;
                }
            }
        }

        return maxArea;
    }
}