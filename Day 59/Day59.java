class Day59 { 
    // Function to search for the target in the 2D matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;  // Start from the first row
        int col = matrix[0].length - 1;  // Start from the last column

        // Traverse the matrix within its boundaries
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true; // Target found
            } else if (matrix[row][col] > target) {
                col--; // Move left if the current value is greater than the target
            } else {
                row++; // Move down if the current value is smaller than the target
            }
        }
        return false; // Target not found
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;

        // Call the searchMatrix function and print the result
        if (searchMatrix(matrix, target)) {
            System.out.println("Target " + target + " found in the matrix.");
        } else {
            System.out.println("Target " + target + " not found in the matrix.");
        }
    }
}
