import java.util.Scanner;

class Day45 {
    /**
     * Function to find the length of the last word in a given string.
     * @param s Input string consisting of words and spaces.
     * @return Length of the last word.
     */
    public int lengthOfLastWord(String s) {
        int count = 0;

        // Traverse the string from the end
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            // Count characters until a space is encountered after counting a word
            if (ch != ' ') {
                count++;
            } else if (count != 0) {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Creating an object of Day45 class
        Day45 obj = new Day45();

        // Finding and printing the length of the last word
        int result = obj.lengthOfLastWord(input);
        System.out.println("Length of the last word: " + result);

        scanner.close();
    }
}
