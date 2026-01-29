# 🔵 Scenario 1 – Hover, Wait, and Navigate (Amazon / Flipkart)

## 🎯 Interview Scenario

On an e-commerce website like **Amazon or Flipkart**:

- The **Electronics** category is visible in the header
- Submenu options appear **only after mouse hover**
- The submenu loads with a slight delay
- Clicking **Mobiles** navigates to the **Mobiles listing page**
- Products like **iPhone** are displayed on the listing page

**Task:**  
Automate navigation from **Electronics → Mobiles** using Selenium.

---

## 🎤 Interview Question

> How would you automate a hover-based category menu, wait for the submenu to load, and click a submenu option in a real e-commerce application like Amazon or Flipkart

---

## 🧩 Product-Accurate DOM Structures

### 🔹 DOM 1: Header Navigation (Hover Menu)

```html
<div id="nav-main">
  <div class="nav-item" data-category="electronics">
    <span class="nav-label">Electronics</span>

    <div class="nav-flyout">
      <a href="/mobile-phones" class="nav-link">Mobiles</a>
      <a href="/laptops" class="nav-link">Laptops</a>
    </div>
  </div>
</div>
```
---
```html
<div class="product-grid">
  <div class="product-card">
    <span class="product-title">iPhone 15</span>
    <a href="/iphone-15" target="_blank">View</a>
  </div>

  <div class="product-card">
    <span class="product-title">Samsung Galaxy S23</span>
  </div>
</div>
```
---

### ✅ Selenium Code (Interview-Level)

```java
WebElement electronicsMenu = driver.findElement(
        By.xpath("//div[@data-category='electronics']")
);

Actions actions = new Actions(driver);
actions.moveToElement(electronicsMenu).perform();

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement mobiles = wait.until(
        ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='Mobiles']")
        )
);
mobiles.click();

```
---

### 🧠 Explanation (How to Explain in Interview)

- `electronicsMenu`  
  → Locates the category menu element on which hover action is required

- `Actions actions = new Actions(driver)`  
  → Used to perform mouse interactions such as hover, click-and-hold, etc.

- `moveToElement(electronicsMenu).perform()`  
  → Hovers the mouse over the Electronics menu, which triggers the submenu

- `WebDriverWait`  
  → Used for dynamic waiting instead of fixed delays like `Thread.sleep`

- `elementToBeClickable(Mobiles)`  
  → Ensures the submenu option is fully loaded and ready before clicking

👉 **Waiting for submenu = waiting for the Mobiles element to become clickable**
