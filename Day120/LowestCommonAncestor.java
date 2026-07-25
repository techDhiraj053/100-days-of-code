/*
236. Lowest Common Ancestor of a Binary Tree (Bottom-Up DFS Convergence - DAY 120!)

This solution finds the lowest common ancestor of two nodes in a binary tree 
in O(N) time and O(H) space, where H is the height of the tree.

Senior Twist: Bottom-Up Convergence Architecture.
Instead of tracking full paths from root to node, this algorithm leverages 
post-order traversal to bubble up findings. If a node's left and right subtrees 
both return non-null references, the current node is the exact split point 
where p and q diverge—making it their Lowest Common Ancestor!
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case: If the root is null, or matches either target node, return it.
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively search left and right subtrees
        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);

        // Convergence Check: If both left and right returned non-null, 
        // p and q are located in separate subtrees; current root is the LCA.
        if (leftResult != null && rightResult != null) {
            return root;
        }

        // Otherwise, return whichever side found a target (or null if neither did)
        return (leftResult != null) ? leftResult : rightResult;
    }
}