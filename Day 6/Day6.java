class Day6 {

    public int[] twoSum(int[] nums, int target) {
        
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {  // checking two no's are equal to target or not
                    ans[0] = i;              // Store their indices in the result array
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }

    // public static void main(String[] args) {
    //     Day6 solution = new Day6();

    //     // Test case 1
    //     int[] nums1 = {2, 7, 11, 15};
    //     int target1 = 9;
    //     int[] result1 = solution.twoSum(nums1, target1);
    //     System.out.println("Indices: [" + result1[0] + ", " + result1[1] + "]");

    //     // Test case 2
    //     int[] nums2 = {3, 2, 4};
    //     int target2 = 6;
    //     int[] result2 = solution.twoSum(nums2, target2);
    //     System.out.println("Indices: [" + result2[0] + ", " + result2[1] + "]");

    //     // Test case 3
    //     int[] nums3 = {3, 3};
    //     int target3 = 6;
    //     int[] result3 = solution.twoSum(nums3, target3);
    //     System.out.println("Indices: [" + result3[0] + ", " + result3[1] + "]");
    // }
}
