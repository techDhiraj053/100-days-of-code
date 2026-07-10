/*
86. Partition List (Self-Documenting Bifurcation - DAY 105!)

This solution optimally partitions a linked list around a pivot value 'x' in 
O(N) time and strictly O(1) auxiliary space.

Senior Twist: Enterprise Nomenclature & Self-Documenting Code.
Rather than using generic names like `smallDummy` or `largeDummy`, we apply 
architectural naming. We are effectively building two independent data pipelines: 
the 'lessThan' pipeline and the 'greaterOrEqual' pipeline. By naming our pointers 
`anchor` (the dummy head) and `tail` (the active appending point), the final 
assembly logic (connecting the two pipelines) reads like plain English.
*/
class Solution {
    public ListNode partition(ListNode head, int x) {
        
        // Sentinel anchors to establish the starting points of our two pipelines
        ListNode lessThanAnchor = new ListNode(0);
        ListNode greaterOrEqualAnchor = new ListNode(0);

        // Active tail pointers for appending nodes to each respective pipeline
        ListNode lessThanTail = lessThanAnchor;
        ListNode greaterOrEqualTail = greaterOrEqualAnchor;
        
        // The pointer we use to evaluate the original list
        ListNode currentNode = head;

        // Phase 1: Bifurcate the data stream
        while (currentNode != null) {
            if (currentNode.val < x) {
                lessThanTail.next = currentNode;
                lessThanTail = lessThanTail.next;
            } else {
                greaterOrEqualTail.next = currentNode;
                greaterOrEqualTail = greaterOrEqualTail.next;
            }
            currentNode = currentNode.next;
        }

        // Phase 2: Terminate the greater list to prevent cyclic loops
        greaterOrEqualTail.next = null;

        // Phase 3: Assemble the pipelines (stitch the end of 'less' to the start of 'greater')
        lessThanTail.next = greaterOrEqualAnchor.next;

        return lessThanAnchor.next;
    }
}