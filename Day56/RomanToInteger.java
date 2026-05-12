/*
13. Roman to Integer (Right-to-Left Optimization - Day 56)

This solution converts Roman numerals to integers using an optimal O(N) time 
and O(1) space approach. 

Senior Twist: By traversing the string from Right-to-Left, we eliminate the 
need to "peek ahead" at the next character. This prevents potential 
IndexOutOfBounds exceptions, removes the need to stop the loop early, and 
avoids having to manually add the final character outside the loop. A switch 
statement is also used for cleaner and slightly more performant character matching.
*/

class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int prevValue = 0;

        // Iterate from the end of the string to the beginning
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = getValue(s.charAt(i));

            // If the current value is less than the one we just processed, it's a subtraction (e.g., IV)
            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                // Otherwise, it's a standard addition (e.g., VI)
                total += currentValue;
            }
            
            // Update the previous value for the next iteration
            prevValue = currentValue;
        }
        
        return total;
    }

    // Using a switch statement for clean, readable exact-matching
    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}