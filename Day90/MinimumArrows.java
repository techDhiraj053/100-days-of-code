/*
452. Minimum Number of Arrows to Burst Balloons (Greedy Interval Scheduling - Day 90)

This solution utilizes the Greedy Choice Property to solve a classic variation 
of the Interval Scheduling Maximization Problem (ISMP). 

Senior Twist: Overflow Protection & Fast-Fail Guarding.
1. By using `Integer.compare(a[1], b[1])`, we safely sort the intervals by their 
   end coordinates, completely avoiding Integer Overflow bugs that occur with `a[1] - b[1]` 
   when dealing with maximum negative/positive constraints.
2. We add a fast-fail guard clause at the top. In enterprise software, handling 
   empty or null inputs instantly saves CPU cycles and prevents downstream 
   IndexOutOfBounds exceptions.
*/

import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        // Enterprise standard: Fast-fail guard clause for edge cases
        if (points == null || points.length == 0) {
            return 0;
        }

        // Sort by END coordinate safely to prevent Integer Overflow
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int arrowPos = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            // If the start of the next balloon is strictly strictly greater than 
            // our current arrow position, we MUST shoot a new arrow.
            if (points[i][0] > arrowPos) {
                arrows++;
                // Place the new arrow at the end of this new balloon
                arrowPos = points[i][1];
            }
        }
        
        return arrows;
    }
}