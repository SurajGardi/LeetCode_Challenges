class Day9 {

    // Finds the median of two sorted arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = merge(nums1, nums2);

        // Check if the array length is even
        if (mergedArray.length % 2 == 0) {
            // Median is the average of two middle values
            return (double) (mergedArray[mergedArray.length / 2] + mergedArray[mergedArray.length / 2 - 1]) / 2;
        } else {
            // Median is the middle value
            return mergedArray[mergedArray.length / 2];
        }
    }

    // Merges two sorted arrays into one
    public int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int p1 = 0, p2 = 0, p3 = 0;

        // Merge elements until both arrays are processed
        while (p1 < arr1.length || p2 < arr2.length) {
            int val1 = (p1 < arr1.length) ? arr1[p1] : Integer.MAX_VALUE;
            int val2 = (p2 < arr2.length) ? arr2[p2] : Integer.MAX_VALUE;

            // Insert the smaller value
            if (val1 < val2) {
                result[p3++] = val1;
                p1++;
            } else {
                result[p3++] = val2;
                p2++;
            }
        }
        return result;
    }

    // Main method to test the code
    public static void main(String[] args) {
        Day9 obj = new Day9();

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median: " + obj.findMedianSortedArrays(nums1, nums2)); // Output: 2.0

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("Median: " + obj.findMedianSortedArrays(nums3, nums4)); // Output: 2.5
    }
}
