/*
94. Binary Tree Inorder Traversal (Iterative Stack - DAY 213!)

This solution performs an inorder traversal of a binary tree.
Time Complexity: O(N) where N is the number of nodes.
Space Complexity: O(H) where H is the height of the tree.

Senior Twist: Heap-Allocated Stack Simulation (The Follow-Up).
The standard recursive solution is clean but risks a `StackOverflowError` 
on massively deep or unbalanced trees in production because it relies 
on the JVM's limited execution stack. To answer the LeetCode follow-up, 
we simulate the recursion iteratively using an explicit `ArrayDeque`. 
This shifts the state-tracking burden from the execution stack to the 
massive JVM heap memory, making the algorithm crash-proof for trees of any depth!
*/
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        // Use ArrayDeque as it's faster and more modern than the legacy Stack class
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;

        // Loop until all nodes are processed
        while (current != null || !stack.isEmpty()) {
            
            // 1. Traverse as far left as possible, pushing nodes onto our simulated stack
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 2. Process the node (Root)
            current = stack.pop();
            result.add(current.val);

            // 3. Move to the right subtree to continue the traversal
            current = current.right;
        }

        return result;
    }
}