/*
909. Snakes and Ladders (BFS Shortest Path & Boustrophedon Mapping - DAY 133!)

This solution finds the minimum dice rolls required to reach the final square 
in O(N^2) time complexity and O(N^2) auxiliary space.

Senior Twist: Geometric Coordinate Decoding.
By decoupling 1D board positions into 2D Boustrophedon (zigzag) matrix coordinates 
via a dedicated mapping helper, the BFS traversal evaluates standard 6-sided dice 
transitions and snake/ladder teleports with optimal clarity and performance.
*/
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int boardDimension = board.length;
        int targetSquare = boardDimension * boardDimension;

        Queue<Integer> traversalQueue = new LinkedList<>();
        boolean[] visitedSquares = new boolean[targetSquare + 1];

        // Initialize BFS from square 1
        traversalQueue.offer(1);
        visitedSquares[1] = true;
        int diceRollCount = 0;

        while (!traversalQueue.isEmpty()) {
            int currentLevelSize = traversalQueue.size();

            for (int i = 0; i < currentLevelSize; i++) {
                int currentSquare = traversalQueue.poll();

                // Termination check: reached the final square
                if (currentSquare == targetSquare) {
                    return diceRollCount;
                }

                // Simulate 6-sided dice roll [currentSquare + 1, currentSquare + 6]
                for (int nextSquare = currentSquare + 1; nextSquare <= Math.min(currentSquare + 6, targetSquare); nextSquare++) {
                    int finalDestination = nextSquare;
                    
                    // Decode 1D square number into 2D board coordinates
                    int[] boardCoordinates = getBoardCoordinates(nextSquare, boardDimension);
                    int targetRow = boardCoordinates[0];
                    int targetCol = boardCoordinates[1];

                    // If a snake or ladder exists, teleport to its destination
                    if (board[targetRow][targetCol] != -1) {
                        finalDestination = board[targetRow][targetCol];
                    }

                    // Process unvisited destination squares
                    if (!visitedSquares[finalDestination]) {
                        visitedSquares[finalDestination] = true;
                        traversalQueue.offer(finalDestination);
                    }
                }
            }

            diceRollCount++; // Increment move count per BFS depth level
        }

        return -1; // Target square is unreachable
    }

    /**
     * Translates a 1D linear square label (1 to n^2) into 2D matrix indices 
     * accounting for Boustrophedon (alternating row) layout.
     */
    private int[] getBoardCoordinates(int squareNumber, int n) {
        int zeroBasedIndex = squareNumber - 1;
        int reverseRowFromBottom = zeroBasedIndex / n;
        int colOffset = zeroBasedIndex % n;

        // In odd rows from the bottom, columns alternate direction (right-to-left)
        if (reverseRowFromBottom % 2 == 1) {
            colOffset = n - 1 - colOffset;
        }

        // Convert bottom-up row index to standard top-down matrix row index
        int matrixRow = n - 1 - reverseRowFromBottom;

        return new int[]{matrixRow, colOffset};
    }
}