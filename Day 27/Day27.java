class SingleElementInSortedArray {

    // Function to find the single non-duplicate element in a sorted array
    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        // If array has only one element, return that element
        if (nums.length == 1) {
            return nums[0];
        }
        // Check if the first element is unique
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        // Check if the last element is unique
        if (nums[end] != nums[end - 1]) {
            return nums[end];
        }

        // Perform binary search
        while (start <= end) {
            int mid = (start + end) / 2;

            // If mid element is unique, return it
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // Determine which side to search
            if (mid % 2 == 1) {  // If mid is an odd index
                if (nums[mid] == nums[mid - 1]) {
                    start = mid + 1;  // Move to the right half
                } else {
                    end = mid - 1;    // Move to the left half
                }
            } else {  // If mid is an even index
                if (nums[mid] == nums[mid + 1]) {
                    start = mid + 1;  // Move to the right half
                } else {
                    end = mid - 1;    // Move to the left half
                }
            }
        }

        return -1;  // This should never be reached
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};  // Sorted input array with one unique element
        int result = singleNonDuplicate(nums);  // Call the function
        System.out.println("The single non-duplicate element is: " + result);
    }
}
