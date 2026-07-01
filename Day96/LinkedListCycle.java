/*
141. Linked List Cycle (FAANG Cycle-Start Flex - Day 96)

This solution optimally detects a cycle in a linked list using Floyd's Tortoise 
and Hare algorithm, achieving O(N) time and O(1) space.

Senior Twist: FAANG Extension (Finding the Cycle Origin).
In enterprise systems, merely detecting a cyclical reference isn't enough; 
you need to know exactly which node is broken so you can repair the pointer.
By utilizing the mathematical properties of Floyd's algorithm, once a collision 
is detected, we can find the exact node where the cycle begins. We place a 
pointer at the head, keep the slow pointer at the collision site, and move 
both at a speed of 1. Where they meet is the absolute start of the cycle!
*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Collision detected! A cycle absolutely exists.
            if (slow == fast) {
                
                // Senior Twist: Find exactly WHERE the cycle starts
                ListNode cycleStart = head;
                
                // Move both at speed 1. They will mathematically collide at the cycle's origin.
                while (cycleStart != slow) {
                    cycleStart = cycleStart.next;
                    slow = slow.next;
                }
                
                // In a production environment, you could now log 'cycleStart.val' 
                // or actively repair the broken 'next' pointer!
                
                return true; 
            }
        }
        
        return false;
    }
}