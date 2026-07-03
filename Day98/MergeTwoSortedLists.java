/*
21. Merge Two Sorted Lists (In-Place Splicing & Sentinel Node - Day 98)

This solution optimally merges two sorted linked lists by dynamically rewiring 
their existing pointers, achieving O(N + M) time and O(1) auxiliary space.

Senior Twist: Iterative Memory Safety & Enterprise Nomenclature.
1. Many developers use Recursion for this problem because it looks elegant. 
   However, recursion utilizes O(N + M) memory on the Call Stack. In an enterprise 
   environment with massive datasets, recursion will trigger a catastrophic 
   StackOverflowError. This iterative approach uses strict O(1) memory, making 
   it perfectly safe for production.
2. The 'dummy' variable has been renamed to 'sentinelHead'. In enterprise codebases, 
   a Sentinel Node specifically implies a dummy node used to simplify boundary 
   conditions and avoid null-pointer checks during list initialization.
*/

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Use a Sentinel Node to anchor the merged list and prevent null checks
        ListNode sentinelHead = new ListNode(-1);
        ListNode current = sentinelHead;

        // Traverse both lists, splicing the smaller node into our merged list
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            // Advance the merged list pointer
            current = current.next;
        }

        // Fast-path: Attach any remaining nodes from the unexhausted list in O(1) time
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Return the actual head of the merged list, bypassing the sentinel
        return sentinelHead.next;
    }
}