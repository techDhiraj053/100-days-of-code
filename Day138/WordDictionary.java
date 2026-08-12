/*
211. Design Add and Search Words (Wildcard-Enabled Trie - DAY 138!)

This data structure supports adding words and searching via exact 
match or wildcard '.' patterns in O(M) time for add and O(M * 26^D) 
worst-case for search, where M is word length and D is the number of dots.

Senior Twist: Recursive Backtracking Search.
The standard Trie lookup is augmented with a backtracking search for '.' 
wildcards. By branching across all existing child nodes when a wildcard is 
encountered, we satisfy the "match any letter" requirement while maintaining 
the underlying Trie's space-saving structure.
*/
class WordDictionary {
    private static final int ALPHABET_SIZE = 26;

    private static class TrieNode {
        private final TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        private boolean isEndOfWord = false;
    }

    private final TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return performRecursiveSearch(root, word, 0);
    }

    private boolean performRecursiveSearch(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char ch = word.charAt(index);

        if (ch == '.') {
            // Wildcard: Try all 26 possible branches that exist
            for (TrieNode child : node.children) {
                if (child != null && performRecursiveSearch(child, word, index + 1)) {
                    return true;
                }
            }
        } else {
            // Exact match: proceed only down the specific character path
            int indexInAlphabet = ch - 'a';
            TrieNode child = node.children[indexInAlphabet];
            return child != null && performRecursiveSearch(child, word, index + 1);
        }

        return false;
    }
}