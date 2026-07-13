/*
100. Same Tree (Self-Documenting Parallel Traversal - DAY 108!)

This solution optimally compares two binary trees for structural and data 
equality using synchronized Depth-First Search in O(N) time and O(H) space.

Senior Twist: Enterprise Nomenclature & Self-Documenting Code.
LeetCode defaults to `p` and `q`, which provides zero context. By renaming them 
to `referenceNode` and `comparisonNode`, the intent of the function is immediately 
obvious. Additionally, by extracting the recursive calls into explicit boolean 
variables (`isLeftIdentical` and `isRightIdentical`), we make the call stack 
highly readable and much easier to step through in a debugger.
*/
class Solution {
    public boolean isSameTree(TreeNode referenceNode, TreeNode comparisonNode) {

        // Structural Check: Both branches reached a leaf simultaneously
        if (referenceNode == null && comparisonNode == null) {
            return true;
        }

        // Structural Check: One branch is deeper or structurally divergent
        if (referenceNode == null || comparisonNode == null) {
            return false;
        }

        // Data Check: Nodes exist in the same position but hold different data
        if (referenceNode.val != comparisonNode.val) {
            return false;
        }

        // Recursive Leap: Traverse both the left and right subtrees in parallel lockstep
        boolean isLeftIdentical = isSameTree(referenceNode.left, comparisonNode.left);
        boolean isRightIdentical = isSameTree(referenceNode.right, comparisonNode.right);

        // Both subtrees must be perfect matches for the parent tree to be identical
        return isLeftIdentical && isRightIdentical;
    }
}