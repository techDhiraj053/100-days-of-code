/*
25. Reverse Nodes in k-Group (Self-Documenting Pointers - DAY 101!)

This solution optimally reverses nodes in k-sized groups using 
strictly O(1) auxiliary space.

Senior Twist: Enterprise Nomenclature & Self-Documenting Code.
Pointer gymnastics are notoriously difficult to read, debug, and maintain. 
By replacing generic variables (groupPrev, prev, curr, temp) with highly specific 
semantic names (groupAnchor, previousNode, currentExtractionNode, nextNodeCache), 
the complex rewiring logic becomes a self-documenting blueprint that any 
engineer can instantly understand without tracing variables on paper!
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Sentinel node safely anchors the list, simplifying head manipulations
        ListNode sentinelHead = new ListNode(0);
        sentinelHead.next = head;

        // Points to the node immediately preceding the current k-group
        ListNode groupAnchor = sentinelHead;

        while (true) {
            // Step 1: Verify if a complete k-group exists
            ListNode kthNode = getKthNode(groupAnchor, k);
            if (kthNode == null) {
                break; // Not enough nodes left, leave as is
            }

            ListNode nextGroupStart = kthNode.next;

            // Step 2: Set up pointers for the reversal
            // The first node we process will eventually connect to the next group
            ListNode previousNode = nextGroupStart;
            ListNode currentExtractionNode = groupAnchor.next;

            // Step 3: Execute the in-place reversal for the k-group
            while (currentExtractionNode != nextGroupStart) {
                ListNode nextNodeCache = currentExtractionNode.next;
                currentExtractionNode.next = previousNode;
                previousNode = currentExtractionNode;
                currentExtractionNode = nextNodeCache;
            }

            // Step 4: Reconnect the reversed group back to the main list
            ListNode nextAnchor = groupAnchor.next; // The old start is now the end
            groupAnchor.next = kthNode;             // Anchor points to the new start
            groupAnchor = nextAnchor;               // Move anchor up for the next group
        }

        return sentinelHead.next;
    }

    // Helper function to cleanly identify group boundaries
    private ListNode getKthNode(ListNode current, int k) {
        while (current != null && k > 0) {
            current = current.next;
            k--;
        }
        return current;
    }
}