import java.util.Stack;

public class Day46 { 
    public static String removeDuplicateLetters(String s) {
        // Array to store the last index of each character in the string
        int[] lastIndex = new int[26];

        // Fill the lastIndex array with the last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            lastIndex[idx] = i;
        }

        // Boolean array to track if a character is already in the result
        boolean[] present = new boolean[26];

        // Stack to store the result characters in lexicographical order
        Stack<Character> stack = new Stack<>();

        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';

            // If the character is already in the stack, skip it
            if (!present[idx]) {
                // Remove characters from stack if they are greater than current character
                // and they appear later in the string
                while (!stack.isEmpty() && stack.peek() > ch && lastIndex[stack.peek() - 'a'] > i) {
                    present[stack.pop() - 'a'] = false;
                }

                // Push current character into the stack
                stack.push(ch);
                present[idx] = true; // Mark character as present in stack
            }
        }

        // Build the result string from stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString(); // Reverse to get the correct order
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test cases
        String s1 = "bcabc";
        String s2 = "cbacdcbc";

        // Output results
        System.out.println("Output for \"" + s1 + "\": " + removeDuplicateLetters(s1)); // Expected: "abc"
        System.out.println("Output for \"" + s2 + "\": " + removeDuplicateLetters(s2)); // Expected: "acdb"
    }
}
