/*
138. Copy List with Random Pointer (O(1) Space Interweaving - Day 99)

The HashMap approach perfectly solves this in O(N) time and O(N) space.

Senior Twist: O(1) Space Interweaving Algorithm.
To eliminate the HashMap's memory footprint entirely, we can temporarily weave 
the deep copies directly into the original list! 
Phase 1: Clone each node and link it immediately after its original (A -> A' -> B -> B').
Phase 2: Assign random pointers. Since A' is next to A, A'.random is simply A.random.next!
Phase 3: Unweave the lists to restore the original and extract the pure deep copy.
This achieves O(N) time and strictly O(1) auxiliary space!
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Phase 1: Create clones and weave them into the original list
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // Phase 2: Assign the random pointers for the cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                // The clone's random is the original random's clone (which is always the next node)
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // Skip to the next original node
        }

        // Phase 3: Unweave the lists (Restore original, extract clone)
        curr = head;
        Node sentinelHead = new Node(0);
        Node cloneCurr = sentinelHead;

        while (curr != null) {
            // Extract the cloned node and attach it to our new list
            cloneCurr.next = curr.next;
            cloneCurr = cloneCurr.next;

            // Restore the original list's pointers
            curr.next = curr.next.next;
            curr = curr.next;
        }

        return sentinelHead.next;
    }
}