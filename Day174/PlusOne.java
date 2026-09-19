/*
66. Plus One (Array Carry Propagation - DAY 174!)

This solution increments an array-represented integer in O(N) time and 
O(1) space (amortized), handling the 9-to-0 carry cascade perfectly.

Senior Twist: Short-Circuiting & JVM Memory Allocation.
1. Short-Circuiting: The moment we find a digit less than 9, we increment 
   and return immediately. For 90% of inputs, this algorithm runs in O(1) time!
2. JVM Defaults: If we exit the loop, we had a number like [9,9,9]. 
   Creating `new int[digits.length + 1]` in Java automatically fills it 
   with zeros. We only need to set `result[0] = 1` to get [1,0,0,0], 
   skipping a completely unnecessary array copy loop.
*/
class Solution {
    public int[] plusOne(int[] digits) {
        
        // Traverse from least significant digit to most significant
        for (int i = digits.length - 1; i >= 0; i--) {
            
            if (digits[i] < 9) {
                digits[i]++;
                // Short-circuit: no further carry needed, exit immediately
                return digits; 
            }
            
            // Digit is 9, so it becomes 0. 
            // The carry naturally propagates to the next loop iteration.
            digits[i] = 0;
        }

        // We only reach here if every single digit was a 9 (e.g., 999 -> 000).
        // Java initializes arrays with 0s, so we just set the leading digit to 1.
        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}