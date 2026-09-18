/*
9. Palindrome Number (Half-Reversal Math - DAY 173!)

This solution checks if an integer is a palindrome without string conversion.
Time Complexity: O(log10(n)), Space Complexity: O(1).

Senior Twist: Half-Reversal to Prevent Overflow.
Reversing the entire integer risks hitting the 32-bit MAX_VALUE overflow limit. 
Instead, we only reverse the *second half* of the number. We know we've reached 
the middle when our `reversedHalf` becomes greater than or equal to the remaining `x`. 
This guarantees overflow safety and cuts our loop operations directly in half!
*/
class Solution {
    public boolean isPalindrome(int x) {
        
        // Fast-fail: Negative numbers are never palindromes.
        // Fast-fail: If a number ends in 0, it must start with 0 to be a palindrome.
        // Since no integer starts with 0 (except 0 itself), we can reject them.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        // Stop exactly at the middle of the integer
        while (x > reversedHalf) {
            int lastDigit = x % 10;
            reversedHalf = (reversedHalf * 10) + lastDigit;
            x /= 10;
        }

        // Even length numbers: x == reversedHalf (e.g., 1221 -> 12 == 12)
        // Odd length numbers: x == reversedHalf / 10 (e.g., 12321 -> 12 == 123 / 10)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}