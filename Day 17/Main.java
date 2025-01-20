// Program to find the maximum area a container can store water
public class Main {

    public static void main(String[] args) {
        // Example input
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        // Call the function and print the result
        int result = maxArea(height);
        System.out.println("Maximum water a container can hold: " + result);
    }

    // Function to calculate maximum water area
    public static int maxArea(int[] height) {
        int start = 0; // Pointer at the beginning
        int end = height.length - 1; // Pointer at the end
        int maxCap = 0; // Variable to store maximum capacity

        while (start < end) {
            // Calculate current height and width
            int h = Math.min(height[start], height[end]);
            int width = end - start;

            // Update maximum capacity if current is greater
            maxCap = Math.max(maxCap, h * width);

            // Move the pointer of the shorter line inward
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxCap; // Return the maximum area
    }
}
