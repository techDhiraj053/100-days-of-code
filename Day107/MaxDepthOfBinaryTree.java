/*
104. Maximum Depth of Binary Tree (Self-Documenting Recursion - DAY 107!)

This solution optimally calculates the maximum depth of a binary tree using 
Depth-First Search (DFS) in O(N) time and O(H) space.

Senior Twist: Enterprise Nomenclature & Self-Documenting Code.
Recursion can be difficult to read. By renaming generic depth variables to 
`leftSubtreeHeight` and `rightSubtreeHeight`, we explicitly document what the 
call stack is returning to us. The final return statement translates perfectly to:
"My depth is 1 (myself) plus the height of my tallest subtree."
*/
class Solution {
    public int maxDepth(TreeNode root) {
        
        // Base Case: We have reached beyond a leaf node
        if (root == null) {
            return 0;
        }
        
        // Recursive Leap: Traverse all the way down the left and right branches
        int leftSubtreeHeight = maxDepth(root.left);
        int rightSubtreeHeight = maxDepth(root.right);

        // Bubble Up: The current depth is 1 (this node) + the tallest branch below it
        return 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }
}