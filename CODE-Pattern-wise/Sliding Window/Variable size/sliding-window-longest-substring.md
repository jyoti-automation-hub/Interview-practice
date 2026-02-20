# Longest Substring Without Repeating Characters (Sliding Window)

## 🔹 Problem Statement

Given a string `s`, find the length of the longest substring without repeating characters.

A substring must be continuous.

---

## 🔹 Example

Input:
```
"abcabcbb"
```

Output:
```
3
```

Explanation:
The longest substring without repeating characters is `"abc"`.

---

## 🔹 Approach (Sliding Window – Variable Size)

We use:

- `left` pointer → start of window
- `right` pointer → end of window
- `HashSet` → to track characters in current window
- `maxLength` → to store maximum window size

### Logic:

1. Expand window using `right`
2. If duplicate found → shrink window using `left`
3. Update maximum length
4. Continue until end of stri
---

## 🔹 Java Code

```java
import java.util.HashSet;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
        System.out.println(lengthOfLongestSubstring("abba"));     // 2
    }
}
```

---

## 🔹 Time Complexity

```
O(n)
```

Each character is visited at most twice (once by right, once by left).

---

## 🔹 Space Complexity

```
O(k)
```

Where `k` is number of unique characters in the window.

---

***When exactly do you move left?***
>👉 We move left inside a while loop when the set already contains the current right character.
>We keep moving left until the duplicate is removed.

>That “while duplicate exists” part is important.

***When do we update max length?***
>👉 After the window becomes valid (no duplicates), update maxLength = max(maxLength, right - left + 1).

***Time complexity***
>👉 O(n)
Because:
	•	Each character is added once
	•	Each character is removed at most once
Left and right both move only forward.
