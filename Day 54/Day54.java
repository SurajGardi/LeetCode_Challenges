import java.util.Stack;

class Day54 {  
    public int minAddToMakeValid(String s) {
        // Stack to store open brackets
        Stack<Character> st = new Stack<>();

        // Count to track extra closing brackets
        int count = 0;

        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // Push open brackets to the stack
                st.push(ch);
            } else if (!st.isEmpty() && st.peek() == '(') {
                // If there's a matching open bracket, pop it
                st.pop();
            } else {
                // Unmatched closing bracket increases count
                count++;
            }
        }

        // Remaining open brackets in the stack also need closing
        return st.size() + count;
    }

    public static void main(String[] args) {
        Day54 obj = new Day54();
        
        // Test cases
        String s1 = "())";
        System.out.println("Input: " + s1 + " | Output: " + obj.minAddToMakeValid(s1)); // Output: 1

        String s2 = "(((";
        System.out.println("Input: " + s2 + " | Output: " + obj.minAddToMakeValid(s2)); // Output: 3

        String s3 = "()";
        System.out.println("Input: " + s3 + " | Output: " + obj.minAddToMakeValid(s3)); // Output: 0

        String s4 = "()))((";
        System.out.println("Input: " + s4 + " | Output: " + obj.minAddToMakeValid(s4)); // Output: 4
    }
}
