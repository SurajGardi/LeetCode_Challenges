import java.util.Arrays;

class Day60 {
    // Function to rotate the matrix by 90 degrees clockwise
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix (swap rows with columns)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row to complete the 90-degree rotation
        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }
    }

    // Function to reverse a 1D array (used to reverse each row)
    public void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Main method to test the solution
    public static void main(String[] args) {
        Day60 obj = new Day60();
        
        // Example Input
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Rotate the matrix
        obj.rotate(matrix);

        System.out.println("Rotated Matrix:");
        printMatrix(matrix);
    }

    // Utility function to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
