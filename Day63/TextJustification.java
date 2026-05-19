/*
68. Text Justification (Memory Pre-allocation Review - Day 63)

This solution elegantly handles one of LeetCode's most notoriously tedious 
string manipulation problems. By using a greedy approach, it accurately packs 
words and calculates the exact base spaces and leftover spaces using modulo 
arithmetic (totalSpaces % gaps).

Senior Twist: Building on previous lessons, we optimize the memory footprint 
of this algorithm. Since the problem strictly requires every single line to 
be exactly 'maxWidth' characters long, we initialize our StringBuilder with 
that exact capacity: `new StringBuilder(maxWidth)`. This completely prevents 
the underlying character arrays from resizing while appending words and spaces!
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i;
            int lineLength = 0;

            // Find how many words can fit in current line
            while (j < words.length && lineLength + words[j].length() + (j - i) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            
            // Senior Twist: Pre-allocate the exact required memory!
            StringBuilder line = new StringBuilder(maxWidth);

            // CASE 1: Last line OR only one word
            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k != j - 1) {
                        line.append(" ");
                    }
                }
                
                // Fill remaining spaces at end
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            }
            // CASE 2: Normal fully-justified line
            else {
                int totalSpaces = maxWidth - lineLength;
                int eachSpace = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    
                    if (k != j - 1) {
                        // Minimum spaces
                        for (int s = 0; s < eachSpace; s++) {
                            line.append(" ");
                        }
                        
                        // Extra spaces go to left gaps
                        if (extraSpaces > 0) {
                            line.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}