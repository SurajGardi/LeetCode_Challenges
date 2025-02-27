import java.util.HashMap;

class Day55 {
    // Method to check if two strings are anagrams
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // HashMap to store character frequencies
        HashMap<Character, Integer> hm = new HashMap<>();

        // Count frequency of each character in string s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        // Reduce frequency using characters in string t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            // If character is not in hashmap, it's not an anagram
            if (!hm.containsKey(ch)) {
                return false;
            }

            // Decrease count or remove character if count reaches zero
            if (hm.get(ch) == 1) {
                hm.remove(ch);
            } else {
                hm.put(ch, hm.get(ch) - 1);
            }
        }

        // If hashmap is empty, s and t are anagrams
        return hm.isEmpty();
    }

    // Main method to test the function
    public static void main(String[] args) {
        Day55 obj = new Day55();

        // Test cases
        String s1 = "anagram", t1 = "nagaram";
        System.out.println("Input: " + s1 + ", " + t1 + " | Output: " + obj.isAnagram(s1, t1)); // true

        String s2 = "rat", t2 = "car";
        System.out.println("Input: " + s2 + ", " + t2 + " | Output: " + obj.isAnagram(s2, t2)); // false

        String s3 = "listen", t3 = "silent";
        System.out.println("Input: " + s3 + ", " + t3 + " | Output: " + obj.isAnagram(s3, t3)); // true

        String s4 = "aabb", t4 = "bbaa";
        System.out.println("Input: " + s4 + ", " + t4 + " | Output: " + obj.isAnagram(s4, t4)); // true

        String s5 = "hello", t5 = "helloo";
        System.out.println("Input: " + s5 + ", " + t5 + " | Output: " + obj.isAnagram(s5, t5)); // false
    }
}
