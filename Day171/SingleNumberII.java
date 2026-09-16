/*
137. Single Number II (32-Bit Accumulator - DAY 171!)

This solution finds the single unique number in an array where all other 
elements appear exactly 'k' times. 
Time Complexity: O(N) — technically O(32 * N). Space Complexity: O(1).

Senior Twist: Extensible Parameterization.
Instead of hardcoding a modulo 3, we abstract the occurrence frequency into 
a `k` parameter. This transforms the method from a highly specific LeetCode 
answer into a generalized, production-ready utility function that can solve 
any variation of this problem instantly.
*/
class Solution {
    public int singleNumber(int[] nums) {
        return findUniqueWithFrequency(nums, 3);
    }

    private int findUniqueWithFrequency(int[] nums, int duplicateFrequency) {
        int uniqueNumber = 0;

        // Iterate through all 32 bits of a standard Java integer
        for (int bitIndex = 0; bitIndex < 32; bitIndex++) {
            int bitCount = 0;

            // Count how many numbers have a '1' at the current bit position
            for (int num : nums) {
                if ((num & (1 << bitIndex)) != 0) {
                    bitCount++;
                }
            }

            // If the count is not a clean multiple of the frequency, 
            // this bit MUST belong to our unique number.
            if (bitCount % duplicateFrequency != 0) {
                uniqueNumber |= (1 << bitIndex);
            }
        }

        return uniqueNumber;
    }
}/*
137. Single Number II (32-Bit Accumulator - DAY 171!)

This solution finds the single unique number in an array where all other 
elements appear exactly 'k' times. 
Time Complexity: O(N) — technically O(32 * N). Space Complexity: O(1).

Senior Twist: Extensible Parameterization.
Instead of hardcoding a modulo 3, we abstract the occurrence frequency into 
a `k` parameter. This transforms the method from a highly specific LeetCode 
answer into a generalized, production-ready utility function that can solve 
any variation of this problem instantly.
*/
class Solution {
    public int singleNumber(int[] nums) {
        return findUniqueWithFrequency(nums, 3);
    }

    private int findUniqueWithFrequency(int[] nums, int duplicateFrequency) {
        int uniqueNumber = 0;

        // Iterate through all 32 bits of a standard Java integer
        for (int bitIndex = 0; bitIndex < 32; bitIndex++) {
            int bitCount = 0;

            // Count how many numbers have a '1' at the current bit position
            for (int num : nums) {
                if ((num & (1 << bitIndex)) != 0) {
                    bitCount++;
                }
            }

            // If the count is not a clean multiple of the frequency, 
            // this bit MUST belong to our unique number.
            if (bitCount % duplicateFrequency != 0) {
                uniqueNumber |= (1 << bitIndex);
            }
        }

        return uniqueNumber;
    }
}