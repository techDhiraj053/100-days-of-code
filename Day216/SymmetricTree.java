/*
101. Symmetric Tree (Iterative Queue Simulation - DAY 216!)

This solution checks if a binary tree is a mirror of itself.
Time Complexity: O(N) where N is the number of nodes.
Space Complexity: O(W) where W is the maximum width of the tree (for the Queue).

Senior Twist: Iterative Pair Processing (The Follow-Up).
While the recursive solution is elegant, it relies heavily on the JVM's 
execution call stack, which can crash on extremely deep trees. To answer 
the follow-up, we convert the top-down recursion into an iterative approach 
using a Queue. By pushing opposite child pairs sequentially and evaluating 
them iteratively, we shift the memory load to the heap, making this strictly 
enterprise-safe!
*/
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        // Use a Queue to iteratively evaluate pairs of nodes
        Queue<TreeNode> queue = new LinkedList<>();
        
        // Push the first pair of mirrored nodes
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            // If both are null, this branch is symmetrically empty, continue
            if (t1 == null && t2 == null) {
                continue;
            }

            // If only one is null, or their values don't match, symmetry is broken
            if (t1 == null || t2 == null || t1.val != t2.val) {
                return false;
            }

            // Push the next pairs in mirrored order:
            // 1. Outer children
            queue.add(t1.left);
            queue.add(t2.right);
            
            // 2. Inner children
            queue.add(t1.right);
            queue.add(t2.left);
        }

        return true;
    }
}