/*
105. Construct Binary Tree from Preorder and Inorder (DAY 220!)

This solution reconstructs a binary tree from its preorder and inorder traversals.
Time Complexity: O(N) since we visit each node once and use a HashMap for O(1) lookups.
Space Complexity: O(N) for the HashMap and O(H) for the recursion stack.

Senior Twist: Thread-Safe State Encapsulation.
Your mathematical logic for splitting the arrays is flawless. However, using 
instance-level variables (`map` and `preIndex`) creates critical race conditions 
in multi-threaded enterprise environments. To make this production-ready, we 
encapsulate `preIndex` into a 1-element array and pass both the index array 
and the `HashMap` down the recursive call stack. This ensures the method is 
completely stateless at the class level and 100% thread-safe!
*/
import java.util.HashMap;
import java.util.Map;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        
        // Build the hashmap for O(1) root index lookups
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Encapsulated state to track the preorder index safely across threads
        int[] preIndex = new int[] { 0 };
        
        // Pass the state variables down the recursive stack
        return helper(preorder, 0, inorder.length - 1, inorderMap, preIndex);
    }

    private TreeNode helper(int[] preorder, int left, int right, 
                            Map<Integer, Integer> inorderMap, int[] preIndex) {
        // Base case: No elements left to construct the subtree
        if (left > right) {
            return null;
        }

        // The current root is always at the current preIndex in the preorder array
        int rootVal = preorder[preIndex[0]];
        TreeNode root = new TreeNode(rootVal);
        
        // Increment the tracker for the next recursive call
        preIndex[0]++;

        // Find the root's position in the inorder array to split left and right subtrees
        int mid = inorderMap.get(rootVal);

        // Recursively build the left and right subtrees
        root.left = helper(preorder, left, mid - 1, inorderMap, preIndex);
        root.right = helper(preorder, mid + 1, right, inorderMap, preIndex);

        return root;
    }
}