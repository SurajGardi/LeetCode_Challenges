import java.util.Arrays;

class Day44 {
    public int numRescueBoats(int[] people, int limit) {
        // Sort the array to efficiently pair the lightest and heaviest person
        Arrays.sort(people);
        int start = 0; // Pointer for the lightest person
        int end = people.length - 1; // Pointer for the heaviest person

        int count = 0; // Counter for the number of boats

        while (start <= end) {
            // If the lightest and heaviest person can share a boat
            if (people[start] + people[end] <= limit) {
                start++; // Move to the next lightest person
                end--;   // Move to the next heaviest person
            } else {
                // If they can't share, the heaviest person goes alone
                end--;
            }
            count++; // A boat is used
        }

        return count; // Return the total number of boats needed
    }

    public static void main(String[] args) {
        Day44 obj = new Day44();

        // Test Case 1
        int[] people1 = {3, 2, 2, 1};
        int limit1 = 3;
        System.out.println("Minimum boats needed: " + obj.numRescueBoats(people1, limit1)); // Output: 3

        // Test Case 2
        int[] people2 = {3, 5, 3, 4};
        int limit2 = 5;
        System.out.println("Minimum boats needed: " + obj.numRescueBoats(people2, limit2)); // Output: 4

        // Test Case 3
        int[] people3 = {1, 2};
        int limit3 = 3;
        System.out.println("Minimum boats needed: " + obj.numRescueBoats(people3, limit3)); // Output: 1
    }
}
