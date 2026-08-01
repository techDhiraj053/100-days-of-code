/*
98. Validate Binary Search Tree (Recursive Boundary Validation - DAY 127!)

This solution determines if a binary tree is a valid BST in O(N) time 
complexity and O(H) auxiliary space, where H is the height of the tree.

Senior Twist: Explicit Range Guarding.
By passing strict lower and upper bounds (`minLimit` and `maxLimit`) down the 
recursion tree, we ensure that every descendant adheres globally to its ancestor 
constraints rather than just local parent-child relations. Using `long` types 
safely accommodates boundary nodes holding extreme integer values.
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        // Initialize validation with open bounds spanning beyond integer limits
        return validateSubtreeBounds(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validateSubtreeBounds(TreeNode currentNode, long minLimit, long maxLimit) {
        // Base case: an empty node is a valid subtree
        if (currentNode == null) {
            return true;
        }

        // Constraint check: current node's value must strictly fall within the permitted range
        if (currentNode.val <= minLimit || currentNode.val >= maxLimit) {
            return false;
        }

        // Recursive validation:
        // 1. Left child must lie within (minLimit, currentNode.val)
        // 2. Right child must lie within (currentNode.val, maxLimit)
        return validateSubtreeBounds(currentNode.left, minLimit, currentNode.val) &&
               validateSubtreeBounds(currentNode.right, currentNode.val, maxLimit);
    }
}