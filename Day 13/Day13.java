public class Day13 {
    // Method to find two numbers that add up to the target
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];  // Array to store the result indices
        int start = 0;  // Pointer at the beginning
        int end = numbers.length - 1;  // Pointer at the end

        // Iterate until pointers meet
        while (start < end) {
            int sum = numbers[start] + numbers[end];  // Calculate sum of two numbers

            if (sum == target) {
                ans[0] = start + 1;  // Convert to 1-indexed
                ans[1] = end + 1;
                return ans;
            } else if (sum > target) {
                end--;  // Move the end pointer left if sum is too large
            } else {
                start++;  // Move the start pointer right if sum is too small
            }
        }
        return ans;  // Return result
    }

    public static void main(String[] args) {
        Day13 obj = new Day13();
        int[] numbers = {2, 7, 11, 15};  // Example input
        int target = 9;

        // Call the method and get the result
        int[] result = obj.twoSum(numbers, target);

        // Print the result
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
