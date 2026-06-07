/*
49. Group Anagrams (Frequency Signature & Idiomatic Java - Day 82)

The standard approach uses sorting to generate a universal key for anagrams, 
yielding an O(N * K log K) time complexity.

Senior Twist: Frequency Array Signature & Idiomatic HashMaps.
Because the inputs are strictly lowercase English letters, we can map the 
character frequencies into an array of size 26. We then serialize this array 
into a String to use as our HashMap key. This completely eliminates the sorting 
overhead, bringing the time complexity down to a highly optimal O(N * K).
Furthermore, we use Java's .computeIfAbsent() to elegantly handle missing 
keys without explicit if-statements.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Fast-fail guard clause
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Build a frequency array instead of sorting the string
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }

            // Serialize the array to a string to act as our universal signature key
            String key = Arrays.toString(count);

            // Idiomatic Java 8+: If the key doesn't exist, create a new ArrayList, 
            // then immediately add the string to the list.
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        // Return the grouped values
        return new ArrayList<>(map.values());
    }
}