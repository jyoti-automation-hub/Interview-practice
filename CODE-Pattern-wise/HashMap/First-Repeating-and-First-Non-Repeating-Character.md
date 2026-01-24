# First Repeating and First Non-Repeating Character (Using LinkedHashMap)

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstRepeatingAndNonRepeating {

    public static void main(String[] args) {

        String input = "aabbcdde";

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        // Step 1: Count frequency of each character
        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Character firstRepeating = null;
        Character firstNonRepeating = null;

        // Step 2: Find first repeating character
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                firstRepeating = entry.getKey();
                break;
            }
        }

        // Step 3: Find first non-repeating character
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                firstNonRepeating = entry.getKey();
                break;
            }
        }

        System.out.println("First Repeating: " + firstRepeating);
        System.out.println("First Non-Repeating: " + firstNonRepeating);
    }
}
```

## 🧠 Explanation

- The problem asks for **first repeating** and **first non-repeating** character
- The word **“first”** means the character that appears **earliest in the input**
- We use **LinkedHashMap** because:
  - It stores **frequency** (key → character, value → count)
  - It **preserves insertion order**

**Example:**  
Input: `"aabbcdde"`  
Map after counting: `{a=2, b=2, c=1, d=2, e=1}`  
- First repeating → `a`  
- First non-repeating → `c`

---

## ⏱ Complexity

- **Time Complexity:** O(n)  
- **Space Complexity:** O(n)

---

## 👉 Interview Takeaway

- Use **LinkedHashMap** when both **frequency** and **order** matter
- Build the map once, iterate to find required conditions
- Clean and commonly asked SDET interview problem
