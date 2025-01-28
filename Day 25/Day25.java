import java.util.Scanner;

public class Day25 {

    // Function to find the index of a peak element
    public int findPeakElement(int[] nums) {
        // If the array has only one element, it is the peak
        if (nums.length == 1) {
            return 0;
        }

        // If the first element is greater than the second, it is a peak
        if (nums[0] > nums[1]) {
            return 0;
        }

        // If the last element is greater than the second last, it is a peak
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        // Binary search for the peak element in the middle of the array
        int start = 1;
        int end = nums.length - 2; // Ignore the first and last elements (already checked)
        while (start <= end) {
            int mid = start + (end - start) / 2; // Avoid overflow

            // Check if the current element is a peak
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // If the right neighbor is greater, move to the right half
            else if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            }
            // Otherwise, move to the left half
            else {
                end = mid - 1;
            }
        }

        // Return -1 if no peak is found (should not happen for valid input)
        return -1;
    }

    public static void main(String[] args) {
        Day25 solution = new Day25();
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

        // Input: elements of the array
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Find and display the index of a peak element
        int peakIndex = solution.findPeakElement(nums);
        System.out.println("The index of a peak element is: " + peakIndex);
        System.out.println("The peak element is: " + nums[peakIndex]);

        scanner.close();
    }
}
