/*
134. Gas Station (Greedy Optimization - Day 53)

This solution utilizes an optimal O(N) Greedy algorithm.
Instead of checking every possible starting point (which would take O(N^2) time), 
we rely on two mathematical properties:
1. If the total gas available across all stations is less than the total cost, 
   a complete circuit is impossible.
2. As we traverse, if our current tank drops below zero at station 'i', 
   it means NO station from our starting point up to 'i' could possibly be 
   the correct start. We confidently reset our tank and set the new starting 
   candidate to 'i + 1'.
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0;
        int currentTank = 0;
        int startingStation = 0;

        for (int i = 0; i < gas.length; i++) {
            // Calculate the net gas gained/lost at this specific station
            int netGas = gas[i] - cost[i];
            
            // Add to our global tracking to ensure a solution exists
            totalSurplus += netGas;
            
            // Add to our local tracking to check if our current starting point is valid
            currentTank += netGas;

            // If our tank runs dry, this starting point (and any before it) fails
            if (currentTank < 0) {
                startingStation = i + 1; // Try starting at the next station
                currentTank = 0;         // Reset the local tank
            }
        }

        // If the total surplus is negative, a full circuit is mathematically impossible
        return totalSurplus < 0 ? -1 : startingStation;
    }
}