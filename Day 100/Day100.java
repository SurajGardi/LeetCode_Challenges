// Day 100 - LeetCode Problem 121: Best Time to Buy and Sell Stock

import java.util.*;

public class Day100 {

    // Function to calculate the maximum profit
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // Array to store the maximum future price for each day
        int[] maxValue = new int[n];

        // Start from the last day where the only possible price is the current one
        maxValue[n - 1] = prices[n - 1];

        // Fill maxValue array by moving from right to left
        for (int i = n - 2; i >= 0; i--) {
            maxValue[i] = Math.max(maxValue[i + 1], prices[i]);
        }

        int ans = 0;

        // Calculate max profit by comparing future max with current price
        for (int i = 0; i < n; i++) {
            int currProfit = maxValue[i] - prices[i];
            ans = Math.max(ans, currProfit);
        }

        return ans;
    }

    // Main method for testing the code
    public static void main(String[] args) {
        Day100 obj = new Day100();

        // Test case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum Profit (Test 1): " + obj.maxProfit(prices1)); // Output: 5

        // Test case 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Maximum Profit (Test 2): " + obj.maxProfit(prices2)); // Output: 0
    }
}
