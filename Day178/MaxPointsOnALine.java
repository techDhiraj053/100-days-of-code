/*
149. Max Points on a Line (GCD Slope Grouping - DAY 178!)

This solution finds the maximum number of collinear points in O(N^2) time 
by grouping points that share the exact same normalized directional vector.

Senior Twist: Bitwise Key Packing (Zero Allocation Hashing).
Using `dx + "/" + dy` as a String key in an O(N^2) loop creates massive Garbage 
Collection overhead. Since coordinate differences are bounded, we can pack both 
32-bit integers into a single 64-bit `long` primitive using bitwise shifting 
(`<< 32`) and masking (`& 0xFFFFFFFFL`). This completely eliminates object 
allocation overhead and accelerates hash lookups significantly.
*/
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }

        int maxPointsOnLine = 0;

        for (int i = 0; i < n; i++) {
            // Map stores the packed 64-bit vector and its frequency
            Map<Long, Integer> slopeMap = new HashMap<>();
            int currentMax = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // Normalize the directional vector
                if (dx == 0) {
                    dy = 1;
                } else if (dy == 0) {
                    dx = 1;
                } else {
                    // Force a consistent sign representation
                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }
                    int gcd = gcd(Math.abs(dx), Math.abs(dy));
                    dx /= gcd;
                    dy /= gcd;
                }

                // Pack dx (top 32 bits) and dy (bottom 32 bits) into a long
                // We mask dy with 0xFFFFFFFFL to prevent sign extension of negative numbers
                long packedSlopeKey = (((long) dx) << 32) | (dy & 0xFFFFFFFFL);

                slopeMap.put(packedSlopeKey, slopeMap.getOrDefault(packedSlopeKey, 0) + 1);
                currentMax = Math.max(currentMax, slopeMap.get(packedSlopeKey));
            }

            // Include the anchor point itself (+1)
            maxPointsOnLine = Math.max(maxPointsOnLine, currentMax + 1);
        }

        return maxPointsOnLine;
    }

    // Iterative GCD for optimal performance
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}