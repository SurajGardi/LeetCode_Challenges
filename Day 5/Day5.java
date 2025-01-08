class Day5 {
    public int numWaterBottles(int numBottles, int numExchange) {

        int ans = numBottles;        // Total bottles you can drink initially


        while(numBottles >= numExchange){        // Keep exchanging empty bottles for full ones


            int newBottles = numBottles / numExchange;   // Get new full bottles by exchanging

            int  remBottles = numBottles % numExchange;  // Leftover empty bottles after exchange


            ans = ans + newBottles;            // Add new full bottles to total


            numBottles = newBottles + remBottles;     // Update total bottles for the next round

        }
        return ans;
    }
    public static void main(String[] args) {
        Day5 solution = new Day5();
        System.out.println(solution.numWaterBottles(9, 3));  // Output: 13
        System.out.println(solution.numWaterBottles(15, 4)); // Output: 19
    }
}