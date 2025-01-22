public class Day19 {

    // Function to calculate the maximum ascending subarray sum
    public int maxAscendingSum(int[] nums) {
        // Initialize the maximum ascending sum with the first element
        int max = nums[0];
        // Track the current ascending sum
        int currSum = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is greater than the previous, add it to the current sum
            if (nums[i] > nums[i - 1]) {
                currSum += nums[i];
            } else {
                // Update the maximum sum if needed and reset the current sum
                max = Math.max(max, currSum);
                currSum = nums[i];
            }
        }

        // Update the maximum sum one last time after the loop
        max = Math.max(max, currSum);
        return max; // Return the maximum ascending sum
    }

    public static void main(String[] args) {
        Day19 solution = new Day19();

        // Test case 1
        int[] nums1 = {10, 20, 30, 5, 10, 50};
        System.out.println("Maximum Ascending Subarray Sum: " + solution.maxAscendingSum(nums1));
        // Output: 65

        // Test case 2
        int[] nums2 = {10, 20, 30, 40, 50};
        System.out.println("Maximum Ascending Subarray Sum: " + solution.maxAscendingSum(nums2));
        // Output: 150

        // Test case 3
        int[] nums3 = {12, 17, 15, 13, 10, 11, 12};
        System.out.println("Maximum Ascending Subarray Sum: " + solution.maxAscendingSum(nums3));
        // Output: 33
    }
}
