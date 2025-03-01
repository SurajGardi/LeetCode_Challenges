import java.util.Arrays;

class Day57 {
    // Method to compute the transpose of a matrix
    public static int[][] transpose(int[][] matrix) {
        int row = matrix.length;  // Number of rows
        int col = matrix[0].length;  // Number of columns

        // Create a new matrix with swapped dimensions
        int[][] ans = new int[col][row];

        // Iterate through the original matrix
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[j][i] = matrix[i][j];  // Swap rows and columns
            }
        }
        return ans;
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Example input matrix
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Get the transposed matrix
        int[][] result = transpose(matrix);

        // Print the transposed matrix
        System.out.println("Transposed Matrix:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
