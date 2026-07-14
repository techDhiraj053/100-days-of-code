/*
226. Invert Binary Tree (Self-Documenting State Mutation - DAY 109!)

This solution optimally mirrors a binary tree using a Post-Order Depth-First 
Search in O(N) time and O(H) space.

Senior Twist: Enterprise Nomenclature & Self-Documenting Code.
In a post-order traversal, the recursive calls complete before the current node 
is processed. Therefore, the variables holding the results of those calls do 
not represent the "left" and "right" nodes—they represent fully processed subtrees! 
By renaming them to `invertedLeftSubtree` and `invertedRightSubtree`, the exact 
state of the data at the moment of the swap is explicitly documented.
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        // Fast-fail guard clause / Base case for recursion
        if (root == null) {
            return null;
        }

        // Post-Order Traversal: Fully invert the left and right children FIRST
        TreeNode invertedLeftSubtree = invertTree(root.left);
        TreeNode invertedRightSubtree = invertTree(root.right);

        // State Mutation: Swap the fully inverted branches at the current node level
        root.left = invertedRightSubtree;
        root.right = invertedLeftSubtree;

        return root;
    }
}