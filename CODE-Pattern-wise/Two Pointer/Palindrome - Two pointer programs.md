# Palindrome Check Using Two Pointers 

##  Question
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

## Code (Two Pointers, No Boolean)
---

```java
public class PalindromeCheck {

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;   // mismatch → not a palindrome
            }
            left++;
            right--;
        }
        return true; // all characters matched
    }

    public static void main(String[] args) {
        String input = "madam";
        System.out.println(isPalindrome(input)); // true
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

---


```java
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        if (s == null) return false;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Skip non-alphanumeric characters from left
            while (left < right &&
                   !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from right
            while (left < right &&
                   !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = "Madam!";
        String s4 = "12321";

        System.out.println(isPalindrome(s1)); // true
        System.out.println(isPalindrome(s2)); // false
        System.out.println(isPalindrome(s3)); // true
        System.out.println(isPalindrome(s4)); // true
    }
}

```

---

🔵 Q2 – Palindrome

We are NOT modifying anything.

We are only:
	•	Reading characters
	•	Comparing characters

So this is enough:
s.charAt(left)
s.charAt(right)

No modification → No need for extra array.


