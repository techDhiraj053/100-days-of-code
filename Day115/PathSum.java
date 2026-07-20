/*
112. Path Sum (Recursive Reduction Strategy - DAY 115!)

This solution identifies if a root-to-leaf path exists that sums to 
targetSum in O(N) time and O(H) space, where H is tree height.

Senior Twist: Structural Guarding.
By reducing the targetSum at each recursive call, we eliminate the need for 
extra variables. The base cases (null check and leaf check) act as 
'structural guards,' ensuring that we only evaluate valid paths and stop 
immediately when we reach a leaf node.
*/
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Guard: Empty tree cannot have a path
        if (root == null) {
            return false;
        }

        // Structural Guard: Leaf node check
        // We only succeed if the remaining targetSum is exactly the leaf's value
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Recursive Step: Check subtrees with the reduced balance
        int remainingBalance = targetSum - root.val;
        
        return hasPathSum(root.left, remainingBalance) || 
               hasPathSum(root.right, remainingBalance);
    }
}/*
112. Path Sum (Recursive Reduction Strategy - DAY 115!)

This solution identifies if a root-to-leaf path exists that sums to 
targetSum in O(N) time and O(H) space, where H is tree height.

Senior Twist: Structural Guarding.
By reducing the targetSum at each recursive call, we eliminate the need for 
extra variables. The base cases (null check and leaf check) act as 
'structural guards,' ensuring that we only evaluate valid paths and stop 
immediately when we reach a leaf node.
*/
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Guard: Empty tree cannot have a path
        if (root == null) {
            return false;
        }

        // Structural Guard: Leaf node check
        // We only succeed if the remaining targetSum is exactly the leaf's value
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Recursive Step: Check subtrees with the reduced balance
        int remainingBalance = targetSum - root.val;
        
        return hasPathSum(root.left, remainingBalance) || 
               hasPathSum(root.right, remainingBalance);
    }
}