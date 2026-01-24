# 📌 Collections – SDET Interview Notes

---

## Q1. Explain the difference between List, Set, and Map

### 1. List
- List allows duplicates  
- List maintains insertion order  
- Supports index-based access  

**Automation example:**  
I store dropdown values in a List and compare them with expected values for validation.

---

### 2. Set
- Set does NOT allow duplicates  
- Set does NOT maintain insertion order (HashSet)  
- Used when only unique values are needed  

**Automation example:**  
When I want only unique product names from search results, I store them in a Set to automatically remove duplicates.

---

### 3. Map
- Map stores data in key–value pairs  

**Automation example:**  
I use Map to store table data like:  
- column name → column value  
- then validate UI table against expected data.

---

## Q2 – ArrayList vs LinkedList

👉 **In your framework, when would you choose ArrayList over LinkedList?**

In my framework I mostly use ArrayList (around 90%) because automation scenarios are mainly about:

- storing elements from dropdowns  
- iterating over lists  
- validating UI data  
- comparing expected vs actual values  

**ArrayList is better for this because:**
- Fast reading → O(1) random access  
- Good for traversal and searching  

I would use LinkedList only when:

- frequent insert/delete in middle is required  
- because LinkedList works with node references and deletion is O(1) when the node is known.

---

## Q3 – You stored dropdown elements in List. Why not use Set instead?

I use List for dropdowns because:

1. I need index-based access like options.get(2) – Set doesn’t support that.  
2. Selenium itself returns elements as List, so List fits naturally.

I would use Set only if my requirement is uniqueness, for example:

- verify there are no duplicate product names  
- remove repeated values before comparison.

---

## Q4 – How would you check if a dropdown has duplicate values using Set?

I’ll capture dropdown elements in List,  
extract their text into a Set,  
and compare list size vs set size.  
If sizes differ → duplicates exist.

```java
List<WebElement> elems = driver.findElements(By.xpath("//option"));

Set<String> unique = new HashSet<>();

for(WebElement e : elems) { 
    unique.add(e.getText());   // Set stores String values, not WebElements → extract text first
}

if(elems.size() != unique.size()) {
    System.out.println("Duplicates present");
}
```
---
# Collections – Interview Notes (Q5 to Q10)

---

## Q5 – How would you remove duplicates from a list while preserving order?

```java
List<String> list = Arrays.asList("apple", "mango", "apple", "banana");

Set<String> set = new LinkedHashSet<>(list);

List<String> result = new ArrayList<>(set);
```

**Answer:**  
To remove duplicates while preserving order, I use **LinkedHashSet** because:

- Set removes duplicates  
- LinkedHashSet maintains insertion order  

Flow:  
List → LinkedHashSet → back to List.

---

## Q6 – HashSet vs LinkedHashSet vs TreeSet

**HashSet**
- Removes duplicates  
- Does NOT maintain any order  

**LinkedHashSet**
- Removes duplicates  
- Maintains insertion order  

**TreeSet**
- Removes duplicates  
- Maintains **sorted (natural) order**

---

## Q7 – Where have you used HashMap in your automation framework?

**Answer:**

I used HashMap when I needed to map one value to another.  
Example in table validation:

- "Product Name" → "iPhone"  
- "Price" → "80000"

This made validation easy because I could directly fetch values using keys instead of iterating lists.

---

## Q8 – Hashtable vs HashMap

**Answer:**

Hashtable is an older version of HashMap.

- Does not allow **null keys or null values**  
- Slower compared to HashMap  
- Legacy class

In automation frameworks we mostly use **HashMap**, not Hashtable.

---

## Q9 – What happens if you put the same key twice in HashMap?

**Answer:**

- Keys CANNOT be duplicate  
- Values CAN be duplicate  

```java
map.put("price","100");
map.put("price","200");
```

Final value will be **200** — the first one is replaced.

---

## Q10 – How would you store a web table row using HashMap? Explain logic.

**Answer:**

To store a web table row in HashMap:

- Treat each row as key–value pair  
- Usually keep **product name as key**  
- Keep **price as value**  

Reason:
- Product name is unique  
- Easy to search using key  
- Faster validation than iterating lists

---

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


---

# 📌 Collections – TreeSet & Vector (SDET Interview Notes)

---

## 🌳 TreeSet

### What is TreeSet?
- TreeSet is a class that implements the **Set** interface
- It does **NOT allow duplicate elements**
- It **automatically sorts elements** in natural (ascending) order

---

### Properties of TreeSet
- No duplicates
- Maintains **sorted order**
- Slower than HashSet / LinkedHashSet because sorting is involved

---

### When would you use TreeSet in Automation?
TreeSet is used **only when sorting is required**.

**Example scenarios:**
- Verify dropdown values are sorted alphabetically
- Validate sorted product names on UI
- Check sorted report values

---

### Why TreeSet is rarely used in Automation Frameworks?
- Sorting adds performance overhead
- Most automation scenarios need:
  - uniqueness → LinkedHashSet
  - fast lookup → HashSet
- Sorting is usually validated once, not stored repeatedly

---

### Interview One-Liner (TreeSet)
> TreeSet removes duplicates and keeps elements sorted, but it is slower, so it’s used only when sorting is required.

---

## 📦 Vector

### What is Vector?
- Vector is a **legacy implementation of List**
- It is **synchronized (thread-safe) by default**
- Introduced before ArrayList

---

### Properties of Vector
- Allows duplicates
- Maintains insertion order
- Thread-safe (synchronized)
- Slower than ArrayList due to synchronization

---

### Why Vector is NOT used in Automation Frameworks?
- Automation frameworks mostly run in **single-threaded flows**
- Thread safety is not required in most test executions
- Synchronization makes Vector slower
- **ArrayList is faster and preferred**

---

### Interview One-Liner (Vector)
> Vector is a legacy, synchronized List implementation. In modern automation frameworks, we prefer ArrayList because it is faster.

---

## ✅ Summary (Interview Focus)

| Collection | Duplicates | Order | Automation Usage |
|----------|------------|-------|------------------|
| TreeSet | ❌ | Sorted | Rare (sorting cases) |
| Vector | ✅ | Insertion | ❌ Not used |

---

💡 Interview Tip:
For SDET roles (4+ years), **know Vector only conceptually**.  
You will almost never be asked to write code using Vector.
