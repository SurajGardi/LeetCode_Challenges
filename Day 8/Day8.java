
class Day8 {
    public static int maxProduct(int[] nums) {
        // Initialize max and second max values
        int max = -1;
        int smax = -1;

        // Find the two largest numbers in the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                smax = max;
                max = nums[i];
            } else if (nums[i] > smax) {
                smax = nums[i];
            }
        }

        // Calculate the result using the formula (max-1) * (smax-1)
        return (max - 1) * (smax - 1);
    }

    public static void main(String[] args) {
        // Example inputs
        int[] nums1 = {3, 4, 5, 2};
        int[] nums2 = {1, 5, 4, 5};
        int[] nums3 = {3, 7};

        // Print outputs
        System.out.println("Output 1: " + maxProduct(nums1));  // Output: 12
        System.out.println("Output 2: " + maxProduct(nums2));  // Output: 16
        System.out.println("Output 3: " + maxProduct(nums3));  // Output: 12
    }
}
