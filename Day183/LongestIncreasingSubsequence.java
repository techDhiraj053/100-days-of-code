/*
300. Longest Increasing Subsequence (Patience Sorting - DAY 183!)

This solution finds the length of the LIS in optimal O(N log N) time 
and O(N) space using Patience Sorting and Binary Search.

Senior Twist: Standard API Utilization.
While manually implementing binary search proves algorithmic knowledge, 
production enterprise code relies on standard library utilities. 
`Arrays.binarySearch(array, fromIndex, toIndex, key)` handles the search 
perfectly. If it doesn't find the exact key, it returns `-(insertionPoint) - 1`. 
We capture this, decode the insertion point, and update our tails array 
in just 3 lines of highly readable code.
*/
import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for (int num : nums) {
            // Enterprise Java: Use the built-in binary search
            int index = Arrays.binarySearch(tails, 0, size, num);
            
            // Agar exact number nahi mila, toh insertion point decode karo
            if (index < 0) {
                index = -(index + 1);
            }

            // Existing tail ko overwrite karo, ya append karo
            tails[index] = num;
            
            // Agar humne current size ke aage append kiya hai, toh size badha do
            if (index == size) {
                size++;
            }
        }

        return size;
    }
}