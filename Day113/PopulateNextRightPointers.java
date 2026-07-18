/*
117. Populating Next Right Pointers in Each Node II (Self-Documenting Traversal - DAY 113!)

This solution optimally links nodes at the same level in O(N) time and O(1) 
constant space.

Senior Twist: Enterprise Nomenclature.
Renaming `curr` to `currentLevelNode` clarifies that this pointer moves 
horizontally across the tree. Renaming `tail` to `nextLevelTail` clarifies 
that this pointer is responsible for constructing the list of nodes for the 
succeeding level. The use of a `dummy` node is a classic pattern—it acts as 
an anchor for the next level's head!
*/
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node currentLevelNode = root;

        // Traverse level by level until we run out of nodes
        while (currentLevelNode != null) {

            // Dummy node anchors the head of the linked list for the next level
            Node dummyHead = new Node(0);
            Node nextLevelTail = dummyHead;

            // Link nodes within the current level horizontally
            while (currentLevelNode != null) {

                if (currentLevelNode.left != null) {
                    nextLevelTail.next = currentLevelNode.left;
                    nextLevelTail = nextLevelTail.next;
                }

                if (currentLevelNode.right != null) {
                    nextLevelTail.next = currentLevelNode.right;
                    nextLevelTail = nextLevelTail.next;
                }

                // Move horizontally to the next node in the current level
                currentLevelNode = currentLevelNode.next;
            }

            // Move the traversal pointer to the start of the next level
            currentLevelNode = dummyHead.next;
        }

        return root;
    }
}