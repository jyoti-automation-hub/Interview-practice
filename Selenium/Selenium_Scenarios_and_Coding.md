# Selenium Scenario-Based Interview Questions

---

## Round 2 – Scenario 1: Hover, Wait, and Click Submenu (Amazon / Flipkart)

### Interview Scenario
On an e-commerce website like Amazon or Flipkart:

- The category menu is hidden by default  
- Submenu appears **only after mouse hover**  
- Submenu loads with a slight delay  

You need to automate navigation from **Electronics → Mobiles / iPhone**.

---

### Given DOM Structure

```html
<div class="nav-menu">
   <div class="menu-item" id="electronics">
       <span>Electronics</span>

       <div class="sub-menu" style="display:none">
           <ul>
              <li><a href="/mobiles">Mobiles</a></li>
              <li><a href="/laptops">Laptops</a></li>
           </ul>
       </div>
   </div>
</div>
```

---

### Interview Question
How will you automate this scenario using Selenium?

---

### Expected Interview Answer (Approach)

- Since the submenu appears only after hover, I will use the **Actions class**.  
- After hovering, I will apply an **explicit wait** for the submenu element and then click it.

---

### Selenium Code (Interview-Level Logic)

```java
Actions actions = new Actions(driver);

// Locate main menu
WebElement menu = driver.findElement(By.id("electronics"));

// Hover on menu
actions.moveToElement(menu).perform();

// Locate submenu item
WebElement mobilesLink =
        driver.findElement(By.xpath(".//a[text()='Mobiles']"));

// Explicit wait for submenu visibility
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOf(mobilesLink));

// Click submenu
mobilesLink.click();
```

---

### Interview Tips
- Do **not** click the parent menu unless explicitly required  
- Always use **Explicit Wait** for dynamically loaded elements  
- Interviewers focus on **approach and decision-making**, not full runnable code

---

## Round 2 – Scenario 2: New Tab / Window Handling 

### Interview Scenario
On e-commerce websites like Amazon or Flipkart:

- Clicking a product from the listing page opens the product details in a **new tab**
- Selenium does **not** automatically switch to the new tab
- You need to:
  - Switch to the new tab
  - Verify the product page title

---

### Given DOM Structure

```html
<div class="product-list">
   <div class="product-card">
       <a href="/iphone-15" target="_blank" class="product-link">
           iPhone 15
       </a>
   </div>
</div>
```

---

### Interview Question
How will you handle switching to the new tab and verify the product page?

---

### Expected Interview Answer (Approach)

- I will store the parent window handle before clicking the product.  
- After clicking, I will loop through all window handles and switch to the window that is **not equal to the parent**, then verify the title.

---

### Selenium Code Logic (Interview-Level)

```java
// Store parent window
String parentWindow = driver.getWindowHandle();

// Click product link
driver.findElement(By.linkText("iPhone 15")).click();

// Get all open windows
Set<String> allWindows = driver.getWindowHandles();

// Switch to new (child) window
for (String windowId : allWindows) {
    if (!windowId.equals(parentWindow)) {
        driver.switchTo().window(windowId);
        break;
    }
}

// Verify product page title
String title = driver.getTitle();
```

---

### Interview Tips
- Always store **parent window handle before clicking**
- `getWindowHandles()` returns **all window IDs**
- Switch to the window that is **not equal to the parent**
- Interviewers focus on **logic and clarity**, not full runnable code

  ---

  ## Round 2 – Scenario 3: iframe Handlin

### Interview Scenario

- Clicking **Pay Now** opens the payment form inside an **iframe**
- Selenium cannot directly access elements inside an iframe
- You need to:
  - Switch to the iframe
  - Perform payment action
  - Switch back to the main page

---

### Given DOM Structure

```html
<button id="payNow">Pay Now</button>

<iframe id="razorpay-frame" name="razorpay-frame">
   <input type="text" id="cardNumber" />
   <button id="payBtn">Pay</button>
</iframe>
```

---

### Interview Question
How will you automate this payment flow using Selenium?

---

### Expected Interview Answer (Approach)

- Since the element is inside an iframe, I use `driver.switchTo().frame()` to shift control to that frame before interacting with any elements inside it.  
- Once I’m done, I use `driver.switchTo().defaultContent()` to return to the main HTML context.

---

### Selenium Code Logic (Interview-Level)

```java
// Click Pay Now
driver.findElement(By.id("payNow")).click();

// Switch to payment iframe using id
driver.switchTo().frame("razorpay-frame");

// Perform action inside iframe
driver.findElement(By.id("cardNumber")).sendKeys("4111111111111111");
driver.findElement(By.id("payBtn")).click();

// Switch back to main page
driver.switchTo().defaultContent();
```

---

### Interview Tips
- Selenium cannot access iframe elements without switching
- Prefer switching by **id or name** if available
- Always switch back using `defaultContent()` after iframe actions
