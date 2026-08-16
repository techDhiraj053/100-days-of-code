/*
46. Permutations (In-Place Swapping - DAY 142!)

This solution generates all possible permutations of distinct integers 
in O(N * N!) time complexity.

Senior Twist: In-Place Swapping Architecture.
Instead of maintaining a separate `used` boolean array and dynamically 
adding/removing elements from a tracking list, we generate permutations 
by swapping elements within the original array itself. This eliminates 
extra O(N) space overhead and avoids heavy list mutations during traversal.
*/
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutationsResult = new ArrayList<>();
        explorePermutations(nums, 0, permutationsResult);
        return permutationsResult;
    }

    private void explorePermutations(int[] nums, int currentIndex, List<List<Integer>> result) {
        // Base case: all positions have been fixed
        if (currentIndex == nums.length) {
            List<Integer> currentPermutation = new ArrayList<>(nums.length);
            for (int num : nums) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }

        // Try placing each available number at the current index
        for (int i = currentIndex; i < nums.length; i++) {
            // 1. Choose: Swap the current index with i to lock it in place
            swap(nums, currentIndex, i);

            // 2. Explore: Recurse to fill the next position
            explorePermutations(nums, currentIndex + 1, result);

            // 3. Undo (Backtrack): Swap back to restore the original array state
            swap(nums, currentIndex, i);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}