# Java Streams – Creating Streams 

## Question  
**1. How do you create Streams in Java?**
---

## 1️⃣ Create Stream from a Collection

```java
import java.util.*;

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Print even numbers
numbers.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println);
```

---

## 2️⃣ Create Stream from an Array
```java
import java.util.*;
import java.util.stream.*;

int[] arr = {1, 2, 3, 4, 5};

// Square each number
Arrays.stream(arr)
      .map(n -> n * n)
      .forEach(System.out::println);
```

---

## 3️⃣ Create Stream using Stream.of()
```java
import java.util.stream.*;

Stream.of(10, 20, 30, 40)
      .filter(n -> n > 20)
      .forEach(System.out::println);
```

---

## 4️⃣ Create Stream using Stream.iterate()
```java
import java.util.stream.*;

Stream.iterate(1, n -> n + 1)
      .limit(5)
      .forEach(System.out::println);
```

---

## 🔑 Interview One-Liner
Streams in Java can be created from **collections, arrays, Stream.of(), and Stream.iterate()**, and processed using operations like `filter`, `map`, and `forEach`.

---
# Java Streams – Filter Even Numbers from List (Interview Ready)

## Question  
**2. Filter even numbers from a list using Java Streams**

---

## Problem Statement  
Given a list of integers, filter out only the **even numbers** using Java Streams.

---

## Code Implementation
```java
import java.util.*;
import java.util.stream.Collectors;

public class FilterEvenNumbers {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());

        System.out.println(evenNumbers);
    }
}
```

---

## Output
```
[2, 4, 6, 8, 10]
```

---

## Core Idea (Interview Explanation)
- Convert the list into a **stream**
- Use `filter()` to keep only numbers divisible by 2
- Collect the result back into a list using `Collectors.toList()`

---

## Time & Space Complexity
- **Time Complexity:** O(n)  
- **Space Complexity:** O(n)

---

## One-Line Interview Answer
We use `stream()` to process elements, `filter()` to select even numbers, and `collect()` to store the result back into a list.
