/*
200. Number of Islands (DFS Grid Flood Fill - DAY 128!)

This solution counts connected components in a 2D binary grid in O(M * N) 
time complexity and O(M * N) space complexity (recursion stack).

Senior Twist: Direction Vector Architecture.
Utilizing a static `DIRECTIONS` array cleans up 4-directional matrix exploration. 
In-place mutation (`grid[row][col] = '0'`) sinks visited land cells instantly, 
eliminating the memory overhead of an external visited matrix.
*/
class Solution {
    private static final int[][] DIRECTIONS = {
        {1, 0},  // Down
        {-1, 0}, // Up
        {0, 1},  // Right
        {0, -1}  // Left
    };

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int totalIslands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    totalIslands++;
                    sinkIslandDFS(grid, r, c);
                }
            }
        }

        return totalIslands;
    }

    private void sinkIslandDFS(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Boundary guard and water cell check
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0') {
            return;
        }

        // Sink current land cell (mark visited in-place)
        grid[row][col] = '0';

        // Explore all 4 orthogonal neighbors using direction vectors
        for (int[] dir : DIRECTIONS) {
            sinkIslandDFS(grid, row + dir[0], col + dir[1]);
        }
    }
}