# Java Streams – Creating Streams 

## Question  
**1. How do you create Streams in Java?**

This document shows **four standard ways to create streams** with **simple operations**.
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
