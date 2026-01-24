# Java Streams – filter()  
## Scenario 1: Amazon Price Validation (Real Automation Use Case)

---

## 🎯 Goal

Validate only **real product prices** from Amazon search results by:
- Ignoring unavailable products
- Ignoring empty prices
- Ignoring ₹0 prices  
So that assertions are done only on **valid data**.

---

## 🧪 Selenium + Java Streams Code

```java
// Step 1: Capture all price elements from search results
List<WebElement> priceElements = driver.findElements(
        By.xpath("//span[@class='a-price-whole']")
);

// Step 2: Filter valid prices and convert them to integers
List<Integer> validPrices = priceElements.stream()

        // Convert WebElement → String (price text)
        .map(WebElement::getText)

        // Remove empty prices
        .filter(price -> !price.isEmpty())

        // Remove commas (e.g. "12,999" → "12999")
        .map(price -> price.replace(",", ""))

        // Convert String → Integer
        .map(Integer::parseInt)

        // Keep only prices greater than 0
        .filter(price -> price > 0)

        // Collect final valid prices into a List
        .collect(Collectors.toList());

// Validation: ensure at least one valid price exists
Assert.assertFalse(validPrices.isEmpty(), "No valid prices found");

```

---

## 🧠 Line-by-Line Explanation (Simple & Interview-Friendly)

- **findElements(...)**  
  Captures all price elements from the page, including valid, empty, and unavailable prices.

- **stream()**  
  Converts the List into a Stream so elements can be processed one by one using stream operations.

- **map(WebElement::getText)**  
  Extracts text from each WebElement (price values from UI).

- **filter(price -> !price.isEmpty())**  
  Removes empty or missing price values.

- **map(price -> price.replace(",", ""))**  
  Cleans the price string by removing commas so it can be converted to a number.

- **map(Integer::parseInt)**  
  Converts price from String to Integer for numeric validation.

- **filter(price -> price > 0)**  
  Removes zero or invalid prices.

- **collect(Collectors.toList())**  
  Converts the processed Stream back into a usable List.

- **Assert.assertFalse(...)**  
  Validates that at least one valid price exists on the page.
  
  ---

## ❓ Why `filter()` Is Used Here

- UI data is often **not clean** (mix of valid, empty, or unavailable values)
- `filter()` removes **unwanted entries before validation**
- Helps **prevent false test failures**
- Replaces **complex nested loops** with clean, readable logic
- Makes validations **more reliable and maintainable** in automation frameworks

---

## 🎤 Interview One-Liner (Product Company Ready)

> “I use Java Streams `filter()` to remove unavailable or empty prices from search results and validate only real product prices.”
