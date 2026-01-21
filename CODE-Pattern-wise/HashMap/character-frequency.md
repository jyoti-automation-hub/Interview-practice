# Java Collections – Coding Question

## Q: Count the frequency of each character in a String

### Problem
Given a string, count how many times each character appears.

Example:
Input:  “banana”
Output: {b=1, a=3, n=2}

---

## Approach

- Convert the string into characters.
- Use a `HashMap<Character, Integer>` to store:
  - **key** → character  
  - **value** → frequency count
- If character already exists, increment count.
- Else, insert it with count = 1.

---

## ✅ Working Code

```java
import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency {

    public static void main(String[] args) {
        String s = "banana";

        Map<Character, Integer> mp = new HashMap<>();

        for (char c : s.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        System.out.println(mp);
    }
}
```
## Why `toCharArray()` Is Used

- A `String` is not directly iterable using a for-each loop.
- `toCharArray()` converts the string into a `char[]`, which is iterable.
  
  ---

• Why HashMap?
→ Fast lookup and update using key–value structure.
	•	Time Complexity:
→ O(n), where n = length of string.
	•	Where used in Automation?
→ Log analysis, text validation, API response parsing, test data verification.

