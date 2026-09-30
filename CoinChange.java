/*
322. Coin Change (Unbounded Knapsack DP - DAY 185!)

This solution finds the minimum number of coins needed to make a specific amount.
Time Complexity: O(amount * N), Space Complexity: O(amount).

Senior Twist: CPU Branch Prediction & Loop Inversion.
By filling the array with `amount + 1` instead of `Integer.MAX_VALUE`, we safely 
prevent integer overflow when doing `+ 1`. 
To optimize for the CPU, we invert the standard nested loop. By iterating over 
`coins` first, we can initialize the inner `amount` loop directly at `coin`. 
This completely eliminates the need for an `if (coin <= i)` bounds check, 
creating a branchless inner loop that executes much faster at the silicon level.
*/
import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // amount + 1 acts as our "Infinity" without risking integer overflow
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // Outer loop: iterate through each available coin
        for (int coin : coins) {
            // Inner loop: branchless iteration starting directly at the coin's value
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // If the value is still > amount, the combination was impossible
        return dp[amount] > amount ? -1 : dp[amount];
    }
}