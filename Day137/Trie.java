/*
208. Implement Trie (Prefix Tree) - DAY 137!

This class implements a Trie data structure, providing O(L) time complexity 
for insertion, search, and prefix matching, where L is the length of the string.

Senior Twist: Node-Level Encapsulation.
By isolating the internal state of `TrieNode` within the `Trie` class, we 
enforce strong encapsulation. The use of a fixed-size array (`children`) 
provides predictable O(1) character indexing for English alphabet strings.
*/
class Trie {
    private static final int ALPHABET_SIZE = 26;

    private static class TrieNode {
        private final TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        private boolean isEndOfWord = false;
    }

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int charIndex = ch - 'a';
            if (current.children[charIndex] == null) {
                current.children[charIndex] = new TrieNode();
            }
            current = current.children[charIndex];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = traverse(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = traverse(prefix);
        return node != null;
    }

    /**
     * Internal helper to traverse the path associated with a string.
     * Returns the node at the end of the path or null if the path is invalid.
     */
    private TrieNode traverse(String sequence) {
        TrieNode current = root;
        for (char ch : sequence.toCharArray()) {
            int charIndex = ch - 'a';
            if (current.children[charIndex] == null) {
                return null;
            }
            current = current.children[charIndex];
        }
        return current;
    }
}