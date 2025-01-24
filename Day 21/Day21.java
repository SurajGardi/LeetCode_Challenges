class Day21 {

    // Function to perform binary search
    public int search(int[] nums, int target) {
        int start = 0; // Start index of the array
        int end = nums.length - 1; // End index of the array

        // Loop until the search range is valid
        while (start <= end) {
            int mid = (start + end) / 2; // Calculate the middle index

            // If target is found, return the index
            if (nums[mid] == target) {
                return mid;
            } 
            // If target is greater, search in the right half
            else if (target > nums[mid]) {
                start = mid + 1;
            } 
            // If target is smaller, search in the left half
            else {
                end = mid - 1;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        Day21 obj = new Day21();

        // Example 1
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        System.out.println("Index of " + target1 + ": " + obj.search(nums1, target1)); // Output: 4

        // Example 2
        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        int target2 = 2;
        System.out.println("Index of " + target2 + ": " + obj.search(nums2, target2)); // Output: -1
    }
}
