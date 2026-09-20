/*
172. Factorial Trailing Zeroes (Prime Factorization Math - DAY 175!)

This solution counts the trailing zeroes of n! in strictly O(log_5(N)) time 
and O(1) space, avoiding the impossible task of computing the actual factorial.

Senior Twist: Mathematical Documentation.
Trailing zeroes are created by multiplying 10. The prime factors of 10 are 2 and 5.
In any factorial expansion, there are always vastly more 2s than 5s. Therefore, 
the number of 5s is the bottleneck that determines the number of trailing zeroes.
By continuously dividing by 5, we efficiently count all multiples of 5, then the 
extra 5s in multiples of 25, 125, etc. (Legendre's Formula).
*/
class Solution {
    public int trailingZeroes(int n) {
        int zeroCount = 0;

        // Count the number of 5s in the prime factorization of n!
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }

        return zeroCount;
    }
}