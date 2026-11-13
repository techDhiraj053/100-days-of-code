/*
108. Convert Sorted Array to Binary Search Tree (DAY 221!)

This solution converts a strictly sorted array into a height-balanced BST.
Time Complexity: O(N) since every array element is visited exactly once.
Space Complexity: O(log N) for the recursion stack (since the tree is balanced).

Senior Twist: Binary Search Synergy & Bitwise Shift.
Building a height-balanced BST from a sorted array is mathematically identical 
to tracing the execution path of a standard Binary Search. The root is the 
initial 'mid', the left child is the 'mid' of the left half, and so on. 
To keep this fully enterprise-safe, we use the unsigned right bit-shift `>>> 1` 
to calculate the midpoint, eliminating any risk of integer overflow.
*/
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        // Corrected the syntax error to nums.length - 1
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        // Base case: the search space is exhausted
        if (left > right) {
            return null;
        }

        // Unsigned bitwise shift for safe and fast mid calculation
        int mid = (left + right) >>> 1;

        // The middle element becomes the root of the current subtree
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively build the left and right subtrees from the remaining array halves
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);

        return root;
    }
}