/*
290. Word Pattern (Heterogeneous Map Optimization - Day 80)

This solution validates a strict bijection between a pattern and a string.

Senior Twist: Single Heterogeneous Map & Return Value Tracking.
Instead of using two separate maps, we use a single Map<Object, Integer>. 
Because Character and String are different object types, their keys will 
never collide in the map. Furthermore, Map.put() returns the PREVIOUS 
value associated with a key. By putting both the character and the word 
into the map, we can assert that they must return the exact same previous 
index to maintain the bijection!

Note: We must use Objects.equals() to compare the returned Integers to 
avoid memory reference issues with Java's Integer cache.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        // Fast-fail guard clause
        if (words.length != pattern.length()) {
            return false;
        }

        // A single map to hold both Character and String keys
        Map<Object, Integer> indexMap = new HashMap<>();

        // We use Integer here instead of int so the autoboxing matches the Map's signature
        for (Integer i = 0; i < words.length; i++) {
            
            // Map.put() returns the PREVIOUS index. 
            // If the pattern holds, both keys should yield the exact same history.
            if (!Objects.equals(indexMap.put(pattern.charAt(i), i), indexMap.put(words[i], i))) {
                return false;
            }
        }

        return true;
    }
}