/*
122. Best Time to Buy and Sell Stock II (Branchless Code Review - Day 47)

This solution utilizes a highly optimal Greedy approach. 
Instead of tracking complex local peaks and valleys, we simply accumulate 
the profit from every single consecutive upward price movement. 
To make the code enterprise-ready, the standard 'if' conditional is 
replaced with 'Math.max()'. This "Branchless Programming" technique 
reduces Cyclomatic Complexity while maintaining O(N) time and O(1) space.
*/

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            // Senior Twist: Branchless addition. 
            // If the price dropped, the difference is negative, so we add 0.
            // If the price rose, we add the positive difference to our total profit.
            maxProfit += Math.max(0, prices[i] - prices[i - 1]);
        }
        
        return maxProfit;
    }
}