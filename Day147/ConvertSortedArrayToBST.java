/*
108. Convert Sorted Array to Binary Search Tree (Divide and Conquer - DAY 147!)

This solution converts a sorted array into a height-balanced BST in O(N) time 
and O(log N) space.

Senior Twist: Overflow-Safe Boundary Tracking.
By structurally mirroring the Binary Search algorithm, we recursively slice the 
search space into exact halves. The middle element becomes the root of the current 
subtree, ensuring the maximum depth difference between left and right branches 
is never more than 1.
*/
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructBST(nums, 0, nums.length - 1);
    }

    private TreeNode constructBST(int[] nums, int leftBound, int rightBound) {
        // Base case: the subarray is empty
        if (leftBound > rightBound) {
            return null;
        }

        // Calculate the median index securely to prevent integer overflow
        int midIndex = leftBound + (rightBound - leftBound) / 2;

        // The median element becomes the root of the current subtree
        TreeNode subtreeRoot = new TreeNode(nums[midIndex]);

        // Recursively construct the left and right halves
        subtreeRoot.left = constructBST(nums, leftBound, midIndex - 1);
        subtreeRoot.right = constructBST(nums, midIndex + 1, rightBound);

        return subtreeRoot;
    }
}