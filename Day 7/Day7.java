import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Day7 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;

        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];  // Add array digit to k
                i--;
            }
            result.add(k % 10);  // Add last digit to result
            k /= 10;  // Remove last digit from k
        }

        Collections.reverse(result);  // Reverse the result
        return result;
    }

    public static void main(String[] args) {
        Day7 solution = new Day7();
        
        // Test case 1
        int[] num1 = {1, 2, 0, 0};
        int k1 = 34;
        System.out.println("Output: " + solution.addToArrayForm(num1, k1));

        // Test case 2
        int[] num2 = {2, 7, 4};
        int k2 = 181;
        System.out.println("Output: " + solution.addToArrayForm(num2, k2));

        // Test case 3
        int[] num3 = {2, 1, 5};
        int k3 = 806;
        System.out.println("Output: " + solution.addToArrayForm(num3, k3));
    }
}
