/*
127. Word Ladder (BFS Shortest Transformation Sequence - DAY 135!)

This solution finds the shortest transformation sequence between two words 
using Breadth-First Search (BFS) in O(M^2 * N) time, where M is the word length 
and N is the number of words in the wordList.

Senior Twist: Implicit Visited Tracking.
By removing words from the `dictionarySet` upon discovery, we guarantee 
each word is processed exactly once, serving as an efficient alternative 
to a dedicated `visited` set and reducing memory overhead.
*/
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionarySet = new HashSet<>(wordList);

        // Short-circuit: Target word must be in the dictionary
        if (!dictionarySet.contains(endWord)) {
            return 0;
        }

        Queue<String> searchQueue = new LinkedList<>();
        searchQueue.offer(beginWord);

        int transformationDepth = 1;

        while (!searchQueue.isEmpty()) {
            int currentLevelSize = searchQueue.size();

            for (int i = 0; i < currentLevelSize; i++) {
                String currentWord = searchQueue.poll();

                // Generate and check all possible 1-letter mutations
                char[] wordChars = currentWord.toCharArray();
                for (int pos = 0; pos < wordChars.length; pos++) {
                    char originalChar = wordChars[pos];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == originalChar) continue;

                        wordChars[pos] = ch;
                        String mutatedWord = new String(wordChars);

                        if (mutatedWord.equals(endWord)) {
                            return transformationDepth + 1;
                        }

                        // Pruning: Explore if valid and not yet visited (via removal)
                        if (dictionarySet.contains(mutatedWord)) {
                            searchQueue.offer(mutatedWord);
                            dictionarySet.remove(mutatedWord); // Implicit visited mark
                        }
                    }
                    wordChars[pos] = originalChar; // Backtrack mutation
                }
            }
            transformationDepth++;
        }

        return 0; // No valid sequence found
    }
}