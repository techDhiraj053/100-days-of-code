/*
151. Reverse Words in a String (Regex Elimination - Day 60)

While .split("\\s+") is highly readable, it relies on Java's heavy Regex 
engine and allocates multiple intermediate String arrays. 

Senior Twist: Building directly on the string parsing logic mastered in 
previous problems, this solution utilizes a Right-to-Left Two-Pointer approach. 
By manually skipping spaces and extracting words using index boundaries, we 
completely eliminate the Regex overhead and minimize memory allocations, 
keeping the algorithm incredibly fast and lean.
*/

class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // 1. Skip any trailing spaces (just like Day 58!)
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            
            // If we've hit the beginning of the string, we're done
            if (i < 0) break; 

            // 2. Mark the end of the current word
            int right = i;

            // 3. Move the pointer left until we find the start of the word
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            
            // 4. Append a space before adding the NEXT word (if the builder isn't empty)
            if (ans.length() > 0) {
                ans.append(" ");
            }
            
            // 5. Extract the word using our boundary pointers and append it
            ans.append(s.substring(i + 1, right + 1));
        }

        return ans.toString();
    }
}