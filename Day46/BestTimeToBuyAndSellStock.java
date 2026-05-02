/*
121. Best Time to Buy and Sell Stock (Clean Code Review - Day 46)

This solution uses a highly optimal Greedy/Dynamic Programming approach.
By iterating through the array just once O(N) time and keeping track of the 
absolute lowest price seen so far, we can calculate the maximum potential 
profit at every subsequent step. An enhanced for-loop is used to maximize 
readability and eliminate unnecessary index lookups, while maintaining O(1) space.
*/

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        // Senior Twist: Enhanced for-loop since we only need the value
        for (int price : prices) {
            
            // Track the absolute lowest price we have seen so far
            minPrice = Math.min(minPrice, price);
            
            // Calculate potential profit if we sold at today's price
            int profit = price - minPrice;
            
            // Update maxProfit if today's profit breaks our previous record
            maxProfit = Math.max(maxProfit, profit);
        }
        
        return maxProfit;
    }
}