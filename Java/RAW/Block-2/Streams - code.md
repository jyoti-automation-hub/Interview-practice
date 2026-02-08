# Java 8 – Stream Coding Practice

---

## Question 1: Filter Elements Using Stream

### 📝 Problem Statement

Given the following list:

```java
List<String> list = Arrays.asList("Apple", "Banana", "Avocado", "Mango");
```

---

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

List<String> list = Arrays.asList("Apple", "Banana", "Avocado", "Mango");

List<String> result = list.stream()
                          .filter(s -> s.startsWith("A"))
                          .collect(Collectors.toList());

```
---

## Question 2: Remove Duplicates Using distinct()

### 📝 Problem Statement

Given the following list:

```java
List<String> list = Arrays.asList("Apple", "Mango", "Apple", "Banana", "Mango");

```

---
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

List<String> list = Arrays.asList("Apple", "Mango", "Apple", "Banana", "Mango");

List<String> result = list.stream()
                          .distinct()
                          .collect(Collectors.toList());

System.out.println(result);

```

---

## Question 3: Sort a List Using Stream

### 📝 Problem Statement

Given the following list:

```java
List<String> list = Arrays.asList("Mango", "Apple", "Banana", "Avocado");

```

---

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

List<String> list = Arrays.asList("Mango", "Apple", "Banana", "Avocado");

List<String> result = list.stream()
                          .sorted()
                          .collect(Collectors.toList());

System.out.println(result);

```
---









