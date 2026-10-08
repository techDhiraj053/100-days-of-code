/*
123. Best Time to Buy and Sell Stock III (Finite State Machine - DAY 190!)

This solution finds the maximum profit with at most 2 transactions.
Time Complexity: O(N), Space Complexity: O(1).

Senior Twist: Domain-Driven FSM & Zero-Sum Safety.
Instead of using two O(N) arrays, we model this as a 4-state Finite State Machine. 
By tracking the "Account Balance" at each step, `secondBuyBalance` naturally 
reinvests the profit made from `firstSellProfit`.
We evaluate all 4 states in sequential order. Buying and selling on the 
exact same day cancels out to a net zero change (-price + price = 0), which 
safely evaluates without corrupting the historical maximums, allowing us 
to use a completely branchless loop!
*/
class Solution {
    public int maxProfit(int[] prices) {
        // Initializing buys to MIN_VALUE because buying is a debt (negative balance)
        int firstBuyBalance = Integer.MIN_VALUE;
        int firstSellProfit = 0;
        
        int secondBuyBalance = Integer.MIN_VALUE;
        int totalFinalProfit = 0;

        for (int currentPrice : prices) {
            // State 1: Maximize balance after buying the first stock (costs money)
            firstBuyBalance = Math.max(firstBuyBalance, -currentPrice);
            
            // State 2: Maximize profit after selling the first stock
            firstSellProfit = Math.max(firstSellProfit, firstBuyBalance + currentPrice);
            
            // State 3: Maximize balance after reinvesting first profit into second stock
            secondBuyBalance = Math.max(secondBuyBalance, firstSellProfit - currentPrice);
            
            // State 4: Maximize final profit after selling the second stock
            totalFinalProfit = Math.max(totalFinalProfit, secondBuyBalance + currentPrice);
        }

        return totalFinalProfit;
    }
}