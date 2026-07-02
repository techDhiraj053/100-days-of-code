/*
2. Add Two Numbers (Arbitrary-Precision Arithmetic - Day 97)

This solution implements grade-school addition for numbers represented as 
Linked Lists, achieving an optimal O(max(N, M)) time and space complexity.

Senior Twist: Enterprise Naming & BigInteger Parallels.
This exact algorithmic pattern is how enterprise standard libraries (like Java's 
BigInteger) perform arbitrary-precision arithmetic on numbers that exceed the 
64-bit hardware limits. To reflect production-grade code, the variables have 
been upgraded from competitive programming shorthand (x, y, dummy) to semantic, 
self-documenting names (val1, val2, sentinelHead).
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // A sentinel node safely anchors the start of the result list
        ListNode sentinelHead = new ListNode(0);
        ListNode current = sentinelHead;

        int carry = 0;

        // Loop continues as long as there is data to process in either list OR a lingering carry
        while (l1 != null || l2 != null || carry != 0) {
            
            // Extract values safely, defaulting to 0 if the list is exhausted
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;

            // Calculate the new carry (e.g., 15 / 10 = 1)
            carry = sum / 10;
            
            // Append the remainder to the result list (e.g., 15 % 10 = 5)
            current.next = new ListNode(sum % 10);
            
            // Advance the result pointer
            current = current.next;

            // Advance the input pointers if they haven't reached the end
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return the actual head of the resulting list, skipping the sentinel
        return sentinelHead.next;
    }
}