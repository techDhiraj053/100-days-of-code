/*
56. Merge Intervals (Overflow Protection & In-Place Merging - Day 88)

This solution optimally merges intervals by first sorting them by their start 
times, and then iterating through them in a single pass O(N log N).

Senior Twist: Defensive Sorting & List Modification.
1. Many developers use `a[0] - b[0]` in their comparators. If 'b' is a large 
   negative number, this causes an Integer Overflow and corrupts the sort. We 
   use `Integer.compare()` to guarantee enterprise-grade mathematical safety.
2. Instead of tracking loose 'start' and 'end' variables, we push the first 
   interval into our results list immediately. During the loop, we simply fetch 
   a reference to the last interval in the list and update its 'end' value 
   in-place if an overlap is detected!
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Fast-fail guard clause
        if (intervals.length <= 1) {
            return intervals;
        }

        // Senior Twist 1: Prevent Integer Overflow bugs using Integer.compare
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Pre-allocate memory for the worst-case scenario (no overlaps)
        List<int[]> result = new ArrayList<>(intervals.length);
        
        // Add the first interval to start our tracking process
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            
            // Get a reference to the last interval we added to our result list
            int[] lastAddedInterval = result.get(result.size() - 1);

            // If they overlap, update the end of the last added interval directly!
            if (currentInterval[0] <= lastAddedInterval[1]) {
                lastAddedInterval[1] = Math.max(lastAddedInterval[1], currentInterval[1]);
            } else {
                // No overlap, add the new distinct interval to the list
                result.add(currentInterval);
            }
        }

        // Convert the dynamic list back into a 2D array
        return result.toArray(new int[result.size()][]);
    }
}