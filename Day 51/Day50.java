import java.util.*;

class Day50 {
    // Method to check if all words can be made equal
    public boolean makeEqual(String[] words) {
        int[] frequency = new int[26]; // Array to store the frequency of each letter

        // Count occurrences of each character in all words
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                frequency[ch - 'a']++; // Increment count for the character
            }
        }

        // Check if every character count is divisible by the number of words
        for (int count : frequency) {
            if (count % words.length != 0) {
                return false; // If not evenly distributed, return false
            }
        }

        return true; // If all characters can be evenly distributed, return true
    }

    // Main method to test the function
    public static void main(String[] args) {
        Day50 obj = new Day50();
        
        // Example test cases
        String[] words1 = {"abc", "aabc", "bc"};
        System.out.println("Test 1: " + obj.makeEqual(words1)); // Output: true

        String[] words2 = {"ab", "a"};
        System.out.println("Test 2: " + obj.makeEqual(words2)); // Output: false

        String[] words3 = {"a", "a", "a", "a"};
        System.out.println("Test 3: " + obj.makeEqual(words3)); // Output: true
    }
}
