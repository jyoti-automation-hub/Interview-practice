# 🔵 Scenario 7 – Dropdown Handling (Standard `<select>`)

## 🎯 Interview Scenario

On an e-commerce website, products can be sorted using a dropdown.
The dropdown is implemented using a standard HTML `<select>` tag.

**Task:**
- Select a value from the dropdown
- Validate the selected option
- Fetch all available dropdown values

---

## 🧩 DOM Structure (Standard Select Dropdown)

```html
<select id="sort-options">
  <option value="relevance">Relevance</option>
  <option value="price-low">Price: Low to High</option>
  <option value="price-high">Price: High to Low</option>
</select>
```
---

### ✅ Selenium Java Code

```java
// Locate dropdown
WebElement dropdown = driver.findElement(By.id("sort-options"));

// Create Select class object
Select select = new Select(dropdown);

// Select option by visible text
select.selectByVisibleText("Price: Low to High");

// Validate selected option
String selectedOption = select.getFirstSelectedOption().getText();
System.out.println(selectedOption);

// Fetch all dropdown values
List<WebElement> options = select.getOptions();
for (WebElement option : options) {
    System.out.println(option.getText());
}
```

---
## 🎤 Interview Questions & Answers – Standard `<select>` Dropdown (Selenium)

### 1️⃣ How do you handle a dropdown implemented using a `<select>` tag in Selenium?

**Answer:**  
If the dropdown is implemented using a `<select>` tag, I handle it using the **Select class** provided by Selenium.

---

### 2️⃣ What are the different ways to select an option?

**Answer:**  
There are three ways to select an option using the Select class:
- `selectByVisibleText()`
- `selectByValue()`
- `selectByIndex()`

---

### 3️⃣ How do you validate the selected option?

**Answer:**  
I use `getFirstSelectedOption()` and fetch its text to validate which option is currently selected.

---

### 4️⃣ How do you fetch all dropdown values?

**Answer:**  
I use the `getOptions()` method, which returns a list of all available options in the dropdown.

---

### 5️⃣ When will the Select class not work?

**Answer:**  
The Select class will not work when the dropdown is **not implemented using a `<select>` tag**, such as custom dropdowns built using `div` and `li` elements.

---

### 🔑 Interview Tip

Always inspect the DOM first.  
Use **Select class only for `<select>` tags** and a different approach for custom dropdowns.
