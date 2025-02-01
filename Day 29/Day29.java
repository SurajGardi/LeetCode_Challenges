class MaximumSubarray {
    // Function to find the maximum sum of a subarray using Kadane's Algorithm
    public int maxSubArray(int[] nums) {
        int currSum = nums[0]; // Stores the current subarray sum
        int maxSum = nums[0];  // Stores the maximum subarray sum found so far

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to add the current element to the existing subarray or start a new subarray
            currSum = Math.max(nums[i], currSum + nums[i]);
            // Update maxSum if a new maximum is found
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray obj = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Maximum Subarray Sum: " + obj.maxSubArray(nums));
    }
}
