/*
52. N-Queens II (O(1) Geometric State Tracking - DAY 144!)

This solution counts all distinct valid N-Queens configurations 
in O(N!) time complexity and O(N) auxiliary space.

Senior Twist: Semantic Geometric Tracking.
By tracking attack vectors using 1D boolean arrays based on constant 
algebraic properties of matrix diagonals (`row + col` and `row - col`), 
we achieve O(1) conflict lookups. Naming these arrays explicitly 
(`mainDiagonals`, `antiDiagonals`) makes the complex geometry self-documenting.
*/
class Solution {
    private int totalValidConfigurations = 0;

    public int totalNQueens(int n) {
        // State tracking arrays for O(1) conflict lookups
        boolean[] occupiedCols = new boolean[n];
        boolean[] mainDiagonals = new boolean[2 * n - 1]; // Top-left to bottom-right
        boolean[] antiDiagonals = new boolean[2 * n - 1]; // Bottom-left to top-right

        exploreBoard(0, n, occupiedCols, mainDiagonals, antiDiagonals);

        return totalValidConfigurations;
    }

    private void exploreBoard(int currentRow, int n, 
                              boolean[] occupiedCols, 
                              boolean[] mainDiagonals, 
                              boolean[] antiDiagonals) {
        
        // Base case: Successfully survived to the end of the board (all N queens placed)
        if (currentRow == n) {
            totalValidConfigurations++;
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            
            // Calculate unique IDs for the diagonals passing through (currentRow, col)
            int mainDiagId = currentRow - col + (n - 1);
            int antiDiagId = currentRow + col;

            // Branch Pruning: If the square is under attack, skip to the next column
            if (occupiedCols[col] || mainDiagonals[mainDiagId] || antiDiagonals[antiDiagId]) {
                continue;
            }

            // 1. Choose: Lock in the queen and mark her attack vectors
            occupiedCols[col] = true;
            mainDiagonals[mainDiagId] = true;
            antiDiagonals[antiDiagId] = true;

            // 2. Explore: Recurse down to the next row
            exploreBoard(currentRow + 1, n, occupiedCols, mainDiagonals, antiDiagonals);

            // 3. Undo (Backtrack): Lift the queen and clear her attack vectors
            occupiedCols[col] = false;
            mainDiagonals[mainDiagId] = false;
            antiDiagonals[antiDiagId] = false;
        }
    }
}