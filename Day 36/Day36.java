
public class Day36 {

    public double average(int[] salary) {
        int max = salary[0];  // Initialize max with the first salary
        int min = salary[0];  // Initialize min with the first salary
        int sum = salary[0];  // Initialize sum with the first salary

        // Iterate through the array to find min, max, and sum of salaries
        for (int i = 1; i < salary.length; i++) {
            if (salary[i] > max) {
                max = salary[i];  // Update max if current salary is greater
            }
            if (salary[i] < min) {
                min = salary[i];  // Update min if current salary is smaller
            }
            sum += salary[i];  // Add current salary to the sum
        }

        // Subtract min and max from the sum to exclude them
        sum = sum - min - max;

        // Calculate the average by dividing the adjusted sum by (length - 2)
        return (double) sum / (salary.length - 2);
    }

    public static void main(String[] args) {
        Day36 obj = new Day36();

        // Test case 1
        int[] salary1 = {4000, 3000, 1000, 2000};
        System.out.printf("Average Salary (Test 1): %.5f\n", obj.average(salary1));

        // Test case 2
        int[] salary2 = {1000, 2000, 3000};
        System.out.printf("Average Salary (Test 2): %.5f\n", obj.average(salary2));

        // Test case 3
        int[] salary3 = {6000, 5000, 8000, 3000, 7000};
        System.out.printf("Average Salary (Test 3): %.5f\n", obj.average(salary3));
    }
}
