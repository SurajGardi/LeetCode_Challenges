import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Day31 {

    /**
     * Finds the target indices in the sorted array without actually sorting it.
     * @param nums - Input array of integers
     * @param target - Target value to find indices for
     * @return List of indices where target appears after sorting
     */
    public List<Integer> targetIndices(int[] nums, int target) {
        int num = 0;  // Count of numbers less than target
        int tcount = 0; // Count of occurrences of target

        // Iterate through the array to count occurrences and smaller elements
        for (int ele : nums) {
            if (ele == target) {
                tcount++;
            } else if (ele < target) {
                num++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        // Generate indices based on counted values
        while (tcount > 0) {
            ans.add(num);
            num++;
            tcount--;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input for array size
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Taking array input
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Taking target input
        System.out.print("Enter the target value: ");
        int target = sc.nextInt();

        // Creating an instance of Day31 class and calling the method
        Day31 obj = new Day31();
        List<Integer> result = obj.targetIndices(nums, target);

        // Displaying the output
        System.out.println("Target indices after sorting: " + result);

        sc.close();
    }
}
