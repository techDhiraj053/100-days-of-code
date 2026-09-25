/*
198. House Robber (Space-Optimized DP - DAY 180!)

This solution finds the maximum amount of money that can be robbed 
without triggering adjacent alarms.
Time Complexity: O(N), Space Complexity: O(1).

Senior Twist: Domain-Driven Semantics.
By refactoring the competitive programming variables (prev1, prev2) into 
domain-specific terms (maxLootOneHouseBack, maxLootTwoHousesBack), the 
core dynamic programming transition reads like a self-documenting business rule:
"The max loot at this house is the greater of either skipping it (keeping 
the loot from the previous house) OR robbing it (adding its money to the 
loot from two houses back)."
*/
class Solution {
    public int rob(int[] nums) {
        int maxLootTwoHousesBack = 0;
        int maxLootOneHouseBack = 0;

        for (int currentHouseMoney : nums) {
            // The core DP decision: Rob this house, or skip it?
            int currentMaxLoot = Math.max(
                maxLootOneHouseBack, 
                maxLootTwoHousesBack + currentHouseMoney
            );

            // Slide the window forward for the next iteration
            maxLootTwoHousesBack = maxLootOneHouseBack;
            maxLootOneHouseBack = currentMaxLoot;
        }

        return maxLootOneHouseBack;
    }
}