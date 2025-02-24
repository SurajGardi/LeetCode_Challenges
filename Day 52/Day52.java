import java.util.Scanner;

class Day52 {
    // Method to check if a given string is a valid palindrome
    public boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

        StringBuilder sb = new StringBuilder("");

        // Step 1: Process the string to keep only alphanumeric characters and convert to lowercase
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') { 
                sb.append(ch);  // Append lowercase letters as is
            } 
            else if (ch >= 'A' && ch <= 'Z') {
                sb.append((char) (ch - 'A' + 'a')); // Convert uppercase to lowercase
            } 
            else if (ch >= '0' && ch <= '9') {
                sb.append(ch);  // Append numeric characters
            }
        }

        // Step 2: Use two-pointer technique to check for palindrome
        int start = 0;
        int end = sb.length() - 1;

        while (start < end) {
            if (sb.charAt(start) != sb.charAt(end)) {
                return false; // If mismatch found, it's not a palindrome
            }
            start++;
            end--;
        }

        return true; // String is a palindrome
    }

    // Main method for testing the function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        Day52 obj = new Day52();
        boolean result = obj.isPalindrome(input);

        System.out.println("Is the given string a palindrome? " + result);
        
        scanner.close();
    }
}
