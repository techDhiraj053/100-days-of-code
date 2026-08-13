/*
212. Word Search II (Trie-Guided Matrix Backtracking - DAY 139!)

This solution finds all words from a dictionary present on a 2D board 
using a Trie combined with Depth-First Search and in-place backtracking.

Senior Twist: Trie-Accelerated Search.
By fusing the words into a prefix tree, we evaluate multiple candidate words 
simultaneously during board traversal. Storing the terminal word string directly 
at the Trie node eliminates post-processing overhead.
*/
import java.util.List;
import java.util.ArrayList;

class Solution {
    private static final int ALPHABET_SIZE = 26;
    private static final char VISITED_MARKER = '#';

    private static class TrieNode {
        private final TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        private String storedWord = null; // Stores complete word at terminal nodes
    }

    private final TrieNode trieRoot = new TrieNode();
    private final List<String> matchedWordsResult = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        // 1. Build the prefix tree
        for (String word : words) {
            insertIntoTrie(word);
        }

        int rowCount = board.length;
        int colCount = board[0].length;

        // 2. Initiate DFS backtracking from every cell on the board
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                exploreBoardDFS(board, r, c, trieRoot);
            }
        }

        return matchedWordsResult;
    }

    private void insertIntoTrie(String word) {
        TrieNode current = trieRoot;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.storedWord = word;
    }

    private void exploreBoardDFS(char[][] board, int row, int col, TrieNode parentNode) {
        // Boundary check
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        char currentChar = board[row][col];

        // Check if cell is already visited or doesn't exist in the Trie
        if (currentChar == VISITED_MARKER) {
            return;
        }

        int charIndex = currentChar - 'a';
        TrieNode nextNode = parentNode.children[charIndex];

        if (nextNode == null) {
            return;
        }

        // If a complete word is reached, capture it and clear reference to prevent duplicates
        if (nextNode.storedWord != null) {
            matchedWordsResult.add(nextNode.storedWord);
            nextNode.storedWord = null; // De-duplicate result collection
        }

        // Mark current cell as visited in-place
        board[row][col] = VISITED_MARKER;

        // Recursively explore all 4 orthogonal directions
        exploreBoardDFS(board, row + 1, col, nextNode);
        exploreBoardDFS(board, row - 1, col, nextNode);
        exploreBoardDFS(board, row, col + 1, nextNode);
        exploreBoardDFS(board, row, col - 1, nextNode);

        // Restore cell state (Backtracking)
        board[row][col] = currentChar;
    }
}