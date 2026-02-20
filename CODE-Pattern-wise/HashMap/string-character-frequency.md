# Count Frequency of Characters in a String (Java)

## 🔹 Problem Statement

Given a string, count and print the frequency of each character present in the string.

You should:
- Traverse the string
- Count how many times each character appears
- Print all character-frequency pairs

---

## 🔹 Example

Input:
```
aabbc
```

Output:
```
a → 2
b → 2
c → 1
```

---

## 🔹 Approach

- Use a `HashMap<Character, Integer>`
- First loop → count frequency of each character
- Second loop → print all key-value pairs

---

## 🔹 Java Code

```java
import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency {

    public static void printFrequency(String s) {

        if (s == null || s.length() == 0) {
            return;
        }

        Map<Character, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Print frequency
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFrequency("aabbc");
    }
}
```

---

## 🔹 Time Complexity

```
O(n)
```

We traverse the string once to count and once to print.

---

## 🔹 Space Complexity

```
O(n)
```

In worst case, all characters are unique.

---

# Understanding This For Loop in Java

```java
for (Map.Entry<Character, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " → " + entry.getValue());
}
```

## What Is This Loop Doing?

This loop goes through **each key-value pair inside the map**.

That’s it.

---

## Step-by-Step Simple Explanation

### 1️⃣ `map.entrySet()`

- It gives all key-value pairs from the map.
- Not just keys.
- Not just values.
- Full pairs.

Example:

If map contains:
```
a → 2
b → 1
```

Then `map.entrySet()` gives:
```
(a,2)
(b,1)
```

---

### 2️⃣ `Map.Entry<Character, Integer> entry`

- `entry` is just a variable.
- In every loop iteration, it holds one pair.

First loop:
```
entry = (a,2)
```

Second loop:
```
entry = (b,1)
```

---

### 3️⃣ Inside the Loop

```java
entry.getKey()   // gives the key
entry.getValue() // gives the value
```

So it prints:

```
a → 2
b → 1
```

---

## In One Line

This loop simply says:

👉 "Go through each key-value pair in the map and print it."
 
