/*
114. Flatten Binary Tree to Linked List (O(1) Morris Style - DAY 223!)

This solution flattens a binary tree into a right-skewed linked list.
Time Complexity: O(N) as each node is visited at most twice.
Space Complexity: O(1) strictly in-place auxiliary space.

Senior Twist: Morris Traversal Flattening & Thread Safety.
The baseline approach using an ArrayList fails the O(1) space follow-up challenge 
and introduces critical multi-threading race conditions via the global list variable. 
To achieve true FAANG-tier enterprise quality, we use a Morris Traversal inspired 
pointer manipulation. For any node with a left child, we find the rightmost node 
of that left subtree. We rewire this rightmost node to point to the current 
node's original right child, then shift the entire left subtree to the right. 
This flattens the tree perfectly in-place with zero recursion and zero extra memory!
*/
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        
        while (curr != null) {
            // If there is a left subtree, we need to rewire it
            if (curr.left != null) {
                
                // Find the rightmost node of the left subtree
                TreeNode runner = curr.left;
                while (runner.right != null) {
                    runner = runner.right;
                }
                
                // Hook the rightmost node of the left subtree to the original right subtree
                runner.right = curr.right;
                
                // Shift the entire left subtree to the right side
                curr.right = curr.left;
                curr.left = null; // Don't forget to sever the old left tie!
            }
            
            // Move down the newly formed right side to process the next node
            curr = curr.right;
        }
    }
}