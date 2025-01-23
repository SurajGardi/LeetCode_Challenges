import java.util.HashMap;

class Solution {
    public int findLucky(int[] arr) {
        // Create a HashMap to store the frequency of each element
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Count the frequency of each element in the array
        for (int i = 0; i < arr.length; i++) {
            int ele = arr[i];
            if (hm.containsKey(ele)) {
                hm.put(ele, hm.get(ele) + 1); // Increment the count if element already exists
            } else {
                hm.put(ele, 1); // Add the element to the map with count 1
            }
        }

        int ans = -1; // Initialize the result to -1 (default if no lucky number is found)

        // Iterate through the map to find the largest "lucky" integer
        for (int key : hm.keySet()) {
            if (hm.get(key) == key) { // Check if the frequency equals the value
                ans = Math.max(ans, key); // Update the result with the maximum lucky number
            }
        }

        return ans; // Return the lucky number (or -1 if none found)
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example input array
        int[] arr = {2, 2, 3, 4, 3, 3, 1};

        // Call the method and get the result
        int result = solution.findLucky(arr);

        // Print the result
        System.out.println("The lucky integer is: " + result);
    }
}
