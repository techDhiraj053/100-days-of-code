/*
45. Jump Game II (Early Exit Optimization - Day 49)

This solution utilizes a highly optimal Greedy approach with "Jump Windows". 
Instead of checking every possible path (O(N^2) DP), we scan the array to find 
the farthest possible reach within our current jump radius. Once we hit the end 
of that radius, we are forced to jump. 

To make this enterprise-ready, an aggressive "Early Exit" guard is added. 
If we ever calculate a reach that touches or exceeds the final index, we instantly 
add 1 to our jump count and return, bypassing all remaining loop iterations!
*/

class Solution {
    public int jump(int[] nums) {
        // Base case: If the array has only 1 element, no jumps are needed
        if (nums.length <= 1) return 0;

        int jumps = 0;
        int farthestReach = 0;
        int currentJumpWindowEnd = 0;

        // We loop until the second-to-last element because jumping FROM the last element isn't needed
        for (int i = 0; i < nums.length - 1; i++) {
            
            // Constantly update the farthest we can reach from our current window
            farthestReach = Math.max(farthestReach, i + nums[i]);

            // Senior Twist: Early Exit Optimization
            // If our newly discovered reach can hit the end of the array, 
            // we just need ONE more jump to get there. Stop looping immediately!
            if (farthestReach >= nums.length - 1) {
                return jumps + 1;
            }

            // Once we reach the end of our current jump window, we must commit to a jump
            if (i == currentJumpWindowEnd) {
                jumps++;
                currentJumpWindowEnd = farthestReach;
            }
        }
        
        return jumps;
    }
}