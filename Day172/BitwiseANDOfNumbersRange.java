/*
201. Bitwise AND of Numbers Range (Common Prefix - DAY 172!)

This solution finds the bitwise AND of all numbers in a range in O(1) time 
complexity (max 32 iterations) and O(1) space complexity, avoiding the TLE 
of a linear scan.

Senior Twist: Brian Kernighan's Callback!
While right-shifting to find the common prefix is highly readable, we can also 
deploy Brian Kernighan's algorithm (`n & (n - 1)`) which we mastered on Day 168. 
By continuously clearing the least significant bit of `right` until it is less 
than or equal to `left`, we instantly chop off the non-matching suffix. 
`right` naturally becomes the common prefix padded with zeros!
*/
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        
        // Brian Kernighan's trick: drop the lowest set bit of 'right'
        // until 'right' is no longer greater than 'left'.
        while (right > left) {
            right = right & (right - 1);
        }
        
        // Once right <= left, 'right' holds the common prefix padded with zeros.
        return right;
    }
}