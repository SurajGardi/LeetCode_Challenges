import java.util.Arrays;

class Day41 {
    public int findDuplicate(int[] nums) {
        int ans = 0;

        // Traverse the array to mark visited elements
        for (int i = 0; i < nums.length; i++) {
            int ele = Math.abs(nums[i]); // Get the absolute value

            // If nums[ele] is already negative, we found the duplicate
            if (nums[ele] < 0) {
                ans = ele;
                break;
            } else {
                nums[ele] = -nums[ele]; // Mark it as visited by making it negative
            }
        }

        // Restore the original array (optional, to avoid modifying input)
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Day41 obj = new Day41();

        // Test cases
        int[] nums1 = {1, 3, 4, 2, 2};
        int[] nums2 = {3, 1, 3, 4, 2};
        int[] nums3 = {3, 3, 3, 3, 3};

        System.out.println("Duplicate in nums1: " + obj.findDuplicate(Arrays.copyOf(nums1, nums1.length)));
        System.out.println("Duplicate in nums2: " + obj.findDuplicate(Arrays.copyOf(nums2, nums2.length)));
        System.out.println("Duplicate in nums3: " + obj.findDuplicate(Arrays.copyOf(nums3, nums3.length)));
    }
}
