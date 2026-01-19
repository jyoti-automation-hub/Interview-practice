# HashMap – Store Web Table Row (SDET Interview – 4+ Years)

## 🎯 Interview Question  
**How would you store a web table row using HashMap? Explain the logic with code.**

---

## 📌 Scenario

UI Table Example:

| Product | Price |
|--------|-------|
| iPhone | 1000 |
| Mac    | 2000 |
| Watch  | 500  |

👉 Goal: Store as **Key → Value**  
`Product → Price` using `HashMap<String, String>`

---

## ✅ Selenium + Java Implementation

### Step 1 – Capture Table Columns

```java
List<WebElement> names  = driver.findElements(By.xpath("//table//tr/td[1]"));
List<WebElement> prices = driver.findElements(By.xpath("//table//tr/td[2]"));


// Step 2 - Store in HashMap

Map<String, String> tableData = new HashMap<>();

for (int i = 0; i < names.size(); i++) {
    tableData.put(
        names.get(i).getText(),
        prices.get(i).getText()
    );
}
System.out.println(tableData.get("iPhone"));   // 1000

```
---
## 🎤 How I Explain HashMap Table Logic in Interview

- I read **two columns from the table using findElements**.  
- The **first list contains product names**, the **second contains prices**.  
- I loop with index and store **name as key, price as value** in a HashMap.  
- Now I can directly validate:  
  → `map.get("iPhone")` should return `"1000"`.

---

## 💡 Why HashMap Here?

- Table data is naturally **key → value** structure.  
- **Faster lookup** than iterating lists again and again.  
- Clean validation for:  
  - API vs UI comparison  
  - UI vs UI comparison  
  - price / summary validations.

---

## 🔥 Interview Follow-Ups

### 1. Why not List instead of Map?

- List needs iteration for every validation → **O(n)**.  
- Map gives direct lookup using key → **O(1)**.  
- So Map is better for validation scenarios.

### 2. What if duplicate product names exist?

- HashMap will **override the old value** for same key.  
- Better approach:

```java
Map<String, List<String>> data = new HashMap<>();
```

---

### 3. Where have you used this in real automation?

I used HashMap in these real scenarios:

- **Price validation:**  
  Store product → price from UI table and compare with API response.

- **Order summary verification:**  
  Capture item name → quantity/price and validate totals.

- **Reports comparison:**  
  UI dashboard values vs backend report using key-based lookup.

- **Cart validation:**  
  Product → amount mapping to verify after add/remove actions.

This made validations faster and cleaner compared to iterating lists multiple times.
