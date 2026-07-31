/*
230. Kth Smallest Element in a BST (In-Order Rank Tracking - DAY 126!)

This solution finds the kth smallest value in a BST in O(H + K) time 
complexity and O(H) auxiliary space, where H is the height of the tree.

Senior Twist: Semantic Rank Tracking.
By utilizing in-order traversal combined with a tracking counter, we evaluate 
nodes in ascending order and short-circuit the traversal immediately 
upon hitting the target rank k, avoiding redundant node visits.
*/
class Solution {
    private int evaluatedNodeCount = 0;
    private int kthSmallestValue = 0;

    public int kthSmallest(TreeNode root, int k) {
        findKthInOrder(root, k);
        return kthSmallestValue;
    }

    private void findKthInOrder(TreeNode currentNode, int k) {
        if (currentNode == null) {
            return;
        }

        // 1. Traverse left subtree (smaller values)
        findKthInOrder(currentNode.left, k);

        // 2. Process current node (increment rank)
        evaluatedNodeCount++;
        if (evaluatedNodeCount == k) {
            kthSmallestValue = currentNode.val;
            return; // Target reached; short-circuit further traversal
        }

        // 3. Traverse right subtree (larger values) if target not yet met
        if (evaluatedNodeCount < k) {
            findKthInOrder(currentNode.right, k);
        }
    }
}