/*
82. Remove Duplicates from Sorted List II (Self-Documenting Pointers - DAY 103!)

This solution optimally removes all instances of duplicate numbers in a single 
pass O(N) using strictly O(1) auxiliary space.

Senior Twist: Enterprise Nomenclature & Self-Documenting Code.
By renaming `prev` to `latestDistinctNode` and `curr` to `explorationPointer`, 
the algorithm's intent is immediately clear. We are anchoring our list to the 
last guaranteed unique value, while our exploration pointer scouts ahead to 
bypass any duplicate clusters!
*/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Sentinel node safely anchors the list, handling cases where the head itself is duplicated
        ListNode sentinelNode = new ListNode(0);
        sentinelNode.next = head;

        // Points to the last node we know for sure is unique
        ListNode latestDistinctNode = sentinelNode;
        // Scouts ahead to find and evaluate the next nodes
        ListNode explorationPointer = head;

        while (explorationPointer != null) {
            // Check if we hit a cluster of duplicates
            if (explorationPointer.next != null && explorationPointer.val == explorationPointer.next.val) {
                
                // Scout ahead to the end of the duplicate cluster
                while (explorationPointer.next != null && explorationPointer.val == explorationPointer.next.val) {
                    explorationPointer = explorationPointer.next;
                }
                
                // Skip the final duplicate of the cluster
                explorationPointer = explorationPointer.next;
                
                // Rewire the last known distinct node to completely bypass the cluster
                latestDistinctNode.next = explorationPointer;
            } else {
                // Node is distinct, lock it in and move our anchor forward
                latestDistinctNode = explorationPointer;
                explorationPointer = explorationPointer.next;
            }
        }

        return sentinelNode.next;
    }
}