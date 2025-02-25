import java.util.Stack;

class Day53 {  
    /**
     * Checks if the given string has valid parentheses.
     * @param s The input string containing only '(', ')', '{', '}', '[' and ']'.
     * @return True if the string is valid, otherwise false.
     */
    public boolean isValid(String s) {
        // Stack to store opening brackets
        Stack<Character> st = new Stack<>();

        // Traverse the string character by character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Push opening brackets onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            // Check for valid closing brackets and match with top of stack
            else if (!st.isEmpty() && ch == ')' && st.peek() == '(') {
                st.pop();
            } else if (!st.isEmpty() && ch == '}' && st.peek() == '{') {
                st.pop();
            } else if (!st.isEmpty() && ch == ']' && st.peek() == '[') {
                st.pop();
            } else {
                // If no match is found, return false
                return false;
            }
        }

        // If the stack is empty, all brackets are matched correctly
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Day53 solution = new Day53();

        // Test cases
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([])";

        // Checking the function outputs
        System.out.println("Input: " + s1 + " | Output: " + solution.isValid(s1)); // true
        System.out.println("Input: " + s2 + " | Output: " + solution.isValid(s2)); // true
        System.out.println("Input: " + s3 + " | Output: " + solution.isValid(s3)); // false
        System.out.println("Input: " + s4 + " | Output: " + solution.isValid(s4)); // true
    }
}
