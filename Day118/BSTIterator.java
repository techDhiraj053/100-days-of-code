/*
173. Binary Search Tree Iterator (Controlled In-Order Stack - DAY 118!)

This class implements an iterator over the in-order traversal of a BST 
with O(1) amortized time per `next()` call and O(H) auxiliary memory.

Senior Twist: Encapsulated State Management.
By keeping the stack private and utilizing a dedicated `pushLeftSpine` helper 
method, we cleanly encapsulate the internal traversal state while adhering 
strictly to the memory constraints.
*/
import java.util.Stack;

class BSTIterator {

    private Stack<TreeNode> traversalStack;

    public BSTIterator(TreeNode root) {
        this.traversalStack = new Stack<>();
        pushLeftSpine(root);
    }

    /**
     * Helper to push all left-descendants onto the stack to maintain 
     * the invariant that the top of the stack is always the next smallest element.
     */
    private void pushLeftSpine(TreeNode node) {
        while (node != null) {
            traversalStack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode nextNode = traversalStack.pop();

        // If the popped node has a right child, its left spine must be processed next
        if (nextNode.right != null) {
            pushLeftSpine(nextNode.right);
        }

        return nextNode.val;
    }

    public boolean hasNext() {
        return !traversalStack.isEmpty();
    }
}