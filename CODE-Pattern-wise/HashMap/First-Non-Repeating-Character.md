# First Non-Repeating Character (Using HashMap)

```java
import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    public static char firstNonRepeating(String s) {

        // Edge case: null or empty string
        if (s == null || s.length() == 0) {
            return '-1';
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Step 1: Count frequency of each character
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Find the first character with frequency 1
        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }

        return '-1';
    }

    public static void main(String[] args) {
        String input = "AABBCCDEEFF";
        System.out.println(firstNonRepeating(input)); // Output: D
    }
}
```

## 🧠 Explanation

- The goal is to find the **first character that appears only once** in the string
- We use a **HashMap** to store each character and its frequency
- The string is traversed **twice**:
  - First pass → count frequency
  - Second pass → preserve order and find the first non-repeating character

**Example:**  
"AABBCCDEEFF"  
→ `{A=2, B=2, C=2, D=1, E=2, F=2}`  
→ First character with count `1` is **D**

**Rule to remember:**  
- Characters → `toCharArray()`  
- Frequency counting → `HashMap`

## ⏱ Complexity

- **Time Complexity:** O(n)  
- **Space Complexity:** O(n)

## 👉 Interview Takeaway

- Use `HashMap` when frequency tracking is required
- Two-pass approach helps preserve original order
- Clean, readable, and interview-preferred solution
