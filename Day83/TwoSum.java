/*
1. Two Sum (Enterprise HashMap Optimization - Day 83)

This solution handles the classic Two Sum problem using the optimal single-pass 
HashMap approach, achieving O(N) time and O(N) space.

Senior Twist: Memory Pre-allocation & Defensive Programming.
1. We initialize the HashMap with `nums.length` capacity to completely 
   prevent dynamic array resizing and rehashing overhead.
2. The problem guarantees exactly one valid solution. If the loop exits 
   without finding one, the input contract was violated. We fail fast by 
   throwing an IllegalArgumentException instead of returning an empty array.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Pre-allocate the HashMap capacity to prevent rehashing overhead
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If we've seen the complement before, we found our pair!
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            // Otherwise, store the current number and its index
            map.put(nums[i], i);
        }
        
        // Defensive Programming: Fail fast if the guaranteed contract is broken
        throw new IllegalArgumentException("No two sum solution found for the provided input.");
    }
}