# Java Streams 

---

## 1️⃣ What is a Stream? 

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
```
---

# Java Streams – anyMatch() (SDET Interview Ready)

## Scenario  
Verify whether a dropdown contains a specific value (example: **"India"**) using Java Streams instead of a traditional loop.

---

## Complete Selenium + Java Code

```java
List<WebElement> options =
        driver.findElements(By.xpath("//select[@id='country']/option"));

boolean found =
        options.stream()
               .anyMatch(e -> e.getText().equals("India"));

if (found) {
    System.out.println("India is present in dropdown");
} else {
    System.out.println("India is NOT present in dropdown");
}
```
---

## Java Streams – anyMatch() (Line-by-Line Explanation)

### What the Code is Doing (In Simple Words)
We are checking **whether a dropdown contains a specific value** (for example: `"India"`) using Java Streams.

---

### Line-by-Line Explanation (Human-Friendly)

- **`List<WebElement> options`**
  - Stores all dropdown `<option>` elements.
  - Selenium’s `findElements()` always returns a **List**, never a single element.

- **`options.stream()`**
  - Converts the List into a **Stream**.
  - Stream allows us to process elements one by one **without writing a loop**.

- **`anyMatch(...)`**
  - Checks whether **at least one element** in the stream matches the condition.
  - Returns a **boolean** (`true` or `false`).

- **`e -> e.getText().equals("India")`**
  - `e` represents **one WebElement at a time** from the dropdown.
  - `e.getText()` gets the visible text of that option.
  - `equals("India")` is the condition being checked.

- **`boolean found`**
  - Stores the result of `anyMatch()`.
  - `true` → value exists  
  - `false` → value does not exist

- **`if (found)`**
  - Used to perform validation or assertion logic in automation tests.

---

### Why `anyMatch()` is Used 

- Returns a **boolean directly** (perfect for validations)
- Stops execution as soon as a match is found (**efficient**)
- Cleaner and more readable than traditional `for` loops
- Very commonly used in **product-based company automation frameworks**

---

### Interview One-Liner

> I use `anyMatch()` with Java Streams to verify whether a specific value exists in dropdowns or UI lists without writing manual loops.
