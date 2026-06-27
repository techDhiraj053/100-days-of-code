/*
71. Simplify Path (Modern ArrayDeque & String.join - Day 92)

This solution processes a Unix path using the optimal LIFO (Stack) approach.

Senior Twist: Modern Java APIs.
1. `java.util.Stack` is a slow, synchronized legacy class. The modern enterprise 
   standard is to use `Deque<String> deque = new ArrayDeque<>()`. It acts as a 
   much faster, non-synchronized stack.
2. Instead of manually writing a StringBuilder loop to reconstruct the path, 
   we leverage `String.join("/", deque)`. This natively concatenates all elements 
   with the proper delimiter. Because it returns an empty string if the deque 
   is empty, returning `"/" + String.join()` perfectly handles the root directory 
   edge case without any extra if-statements!
*/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String simplifyPath(String path) {
        // Use ArrayDeque as a modern, high-performance Stack
        Deque<String> deque = new ArrayDeque<>();
        
        // Split the path and process each segment
        for (String part : path.split("/")) {
            // Ignore empty segments (from consecutive slashes) and current directory '.'
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }
            
            // Go up a directory
            if (part.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.removeLast(); // Pop the top of the stack
                }
            } 
            // Go down a directory (valid folder name)
            else {
                deque.addLast(part); // Push to the top of the stack
            }
        }
        
        // Idiomatic Java: Natively join the elements. 
        // If empty, String.join returns "", resulting in exactly "/".
        return "/" + String.join("/", deque);
    }
}