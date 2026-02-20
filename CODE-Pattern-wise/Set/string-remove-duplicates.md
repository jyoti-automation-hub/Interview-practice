# Remove duplicate characters from a string

---

``` java
import java.util.HashSet;

public class RemoveDuplicates {

    public static String removeDuplicates(String s) {

        if (s == null || s.length() == 0)
            return s;

        HashSet<Character> set = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {

            if (!set.contains(c)) {
                set.add(c);
                result.append(c); //👉 Add this character at the end of the existing string.
            }
        }

        return result.toString(); // 👉 Convert StringBuilder into actual String
                                  // 👉 Then return it
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("aabbcc"));      // abc
        System.out.println(removeDuplicates("programming")); // progamin
    }
}

```

---

 ## 🔥 Simple Mental Model
> •	append() → builds string internally
> •	toString() → converts builder into final String

# Quick Notes – Remove Duplicate Characters (Java Doubts)

## 🔹 Why use StringBuilder instead of StringBuffer?
Use `StringBuilder` because it is faster and non-synchronized (thread safety is not required here).

---

## 🔹 Why use HashSet<Character> instead of Map<Character, Integer>?
We only need to check if a character was already seen, not count its frequency.

---

## 🔹 Why `new HashSet<>()` and not `new Set<>()`?
`Set` is an interface and cannot be instantiated; `HashSet` is its implementation.

---

## 🔹 Can we return `null` when string is null or empty?
Yes, because the method return type is `String`, and returning `null` is valid.

---

## 🔹 Why not return `-1`?
Because `-1` is an integer and the method return type is `String`.
