import java.util.Scanner;

class Day51 {
    /**
     * Finds the power of a string, which is the length of the longest contiguous substring 
     * containing only one unique character.
     * 
     * @param s Input string consisting of lowercase English letters.
     * @return The maximum length of a contiguous substring with the same character.
     */
    public static int maxPower(String s) {
        int max = 1; // To track the maximum length of consecutive characters
        int count = 1; // To count occurrences of the current consecutive character

        // Traverse the string starting from the second character
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);   // Current character
            char prev = s.charAt(i - 1); // Previous character

            if (curr == prev) { 
                count++; // Increase count if current character is same as previous
            } else {
                max = Math.max(max, count); // Update max if new character is found
                count = 1; // Reset count for new character
            }
        }

        // Final check to update max (in case the longest substring is at the end)
        max = Math.max(max, count);
        return max;
    }

    public static void main(String[] args) {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine(); // Read input string

        // Call the function and print the result
        int result = maxPower(input);
        System.out.println("The power of the string is: " + result);

        scanner.close();
    }
}
