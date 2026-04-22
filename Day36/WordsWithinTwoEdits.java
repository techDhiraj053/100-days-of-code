/*
2452. Words Within Two Edits of Dictionary (Declarative Streams - Day 36)

While a traditional nested for-loop approach works perfectly, this solution 
demonstrates modern enterprise architecture using the Java 8+ Stream API. 
By converting the iterative logic into a declarative functional pipeline 
(similar to JavaScript's Array.filter and Array.some), the code becomes 
significantly more expressive, readable, and self-documenting.
*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        // Convert the queries array into a stream and filter it
        return Arrays.stream(queries)
            .filter(query -> 
                // Check if ANY word in the dictionary matches our edit criteria
                Arrays.stream(dictionary).anyMatch(dictWord -> isValid(query, dictWord))
            )
            // Collect the surviving queries back into a List
            .collect(Collectors.toList());
    }

    // Helper method remains imperative for maximum performance
    private boolean isValid(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                // Early exit optimization
                if (diff > 2) return false;
            }
        }
        return true;
    }
}