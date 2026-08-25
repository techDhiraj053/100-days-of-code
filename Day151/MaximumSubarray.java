/*
53. Maximum Subarray (Divide and Conquer / Segment Tree Node - DAY 151!)

While Kadane's algorithm provides a simple O(N) solution, this implementation 
answers the follow-up challenge using Divide and Conquer. 

Senior Twist: Segment Tree Architecture.
By returning a composite `SubarrayNode`, we achieve an O(N) time and O(log N) space 
Divide and Conquer solution. This specific merging logic is highly scalable and 
serves as the foundational blueprint for answering distributed range queries in 
advanced data structures like Segment Trees.
*/
class Solution {
    public int maxSubArray(int[] nums) {
        // Fast-fail
        if (nums == null || nums.length == 0) return 0;
        
        return divideAndConquer(nums, 0, nums.length - 1).maxSubArraySum;
    }

    private SubarrayNode divideAndConquer(int[] nums, int left, int right) {
        // Base case: A single element forms its own total, prefix, suffix, and max sum
        if (left == right) {
            return new SubarrayNode(nums[left], nums[left], nums[left], nums[left]);
        }

        int mid = left + (right - left) / 2;
        
        // Recursively conquer the left and right halves
        SubarrayNode leftNode = divideAndConquer(nums, left, mid);
        SubarrayNode rightNode = divideAndConquer(nums, mid + 1, right);

        // Combine the results
        return mergeNodes(leftNode, rightNode);
    }

    private SubarrayNode mergeNodes(SubarrayNode left, SubarrayNode right) {
        // 1. Total sum is simply the sum of both halves
        int totalSum = left.totalSum + right.totalSum;
        
        // 2. Max prefix is either the left's max prefix, OR the entire left side + right's max prefix
        int maxPrefixSum = Math.max(left.maxPrefixSum, left.totalSum + right.maxPrefixSum);
        
        // 3. Max suffix is either the right's max suffix, OR the entire right side + left's max suffix
        int maxSuffixSum = Math.max(right.maxSuffixSum, right.totalSum + left.maxSuffixSum);
        
        // 4. Max Subarray is the max of: left's best, right's best, or a contiguous sequence crossing the middle
        int maxSubArraySum = Math.max(
            Math.max(left.maxSubArraySum, right.maxSubArraySum), 
            left.maxSuffixSum + right.maxPrefixSum
        );

        return new SubarrayNode(totalSum, maxPrefixSum, maxSuffixSum, maxSubArraySum);
    }

    /**
     * DTO to hold the state required to merge adjacent sub-arrays in O(1) time.
     */
    private static class SubarrayNode {
        int totalSum;
        int maxPrefixSum;
        int maxSuffixSum;
        int maxSubArraySum;

        SubarrayNode(int totalSum, int maxPrefixSum, int maxSuffixSum, int maxSubArraySum) {
            this.totalSum = totalSum;
            this.maxPrefixSum = maxPrefixSum;
            this.maxSuffixSum = maxSuffixSum;
            this.maxSubArraySum = maxSubArraySum;
        }
    }
}