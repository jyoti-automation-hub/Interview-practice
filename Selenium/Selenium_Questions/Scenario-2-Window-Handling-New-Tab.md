# 🔵 Scenario 2 – Product Click Opens in New Tab (Amazon / Flipkart)

## 🎯 Scenario

On an e-commerce website like **Amazon or Flipkart**:

- Products are displayed on a **listing page**
- Clicking a product opens the **product detail page in a new tab**
- Automation must:
  - click the product
  - switch to the new tab
  - continue validation on the product page

**Task:**  
Automate clicking a product from the listing page and handle window switching.

---

## 🎤 Question

> When clicking a product opens a new tab, how do you handle multiple windows in Selenium and switch control to the new tab?

---

## 🧩 Product-Accurate DOM Structure (Single DOM)

```html
<div class="product-grid">
  <div class="product-card">
    <span class="product-title">iPhone 15</span>
    <a href="/iphone-15" class="product-link" target="_blank">View</a>
  </div>

  <div class="product-card">
    <span class="product-title">Samsung Galaxy S23</span>
    <a href="/samsung-s23" class="product-link" target="_blank">View</a>
  </div>
</div>
```

---


### ✅ Selenium Code

```java
// Click on product
WebElement product = driver.findElement(
        By.xpath("//span[text()='iPhone 15']")
);
product.click();

// Store parent window ID
String parentWindowId = driver.getWindowHandle();

// Get all open window IDs
Set<String> allWindowIds = driver.getWindowHandles();

// Switch to new window
for (String currentWindowId : allWindowIds) {
    if (!currentWindowId.equals(parentWindowId)) {
        driver.switchTo().window(currentWindowId);
        break;
    }
}

// Driver control is now on product detail page

```

---
### 🧠 Explanation (How to Explain)

- `getWindowHandle()`  
  → Stores the **current (parent) window ID**

- `getWindowHandles()`  
  → Returns IDs of **all open windows or tabs**

- Loop through window IDs  
  → Identify the **new tab** by excluding the parent window ID

- `driver.switchTo().window()`  
  → Switches Selenium control to the **product detail page**

👉 This approach ensures Selenium interacts with the correct browser tab after navigation.


---

## 🔁 Scenario 2 – Follow-up Questions & Answers (Window Handling)

### ❓ Follow-up 1: What if the product sometimes opens in the same tab instead of a new tab?

**Answer:**  
First, I verify whether opening in the same tab is expected behavior or a bug by checking the business requirement. If it is expected, I continue validation in the same window. If a new tab is expected but doesn’t open, I treat it as a functional issue.

---

### ❓ Follow-up 2: What if multiple tabs are already open before clicking the product?

**Answer:**  
I store the current window ID before clicking the product. After the click, I fetch all window IDs and switch to the one that is different from the parent window. This approach works even when multiple tabs are already open.

---

### ❓ Follow-up 3: How would you switch back to the parent window after validation?

**Answer:**  
I store the parent window ID before switching. After completing validations in the new tab, I use `driver.switchTo().window(parentWindowId)` to return control back to the original window.

---

### ❓ Follow-up 4: What if `getWindowHandles()` returns only one window ID?

**Answer:**  
This usually means the product opened in the same tab. In that case, no window switching is required, and I continue validation in the current window.

---

### ❓ Follow-up 5: How would you make this window-handling logic reusable in a framework?

**Answer:**  
I would move the window-switching logic into a reusable utility or base class method. This avoids duplication and allows multiple test cases to reuse the same window-handling logic.

---

### ❓ Follow-up 6: Why didn’t you use `driver.close()` instead of `driver.quit()`?

**Answer:**  
`driver.close()` closes only the current browser window, while `driver.quit()` closes all browser sessions. I use `close()` when I want to close a specific tab and continue testing, and `quit()` at the end of execution.

---

### ❓ Follow-up 7: If a test fails only in CI while switching windows, what would you check?

**Answer:**  
I first check synchronization issues by adding proper explicit waits before switching windows. I also verify locator stability and browser configuration in CI. If timing issues persist, I use FluentWait for better control over polling and dynamic behavior.

---

### 🔑 Tip
- Always store the parent window ID
- Don’t assume a new tab will always open
- Handle both same-tab and new-tab scenarios
- Keep window-handling logic reusable and simple
