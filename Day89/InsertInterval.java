/*
57. Insert Interval (Three-Phase Sweep & JVM Optimization - Day 89)

This solution achieves an optimal O(N) time complexity by avoiding sorting. 
Because the input array is already sorted, we can sweep through the array in 
three distinct phases: 
1. Add all intervals completely to the left of the new interval.
2. Dynamically merge all overlapping intervals into the new interval.
3. Add all remaining intervals to the right.

Senior Twist: Memory Allocation Optimization.
We initialize the ArrayList with `intervals.length + 1` to perfectly prevent 
dynamic resizing. Furthermore, when returning the final array, we use 
`result.toArray(new int[0][])`. Modern JVMs are highly optimized to allocate 
the exact memory needed when a 0-length array is passed, executing faster than 
manually sizing the array with `result.size()`.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Pre-allocate memory: worst case is no merges, meaning length + 1
        List<int[]> result = new ArrayList<>(intervals.length + 1);

        int i = 0;
        int n = intervals.length;

        // Phase 1: Add all intervals that come completely BEFORE the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Phase 2: Merge all overlapping intervals into the newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        // Add the fully merged interval
        result.add(newInterval);

        // Phase 3: Add all remaining intervals that come completely AFTER
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Senior Twist: Use a 0-length array for optimal JVM memory allocation
        return result.toArray(new int[0][]);
    }
}