class Day11 {
    public int removeElement(int[] nums, int val) {
        int ptr = 0;  
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {  // If current element is not equal to 'val'
                nums[ptr] = nums[i];  // Place the element at 'ptr' position
                ptr++;  
            }
        }
        return ptr;  // Return the count of non-val elements
    }

    public static void main(String[] args) {
        Day11 obj = new Day11();

        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        System.out.println("Result 1: " + obj.removeElement(nums1, val1));  // Output: 2

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        System.out.println("Result 2: " + obj.removeElement(nums2, val2));  // Output: 5
    }
}
