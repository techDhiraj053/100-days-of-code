/*
167. Two Sum II - Input Array Is Sorted (Defensive Programming - Day 66)

This solution utilizes an optimal Two-Pointer approach. By leveraging the 
fact that the array is already sorted, we can safely navigate inward from 
both ends. If the sum is too large, we decrease our maximum bound (right--). 
If the sum is too small, we increase our minimum bound (left++). This achieves 
O(N) time complexity and strict O(1) space complexity.

Senior Twist: Contract Enforcement. The problem guarantees exactly one valid 
solution. If the while loop completes without returning, the input data violated 
the contract. We throw an IllegalArgumentException to fail-fast and alert the 
system, rather than quietly returning an empty array.
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // The problem requires a 1-indexed result
                return new int[]{left + 1, right + 1};
            }
            
            if (sum > target) {
                // The sum is too big, we need a smaller number
                right--;
            } else {
                // The sum is too small, we need a larger number
                left++;
            }
        }
        
        // Defensive Programming: Fail-fast if the input violated the guarantee
        throw new IllegalArgumentException("No two sum solution found for the provided input.");
    }
}