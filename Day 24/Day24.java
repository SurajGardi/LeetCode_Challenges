import java.util.Scanner;

public class Day24 {

    // Function to find the minimum element in a rotated sorted array
    public int findMin(int[] nums) {
        // If the array has only one element, return it
        if (nums.length == 1) {
            return nums[0];
        }

        // If the array is not rotated, the first element is the minimum
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        // Initialize pointers for binary search
        int start = 0;
        int end = nums.length - 1;

        // Binary search to find the pivot point (minimum element)
        while (start <= end) {
            int mid = start + (end - start) / 2; // Avoid overflow with this formula

            // Check if mid is the pivot point
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            // Check if mid + 1 is the pivot point
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            // If the left side is sorted, move to the right side
            if (nums[start] <= nums[mid]) {
                start = mid + 1;
            }
            // If the right side is sorted, move to the left side
            else {
                end = mid - 1;
            }
        }

        // If no pivot is found, return -1 (should not happen for valid input)
        return -1;
    }

    public static void main(String[] args) {
        Day24 solution = new Day24();
        Scanner scanner = new Scanner(System.in);

        // Input: size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Validate the input size
        if (n <= 0) {
            System.out.println("Array size must be greater than 0.");
            return;
        }

        int[] nums = new int[n];

        // Input: elements of the rotated sorted array
        System.out.println("Enter the elements of the rotated sorted array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Find and display the minimum element
        int result = solution.findMin(nums);
        System.out.println("The minimum element in the array is: " + result);

        scanner.close();
    }
}
