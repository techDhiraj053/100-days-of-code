/*
19. Remove Nth Node From End of List (Self-Documenting Pointers - DAY 102!)

This solution optimally removes the nth node from the end in a single pass O(N) 
using strictly O(1) auxiliary space via the fast/slow pointer window technique.

Senior Twist: Enterprise Nomenclature & Self-Documenting Code.
The classic "fast" and "slow" pointers are great for algorithms class, but in 
production, we want to name variables by their architectural purpose. By renaming 
them to `leadPointer` (which creates the gap) and `targetPredecessor` (which 
lands exactly before the node to delete), the mechanics of the sliding window 
become instantly obvious!
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Sentinel node safely anchors the list, handling cases where the head itself is removed
        ListNode sentinelNode = new ListNode(0);
        sentinelNode.next = head;

        ListNode leadPointer = sentinelNode;
        ListNode targetPredecessor = sentinelNode;

        // Step 1: Advance leadPointer by n + 1 steps to create the sliding window gap
        for (int i = 0; i <= n; i++) {
            leadPointer = leadPointer.next;
        }

        // Step 2: Move both pointers at the same speed. When leadPointer hits the end (null),
        // the targetPredecessor will be exactly one node before the one we need to remove.
        while (leadPointer != null) {
            leadPointer = leadPointer.next;
            targetPredecessor = targetPredecessor.next;
        }

        // Step 3: Bypass the target node to remove it from the list
        targetPredecessor.next = targetPredecessor.next.next;

        return sentinelNode.next;
    }
}