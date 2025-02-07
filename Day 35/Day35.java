import java.util.PriorityQueue;
import java.util.Scanner;

public class Day35 {

    /**
     * Returns the kth largest element in the array using a min-heap.
     * @param nums the input array of integers
     * @param k the kth position to find (1-indexed)
     * @return the kth largest element
     */
    public int findKthLargest(int[] nums, int k) {
        // Create a min-heap (PriorityQueue) to store the k largest elements
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Iterate over each element in the array
        for (int num : nums) {
            if (pq.size() < k) {
                // If the heap has less than k elements, add the current element
                pq.add(num);
            } else if (pq.peek() < num) {
                // If current element is greater than the smallest element in the heap,
                // remove the smallest and add the current element.
                pq.poll();
                pq.add(num);
            }
        }
        // The top of the min-heap now holds the kth largest element
        return pq.peek();
    }

    
    public static void main(String[] args) {
        Day35 solution = new Day35();
        Scanner scanner = new Scanner(System.in);

        // Input the number of elements in the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // Input the array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Input the value of k
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        // Compute the kth largest element and display it
        int kthLargest = solution.findKthLargest(nums, k);
        System.out.println("The kth largest element is: " + kthLargest);

        scanner.close();
    }
}
