public class Day12 {
    // Method to return a sorted array of squares of each number in the input array
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];  // Array to store the result
        int start = 0;  // Pointer at the start
        int end = nums.length - 1;  // Pointer at the end
        int ptr = nums.length - 1;  // Pointer to fill the result array from the end

        // Traverse until both pointers meet
        while (start <= end) {
            int startSq = nums[start] * nums[start];  // Square of start element
            int endSq = nums[end] * nums[end];  // Square of end element

            // Place the larger square at the current position and move pointers
            if (startSq > endSq) {
                ans[ptr] = startSq;
                start++;
            } else {
                ans[ptr] = endSq;
                end--;
            }
            ptr--;  // Move result pointer to the left
        }
        return ans;
    }

    public static void main(String[] args) {
        Day12 obj = new Day12();
        int[] nums = {-4, -1, 0, 3, 10};  // Example input
        int[] result = obj.sortedSquares(nums);  // Get the result

        // Print the result array
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
