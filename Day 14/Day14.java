public class Day14 {
    // Function to calculate the product of all elements except the current element
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; // Length of the input array
        int[] right = new int[n]; // Array to store the right product
        int pro = 1; // Variable to calculate the right product

        // Calculate the product of elements to the right of each index
        for (int i = n - 1; i >= 0; i--) {
            pro *= nums[i];
            right[i] = pro;
        }

        int[] ans = new int[n]; // Result array to store final values
        int left = 1; // Variable to calculate the left product

        // Calculate the product of elements except the current element
        for (int i = 0; i < n - 1; i++) {
            ans[i] = left * right[i + 1]; // Multiply left and right products
            left *= nums[i]; // Update left product
        }
        ans[n - 1] = left; // Last element only needs the left product
        return ans;
    }

    public static void main(String[] args) {
        Day14 obj = new Day14();
        int[] nums = {1, 2, 3, 4}; // Example input
        int[] result = obj.productExceptSelf(nums); // Call the method

        System.out.print("Output: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
