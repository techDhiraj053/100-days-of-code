/*
124. Binary Tree Maximum Path Sum (Thread-Safe DFS - DAY 211!)

This solution finds the maximum path sum in a binary tree.
Time Complexity: O(N) where N is the number of nodes.
Space Complexity: O(H) for the recursion stack, where H is the tree height.

Senior Twist: Thread-Safe State Encapsulation.
Instead of using a global instance variable which causes race conditions in 
multi-threaded enterprise environments, we encapsulate the state within a 
single-element array (`int[] maxSum`). By passing this reference down the 
recursive DFS stack, we maintain a global tracking mechanism while keeping 
the method completely thread-safe and stateless at the class level.
*/
class Solution {
    public int maxPathSum(TreeNode root) {
        // Encapsulated state to maintain thread safety
        int[] maxSum = new int[] { Integer.MIN_VALUE };
        dfs(root, maxSum);
        return maxSum[0];
    }

    private int dfs(TreeNode node, int[] maxSum) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate the max gain from left and right subtrees.
        // If a subtree's maximum gain is negative, we drop it entirely by taking 0.
        int leftGain = Math.max(0, dfs(node.left, maxSum));
        int rightGain = Math.max(0, dfs(node.right, maxSum));

        // The price to complete a path through the current node (V-shape)
        int currentPath = node.val + leftGain + rightGain;

        // Update our encapsulated max tracking variable if this path is better
        maxSum[0] = Math.max(maxSum[0], currentPath);

        // Return the maximum linear gain to the parent node
        return node.val + Math.max(leftGain, rightGain);
    }
}