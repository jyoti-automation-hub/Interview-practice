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
  
  ---
# Understanding This Line in Java

```java
Map<Character, Integer> map = new HashMap<>();
```

This single line creates a Map that stores characters and their frequency.  
Let’s break it down clearly.

---

## 1️⃣ What is `Map`?

- `Map` is an **interface** in Java.
- It stores data in **key–value pairs**.
- Keys must be unique.
- Values can repeat.

Example:
```
'a' → 3
'b' → 1
```

---

## 2️⃣ What is `<Character, Integer>`?

These are **Generics**.

They define:
- `Character` → Type of Key
- `Integer` → Type of Value

So this map will store:
```
Character → Integer
```

Example:
```
's' → 3
'w' → 1
```

---

## 3️⃣ What is `map`?

`map` is just the **variable name**.

It is of type:
```
Map<Character, Integer>
```

---

## 4️⃣ Why do we use `new`?

`new` creates an **object in memory**.

Without `new`, no object is created.

We need an actual object to store data.

---

## 5️⃣ What is `HashMap`?

- `HashMap` is a **class**.
- It implements the **Map interface**.
- It uses a **hash table** internally.
- Average time complexity:
  - `put()` → O(1)
  - `get()` → O(1)

---

## 6️⃣ Why write `Map` instead of `HashMap` on the left side?

```java
Map<Character, Integer> map = new HashMap<>();
```

We program to the **interface**, not the implementation.

This gives flexibility:
- Later we can replace `HashMap` with `LinkedHashMap`
- No change needed in variable type

---

## 7️⃣ What is `<>` in `new HashMap<>()`?

This is called the **Diamond Operator**.

Java automatically understands the types from the left side.

Equivalent to:
```java
new HashMap<Character, Integer>();
```

---

##  Meaning

This line:

```java
toCharArray
```
---
- So internally, Java converts String into a char array.
- ['s','w','i','s','s']

---

```java
map.put(c, map.getOrDefault(c, 0) + 1);
```

---
It is equivalent to writing: 
 
>int oldValue = map.getOrDefault(c, 0);
>int newValue = oldValue + 1;
>map.put(c, newValue);



  
