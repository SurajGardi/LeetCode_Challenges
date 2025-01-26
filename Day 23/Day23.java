import java.util.Scanner;

class Day23 {
    // Function to search the target in a rotated sorted array
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            // Check if mid is the target
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the first part is sorted
            if (nums[start] <= nums[mid]) {
                // Target lies within the sorted part
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else { // Move to the unsorted part
                    start = mid + 1;
                }
            } else { // Second part is sorted
                // Target lies within the sorted part
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else { // Move to the unsorted part
                    end = mid - 1;
                }
            }
        }
        // Return -1 if target is not found
        return -1;
    }

    public static void main(String[] args) {
        Day23 obj = new Day23();
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        // Input array elements
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input target value
        System.out.print("Enter the target value: ");
        int target = sc.nextInt();

        // Call the search function and print the result
        int result = obj.search(nums, target);
        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found in the array.");
        }

        sc.close();
    }
}
