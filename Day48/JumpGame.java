/*
55. Jump Game (Early Exit Optimization - Day 48)

This solution utilizes a highly optimal Greedy approach. By continuously 
tracking the maximum reachable index (maxReach), we can solve the problem 
in O(N) time and O(1) space without needing complex Dynamic Programming. 
To make the code enterprise-ready, an "Early Exit" guard is added to 
immediately return true the moment the end of the array becomes reachable, 
drastically improving performance on large datasets.
*/

class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int finalIndex = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond our maximum reach, we are stuck!
            if (i > maxReach) {
                return false;
            }
            
            // Update the furthest index we can possibly reach from here
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // Senior Twist: Early Exit Optimization
            // If our reach already meets or exceeds the final index, stop calculating!
            if (maxReach >= finalIndex) {
                return true;
            }
        }
        
        return true;
    }
}