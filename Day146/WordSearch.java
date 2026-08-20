/*
79. Word Search (Optimized DFS with Frequency Pruning - DAY 146!)

This solution checks if a word exists in a grid using DFS and backtracking.

Senior Twist: Extreme Search Pruning.
To handle the follow-up for larger boards, we implement a two-pass optimization:
1. Frequency Map: We instantly reject cases where the board lacks the required characters.
2. Branch Reduction via Reversal: We compare the frequency of the word's first and last 
   characters. If the starting character is highly abundant, it creates a massive 
   recursive branching factor. By reversing the word and searching from the rarer 
   character, we collapse the search space and drastically improve average-case speed.
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Pruning 1: Validate character frequencies before running expensive DFS
        int[] boardFreq = new int[128];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                boardFreq[board[r][c]]++;
            }
        }

        for (char ch : word.toCharArray()) {
            if (--boardFreq[ch] < 0) {
                return false; // Board doesn't have enough of this character
            }
        }

        // Pruning 2: Reverse the word to start searching from the least frequent end character
        if (boardFreq[word.charAt(0)] > boardFreq[word.charAt(word.length() - 1)]) {
            word = new StringBuilder(word).reverse().toString();
        }

        // Execute optimized DFS
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (exploreGrid(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exploreGrid(char[][] board, String word, int row, int col, int charIndex) {
        // Base case: Entire word found
        if (charIndex == word.length()) {
            return true;
        }

        // Boundary checks and character mismatch
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length 
            || board[row][col] != word.charAt(charIndex)) {
            return false;
        }

        // 1. Choose (Mark cell as visited in-place to save memory)
        char originalChar = board[row][col];
        board[row][col] = '#';

        // 2. Explore (Short-circuiting 4 directional traversal)
        boolean isFound = exploreGrid(board, word, row + 1, col, charIndex + 1) || 
                          exploreGrid(board, word, row - 1, col, charIndex + 1) || 
                          exploreGrid(board, word, row, col + 1, charIndex + 1) || 
                          exploreGrid(board, word, row, col - 1, charIndex + 1);

        // 3. Undo (Restore the cell state)
        board[row][col] = originalChar;

        return isFound;
    }
}