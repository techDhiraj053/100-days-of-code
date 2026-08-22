/*
148. Sort List (Top-Down Merge Sort - DAY 148!)

This solution sorts a linked list in O(n log n) time complexity and 
O(log n) space complexity (due to the recursion stack).

Senior Twist: Semantic Divide and Conquer.
By abstracting the splitting logic and merging logic into cleanly named 
methods, the main `sortList` function reads exactly like the high-level 
Merge Sort algorithm. The slow/fast pointer technique is used safely to 
guarantee a strict halving of the list, preventing stack overflow.
*/
class Solution {
    public ListNode sortList(ListNode head) {
        // Base case: 0 or 1 node is already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // 1. Divide: Find the midpoint and sever the list into two halves
        ListNode middleNode = getMiddleAndSplit(head);
        
        // 2. Conquer: Recursively sort both independent halves
        ListNode leftSortedHalf = sortList(head);
        ListNode rightSortedHalf = sortList(middleNode);

        // 3. Combine: Merge the two sorted halves back together
        return mergeSortedHalves(leftSortedHalf, rightSortedHalf);
    }

    /**
     * Uses the slow/fast pointer technique to find the middle of the list.
     * Crucially, it severs the connection between the left and right halves.
     */
    private ListNode getMiddleAndSplit(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // Prevents infinite recursion on size-2 lists

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rightHalfHead = slow.next;
        slow.next = null; // Sever the link to separate the two halves

        return rightHalfHead;
    }

    /**
     * Merges two sorted linked lists into a single sorted list.
     */
    private ListNode mergeSortedHalves(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        // Traverse both lists, stitching the smaller node to the merged list
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach any remaining nodes from either list (one will be null)
        current.next = (list1 != null) ? list1 : list2;

        return dummyHead.next;
    }
}