/*
Triplets with Smaller Sum (Combinatorial Two-Pointer - DAY 208!)

This solution counts unique triplets whose sum is strictly less than a target.
Time Complexity: O(N^2) using sorting and two pointers.
Space Complexity: O(1) auxiliary space (excluding sorting overhead).

Senior Twist: Combinatorial Fast-Forward.
The true genius of this solution is the line `count += right - left;`.
Because the array is sorted, if the sum of elements at `i`, `left`, and `right` 
is less than the target, then mathematically, replacing the `right` element 
with ANY element between `left` and `right` will also yield a valid sum.
Instead of running a costly nested loop to count these individually, we 
use combinatorics to instantly add the entire valid range in O(1) time!
*/
import java.util.Arrays;

class Solution {
    int countTriplets(int sum, int arr[]) {
        // Sort to enable the two-pointer approach
        Arrays.sort(arr);
        int count = 0;
        
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            
            while (left < right) {
                int currSum = arr[i] + arr[left] + arr[right];
                
                // If the sum is strictly less, all elements between left and right 
                // are also valid with 'left'. Count them all instantly!
                if (currSum < sum) {
                    count += (right - left);
                    left++;
                } 
                // If the sum is too large or equal, we need a smaller number
                else {
                    right--;
                }
            }
        }
        
        return count;
    }
}