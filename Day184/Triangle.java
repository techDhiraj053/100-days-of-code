/*
120. Triangle (Bottom-Up 1D DP - DAY 184!)

This solution finds the minimum path sum from top to bottom.
Time Complexity: O(N^2) where N is the number of rows.
Space Complexity: O(N) using a 1D DP array.

Senior Twist: Immutability & Safe Data Handling.
While it is technically possible to achieve O(1) space by modifying the 
original `List<List<Integer>>` directly, doing so is a major anti-pattern 
in enterprise software. Modifying input collections causes destructive side 
effects. By explicitly allocating a small O(N) array for our DP states, 
we keep our function "pure" and leave the original dataset safely intact.
*/
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int numRows = triangle.size();
        
        // O(N) space array to track the minimum path sum upwards
        int[] minPathDp = new int[numRows];
        
        // Base case: initialize with the bottom row of the triangle
        for (int i = 0; i < numRows; i++) {
            minPathDp[i] = triangle.get(numRows - 1).get(i);
        }
        
        // Build upwards from the second-to-last row to the root
        for (int row = numRows - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                
                // The min path sum at this node is the node's value PLUS 
                // the minimum of its two adjacent children in the row below
                int nodeValue = triangle.get(row).get(col);
                int minChildPath = Math.min(minPathDp[col], minPathDp[col + 1]);
                
                minPathDp[col] = nodeValue + minChildPath;
            }
        }
        
        // The top of our DP array now holds the absolute minimum path sum
        return minPathDp[0];
    }
}