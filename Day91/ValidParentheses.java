/*
20. Valid Parentheses (Primitive Array Stack & Expected Bracket Trick - Day 91)

This solution utilizes the optimal LIFO (Last In, First Out) Stack approach 
to process nested structures in strictly O(N) time.

Senior Twist: Primitive Arrays & Simplified Logic.
1. `java.util.Stack` is a slow, synchronized legacy class that requires object 
   autoboxing (Character). We replace this with a raw primitive `char[]` array 
   and an integer pointer (`top`), resulting in blistering hardware-level speed 
   and strict O(N) space without object bloat.
2. We implement a fast-fail check for odd-length strings.
3. Instead of pushing opening brackets, we push the EXPECTED closing bracket. 
   This condenses the matching logic into a single, elegant line of code.
*/

class Solution {
    public boolean isValid(String s) {
        // Fast-fail: A valid set of pairs must be an even length
        if (s.length() % 2 != 0) {
            return false;
        }

        // Create a primitive array to act as our hyper-fast stack
        char[] stack = new char[s.length()];
        int top = -1; // Pointer to the top of our custom stack

        for (char ch : s.toCharArray()) {
            // Push the EXPECTED closing bracket onto the stack
            if (ch == '(') {
                stack[++top] = ')';
            } else if (ch == '{') {
                stack[++top] = '}';
            } else if (ch == '[') {
                stack[++top] = ']';
            } 
            // If it's a closing bracket, pop the stack and check for a match
            else {
                // If the stack is empty (top == -1) or the expected bracket doesn't match
                if (top == -1 || stack[top--] != ch) {
                    return false;
                }
            }
        }

        // If the pointer is back at -1, all brackets were perfectly matched!
        return top == -1;
    }
}