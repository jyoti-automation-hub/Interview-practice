# Second Largest Digit in a String

## Problem

Given a string containing alphabets and digits, return the **second largest unique digit** in the string.

If it does not exist, return `-1`.

---

## Example

Input:
```
"claude2403edualc"
```

Output:
```
3
```

---

## Approach

- Traverse the string once.
- Ignore non-digit characters.
- Keep track of:
  - `max` → largest digit
  - `second` → second largest digit
- Update values in one pass.
- Ensure second is strictly less than max (avoid duplicates).

---

## Java Code

```java
public class Main {
    public static void main(String[] args) {

        String s = "claude2403edualc";

        int max = -1;
        int second = -1;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {

                int num = ch - '0';

                if (num > max) {
                    second = max;
                    max = num;
                } 
                else if (num != max && num > second) {
                    second = num;
                }
            }
        }

        System.out.println(second);
    }
}
```

---

## Output

```
3
```

---

## Time Complexity
```
O(n)
```

## Space Complexity
```
O(1)
```
