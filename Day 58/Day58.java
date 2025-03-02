import java.util.Scanner;

class Day58 {
    // Method to generate the spiral matrix
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n]; // Create an n x n matrix
        int count = 1; // Counter to track numbers being inserted
        int minRow = 0, maxRow = n - 1; // Row boundaries
        int minCol = 0, maxCol = n - 1; // Column boundaries

        while (count <= n * n) {
            // Traverse from left to right along minRow
            for (int c = minCol; c <= maxCol; c++) {
                arr[minRow][c] = count++;
            }
            minRow++; // Move the boundary down

            // Traverse from top to bottom along maxCol
            for (int r = minRow; r <= maxRow; r++) {
                arr[r][maxCol] = count++;
            }
            maxCol--; // Move the boundary left

            // Traverse from right to left along maxRow (if still valid)
            if (minRow <= maxRow) {
                for (int c = maxCol; c >= minCol; c--) {
                    arr[maxRow][c] = count++;
                }
                maxRow--; // Move the boundary up
            }

            // Traverse from bottom to top along minCol (if still valid)
            if (minCol <= maxCol) {
                for (int r = maxRow; r >= minRow; r--) {
                    arr[r][minCol] = count++;
                }
                minCol++; // Move the boundary right
            }
        }
        return arr;
    }

    // Method to print the matrix
    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "\t"); // Print each element with tab space
            }
            System.out.println(); // Move to next line after each row
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n = scanner.nextInt(); // Input for matrix size

        Day58 obj = new Day58(); // Create an instance
        int[][] result = obj.generateMatrix(n); // Generate spiral matrix

        System.out.println("Generated Spiral Matrix:");
        obj.printMatrix(result); // Print the result

        scanner.close();
    }
}
