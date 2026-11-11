/*
104. Maximum Depth of Binary Tree (Post-order DFS - DAY 219!)

This solution calculates the maximum depth (height) of a binary tree.
Time Complexity: O(N) where N is the number of nodes.
Space Complexity: O(H) where H is the height of the tree (for the recursion stack).

Senior Twist: Declarative 1-Liner & Production Considerations.
The entire logic can be condensed into a single, clean declarative return statement 
using a ternary operator. 
Note on Enterprise Safety: While this O(N) recursive DFS is the standard and most 
elegant solution, extremely unbalanced trees (like a straight line of 10,000 nodes) 
could trigger a StackOverflowError in Java. In highly defensive production systems, 
we would alternatively use the iterative BFS (Level Order Traversal with ArrayDeque) 
from Day 218 to safely count depth without using the execution call stack.
*/
class Solution {
    public int maxDepth(TreeNode root) {
        // Base case: if node is null, depth is 0. 
        // Otherwise, add 1 to the max depth of the left and right subtrees.
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}