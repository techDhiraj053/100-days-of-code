/*
3464. Maximize the Distance Between Points on a Square (Hard - Day 39)

Algorithm Strategy:
1. Perimeter Unfolding: Convert the 2D (x,y) coordinates into a 1D distance 
   along the perimeter of the square. 
2. Circular Array Simulation: Duplicate the 1D array (arr[i] + perimeter) 
   to seamlessly handle distance calculations that wrap around the corners.
3. Binary Search on Answer: Binary search the maximum possible minimum distance. 
   For each 'mid' guess, use a greedy approach with a secondary binary search 
   (lowerBound) to verify if 'k' points can be placed with at least 'mid' gap.
*/

import java.util.*;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] arr = new long[n];

        // Phase 1: Flatten the 2D perimeter into a 1D line segment
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];

            if (y == 0) arr[i] = x;                               // Bottom edge
            else if (x == side) arr[i] = side + y;                // Right edge
            else if (y == side) arr[i] = 3L * side - x;           // Top edge
            else arr[i] = 4L * side - y;                          // Left edge
        }

        Arrays.sort(arr);
        long perimeter = 4L * side;

        // Phase 2: Duplicate the array to handle circular wrapping
        long[] extended = new long[2 * n];
        for (int i = 0; i < n; i++) {
            extended[i] = arr[i];
            extended[i + n] = arr[i] + perimeter;
        }

        // Phase 3: Binary Search on the maximum possible minimum distance
        long left = 0, right = perimeter;
        while (left < right) {
            long mid = (left + right + 1) / 2;

            if (canPlace(extended, n, k, mid, perimeter)) {
                left = mid; // We can place them, try a larger distance
            } else {
                right = mid - 1; // Distance is too large, scale back
            }
        }

        return (int) left;
    }

    /**
     * Greedily checks if we can pick k points with a minimum distance >= dist
     */
    private boolean canPlace(long[] arr, int n, int k, long dist, long perimeter) {
        // Try starting the sequence from every possible point in the original array
        for (int start = 0; start < n; start++) {
            int count = 1;
            long first = arr[start];
            long last = arr[start];
            int idx = start;

            // Greedily find the next valid point that satisfies the 'dist' gap
            while (count < k) {
                int next = lowerBound(arr, idx + 1, start + n, last + dist);
                
                // If we run out of bounds before finding a valid point, break
                if (next == start + n) break;

                last = arr[next];
                idx = next;
                count++;
            }

            // Verify the circular wrap-around gap between the last point and the first point
            if (count == k && first + perimeter - last >= dist) {
                return true;
            }
        }
        return false;
    }

    /**
     * Helper Method: Custom Binary Search to find the first index >= target
     */
    private int lowerBound(long[] arr, int l, int r, long target) {
        int ans = r;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}