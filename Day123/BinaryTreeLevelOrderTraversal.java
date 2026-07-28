/*
102. Binary Tree Level Order Traversal (BFS Queue Architecture - DAY 123!)

This solution performs a level-order traversal of a binary tree, returning 
node values grouped by depth level in O(N) time and O(W) space.

Senior Twist: Semantic Structural Naming.
Naming variables explicitly (`levelQueue`, `currentLevelSize`, `currentLevelValues`) 
makes the multi-level queue mechanics instantly readable for any code reviewer.
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversalResult = new ArrayList<>();

        if (root == null) {
            return traversalResult;
        }

        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.offer(root);

        while (!levelQueue.isEmpty()) {
            int currentLevelSize = levelQueue.size();
            List<Integer> currentLevelValues = new ArrayList<>();

            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode currentNode = levelQueue.poll();
                currentLevelValues.add(currentNode.val);

                // Enqueue child nodes for subsequent depth level processing
                if (currentNode.left != null) {
                    levelQueue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    levelQueue.offer(currentNode.right);
                }
            }

            traversalResult.add(currentLevelValues);
        }

        return traversalResult;
    }
}