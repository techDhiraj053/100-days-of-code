/*
106. Construct Binary Tree from Inorder and Postorder Traversal (Self-Documenting Boundaries - DAY 111!)

This solution optimally constructs a binary tree from traversal arrays 
in O(N) time and O(N) space using a HashMap for O(1) index lookups.

Senior Twist: Enterprise Nomenclature & Self-Documenting Code.
Tree construction relies heavily on shrinking array boundaries. By renaming the 
generic `left` and `right` variables to `inorderBoundaryLeft` and `inorderBoundaryRight`, 
we explicitly document the geometric constraints of the current subtree. 
Furthermore, renaming the global tracker to `currentRootPostorderIndex` perfectly 
describes its architectural role: working backward through the postorder array 
to find the next root node!
*/
import java.util.HashMap;

class Solution {

    // Tracks the current root node in the postorder sequence (processed right to left)
    private int currentRootPostorderIndex;
    
    // Caches inorder values to their indices for O(1) lookups
    private HashMap<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        inorderIndexMap = new HashMap<>();
        
        // Cache the inorder array bounds
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        // The root of the entire tree is always the last element of a postorder traversal
        currentRootPostorderIndex = postorder.length - 1;

        return buildSubtree(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildSubtree(int[] postorder, int inorderBoundaryLeft, int inorderBoundaryRight) {

        // Base Case: The boundaries have crossed, meaning there are no nodes left to build
        if (inorderBoundaryLeft > inorderBoundaryRight) {
            return null;
        }

        // Establish the current root node
        int rootValue = postorder[currentRootPostorderIndex];
        TreeNode root = new TreeNode(rootValue);
        
        // Decrement tracker for the next recursive call
        currentRootPostorderIndex--;

        // Find the pivot point in the inorder array to split left and right subtrees
        int rootIndexInInorder = inorderIndexMap.get(rootValue);

        // IMPORTANT: Because we process postorder backward (Root -> Right -> Left),
        // we MUST build the right subtree before the left subtree!
        root.right = buildSubtree(postorder, rootIndexInInorder + 1, inorderBoundaryRight);
        root.left = buildSubtree(postorder, inorderBoundaryLeft, rootIndexInInorder - 1);

        return root;
    }
}