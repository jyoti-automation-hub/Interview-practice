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


### Step 2 - Store in HashMap

Map<String, String> tableData = new HashMap<>();

for (int i = 0; i < names.size(); i++) {
    tableData.put(
        names.get(i).getText(),
        prices.get(i).getText()
    );
}
System.out.println(tableData.get("iPhone"));   // 1000

```

