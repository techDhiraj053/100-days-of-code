/*
199. Binary Tree Right Side View (BFS with Snapshot - DAY 223!)

This solution returns the rightmost nodes of a binary tree level by level.
Time Complexity: O(N) where N is the total number of nodes.
Space Complexity: O(W) where W is the maximum width of the tree.

Senior Twist: Cache-Efficient ArrayDeque & Level Snapshotting.
You brilliantly reused the `q.size()` snapshot technique from Day 218! 
By capturing the exact size of the current level, you perfectly isolate 
the rightmost node using `i == size - 1`. To make this FAANG-tier, we 
swap the legacy `LinkedList` for a high-performance `ArrayDeque`. 
(Pro-tip: This can also be solved using a "Reverse Pre-Order DFS" 
going Right->Left to save space, but this BFS approach is beautifully intuitive!)
*/
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        // Enterprise standard: ArrayDeque over LinkedList
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            // Snapshot the number of nodes currently in this level
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                // Capture the very last node processed in this level's snapshot
                if (i == size - 1) {
                    ans.add(curr.val);
                }

                // Add children to the back of the queue for the NEXT level
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
        }

        return ans;
    }
}