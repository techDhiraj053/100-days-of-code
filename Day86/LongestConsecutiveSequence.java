/*
128. Longest Consecutive Sequence (Mathematical Pruning Optimization - Day 86)

This solution achieves the requested O(N) time complexity by using a HashSet 
for O(1) lookups and strictly checking for the "start" of a sequence before 
triggering the inner while loop (Amortized O(N)).

Senior Twist: Memory Pre-allocation & Mathematical Pruning.
1. We initialize the HashSet with `nums.length` capacity to prevent expensive 
   rehashing operations under the hood.
2. We implement Early Pruning: If our current longest sequence exceeds half 
   the total length of the array, it is mathematically impossible for any 
   other undiscovered sequence to be longer. We can safely break the loop early!
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        // Fast-fail guard clause for empty arrays
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Pre-allocate the exact required capacity
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        int n = nums.length;

        for (int num : set) {
            // Only start building if this number is the absolute start of a sequence
            if (!set.contains(num - 1)) {
                int length = 1;

                // Continuously check for the next consecutive number
                while (set.contains(num + length)) {
                    length++;
                }

                longest = Math.max(longest, length);

                // Senior Twist: Early Mathematical Pruning!
                // If the sequence is longer than half the array, we've won.
                if (longest > n / 2) {
                    break;
                }
            }
        }

        return longest;
    }
}