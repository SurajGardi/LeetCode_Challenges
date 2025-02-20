import java.util.Arrays;

public class Day48 {
    /**
     * Compresses the given character array in-place.
     * @param chars Input character array to be compressed.
     * @return The new length of the compressed array.
     */
    public int compress(char[] chars) {
        int count = 1; // To count consecutive occurrences of characters
        StringBuilder sb = new StringBuilder(); // Store the compressed string

        sb.append(chars[0]); // Append the first character

        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] != chars[i]) { // If current char is different from the previous one
                if (count > 1) {
                    sb.append(count); // Append the count if greater than 1
                }
                sb.append(chars[i]); // Append the new character
                count = 1; // Reset count for new character
            } else {
                count++; // Increment count for repeated characters
            }
        }

        if (count > 1) {
            sb.append(count); // Append the last counted value
        }

        // Modify the original array
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length(); // Return the new compressed length
    }

    public static void main(String[] args) {
        Day48 obj = new Day48();

        char[] chars1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int newLength1 = obj.compress(chars1);
        System.out.println("Compressed Array: " + Arrays.toString(Arrays.copyOf(chars1, newLength1)) + ", Length: " + newLength1);

        char[] chars2 = {'a'};
        int newLength2 = obj.compress(chars2);
        System.out.println("Compressed Array: " + Arrays.toString(Arrays.copyOf(chars2, newLength2)) + ", Length: " + newLength2);

        char[] chars3 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int newLength3 = obj.compress(chars3);
        System.out.println("Compressed Array: " + Arrays.toString(Arrays.copyOf(chars3, newLength3)) + ", Length: " + newLength3);
    }
}
