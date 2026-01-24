# Java Streams 

---

## 1️⃣ What is a Stream? (Simple, Human Explanation)

A **Stream** is a clean and readable way to process data from a collection like **List, Set, or Map**.

👉 **Interview one-liner:**  
Streams help us process collection data (filter, transform, validate) without writing long loops.

---

## 2️⃣ Why Streams are Used (Real Automation Reason)

In automation frameworks, we constantly work with:
- Lists of WebElements
- Dropdown values
- API response data
- UI vs expected validations

Streams make these validations:
- shorter
- more readable
- easier to maintain

---

## 4️⃣ Core Stream Methods You MUST Know (With Real Code)

### 🔹 `stream()`
Converts a collection into a stream so we can process it.

```java
options.stream();
