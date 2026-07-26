/*
199. Binary Tree Right Side View (Level-Order Traversal - DAY 121!)

This solution retrieves the values of the nodes visible from the right side 
of a binary tree in O(N) time and O(W) space, where W is the maximum width.

Senior Twist: Semantic Structural Naming.
By naming the queue `levelQueue` and tracking the level size explicitly, 
the algorithm clearly documents that the rightmost element (`size - 1`) 
is captured as the boundary node for each depth level.
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightViewResult = new ArrayList<>();

        if (root == null) {
            return rightViewResult;
        }

        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.offer(root);

        while (!levelQueue.isEmpty()) {
            int currentLevelSize = levelQueue.size();

            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode currentNode = levelQueue.poll();

                // The last node in the current level's iteration is visible from the right side
                if (i == currentLevelSize - 1) {
                    rightViewResult.add(currentNode.val);
                }

                // Push child nodes into the queue for the next level
                if (currentNode.left != null) {
                    levelQueue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    levelQueue.offer(currentNode.right);
                }
            }
        }

        return rightViewResult;
    }
}