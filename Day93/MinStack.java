/*
155. Min Stack (Custom Linked List Optimization - Day 93)

This solution optimally tracks the minimum value at every depth of the stack, 
achieving strict O(1) time complexity for all operations.

Senior Twist: Custom Node Linked List.
Instead of using two synchronized, legacy `java.util.Stack` objects (which 
force memory-heavy autoboxing from int to Integer), we design the data structure 
from scratch using a Custom Linked List pattern. 

Each `Node` stores the pushed value, the current minimum at that depth, and a 
pointer to the previous node. This guarantees zero array-resizing overhead, 
zero autoboxing, and absolute maximum performance!
*/

class MinStack {
    
    // Private inner class to represent each layer of the stack
    private class Node {
        int val;
        int min;
        Node next;
        
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    
    // Pointer to the top of the stack
    private Node head;

    public MinStack() {
        // Initialize an empty stack
        head = null;
    }
    
    public void push(int val) {
        if (head == null) {
            // First element: it is both the value and the minimum
            head = new Node(val, val, null);
        } else {
            // Point the new node to the old head, and calculate the new minimum
            head = new Node(val, Math.min(val, head.min), head);
        }
    }
    
    public void pop() {
        // Remove the top node by moving the head pointer down one level
        if (head != null) {
            head = head.next;
        }
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}