/*
103. Binary Tree Zigzag Level Order Traversal (BFS Directional Toggle - DAY 124!)

This solution performs a zigzag level-order traversal of a binary tree, 
alternating traversal direction per row in O(N) time and O(W) space.

Senior Twist: Dynamic Directional Insertion.
By tracking direction with `isLeftToRight`, we can dynamically insert elements 
at the head (`index 0`) of the row list when traversing right-to-left, 
bypassing the need for a separate reversal pass while keeping O(N) performance.
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagResult = new ArrayList<>();

        if (root == null) {
            return zigzagResult;
        }

        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.offer(root);

        boolean isLeftToRight = true;

        while (!levelQueue.isEmpty()) {
            int currentLevelSize = levelQueue.size();
            List<Integer> currentLevelValues = new ArrayList<>();

            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode currentNode = levelQueue.poll();

                // Append normally for left-to-right; insert at head (index 0) for right-to-left
                if (isLeftToRight) {
                    currentLevelValues.add(currentNode.val);
                } else {
                    currentLevelValues.add(0, currentNode.val);
                }

                // Enqueue child nodes for subsequent depth level processing
                if (currentNode.left != null) {
                    levelQueue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    levelQueue.offer(currentNode.right);
                }
            }

            zigzagResult.add(currentLevelValues);
            isLeftToRight = !isLeftToRight; // Toggle direction for the next row
        }

        return zigzagResult;
    }
}