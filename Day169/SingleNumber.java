/*
136. Single Number (Bitwise XOR Annihilation - DAY 169!)

This solution finds the single unique number in an array of duplicates 
using an optimal O(N) time complexity and strictly O(1) space complexity.

Senior Twist: Boolean Algebra Documentation.
This uses the XOR (^) operator, which acts as a binary toggle. 
Because XOR is both commutative and associative, the order of operations 
does not matter. We rely on two mathematical properties:
1. A ^ A = 0 (Identical numbers cancel each other out)
2. A ^ 0 = A (XORing with zero preserves the number)
Therefore, all pairs will annihilate into 0, leaving only the single number.
*/
class Solution {
    public int singleNumber(int[] nums) {
        int singleUnique = 0;

        for (int num : nums) {
            singleUnique ^= num;
        }

        return singleUnique;
    }
}