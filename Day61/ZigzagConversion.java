/*
6. Zigzag Conversion (Memory Pre-allocation Optimization - Day 61)

This solution utilizes an optimal Boolean State Machine to simulate the 
zigzag traversal, achieving O(N) time and O(N) space. By treating each 
row as an independent StringBuilder, we avoid the massive memory overhead 
of building a sparse 2D matrix.

Senior Twist: Memory Capacity Pre-allocation. To prevent the internal 
character arrays of the StringBuilders from resizing and copying memory 
during the loop, we initialize them with closely estimated capacities. 
The final answer StringBuilder is initialized with the exact required length.
*/

class Solution {
    public String convert(String s, int numRows) {
        // Edge case: No zigzagging is possible
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        // Estimate how many characters each row will hold to prevent internal resizing
        int estimatedLen = (s.length() / numRows) + 2; 
        
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder(estimatedLen);
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Traverse the string and distribute characters
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // Flip the state machine direction if we hit the top or bottom boundary
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        // Senior Twist: Pre-allocate the exact needed capacity for the final answer
        StringBuilder ans = new StringBuilder(s.length());

        for (StringBuilder row : rows) {
            ans.append(row);
        }

        return ans.toString();
    }
}