/*
114. Flatten Binary Tree to Linked List (O(1) Space Optimization - DAY 114!)

This solution flattens a binary tree into a right-leaning linked list 
in O(N) time and O(1) space.

Senior Twist: In-Place Manipulation.
Instead of storing nodes in an ArrayList (which uses O(N) space), this 
algorithm finds the rightmost node of the left subtree (the predecessor) 
and stitches the tree together by moving the original right subtree 
to the end of the left subtree. This transforms the tree in-place!
*/
class Solution {
    public void flatten(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            // If there is a left subtree, we need to move it to the right
            if (current.left != null) {
                
                // Find the rightmost node of the current left subtree
                TreeNode predecessor = current.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                // Connect the original right subtree to the right of the predecessor
                predecessor.right = current.right;

                // Move the entire left subtree to the right
                current.right = current.left;
                current.left = null;
            }

            // Move to the next node in the now-flattened right-side chain
            current = current.right;
        }
    }
}