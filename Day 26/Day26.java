class SearchInsertPosition {

    // Function to find the index of target or insertion position in a sorted array
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        // Perform binary search
        while (start <= end) {
            int mid = (start + end) / 2;

            // If target is found, return the index
            if (nums[mid] == target) {
                return mid;
            }
            // If target is greater, move to the right half
            else if (target > nums[mid]) {
                start = mid + 1;
            }
            // If target is smaller, move to the left half
            else {
                end = mid - 1;
            }
        }

        // If target is not found, return the insertion index (start)
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};  // Sorted input array
        int target = 7;  // Target element to find or insert

        int result = searchInsert(nums, target); // Call the function
        System.out.println("Insert position of target " + target + " is: " + result);
    }
}
