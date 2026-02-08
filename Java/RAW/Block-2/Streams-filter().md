# Java Streams – filter()  

---

I use filter() to remove invalid or unwanted UI data before performing assertions.

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

  ## Line-by-Line Explanation (Very Simple & Human) — Java Streams `filter()` + `collect()`

1. **`list.stream()`**  
   Converts the `List` into a **Stream** so Java can process elements one by one in a pipeline instead of using loops.

2. **`filter(...)`**  
   `filter` is used to **keep or remove elements** based on a condition.  
   - If condition returns **true** → element is kept  
   - If condition returns **false** → element is removed  

3. **`p`**  
   `p` represents **one element at a time** coming from the stream.  
   Example values of `p` during execution:
   - `"iPhone"`
   - `"Mac"`
   - `" "` (space)
   - `""` (empty string)

4. **`->` (Lambda arrow)**  
   Means **“for each element `p`, apply this condition”**.  
   It connects the input (`p`) to the logic after it.

5. **`p.trim()`**  
   Removes **leading and trailing spaces** from the string.  
   Examples:
   - `" "` → `""`
   - `" iPhone "` → `"iPhone"`

6. **`isEmpty()`**  
   Checks whether the string is empty (`""`).  
   - Returns `true` if empty  
   - Returns `false` if not empty  

7. **`!` (NOT operator)**  
   Reverses the result:
   - `isEmpty() == true` → `!true` → `false` (remove)
   - `isEmpty() == false` → `!false` → `true` (keep)

   ✅ Result: **only non-empty values are kept**

8. **`collect(Collectors.toList())`**  
   Streams cannot be reused directly.  
   `collect()`:
   - Takes all remaining elements from the stream
   - Converts them back into a **List**
   - Stores the final clean data in the result variable
  
---

## ❓ Why `filter()` Is Used Here

- UI data is often **not clean** (mix of valid, empty, or unavailable values)
- `filter()` removes **unwanted entries before validation**

---

## 🎤 Interview One-Liner (Product Company Ready)

> “I use Java Streams `filter()` to remove unavailable or empty prices from search results and validate only real product prices.


---
# Java Streams – map() Method (Interview-Focused Notes)

---

## What is map()?

**map() is used to transform data in a stream.**  
It converts each element into another form without removing anything.

---

## One-Line Interview Definition

**“map() takes one value and converts it into another value.”**

---

## Difference between `filter()` and `map()` (Important)

### `filter()`
- Used to **remove unwanted elements**
- Works on a **condition (true / false)**
- If condition is **true** → element stays
- If condition is **false** → element is removed
- **Size of data may reduce**

**Example use cases:**
- Remove empty values  
- Remove disabled items  
- Remove invalid prices  

---

### `map()`
- Used to **transform / convert data**
- Changes **value or type** of each element
- Does **not remove elements**
- **Size of data remains the same**

**Example use cases:**
- WebElement → String  
- String → Integer  
- lowercase → uppercase  

---

### Interview One-Liner
**`filter()` cleans the data, `map()` transforms the data.**

---

## Simple Example (Core Java)

```java
List<String> names = List.of("iphone", "mac", "watch");

List<String> upperNames = names.stream()
                               .map(name -> name.toUpperCase())
                               .collect(Collectors.toList());
```
---

## What is collect() in Streams? 

When you use streams, Java processes data step by step, but a stream itself is not a real data structure.

> 👉 collect() is used when you want the final result back in a usable form (like a List).

---

> .collect(Collectors.toList())

---
