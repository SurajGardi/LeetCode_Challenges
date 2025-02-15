class Day43 {
    // Method to find the pivot index
    public static int pivotIndex(int[] nums) {
        int rsum = 0; // Variable to store the total sum of the array
        for (int ele : nums) {
            rsum += ele; // Calculate the total sum of all elements
        }

        int lsum = 0; // Variable to store the left sum
        for (int i = 0; i < nums.length; i++) {
            rsum -= nums[i]; // Update the right sum by subtracting the current element

            // If left sum equals right sum, return the index as pivot index
            if (lsum == rsum) {
                return i;
            }

            lsum += nums[i]; // Update the left sum by adding the current element
        }
        return -1; // Return -1 if no pivot index is found
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        int[] nums2 = {1, 2, 3};
        int[] nums3 = {2, 1, -1};

        System.out.println("Pivot Index of nums1: " + pivotIndex(nums1)); // Output: 3
        System.out.println("Pivot Index of nums2: " + pivotIndex(nums2)); // Output: -1
        System.out.println("Pivot Index of nums3: " + pivotIndex(nums3)); // Output: 0
    }
}
