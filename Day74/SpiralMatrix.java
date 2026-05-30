/*
54. Spiral Matrix (Memory Pre-allocation Optimization - Day 74)

This solution utilizes the optimal 4-Pointer Boundary method. By tracking 
the top, bottom, left, and right walls of the matrix and shrinking them 
inward after traversing each edge, we safely extract the spiral order in 
O(M * N) time. The inner boundary checks prevent duplicate processing in 
non-square matrices.

Senior Twist: Memory Capacity Pre-allocation. 
Since we know the exact number of elements the matrix holds (rows * cols), 
we initialize the ArrayList with this exact capacity. This prevents the 
underlying array from dynamically resizing and copying data in memory, 
resulting in faster execution and reduced Garbage Collection overhead.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Fast-fail guard clause for empty inputs
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Senior Twist: Pre-allocate the exact required memory!
        List<Integer> ans = new ArrayList<>(rows * cols);
        
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse from Left to Right along the Top boundary
            for (int col = left; col <= right; col++) {
                ans.add(matrix[top][col]);
            }
            top++; // Shrink the top wall downward
            
            // Traverse from Top to Bottom along the Right boundary
            for (int row = top; row <= bottom; row++) {
                ans.add(matrix[row][right]);
            }
            right--; // Shrink the right wall leftward
            
            // Traverse from Right to Left along the Bottom boundary
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    ans.add(matrix[bottom][col]);
                }
                bottom--; // Shrink the bottom wall upward
            }
            
            // Traverse from Bottom to Top along the Left boundary
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    ans.add(matrix[row][left]);
                }
                left++; // Shrink the left wall rightward
            }
        }
        
        return ans;
    }
}