import java.util.Stack;

public class Day49 {
    
    // Function to decode the given encoded string
    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>(); // Stack to store numbers (repetition count)
        Stack<String> mainStack = new Stack<>();    // Stack to store characters and substrings

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If the character is a digit, extract the full number
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0'); // Convert character to integer
                    i++;
                }
                i--; // Adjust index after loop
                numberStack.push(num); // Push the extracted number onto stack

            } else if (ch != ']') {
                // If not a closing bracket, push the character onto mainStack
                mainStack.push(String.valueOf(ch));

            } else { 
                // If we encounter ']', pop characters until we find '['
                StringBuilder str = new StringBuilder();
                while (!mainStack.peek().equals("[")) {
                    str.insert(0, mainStack.pop()); // Build the substring in correct order
                }
                mainStack.pop(); // Remove '[' from stack

                // Get the repetition count from numberStack
                int repeatCount = numberStack.pop();
                StringBuilder repeatedStr = new StringBuilder();

                // Repeat the extracted substring
                while (repeatCount > 0) {
                    repeatedStr.append(str);
                    repeatCount--;
                }

                // Push the expanded substring back onto the stack
                mainStack.push(repeatedStr.toString());
            }
        }

        // Construct the final decoded string from the stack
        StringBuilder result = new StringBuilder();
        while (!mainStack.isEmpty()) {
            result.insert(0, mainStack.pop());
        }
        return result.toString();
    }

    // Main method to test the function
    public static void main(String[] args) {
        Day49 obj = new Day49();
        
        // Test cases
        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "2[abc]3[cd]ef";

        // Printing results
        System.out.println("Decoded String for '" + s1 + "' -> " + obj.decodeString(s1)); // Expected: "aaabcbc"
        System.out.println("Decoded String for '" + s2 + "' -> " + obj.decodeString(s2)); // Expected: "accaccacc"
        System.out.println("Decoded String for '" + s3 + "' -> " + obj.decodeString(s3)); // Expected: "abcabccdcdcdef"
    }
}
