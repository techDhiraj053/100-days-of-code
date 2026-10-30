/*
74. Search a 2D Matrix (1D Flattened Binary Search - DAY 209!)

This solution finds a target in a strictly sorted 2D matrix.
Time Complexity: O(log(M * N)) using a single binary search.
Space Complexity: O(1).

Senior Twist: Mathematical Matrix Flattening & Overflow Protection.
Instead of running two separate binary searches (one for the row, one for the col), 
we mathematically treat the entire M x N matrix as a single, flattened 1D array.
By setting `right = m * n - 1`, we can dynamically map the 1D `mid` index back 
to 2D coordinates using division (`mid / n`) and modulo (`mid % n`). 
Combined with the `>>> 1` unsigned bitwise shift for overflow-safe mid calculation, 
this is the absolute optimal way to traverse the matrix!
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            // Enterprise standard unsigned bitwise shift for safe mid calculation
            int mid = (left + right) >>> 1;
            
            // Map 1D index back to 2D matrix coordinates
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } 
            else if (matrix[row][col] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return false;
    }
}