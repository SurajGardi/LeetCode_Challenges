//  Day 10 - LeetCode Challenge: Missing Number

class Day10 {

    public int missingNumber(int[] nums) {
        int range = nums.length;  // Length of the array determines the range [0, n]

        // Calculate the expected sum of numbers from 0 to range
        int actualSum = (range * (range + 1)) / 2;

        // Calculate the current sum of numbers in the array
        int currentSum = 0;
        for (int i : nums) {
            currentSum += i;  // Adding each number to currentSum
        }

        // The missing number is the difference between the expected sum and current sum
        int ans = actualSum - currentSum;
        return ans;
    }

    public static void main(String[] args) {
        Day10 solution = new Day10();

        // Test Case 1
        int[] nums1 = {3, 0, 1};
        System.out.println("Missing number: " + solution.missingNumber(nums1));  // Output: 2

        // Test Case 2
        int[] nums2 = {0, 1};
        System.out.println("Missing number: " + solution.missingNumber(nums2));  // Output: 2

        // Test Case 3
        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Missing number: " + solution.missingNumber(nums3));  // Output: 8
    }
}
