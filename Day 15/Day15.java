class Day15 {
    // Method to calculate the number of bulbs that remain on
    public int bulbSwitch(int n) {
        int count = 0; // Count of bulbs that remain on
        int i = 1; // Start from 1

        // Iterate to find perfect squares less than or equal to n
        while (i * i <= n) {
            count++;
            i++;
        }
        return count; // Return the count of perfect squares
    }

    public static void main(String[] args) {
        Day15 day15 = new Day15();
        
        // Test case 1
        int n1 = 3;
        System.out.println("Number of bulbs on for n = " + n1 + ": " + day15.bulbSwitch(n1)); // Output: 1
        
        // Test case 2
        int n2 = 1;
        System.out.println("Number of bulbs on for n = " + n2 + ": " + day15.bulbSwitch(n2)); // Output: 1

        // Test case 3
        int n3 = 0;
        System.out.println("Number of bulbs on for n = " + n3 + ": " + day15.bulbSwitch(n3)); // Output: 0
    }
}
