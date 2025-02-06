import java.util.Arrays;
import java.util.Scanner;

public class Day34 {

    /**
     * Increments a large integer represented as an array of digits by one.
     * @param digits An array of non-negative integers representing the number.
     * @return The resulting array of digits after incrementing.
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // If the last digit is not 9, simply increment and return the array.
        if (digits[n - 1] != 9) {
            digits[n - 1] += 1;
            return digits;
        }
        
        // If the last digit is 9, set it to 0 and propagate the carry.
        digits[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            }
            // If current digit is 9, set it to 0 and continue to propagate the carry.
            digits[i] = 0;
        }
        
        // If all digits were 9, we need an extra digit at the front.
        int[] result = new int[n + 1];
        result[0] = 1; // The new most significant digit is 1; the rest are 0 by default.
        return result;
    }

    public static void main(String[] args) {
        Day34 solution = new Day34();
        Scanner scanner = new Scanner(System.in);

        // Input: Number of digits in the array.
        System.out.print("Enter the number of digits: ");
        int n = scanner.nextInt();
        int[] digits = new int[n];

        // Input: The digits of the number (most significant digit first).
        System.out.println("Enter the digits (each separated by a space): ");
        for (int i = 0; i < n; i++) {
            digits[i] = scanner.nextInt();
        }

        // Call the plusOne method and get the result.
        int[] result = solution.plusOne(digits);

        // Output the resulting array.
        System.out.println("Result after plus one: " + Arrays.toString(result));
        scanner.close();
    }
}
