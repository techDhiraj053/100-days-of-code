/*
124. Binary Tree Maximum Path Sum (Post-Order Gain Optimization - DAY 117!)

This solution computes the maximum path sum across any arbitrary path 
in O(N) time and O(H) space, where H is the height of the tree.

Senior Twist: Semantic Distinction.
The core architecture separates the 'maximum local path sum' (treating the 
current node as a turning point connecting left and right legs) from the 
'maximum single-leg gain' (returning only the best branch upward to the parent). 
Using `Math.max(0, ...)` ensures that negative subtrees are safely pruned out.
*/
class Solution {
    private int maxGlobalSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateMaxGain(root);
        return maxGlobalSum;
    }

    private int calculateMaxGain(TreeNode currentNode) {
        if (currentNode == null) {
            return 0;
        }

        // Compute max gain from left and right subtrees. 
        // Treat negative contributions as 0 (discard unprofitable paths).
        int leftGain = Math.max(0, calculateMaxGain(currentNode.left));
        int rightGain = Math.max(0, calculateMaxGain(currentNode.right));

        // Path passing through the current node as the peak (turning point)
        int currentPathSum = leftGain + currentNode.val + rightGain;

        // Update the global maximum path sum found so far
        maxGlobalSum = Math.max(maxGlobalSum, currentPathSum);

        // Return the maximum single-leg gain to be extended by the parent node
        return currentNode.val + Math.max(leftGain, rightGain);
    }
}