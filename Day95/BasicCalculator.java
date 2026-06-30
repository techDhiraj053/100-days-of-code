/*
224. Basic Calculator (Primitive Stack & ASCII Optimization - Day 95)

This solution evaluates a mathematical expression with nested parentheses 
by using a Stack to "save" and "load" the running state.

Senior Twist: Primitive Array Stack & Raw ASCII Parsing.
1. To handle the massive constraint of 300,000 characters without memory bloat, 
   we replace `java.util.Stack<Integer>` with a custom primitive `int[]` array. 
   This completely eliminates autoboxing overhead.
2. We replace `Character.isDigit()` with a raw ASCII boundary check 
   (`ch >= '0' && ch <= '9'`). Because we know the exact character set from 
   the problem constraints, skipping the underlying Unicode validations of the 
   wrapper method saves millions of CPU cycles on large strings.
*/

class Solution {
    public int calculate(String s) {
        // Pre-allocate a primitive array stack. Max possible depth is s.length().
        int[] stack = new int[s.length()];
        int top = -1;

        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Raw ASCII check: Much faster than Character.isDigit()
            if (ch >= '0' && ch <= '9') {
                number = number * 10 + (ch - '0');
            } 
            else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } 
            else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } 
            else if (ch == '(') {
                // Save the current result and sign onto our custom stack
                stack[++top] = result;
                stack[++top] = sign;

                // Reset the state for the new sub-expression
                result = 0;
                sign = 1;
            } 
            else if (ch == ')') {
                // Finalize the math inside the parentheses
                result += sign * number;
                number = 0;

                // Load the state from before the parentheses
                result *= stack[top--]; // Multiply by the saved sign
                result += stack[top--]; // Add the saved result
            }
        }

        // Add any remaining number to the result
        return result + sign * number;
    }
}