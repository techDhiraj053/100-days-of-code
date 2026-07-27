/*
637. Average of Levels in Binary Tree (Level-Order Accumulation - DAY 122!)

This solution computes the average value of nodes at each depth level 
of a binary tree in O(N) time and O(W) space, where W is the maximum width.

Senior Twist: Overflow Safety & Semantic Naming.
Using a `long` accumulator for the level sum prevents potential integer 
overflow when summing large node values. Clear naming (`levelQueue`, 
`currentLevelSize`, `levelSum`) enhances long-term code maintainability.
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> levelAverages = new ArrayList<>();

        if (root == null) {
            return levelAverages;
        }

        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.offer(root);

        while (!levelQueue.isEmpty()) {
            int currentLevelSize = levelQueue.size();
            long levelSum = 0; // Guard against integer overflow during level summation

            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode currentNode = levelQueue.poll();
                levelSum += currentNode.val;

                // Enqueue child nodes for the subsequent level
                if (currentNode.left != null) {
                    levelQueue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    levelQueue.offer(currentNode.right);
                }
            }

            // Compute and record the floating-point average for the current level
            levelAverages.add((double) levelSum / currentLevelSize);
        }

        return levelAverages;
    }
}