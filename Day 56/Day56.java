import java.util.Scanner;

class Day56 { 
    /**
     * Method to calculate the sum of primary and secondary diagonals of a square matrix.
     * Ensures that the middle element in odd-sized matrices is counted only once.
     *
     * @param mat The square matrix.
     * @return The sum of diagonal elements.
     */
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i]; // Primary diagonal element
            if (i != n - 1 - i) { // Avoid double counting the middle element
                sum += mat[i][n - 1 - i]; // Secondary diagonal element
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input matrix size
        System.out.print("Enter the size of the square matrix (n): ");
        int n = sc.nextInt();
        int[][] mat = new int[n][n];

        // Input matrix elements
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        // Creating an instance and calling the method
        Day56 obj = new Day56();
        int result = obj.diagonalSum(mat);

        // Output the diagonal sum
        System.out.println("Diagonal Sum: " + result);

        sc.close();
    }
}
