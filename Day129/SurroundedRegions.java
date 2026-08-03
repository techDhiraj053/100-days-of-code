/*
130. Surrounded Regions (Boundary-Driven Flood Fill - DAY 129!)

This solution captures surrounded regions in a 2D matrix in O(M * N) time 
complexity and O(M * N) space complexity (recursion stack).

Senior Twist: Reverse-Boundary Architecture.
Rather than searching inward from interior cells, this algorithm scans 
the outer borders to flag any `'O'` connected to the edge as safe (`'T'`). 
A final cleanup pass converts trapped `'O'` cells to `'X'` and restores 
safe `'T'` cells back to `'O'`, achieving maximum clarity and efficiency.
*/
class Solution {
    private static final int[][] DIRECTIONS = {
        {1, 0},  // Down
        {-1, 0}, // Up
        {0, 1},  // Right
        {0, -1}  // Left
    };

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // 1. Traverse Left and Right boundaries, triggering DFS on edge 'O' cells
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') {
                markSafeBorderDFS(board, r, 0);
            }
            if (board[r][cols - 1] == 'O') {
                markSafeBorderDFS(board, r, cols - 1);
            }
        }

        // 2. Traverse Top and Bottom boundaries, triggering DFS on edge 'O' cells
        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') {
                markSafeBorderDFS(board, 0, c);
            }
            if (board[rows - 1][c] == 'O') {
                markSafeBorderDFS(board, rows - 1, c);
            }
        }

        // 3. Final Sweep: Capture surrounded 'O's into 'X' and restore safe 'T's to 'O'
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X'; // Trapped region captured
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O'; // Edge-connected safe zone restored
                }
            }
        }
    }

    private void markSafeBorderDFS(char[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;

        // Boundary guard and non-'O' check
        if (row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] != 'O') {
            return;
        }

        // Temporarily mark current edge-connected cell as safe ('T' for Temporary)
        board[row][col] = 'T';

        // Recursively visit all 4 orthogonal neighbors
        for (int[] dir : DIRECTIONS) {
            markSafeBorderDFS(board, row + dir[0], col + dir[1]);
        }
    }
}