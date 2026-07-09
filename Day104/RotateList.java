/*
61. Rotate List (Self-Documenting Topology - DAY 104!)

This solution optimally rotates a linked list by k places in O(N) time 
and strictly O(1) auxiliary space.

Senior Twist: Enterprise Nomenclature & Self-Documenting Code.
Rather than viewing this as a shifting problem, we treat it as a Ring Topology 
problem. By using terms like `originalTail`, `breakPoint`, and `rotatedHead`, 
the logic perfectly narrates the three phases of the algorithm:
1. Finding the bounds.
2. Closing the ring.
3. Breaking the ring at the mathematically calculated node.
*/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        // Fast-fail guard clauses: Empty list, single node, or no rotation requested
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Phase 1: Traverse to establish length and identify the end boundary
        int listLength = 1;
        ListNode originalTail = head;

        while (originalTail.next != null) {
            originalTail = originalTail.next;
            listLength++;
        }

        // Phase 2: Eliminate redundant rotations using modulo arithmetic
        int effectiveRotations = k % listLength;

        if (effectiveRotations == 0) {
            return head;
        }

        // Phase 3: Close the topology to form a circular ring
        originalTail.next = head;

        // Phase 4: Calculate the exact point to break the ring
        // If we rotate right by k, the new tail is (length - k) steps from the original head.
        // We subtract 1 because we are starting our traversal at the head (step 0).
        int stepsToBreakPoint = listLength - effectiveRotations - 1;
        ListNode breakPoint = head;

        for (int i = 0; i < stepsToBreakPoint; i++) {
            breakPoint = breakPoint.next;
        }

        // Phase 5: Establish the new bounds and break the ring
        ListNode rotatedHead = breakPoint.next;
        breakPoint.next = null;

        return rotatedHead;
    }
}