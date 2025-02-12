import java.util.HashMap;

public class Day40 {

    // Method to find the length of the longest consecutive sequence
    public int longestConsecutive(int[] nums) {
        // Initialize a HashMap to store each number with a flag indicating if it's a sequence start
        HashMap<Integer, Boolean> hm = new HashMap<>();

        // Add all numbers to the HashMap with default value false
        for (int num : nums) {
            hm.put(num, false);
        }

        // Identify potential starting points of sequences
        for (int key : hm.keySet()) {
            // If the previous number is not in the map, mark current number as a start of sequence
            if (!hm.containsKey(key - 1)) {
                hm.put(key, true);
            }
        }

        int maxLength = 0; // To store the maximum length of consecutive sequences found

        // Iterate through the map to calculate lengths of sequences starting from marked points
        for (int key : hm.keySet()) {
            int currentLength = 1;

            // If the current key is a start of a sequence
            if (hm.get(key)) {
                // Count the length of the sequence
                while (hm.containsKey(key + currentLength)) {
                    currentLength++;
                }
            }

            // Update the maximum length found
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }

    // Main method to test the longestConsecutive function
    public static void main(String[] args) {
        Day40 obj = new Day40();

        // Test Case 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence Length: " + obj.longestConsecutive(nums1));
        // Expected Output: 4

        // Test Case 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Longest Consecutive Sequence Length: " + obj.longestConsecutive(nums2));
        // Expected Output: 9
    }
}
