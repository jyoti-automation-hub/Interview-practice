# String Compression (Java)

## 🔹 Problem Statement

Given a string, compress it by replacing consecutive repeating characters  
with the character followed by its count.

Only consecutive characters are counted.

---

## 🔹 Example

Input:
```
aabcccccaaa
```

Output:
```
a2b1c5a3
```

---

## 🔹 Approach

- Traverse the string from left to right.
- Compare current character with previous character.
- If same → increase count.
- If different → append previous character and its count.
- After loop ends → append the last character group manually.

---

## 🔹 Java Code

```java
public class StringCompression {

    public static String compress(String s) {

        if (s == null || s.length() == 0)
            return s;

        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                result.append(s.charAt(i - 1));
                result.append(count);
                count = 1;
            }
        }

        // Append last group
        result.append(s.charAt(s.length() - 1));
        result.append(count);

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa")); // a2b1c5a3
    }
}
```

---

## 🔹 Dry Run (aabcccccaaa)

| Step | Action | Result |
|------|--------|--------|
| a == a | count = 2 | |
| change to b | append a2 | a2 |
| change to c | append b1 | a2b1 |
| c repeated 5 times | count = 5 | |
| change to a | append c5 | a2b1c5 |
| a repeated 3 times | count = 3 | |
| end of string | append a3 | a2b1c5a3 |

---

## 🔹 Time Complexity

```
O(n)
```

## 🔹 Space Complexity

```
O(n)
```

(For storing compressed result)
