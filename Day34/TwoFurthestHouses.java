/*
2078. Two Furthest Houses With Different Colors (Clean Code Bonus - Day 34)

This solution uses a highly optimal O(N) greedy approach. 
Instead of checking every pair O(N^2), it leverages the mathematical fact that 
the maximum distance MUST involve either the very first house or the very last house. 
Variable names are optimized for self-documenting readability.
*/

class Solution {
    public int maxDistance(int[] colors) {
        int firstHouse = 0;
        int lastHouse = colors.length - 1;
        int maxDist = 0;

        // Pass 1: Find the furthest house from the FIRST house
        for (int i = lastHouse; i >= 0; i--) {
            if (colors[i] != colors[firstHouse]) {
                maxDist = Math.max(maxDist, i); // Distance from 0 is just 'i'
                break; // Stop at the first mismatch since we started from the end
            }
        }

        // Pass 2: Find the furthest house from the LAST house
        for (int i = firstHouse; i <= lastHouse; i++) {
            if (colors[i] != colors[lastHouse]) {
                maxDist = Math.max(maxDist, lastHouse - i); 
                break; // Stop at the first mismatch since we started from the beginning
            }
        }

        return maxDist;
    }
}