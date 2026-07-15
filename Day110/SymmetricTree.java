/*
101. Symmetric Tree (Self-Documenting Mirror Traversal - DAY 110!)

This solution optimally evaluates if a binary tree is a mirror of itself 
using synchronized Depth-First Search in O(N) time and O(H) space.

Senior Twist: Enterprise Nomenclature & Self-Documenting Code.
The recursive step `isMirror(left.left, right.right)` is conceptually checking 
the "outer edges" of the tree, while `left.right, right.left` checks the "inner edges". 
By extracting these recursive calls into explicitly named boolean variables 
(`isOuterSymmetric` and `isInnerSymmetric`), we perfectly document the geometric 
intent of the algorithm. It is highly readable and easy to debug.
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode leftNode, TreeNode rightNode) {

        // Structural Check: Both branches reached a leaf simultaneously
        if (leftNode == null && rightNode == null) {
            return true;
        }

        // Structural Check: One branch is deeper or structurally divergent
        if (leftNode == null || rightNode == null) {
            return false;
        }

        // Data Check: The mirrored nodes exist but hold different data
        if (leftNode.val != rightNode.val) {
            return false;
        }

        // Recursive Leap: Cross-check the mirrored geometry
        // The extreme left must match the extreme right
        boolean isOuterSymmetric = isMirror(leftNode.left, rightNode.right);
        
        // The inner left must match the inner right
        boolean isInnerSymmetric = isMirror(leftNode.right, rightNode.left);

        // Both the inner and outer boundaries must be symmetric for a true mirror
        return isOuterSymmetric && isInnerSymmetric;
    }
}