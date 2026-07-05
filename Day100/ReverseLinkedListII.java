/*
92. Reverse Linked List II (Self-Documenting Pointers - DAY 100!)

This solution optimally reverses a targeted sub-list in a single pass O(N) 
using strictly O(1) auxiliary space via the front-insertion technique.

Senior Twist: Enterprise Nomenclature & Self-Documenting Code.
Pointer gymnastics are notoriously difficult to read, debug, and maintain. 
By replacing generic variables (dummy, prev, curr, temp) with highly specific 
semantic names (sentinelHead, nodeBeforeSublist, sublistTail, nodeToExtract), 
the complex rewiring logic becomes a self-documenting blueprint that any 
engineer can instantly understand without tracing variables on paper!
*/

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Fast-fail guard clause: Nothing to reverse
        if (head == null || left == right) {
            return head;
        }

        // Sentinel node safely anchors the list, handling left = 1 edge cases
        ListNode sentinelHead = new ListNode(0);
        sentinelHead.next = head;

        // Step 1: Navigate to the node immediately preceding the target sub-list
        ListNode nodeBeforeSublist = sentinelHead;
        for (int i = 1; i < left; i++) {
            nodeBeforeSublist = nodeBeforeSublist.next;
        }

        // Step 2: The first node of the sub-list will eventually become its tail
        ListNode sublistTail = nodeBeforeSublist.next;

        // Step 3: Iteratively extract the next node and insert it at the front of the sub-list
        for (int i = 0; i < right - left; i++) {
            // Identify the node to move
            ListNode nodeToExtract = sublistTail.next;
            
            // Detach it by bridging the gap
            sublistTail.next = nodeToExtract.next;
            
            // Wire the extracted node to the front of our reversed portion
            nodeToExtract.next = nodeBeforeSublist.next;
            
            // Anchor it to the preceding node
            nodeBeforeSublist.next = nodeToExtract;
        }

        return sentinelHead.next;
    }
}