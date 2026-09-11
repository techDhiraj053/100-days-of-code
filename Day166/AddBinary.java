/*
67. Add Binary (Simulated Full Adder - DAY 166!)

This solution computes the sum of arbitrarily large binary strings in O(max(N, M)) time 
and O(max(N, M)) space without risking integer overflow.

Senior Twist: StringBuilder Pre-allocation.
By calculating the maximum possible length of the resulting binary string 
(max length of A or B, plus 1 for a potential carry), we initialize the 
StringBuilder with the exact capacity needed. This prevents the underlying 
char[] from dynamically resizing multiple times during the loop, saving memory 
allocations and CPU cycles.
*/
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        // Pre-allocate the exact memory capacity needed
        int maxLength = Math.max(a.length(), b.length()) + 1;
        StringBuilder result = new StringBuilder(maxLength);

        while (i >= 0 || j >= 0 || carry > 0) {
            int currentSum = carry;

            if (i >= 0) {
                // Subtracting '0' (ASCII 48) converts the char to its integer value
                currentSum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                currentSum += b.charAt(j) - '0';
                j--;
            }

            // Append the bit (currentSum % 2)
            result.append(currentSum % 2);
            
            // Carry over the remainder (currentSum / 2)
            carry = currentSum / 2;
        }

        // Reverse the appended string to get the correct endianness
        return result.reverse().toString();
    }
}