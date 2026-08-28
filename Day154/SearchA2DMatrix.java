/*
74. Search a 2D Matrix (Virtual 1D Array Binary Search - DAY 154!)

This solution finds a target in a strictly sorted 2D matrix in O(log(M * N)) time 
and O(1) space by mathematically mapping it to a 1D array.

Senior Twist: Semantic Index Mapping.
By explicitly defining `cols` and using it to map a `virtualMidIndex` back to 
2D `row` and `col` coordinates, the logic mirrors low-level hardware memory 
addressing. A fast-fail guard clause protects against edge cases like empty matrices.
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Fast-fail: guard against null or empty grids
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Treat the 2D matrix as a virtual flattened 1D array
        int virtualLeft = 0;
        int virtualRight = (rows * cols) - 1;

        while (virtualLeft <= virtualRight) {
            int virtualMidIndex = virtualLeft + (virtualRight - virtualLeft) / 2;

            // Map the 1D index back to 2D matrix coordinates
            int row = virtualMidIndex / cols;
            int col = virtualMidIndex % cols;
            int midValue = matrix[row][col];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                virtualLeft = virtualMidIndex + 1;
            } else {
                virtualRight = virtualMidIndex - 1;
            }
        }

        return false;
    }
}