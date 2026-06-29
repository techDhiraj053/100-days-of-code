/*
150. Evaluate Reverse Polish Notation (Primitive Array Optimization - Day 94)

This solution processes RPN optimally using a LIFO Stack approach.

Senior Twist: Primitive Array Stack & In-Place Arithmetic.
To avoid the heavy autoboxing overhead of `java.util.Stack<Integer>`, we 
implement a custom stack using a primitive `int[]` array. 

Furthermore, instead of popping two variables and pushing a result, we perform 
in-place pointer arithmetic! The two target numbers are always at `top` and `top - 1`. 
We directly apply the math to `stack[top - 1]` and simply decrement the `top` pointer. 
This results in absolute hardware-level execution speed (0ms on LeetCode) and zero 
object allocation!
*/

class Solution {
    public int evalRPN(String[] tokens) {
        // Create a primitive array to act as our stack. 
        // Max size is tokens.length (if all were numbers).
        int[] stack = new int[tokens.length];
        int top = -1; // Pointer to the top of our custom stack

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack[top - 1] += stack[top];
                    top--;
                    break;
                case "-":
                    stack[top - 1] -= stack[top];
                    top--;
                    break;
                case "*":
                    stack[top - 1] *= stack[top];
                    top--;
                    break;
                case "/":
                    stack[top - 1] /= stack[top];
                    top--;
                    break;
                default:
                    // If it's a number, push it onto the stack
                    stack[++top] = Integer.parseInt(token);
            }
        }

        // The final result will be the only item left at the bottom of the stack
        return stack[0];
    }
}