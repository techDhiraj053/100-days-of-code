/*
48. Rotate Image (Single-Pass 4-Way Swap - Day 75)

While the Transpose + Reverse approach is mathematically elegant, it requires 
reading the matrix twice. 

Senior Twist: Single-Pass Layer-by-Layer Rotation.
By setting up boundaries (left, right, top, bottom), we can rotate the matrix 
layer by layer from the outside in. For every step in a layer, we perform a 
simultaneous 4-way swap. We save the top-left value in a temporary variable, 
and then rotate the other three corresponding corners into place, achieving 
the exact same O(1) in-place result in half the total operations!
*/

class Solution {
    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix.length - 1;

        // Process the matrix layer by layer (outside-in)
        while (left < right) {
            int top = left;
            int bottom = right;

            // Iterate through the current layer's elements
            for (int i = 0; i < right - left; i++) {
                
                // 1. Save the top-left element
                int topLeft = matrix[top][left + i];

                // 2. Move bottom-left into top-left
                matrix[top][left + i] = matrix[bottom - i][left];

                // 3. Move bottom-right into bottom-left
                matrix[bottom - i][left] = matrix[bottom][right - i];

                // 4. Move top-right into bottom-right
                matrix[bottom][right - i] = matrix[top + i][right];

                // 5. Move saved top-left into top-right
                matrix[top + i][right] = topLeft;
            }
            
            // Shrink the boundaries to process the next inner layer
            left++;
            right--;
        }
    }
}