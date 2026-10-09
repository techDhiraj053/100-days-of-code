/*
188. Best Time to Buy and Sell Stock IV (Algorithmic Routing - DAY 191!)

This solution dynamically routes to the most efficient algorithm based on constraints.
Time Complexity: O(N) if k >= N/2, otherwise O(N * K).
Space Complexity: O(1) if k >= N/2, otherwise O(K).

Senior Twist: Separation of Concerns & Strategy Routing.
Instead of building a massive monolithic function, we separate the logic into 
distinct, pure helper methods. The main function acts as a Router. 
If `k` is massively large (effectively unlimited), we route to the Greedy algorithm, 
saving massive CPU cycles. If `k` is constrained, we route to our generalized 
Finite State Machine DP approach.
*/
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1 || k == 0) {
            return 0;
        }

        // Strategy Routing: If k is large enough to capture every single 
        // price increase, fall back to the O(N) greedy algorithm.
        if (k >= n / 2) {
            return calculateUnlimitedProfit(prices);
        }

        // Otherwise, use the O(N * K) State Machine DP algorithm
        return calculateKTransactionProfit(k, prices);
    }

    // Helper 1: O(N) Greedy Algorithm (Stock II Logic)
    private int calculateUnlimitedProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    // Helper 2: O(N * K) Finite State Machine DP
    private int calculateKTransactionProfit(int k, int[] prices) {
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        // Initialize buy states to the cost of the first day's stock
        for (int t = 1; t <= k; t++) {
            buy[t] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int t = 1; t <= k; t++) {
                // Buy uses capital from the previous transaction's sell
                buy[t] = Math.max(buy[t], sell[t - 1] - prices[i]);
                // Sell uses the asset from the current transaction's buy
                sell[t] = Math.max(sell[t], buy[t] + prices[i]);
            }
        }

        return sell[k];
    }
}