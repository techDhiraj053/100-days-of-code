/*
2615. Sum of Distances (Space-Optimized Prefix Sum - Day 37)

This solution utilizes an optimal O(N) approach by grouping identical elements.
Instead of building a full prefix-sum array for every group (which creates 
unnecessary Garbage Collection overhead), this solution uses a "Running Sum" 
technique. By maintaining a 'leftSum' and 'rightSum' variable and shifting 
values as we iterate, we achieve the mathematical distance calculations 
while minimizing memory allocation.
*/

import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        
        // Step 1: Group indices by their actual values
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        // Step 2: Process each group using a Running Sum (Space Optimized)
        for (List<Integer> list : map.values()) {
            int size = list.size();
            
            // Calculate the initial rightSum (total sum of all indices in this group)
            long rightSum = 0;
            for (int idx : list) {
                rightSum += idx;
            }
            
            long leftSum = 0;
            
            for (int i = 0; i < size; i++) {
                int index = list.get(i);
                
                // As we process this index, remove it from the right side
                rightSum -= index;
                
                // Calculate distances mathematically
                // Left side: (current_index * elements_to_the_left) - sum_of_left_indices
                long left = (long) index * i - leftSum;
                
                // Right side: sum_of_right_indices - (current_index * elements_to_the_right)
                long right = rightSum - (long) index * (size - i - 1);
                
                ans[index] = left + right;
                
                // Add the current index to the left side for the next iteration
                leftSum += index;
            }
        }
        
        return ans;
    }
}