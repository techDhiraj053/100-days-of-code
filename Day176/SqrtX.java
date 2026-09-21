/*
69. Sqrt(x) (Binary Search - DAY 176!)

This solution computes the integer square root in O(log x) time and O(1) space, 
bypassing built-in functions.

Senior Twist: Strict 32-bit Overflow Prevention.
While casting to `(long)` is the standard way to prevent `mid * mid` from 
overflowing, strict 32-bit environments prohibit 64-bit casts. We can prevent 
overflow entirely within 32 bits by using division instead of multiplication: 
testing if `mid <= x / mid` is mathematically identical to `mid * mid <= x`, 
but guarantees the value never exceeds `x`.
*/
class Solution {
    public int mySqrt(int x) {
        // Fast fail for 0 and 1
        if (x < 2) {
            return x;
        }

        int left = 1;
        // Optimization: The square root of x (for x >= 2) is always <= x / 2
        int right = x / 2;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Strict 32-bit safe check: mid <= x / mid 
            if (mid <= x / mid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}