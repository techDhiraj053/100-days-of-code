/*
215. Kth Largest Element in an Array (QuickSelect - DAY 162!)

While a Min-Heap solves this in O(N log k) time, this implementation uses 
QuickSelect to achieve an optimal average time complexity of O(N) and O(1) space.

Senior Twist: Randomized QuickSelect.
By partitioning the array around a randomly selected pivot, we find the exact 
sorted position of that pivot. We can mathematically deduce where the kth largest 
element must reside (index: length - k). We discard the irrelevant half of the 
array on every recursive step, converging on the answer in linear time.
*/
import java.util.Random;

class Solution {
    private final Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        // The kth largest element lives at index (N - k) in a fully sorted array
        int targetIndex = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, targetIndex);
    }

    private int quickSelect(int[] nums, int leftBound, int rightBound, int targetIndex) {
        // Base case: If the bounds are the same, we found the element
        if (leftBound == rightBound) {
            return nums[leftBound];
        }

        // 1. Pick a random pivot to avoid O(N^2) worst-case on sorted arrays
        int pivotIndex = leftBound + random.nextInt(rightBound - leftBound + 1);
        
        // 2. Partition the array around the pivot
        pivotIndex = partition(nums, leftBound, rightBound, pivotIndex);

        // 3. Compare the pivot's final resting place to our target
        if (pivotIndex == targetIndex) {
            return nums[pivotIndex];
        } else if (pivotIndex < targetIndex) {
            // Target is to the right, discard the left half
            return quickSelect(nums, pivotIndex + 1, rightBound, targetIndex);
        } else {
            // Target is to the left, discard the right half
            return quickSelect(nums, leftBound, pivotIndex - 1, targetIndex);
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        
        // Move pivot out of the way to the end
        swap(nums, pivotIndex, right);
        
        int storeIndex = left;
        
        // Move all elements smaller than the pivot to the left
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        
        // Move pivot to its final sorted position
        swap(nums, storeIndex, right);
        
        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}