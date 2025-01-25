class Day22 {

    // Function to find the first and last position of the target
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1}; // Default result when target is not found
        if (nums.length == 0) {
            return ans;
        }
        // Find the first and last occurrences
        ans[0] = firstOccurrence(nums, target);
        ans[1] = lastOccurrence(nums, target);
        return ans;
    }

    // Helper function to find the first occurrence of the target
    public int firstOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                ans = mid; // Record the index
                end = mid - 1; // Continue searching in the left half
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    // Helper function to find the last occurrence of the target
    public int lastOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                ans = mid; // Record the index
                start = mid + 1; // Continue searching in the right half
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Day22 obj = new Day22();

        // Test case 1
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = obj.searchRange(nums1, target1);
        System.out.println("Result: [" + result1[0] + ", " + result1[1] + "]"); // Output: [3, 4]

        // Test case 2
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = obj.searchRange(nums2, target2);
        System.out.println("Result: [" + result2[0] + ", " + result2[1] + "]"); // Output: [-1, -1]

        // Test case 3
        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = obj.searchRange(nums3, target3);
        System.out.println("Result: [" + result3[0] + ", " + result3[1] + "]"); // Output: [-1, -1]
    }
}
