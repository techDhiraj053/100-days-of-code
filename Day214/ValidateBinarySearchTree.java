/*
98. Validate Binary Search Tree (Thread-Safe Inorder - DAY 215!)

This solution checks if a binary tree is a valid Binary Search Tree.
Time Complexity: O(N) where N is the number of nodes.
Space Complexity: O(H) for the recursion stack.

Senior Twist: Structural Inorder Validation.
Instead of passing `min` and `max` boundaries (which requires type-casting 
to `long` to avoid Integer overflow traps), we exploit the fundamental 
property of a BST: an Inorder Traversal must yield strictly increasing values. 
By maintaining a thread-safe encapsulated reference to the previously visited 
node (`TreeNode[] prev`), we can validate the entire tree regardless of its 
underlying data type limits. This is object-oriented algorithmic purity!
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        // Encapsulated state to track the previously visited node safely across threads
        TreeNode[] prev = new TreeNode[1];
        return inorderValidate(root, prev);
    }

    private boolean inorderValidate(TreeNode node, TreeNode[] prev) {
        // Base case: empty nodes are valid
        if (node == null) {
            return true;
        }

        // 1. Validate the Left Subtree
        if (!inorderValidate(node.left, prev)) {
            return false;
        }

        // 2. Validate the Current Node against the Previous Node
        // In a valid BST, the current node's value MUST be strictly greater than the previous
        if (prev[0] != null && node.val <= prev[0].val) {
            return false;
        }
        
        // Update the previous node to be the current node before moving right
        prev[0] = node;

        // 3. Validate the Right Subtree
        return inorderValidate(node.right, prev);
    }
}