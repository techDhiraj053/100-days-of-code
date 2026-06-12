/*
228. Summary Ranges (Memory Pre-allocation - Day 87)

This solution optimally traverses the array in O(N) time. The use of a (long) 
cast inside the while loop perfectly prevents integer overflow errors when 
dealing with Integer.MAX_VALUE constraints.

Senior Twist: Worst-Case Memory Pre-allocation.
In the absolute worst-case scenario (where no numbers are consecutive), the 
output list will contain exactly `nums.length` elements. By passing this exact 
capacity into the ArrayList constructor, we completely eliminate the overhead 
of dynamic array resizing and memory reallocation!
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        // Fast-fail guard clause for empty arrays
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        // Senior Twist: Pre-allocate for the worst-case scenario
        List<String> result = new ArrayList<>(nums.length);

        int n = nums.length;
        int i = 0;

        while (i < n) {
            int start = nums[i];

            // Extend the interval safely! 
            // The (long) cast prevents overflow if nums[i] is Integer.MAX_VALUE
            while (i + 1 < n && (long) nums[i + 1] - nums[i] == 1) {
                i++;
            }

            int end = nums[i];

            if (start == end) {
                result.add(String.valueOf(start));
            } else {
                // Java compilers automatically optimize this with invokedynamic/StringBuilder
                result.add(start + "->" + end); 
            }

            i++;
        }

        return result;
    }
}