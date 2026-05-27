/*
30. Substring with Concatenation of All Words (Memory Allocation Review - Day 71)

This solution handles a notorious LeetCode Hard by combining Frequency Maps 
with a Multi-Offset Sliding Window. Because all target words are the exact 
same length, we only need to run the sliding window 'wordLen' times. Inside 
each run, the pointers jump by 'wordLen' chunks, achieving an optimal O(N) time.

Senior Twist: Object Allocation Profiling. Instead of instantiating a brand 
new HashMap for every offset loop, we instantiate it once at the top and simply 
call .clear(). This drastically reduces Garbage Collection overhead and memory 
churn in a high-performance Java environment.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        
        // Guard Clause
        if (s == null || s.length() == 0 || words.length == 0) {
            return ans;
        }

        int wordLen = words[0].length();
        int totalWords = words.length;

        // Build the frequency map of our target words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Senior Twist: Allocate the 'seen' map exactly ONCE to prevent memory churn
        Map<String, Integer> seen = new HashMap<>();

        // Try all possible starting offsets (0 up to wordLen - 1)
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int count = 0;
            
            // Clear the reused map for the new offset run
            seen.clear();

            // Move the right pointer by 'wordLen' chunks!
            for (int right = i; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (wordCount.containsKey(word)) {
                    // Valid word found!
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    // If we found too many copies of a valid word, shrink the window from the left
                    while (seen.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // If we found exactly all the words, record the starting index!
                    if (count == totalWords) {
                        ans.add(left);
                        
                        // Shift the window rightward to look for more valid permutations
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    // Invalid word found. Reset the entire window!
                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return ans;
    }
}