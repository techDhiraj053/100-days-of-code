/*
50. Pow(x, n) (Binary Exponentiation - DAY 177!)

This solution calculates x^n in optimal O(log N) time and O(1) space, 
bypassing the TLE of a linear loop.

Senior Twist: Bitwise Arithmetic & Overflow Prevention.
1. Overflow Prevention: Negating Integer.MIN_VALUE (-2^31) results in an 
   overflow because the max positive 32-bit int is 2^31 - 1. Casting to `long` 
   first prevents this silent failure.
2. Bitwise Optimization: We replace the expensive modulo (`%`) and division (`/`) 
   operators with bitwise AND (`& 1`) and bitwise right shift (`>>= 1`). These 
   execute significantly faster at the CPU hardware level.
*/
class Solution {
    public double myPow(double x, int n) {
        long power = n;

        // Handle negative exponents gracefully
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double ans = 1.0;

        while (power > 0) {
            // Check if the current least significant bit is 1
            if ((power & 1) == 1) {
                ans *= x;
            }

            // Square the base for the next bit position
            x *= x;
            
            // Shift the bits right by 1 (equivalent to integer division by 2)
            power >>= 1;
        }

        return ans;
    }
}