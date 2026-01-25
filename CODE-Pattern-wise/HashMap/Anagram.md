import java.util.HashMap;

public class AnagramCheck {

    public static boolean isAnagram(String s1, String s2) {

        // Step 1: Edge cases
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        // Step 2: Convert to lowercase (ignore case)
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        HashMap<Character, Integer> map = new HashMap<>();

        // Step 3: Count characters from first string
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 4: Reduce count using second string
        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);

            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        // Step 5: If map is empty → anagram
        return map.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent")); // true
        System.out.println(isAnagram("rat", "car"));       // false
    }
}

