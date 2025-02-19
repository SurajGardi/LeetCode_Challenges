import java.util.Scanner;

class Day47 {
    /**
     * Method to reverse the words in a given string.
     * @param s The input string containing words and spaces.
     * @return A string with words in reverse order and proper spacing.
     */
    public static String reverseWords(String s) {
        // Split the string based on one or more spaces (\\s+ ensures multiple spaces are ignored)
        String[] words = s.trim().split("\\s+"); 

        // Use StringBuilder to efficiently build the reversed sentence
        StringBuilder sb = new StringBuilder();

        // Traverse the words array in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" "); // Append each word followed by a space
        }

        // Trim the final result to remove the trailing space and return
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Take input string from user
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();

        // Call the function and print the result
        String result = reverseWords(input);
        System.out.println("Reversed Words String: " + result);

        // Close scanner
        scanner.close();
    }
}
