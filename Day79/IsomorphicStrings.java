/*
205. Isomorphic Strings (ASCII Array Index Tracking - Day 79)

This solution verifies if two strings are isomorphic. The standard approach 
uses two HashMaps to ensure a strict 1-to-1 character mapping (bijection).

Senior Twist: Direct-Access ASCII Arrays & Index Tracking.
Because the problem constraints guarantee valid ASCII characters, we can 
completely eliminate the overhead of HashMaps. We use two integer arrays 
of size 256. Instead of mapping the characters to each other, we track their 
'last seen index'. If the characters in the current pair have different index 
signatures, the structural pattern is broken. 
(We use i + 1 so index 0 doesn't conflict with the uninitialized array values).
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Direct-access arrays for all 256 possible ASCII characters
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // If the characters were last seen at different indices, 
            // the 1-to-1 mapping structure is violated.
            if (mapS[c1] != mapT[c2]) {
                return false;
            }

            // Update the last seen index for both characters.
            // We use i + 1 because the default array value is 0.
            mapS[c1] = i + 1;
            mapT[c2] = i + 1;
        }

        return true;
    }
}