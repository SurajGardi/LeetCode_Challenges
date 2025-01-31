class SortColors {
    // Function to sort the array in-place using the Dutch National Flag Algorithm
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid); // Swap 0 to the beginning
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++; // 1 is already in the correct position
            } else {
                swap(nums, mid, high); // Swap 2 to the end
                high--;
            }
        }
    }

    // Utility function to swap two elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Main method to test the function
    public static void main(String[] args) {
        SortColors obj = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};

        System.out.println("Before Sorting:");
        printArray(nums);

        obj.sortColors(nums); // Sort the array

        System.out.println("After Sorting:");
        printArray(nums);
    }

    // Helper function to print the array
    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
