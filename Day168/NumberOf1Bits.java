/*
191. Number of 1 Bits (Brian Kernighan's Algorithm - DAY 168!)

This solution counts the number of set bits (Hamming weight) in O(k) time, 
where k is the number of 1s in the binary representation.

Senior Twist: Brian Kernighan & The Caching Follow-Up.
1. The Logic: `n & (n - 1)` mathematically drops the lowest set bit (the rightmost 1). 
   This means the loop only executes exactly as many times as there are 1s, bypassing 
   the need to iterate through all 32 bits.
2. The Follow-Up: If this is called millions of times, we would use a precomputed 
   Lookup Table. We can create an array of size 256 that stores the exact number 
   of 1 bits for every possible 8-bit byte. We then split the 32-bit integer into 4 
   bytes and sum their precomputed weights using 4 instant array lookups.
*/
class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        // Loop continues only as long as there are 1s left in the number
        while (n != 0) {
            // Brian Kernighan's trick: flip the lowest set bit to 0
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}