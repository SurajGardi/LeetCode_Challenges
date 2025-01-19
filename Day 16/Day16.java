class Day16 {
    // Method to find the dominant index
    public int dominantIndex(int[] nums) {
        int max = -1;     // Stores the maximum value
        int smax = -1;    // Stores the second maximum value
        int maxIdx = 0;   // Index of the maximum value

        // Iterate through the array to find max and second max
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                smax = max;    // Update second max
                max = nums[i]; // Update max
                maxIdx = i;    // Update index of max
            } else if (nums[i] > smax) {
                smax = nums[i]; // Update second max
            }
        }

        // Check if the largest number is at least twice the second largest
        return (smax * 2 <= max) ? maxIdx : -1;
    }

    public static void main(String[] args) {
        Day16 day16 = new Day16();

        // Test case 1
        int[] nums1 = {3, 6, 1, 0};
        System.out.println("Dominant index: " + day16.dominantIndex(nums1)); // Output: 1

        // Test case 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Dominant index: " + day16.dominantIndex(nums2)); // Output: -1

        // Test case 3
        int[] nums3 = {0, 0, 3, 6};
        System.out.println("Dominant index: " + day16.dominantIndex(nums3)); // Output: 3
    }
}
