/*
36. Valid Sudoku (Bitmasking Optimization - Day 73)

This solution validates a Sudoku board in a single O(1) pass. It calculates 
the 3x3 sub-box index mathematically using (r / 3) * 3 + (c / 3).

Senior Twist: Bit Manipulation (Bitmasking).
Instead of allocating heavy 2D boolean arrays, we use 1D integer arrays. 
Since we only need to track the digits 1-9, we can represent their presence 
as individual bits inside a standard 32-bit integer. 
- We use the bitwise AND operator (&) to check if a bit is already set (duplicate found).
- We use the bitwise OR operator (|) to set the bit (mark digit as seen).
This drastically reduces memory allocation and leverages hardware-level CPU speeds.
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use single integers as bitmasks for each row, column, and box
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }

                // Get the numerical value (0 to 8)
                int num = board[r][c] - '1';
                
                // Create a bitmask with a '1' in the position of our number
                int bitMask = 1 << num;
                
                // Calculate which 3x3 box we are currently inside
                int box = (r / 3) * 3 + (c / 3);

                // Use bitwise AND to check if the bit is already set (greater than 0)
                if ((rows[r] & bitMask) != 0 || 
                    (cols[c] & bitMask) != 0 || 
                    (boxes[box] & bitMask) != 0) {
                    return false; // Duplicate found!
                }

                // Use bitwise OR to flip the bit to '1' (mark as seen)
                rows[r] |= bitMask;
                cols[c] |= bitMask;
                boxes[box] |= bitMask;
            }
        }

        return true;
    }
}