/*
427. Construct Quad Tree (Divide and Conquer - DAY 149!)

This solution constructs a Quad-Tree from a 2D matrix by recursively dividing 
the grid into four quadrants.

Senior Twist: Single Responsibility Principle & Semantic Naming.
By extracting the uniformity check into its own private method (`isUniformRegion`), 
the main `constructTree` method becomes a pure expression of the Divide and Conquer 
algorithm. This makes the spatial subdivision logic vastly easier to read and maintain.
*/
class Solution {
    public Node construct(int[][] grid) {
        return constructTree(grid, 0, 0, grid.length);
    }

    private Node constructTree(int[][] grid, int row, int col, int size) {
        // Base Condition: If the region is uniform, compress it into a leaf node
        if (isUniformRegion(grid, row, col, size)) {
            boolean nodeValue = (grid[row][col] == 1);
            return new Node(nodeValue, true);
        }

        // Divide: Split the region into 4 sub-quadrants
        int halfSize = size / 2;

        // Conquer: Recursively process each quadrant
        Node topLeftNode = constructTree(grid, row, col, halfSize);
        Node topRightNode = constructTree(grid, row, col + halfSize, halfSize);
        Node bottomLeftNode = constructTree(grid, row + halfSize, col, halfSize);
        Node bottomRightNode = constructTree(grid, row + halfSize, col + halfSize, halfSize);

        // Combine: Link the 4 sub-trees to an internal routing node
        return new Node(
            true, // Value doesn't matter for internal nodes
            false, // isLeaf is false
            topLeftNode, 
            topRightNode, 
            bottomLeftNode, 
            bottomRightNode
        );
    }

    /**
     * Helper method to determine if a specific sub-grid contains only identical values.
     */
    private boolean isUniformRegion(int[][] grid, int startRow, int startCol, int size) {
        int referenceValue = grid[startRow][startCol];

        for (int r = startRow; r < startRow + size; r++) {
            for (int c = startCol; c < startCol + size; c++) {
                if (grid[r][c] != referenceValue) {
                    return false;
                }
            }
        }

        return true;
    }
}