/*
23. Merge k Sorted Lists (Min-Heap / Priority Queue - DAY 150!)

This solution merges multiple sorted linked lists into one using a 
Priority Queue, achieving O(N log k) time complexity and O(k) space complexity.

Senior Twist: Overflow-Safe Comparators.
Instead of using subtraction `a.val - b.val` for the comparator (which is 
vulnerable to integer overflow in edge cases), we use `Comparator.comparingInt`. 
This is the idiomatic, mathematically safe way to structure Priority Queues in Java.
*/
import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Fast-fail for empty inputs
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Min-heap ordered by node value safely
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(node -> node.val)
        );

        // Populate the heap with the initial head of each non-empty list
        for (ListNode listHead : lists) {
            if (listHead != null) {
                minHeap.offer(listHead);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode currentTail = dummyHead;

        // Extract the absolute minimum node and advance its respective list
        while (!minHeap.isEmpty()) {
            ListNode smallestNode = minHeap.poll();
            
            currentTail.next = smallestNode;
            currentTail = currentTail.next;

            // If the extracted node has a successor, queue it up for comparison
            if (smallestNode.next != null) {
                minHeap.offer(smallestNode.next);
            }
        }

        return dummyHead.next;
    }
}