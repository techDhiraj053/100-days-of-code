/*
15. 3Sum (Early Exit Pruning - Day 68)

This solution builds upon the sorted Two-Pointer approach. By fixing one 
element (i) and using two pointers (left, right) for the remaining array, 
we reduce a brute-force O(N^3) problem down to a highly optimal O(N^2). 
Skipping duplicate values manually avoids the overhead of using a HashSet.

Senior Twist: Early Exit Pruning. Because the array is sorted, if our 
anchor number 'nums[i]' is ever greater than 0, it is mathematically 
impossible for the remaining numbers (which are even larger) to sum to 0. 
We can immediately break out of the loop and return our answer!
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        // Sorting is required to use the Two-Pointer technique
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            
            // Senior Twist: Early Exit Pruning
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate fixed elements to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    left++;
                    right--;

                    // Skip duplicate left values
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate right values
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    // Sum is too small, need a larger number
                    left++;
                } else {
                    // Sum is too large, need a smaller number
                    right--;
                }
            }
        }

        return ans;
    }
}