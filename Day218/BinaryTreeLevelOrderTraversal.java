/*
102. Binary Tree Level Order Traversal (BFS - DAY 218!)

This solution groups the nodes of a binary tree level by level.
Time Complexity: O(N) where N is the total number of nodes.
Space Complexity: O(W) where W is the maximum width of the tree.

Senior Twist: ArrayDeque for Cache Locality.
The BFS logic cleanly isolates levels by taking a size snapshot (`q.size()`) 
before processing. To make this enterprise-ready, we replace `LinkedList` 
with `ArrayDeque`. `ArrayDeque` uses a contiguous circular array under the hood, 
meaning it has vastly superior CPU cache locality and zero node-allocation 
overhead compared to `LinkedList`, making it the absolute fastest Queue 
implementation in modern Java.
*/
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        // Modern enterprise standard: ArrayDeque instead of LinkedList
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            // Snapshot the number of nodes currently in this level
            int size = q.size();
            List<Integer> level = new ArrayList<>(size); // Pre-allocate capacity

            // Process exactly 'size' nodes to complete the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            ans.add(level);
        }

        return ans;
    }
}