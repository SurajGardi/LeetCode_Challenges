class Day30 {

    // Method to calculate trapped rainwater
    public int trap(int[] height) {
        int n = height.length;
        
        // Edge case: If there are less than 3 bars, no water can be trapped
        if (n < 3) return 0;

        // Arrays to store max height to the left and right of each element
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Compute the left max height for each index
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Compute the right max height for each index
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate the total trapped water
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            // Water trapped at index i = min(leftMax, rightMax) - height[i]
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
    }

    public static void main(String[] args) {
        Day30 obj = new Day30();

        // Test case 1
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Trapped Water (Test 1): " + obj.trap(height1)); // Output: 6

        // Test case 2
        int[] height2 = {4,2,0,3,2,5};
        System.out.println("Trapped Water (Test 2): " + obj.trap(height2)); // Output: 9
    }
}
