/*
289. Game of Life (Bitwise State Encoding - Day 77)

This solution handles the "simultaneous update" requirement by modifying 
the board in-place without losing the original state, achieving strict 
O(1) auxiliary space.

Senior Twist: Bit Manipulation.
Since the initial states (0 and 1) only use the 1st bit of an integer, 
we can store the future state in the 2nd bit!
- [00] = 0 = Dead now, Dead next
- [01] = 1 = Alive now, Dead next
- [10] = 2 = Dead now, Alive next
- [11] = 3 = Alive now, Alive next

By using bitwise operators (&, |, >>=), we can seamlessly encode the future 
state and then instantly shift the bits to overwrite the old state.
*/

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        // Directional array for the 8 neighbors
        int[][] dir = {
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1},          {0,1},
            {1,-1},  {1,0},  {1,1}
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                // Count live neighbors
                for (int[] d : dir) {
                    int r = i + d[0];
                    int c = j + d[1];

                    if (r >= 0 && r < m && c >= 0 && c < n) {
                        // Use bitwise AND to read only the 1st bit (current state)
                        liveNeighbors += board[r][c] & 1;
                    }
                }

                // Rule Application
                if ((board[i][j] & 1) == 1) { 
                    // Currently ALIVE
                    if (liveNeighbors == 2 || liveNeighbors == 3) {
                        // Lives on! Flip the 2nd bit to 1 (using OR 2)
                        board[i][j] |= 2; 
                    }
                } else { 
                    // Currently DEAD
                    if (liveNeighbors == 3) {
                        // Reproduction! Flip the 2nd bit to 1
                        board[i][j] |= 2; 
                    }
                }
            }
        }

        // Shift all bits to the right to transition to the next state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // The 2nd bit becomes the 1st bit, and the old 1st bit falls off!
                board[i][j] >>= 1;
            }
        }
    }
}