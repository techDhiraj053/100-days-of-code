/*
135. Candy (Loop Fusion Optimization - Day 54)

This solution utilizes the highly optimal Two-Pass Greedy approach to 
solve the problem in O(N) time and O(N) space. By traversing Left-to-Right, 
we satisfy the right-neighbor condition. By traversing Right-to-Left, 
we satisfy the left-neighbor condition using Math.max() to preserve the 
first pass's logic.

Senior Twist: Loop Fusion. Instead of running a 3rd separate pass to 
calculate the final sum, we accumulate the 'total' directly during the 
Right-to-Left pass. This eliminates an entire O(N) array iteration!
*/

import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        // Give every child at least 1 candy to start
        Arrays.fill(candies, 1);

        // Pass 1: Left-to-Right
        // Ensure children with a higher rating than their left neighbor get more candy
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Senior Twist: Loop Fusion
        // Start the total with the very last element, since our reverse loop won't cover it
        int total = candies[n - 1];

        // Pass 2: Right-to-Left + On-the-fly Summation
        // Ensure children with a higher rating than their right neighbor get more candy
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            
            // Add the finalized candy count to our running total immediately
            total += candies[i];
        }

        return total;
    }
}