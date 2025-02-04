import java.util.Arrays;
import java.util.Scanner;

class Day32 {

    /**
     * Forms the largest possible number by arranging integers in a specific order.
     * @param nums - Array of non-negative integers
     * @return The largest number formed as a string
     */
    public String largestNumber(int[] nums) {
        // Convert integer array to string array
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Sort the array based on custom comparator (Descending Order)
        Arrays.sort(arr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        // Edge case: If the largest element is '0', return "0" (avoid multiple zeroes)
        if (arr[0].equals("0")) {
            return "0";
        }

        // Append sorted elements to form the largest number
        StringBuilder sb = new StringBuilder();
        for (String num : arr) {
            sb.append(num);
        }

        return sb.toString();
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

        // Creating an instance of Day32 class and calling the method
        Day32 obj = new Day32();
        String result = obj.largestNumber(nums);

        // Displaying the output
        System.out.println("Largest Number Formed: " + result);

        sc.close();
    }
}
