import java.util.PriorityQueue;
import java.util.Collections;

public class Day42 {
    // Method to find the last remaining stone's weight
    public static int lastStoneWeight(int[] stones) {
        // Create a max heap (priority queue with descending order)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Insert all stone weights into the priority queue
        for (int stone : stones) {
            pq.add(stone);
        }

        // Continue until there is at most one stone left
        while (pq.size() > 1) {
            int max = pq.poll();  // Extract the heaviest stone
            int secondMax = pq.poll();  // Extract the second heaviest stone

            int newStone = max - secondMax;  // Compute the new stone's weight

            // If the new stone has a positive weight, add it back to the queue
            if (newStone != 0) {
                pq.add(newStone);
            }
        }

        // Return the last remaining stone's weight, or 0 if none remain
        return pq.isEmpty() ? 0 : pq.poll();
    }

    // Main method for testing the function
    public static void main(String[] args) {
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        int[] stones2 = {1};
        
        // Test case 1
        System.out.println("Last Stone Weight (Test 1): " + lastStoneWeight(stones1)); // Output: 1
        
        // Test case 2
        System.out.println("Last Stone Weight (Test 2): " + lastStoneWeight(stones2)); // Output: 1
    }
}
