// Class to check if an increasing triplet subsequence exists in an array
public class Day18 {
    
    // Method to check for an increasing triplet subsequence
    public boolean increasingTriplet(int[] nums) {
        // Initialize three variables to track the increasing triplet
        int first = Integer.MAX_VALUE;  // Smallest number
        int second = Integer.MAX_VALUE; // Second smallest number

        // Iterate through the array
        for (int num : nums) {
            if (num <= first) {
                // Update 'first' if the current number is smaller or equal
                first = num;
            } else if (num <= second) {
                // Update 'second' if the current number is greater than 'first' but smaller or equal to 'second'
                second = num;
            } else {
                // If current number is greater than 'first' and 'second', a triplet is found
                return true;
            }
        }

        // Return false if no increasing triplet is found
        return false;
    }

    public static void main(String[] args) {
        // Create an object of the class
        Day18 obj = new Day18();

        // Test case 1
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 1: " + obj.increasingTriplet(nums1)); // Output: true

        // Test case 2
        int[] nums2 = {5, 4, 3, 2, 1};
        System.out.println("Test Case 2: " + obj.increasingTriplet(nums2)); // Output: false

        // Test case 3
        int[] nums3 = {2, 1, 5, 0, 4, 6};
        System.out.println("Test Case 3: " + obj.increasingTriplet(nums3)); // Output: true
    }
}
