import java.util.Scanner;

class Day33 {
    // Method to find the maximum count between positive and negative integers
    public int maximumCount(int[] nums) {
        int lastNegIndex = lastNegative(nums) + 1;  // Count of negative numbers
        int firstPosIndex = nums.length - firstPositive(nums); // Count of positive numbers
        return Math.max(lastNegIndex, firstPosIndex);
    }

    // Binary search to find the last index of a negative number
    public int lastNegative(int[] nums) {
        int start = 0, end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < 0) {
                ans = mid;
                start = mid + 1; // Move right to find last negative
            } else {
                end = mid - 1; // Move left if non-negative
            }
        }
        return ans;
    }

    // Binary search to find the first index of a positive number
    public int firstPositive(int[] nums) {
        int start = 0, end = nums.length - 1;
        int ans = nums.length; // Default to array length if no positive found

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > 0) {
                ans = mid;
                end = mid - 1; // Move left to find first positive
            } else {
                start = mid + 1; // Move right if non-positive
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input for array size
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        // User input for array elements
        System.out.println("Enter the sorted array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Creating an object and calling the method
        Day33 obj = new Day33();
        int result = obj.maximumCount(nums);

        // Displaying the result
        System.out.println("Maximum count of positive or negative numbers: " + result);

        sc.close();
    }
}
