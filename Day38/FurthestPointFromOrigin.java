/*
2833. Furthest Point From Origin (Space Optimization Review - Day 38)

This solution utilizes an optimal greedy mathematical approach. 
To make it production-ready, it avoids the common pitfall of using 
String.toCharArray(). Instead of allocating a brand new O(N) character 
array in memory to iterate over, this solution uses String.charAt(i), 
keeping the space complexity strictly at O(1).
*/

class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0;
        int right = 0;
        int blank = 0;

        // Iterate using .charAt(i) to prevent O(N) memory allocation overhead
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            
            if (c == 'L') {
                left++;
            } else if (c == 'R') {
                right++;
            } else {
                blank++;
            }
        }

        // The furthest distance is the absolute difference of forced moves,
        // plus all blank spaces acting in that "winning" direction.
        return Math.abs(right - left) + blank;
    }
}