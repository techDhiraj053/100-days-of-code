/*
530. Minimum Absolute Difference in BST (In-Order Traversal Tracking - DAY 125!)

This solution finds the minimum absolute difference between any two nodes 
in a BST in O(N) time and O(H) space, where H is the height of the tree.

Senior Twist: Single-Pass In-Order State Tracking.
By capitalizing on the BST in-order property (which yields strictly sorted values), 
we compare each node directly with its immediate predecessor (`previousNode`) 
on the fly. This avoids extra space allocation while achieving optimal O(N) runtime.
*/
class Solution {
    private int minimumDifference = Integer.MAX_VALUE;
    private TreeNode previousNode = null;

    public int getMinimumDifference(TreeNode root) {
        traverseInOrder(root);
        return minimumDifference;
    }

    private void traverseInOrder(TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }

        // 1. Traverse left subtree (smaller values)
        traverseInOrder(currentNode.left);

        // 2. Process current node: compare with its sorted predecessor
        if (previousNode != null) {
            int currentDifference = currentNode.val - previousNode.val;
            minimumDifference = Math.min(minimumDifference, currentDifference);
        }
        previousNode = currentNode;

        // 3. Traverse right subtree (larger values)
        traverseInOrder(currentNode.right);
    }
}