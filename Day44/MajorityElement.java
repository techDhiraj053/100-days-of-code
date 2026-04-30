/*
169. Majority Element (Boyer-Moore Voting Algorithm - Day 44)

This solution utilizes the highly optimal Boyer-Moore Voting Algorithm to find 
the majority element. By keeping a running 'count' and changing the 'candidate' 
whenever the count hits zero, the true majority element is mathematically 
guaranteed to remain as the final candidate. This achieves the Follow-Up 
constraints of O(N) time complexity and O(1) space complexity.
*/

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        // Enhanced for-loop since we only need to read the values
        for (int num : nums) {
            
            // If our vote count drops to zero, elect a new candidate
            if (count == 0) {
                candidate = num;
            }
            
            // Ternary operator: if the current number is our candidate, add 1 vote. 
            // Otherwise, subtract 1 vote.
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}