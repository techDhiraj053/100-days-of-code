/*
190. Reverse Bits (Bitwise Manipulation - DAY 167!)

This solution reverses the bits of a 32-bit integer in strict O(1) time 
and O(1) space, using bit masking and logical shifts.

Senior Twist: Unsigned Shift & The Caching Follow-Up.
1. Unsigned Shift (>>>): Because Java lacks an unsigned integer type, using the 
   standard right shift (>>) on a negative number would carry the sign bit (1). 
   Using the logical shift (>>>) forces 0s to fill in from the left.
2. The Follow-Up: If called millions of times, we would optimize this by splitting 
   the 32-bit integer into four 8-bit bytes. We can precompute the reverse of all 
   256 possible bytes into a cache array, reducing the work from 32 loop iterations 
   to just 4 fast array lookups and bitwise ORs!
*/
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            // Shift result left to make room, then insert the LSB of n
            result = (result << 1) | (n & 1);
            
            // Logical right shift n by 1 (pads with 0s regardless of sign)
            n >>>= 1;
        }

        return result;
    }
}