# Java Streams – filter()  

---


---

## 🧪 Selenium + Java Streams Code

```java

List<String> products = List.of("iPhone", "", "Mac", " ");

List<String> validProducts =
        products.stream()
                .filter(p -> !p.trim().isEmpty())
                .collect(Collectors.toList());

```
  ---

## ❓ Why `filter()` Is Used Here

- I use filter() to remove invalid or unwanted UI data before performing assertions.
- UI data is often **not clean** (mix of valid, empty, or unavailable values)
- `filter()` removes **unwanted entries before validation**

---

## 🎤 Interview One-Liner (Product Company Ready)

> “I use Java Streams `filter()` to remove unavailable or empty prices from search results and validate only real product prices.”
