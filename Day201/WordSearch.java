/*
79. Word Search (Optimized DFS - DAY 201!)

This solution finds if a word exists in a grid using DFS and Backtracking.
Time Complexity: O(M * N * 4^L) worst case, but vastly reduced by pruning.
Space Complexity: O(L) for recursion stack.

Senior Twist: Frequency Pruning & Branch Reduction.
To answer the follow-up, we add pre-computation pruning. 
1. Frequency Check: We count all characters on the board. If the board 
   mathematically doesn't possess enough characters to form the word, 
   we exit immediately without ever launching the expensive DFS.
2. Branch Reduction: If the first letter of the word is extremely common 
   on the board, but the last letter is rare, we reverse the word. 
   Starting the DFS from the rare letter drastically cuts down the number 
   of initial recursive branches!
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // Pruning 1: If word is longer than total cells, impossible.
        if (word.length() > m * n) {
            return false;
        }

        // Pruning 2: Character frequency check
        int[] boardFreq = new int[128];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boardFreq[board[i][j]]++;
            }
        }
        
        for (char ch : word.toCharArray()) {
            boardFreq[ch]--;
            if (boardFreq[ch] < 0) {
                // Board doesn't have enough of this character
                return false; 
            }
        }

        // Pruning 3: Branch Reduction (Reverse word if start char is more common than end char)
        if (boardFreq[word.charAt(0)] > boardFreq[word.charAt(word.length() - 1)]) {
            word = new StringBuilder(word).reverse().toString();
        }

        // Convert to char array for faster lookups in DFS
        char[] wordArray = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, wordArray, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, char[] word, int row, int col, int index) {
        // Base case: All characters found!
        if (index == word.length) {
            return true;
        }

        // Bounds check & Character match check
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length 
            || board[row][col] != word[index]) {
            return false;
        }

        // 1. Choose: Mark current cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // 2. Explore: 4-directional DFS
        boolean found = dfs(board, word, row + 1, col, index + 1) || // down
                        dfs(board, word, row - 1, col, index + 1) || // up
                        dfs(board, word, row, col + 1, index + 1) || // right
                        dfs(board, word, row, col - 1, index + 1);   // left

        // 3. Un-choose: Backtrack and restore cell
        board[row][col] = temp;

        return found;
    }
}