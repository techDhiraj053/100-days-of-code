/*
222. Count Complete Tree Nodes (Logarithmic Height Optimization - DAY 119!)

This solution counts the nodes of a complete binary tree in O(log^2 N) time 
complexity by leveraging the properties of perfect binary subtrees.

Senior Twist: Geometric Subtree Pruning.
By checking if the left height equals the right height, we determine whether 
the left branch is a full binary tree. If it is, we compute its size 
instantly with bitwise shifting `(1 << height) - 1` and eliminate 
full-tree traversal entirely!
*/
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftTreeHeight = getLeftHeight(root);
        int rightTreeHeight = getRightHeight(root);

        // If left and right heights are equal, the left subtree is a perfect binary tree.
        // Total nodes = (2^height - 1) for the left subtree + 1 for root + recursive count on right.
        if (leftTreeHeight == rightTreeHeight) {
            return (1 << leftTreeHeight) - 1;
        }

        // Otherwise, the right subtree is a perfect binary tree of height (leftTreeHeight - 1).
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}