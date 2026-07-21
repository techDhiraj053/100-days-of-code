/*
129. Sum Root to Leaf Numbers (Top-Down DFS Accumulator - DAY 116!)

This solution calculates the total sum of all root-to-leaf numbers 
in O(N) time and O(H) space, where H is the height of the tree.

Senior Twist: Semantic Nomenclature.
Renaming variables to `currentNode` and `currentPathSum` explicitly documents 
how digits are shifted and accumulated (`currentPathSum * 10 + currentNode.val`) 
as the recursion moves deeper into the subtrees.
*/
class Solution {
    public int sumNumbers(TreeNode root) {
        return calculatePathSum(root, 0);
    }

    private int calculatePathSum(TreeNode currentNode, int currentPathSum) {
        // Base case: empty node contributes 0 to the sum
        if (currentNode == null) {
            return 0;
        }

        // Accumulate the current digit into the path sum
        currentPathSum = currentPathSum * 10 + currentNode.val;

        // If it's a leaf node, return the completed path number
        if (currentNode.left == null && currentNode.right == null) {
            return currentPathSum;
        }

        // Recursively sum left and right subtrees
        return calculatePathSum(currentNode.left, currentPathSum) + 
               calculatePathSum(currentNode.right, currentPathSum);
    }
}