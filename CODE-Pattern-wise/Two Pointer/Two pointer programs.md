# Palindrome Check Using Two Pointers (Java)

## Interview Question
Check whether a given string is a palindrome using the **two-pointer technique**.

Constraints:
- Do NOT use built-in reverse methods
- Do NOT use boolean variables

---

## Example
Input:
madam  

Output:
true  

Input:
hello  

Output:
false  

---

## Java Code (Two Pointers, No Boolean)

```java
public class PalindromeCheck {

    public static void main(String[] args) {
        String s = "madam";
        checkPalindrome(s);
    }

    static void checkPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                System.out.println(false);
                return;
            }
            left++;
            right--;
        }

        System.out.println(true);
    }
}
```

---

## Explanation:

- Two pointers are used:
  - `left` starts from the beginning of the string
  - `right` starts from the end of the string
- In each iteration:
  - Characters at `left` and `right` are compared
- If a mismatch is found:
  - Print `false`
  - Exit immediately using `return`
- If the loop completes without any mismatch:
  - Print `true`
- No boolean variable is required because the method exits as soon as the result is determined
