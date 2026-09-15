/*
137. Single Number II (Bitwise State Machine - DAY 170!)

This solution finds the single unique number in an array where every other 
number appears exactly three times. Time Complexity: O(N), Space: O(1).

Senior Twist: Modulo 3 Bitwise Counters.
We use two variables, `ones` and `twos`, to track the frequency of each bit.
1. `ones = (ones ^ num) & ~twos;` 
   -> Add the bit to `ones` if it's not already in `twos`.
2. `twos = (twos ^ num) & ~ones;` 
   -> Add the bit to `twos` if it's not already in `ones`.
When a bit appears for the third time, it gets cleared from both, perfectly 
isolating the number that only appears once!
*/
class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (int num : nums) {
            // Add to 'ones' only if it is NOT in 'twos'
            ones = (ones ^ num) & ~twos;
            
            // Add to 'twos' only if it is NOT in 'ones'
            twos = (twos ^ num) & ~ones;
        }

        // The single number will have its bits stored in 'ones'
        return ones;
    }
}