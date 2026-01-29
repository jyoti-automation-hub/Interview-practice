# Selenium Scenario-Based Questions

---

## Round 2 – Scenario 1: Hover, Wait, and Click Submenu (Amazon / Flipkart)

### Scenario
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

### Question
How will you automate this scenario using Selenium?

---

### Expected Answer (Approach)

- Since the submenu appears only after hover, I will use the **Actions class**.  
- After hovering, I will apply an **explicit wait** for the submenu element and then click it.

---

### Selenium Code (Logic)

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

### Tips
- Do **not** click the parent menu unless explicitly required  
- Always use **Explicit Wait** for dynamically loaded elements  
- Interviewers focus on **approach and decision-making**, not full runnable code

---

## Round 2 – Scenario 2: New Tab / Window Handling 

### Scenario
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

### Question
How will you handle switching to the new tab and verify the product page?

---

### Expected Answer (Approach)

- I will store the parent window handle before clicking the product.  
- After clicking, I will loop through all window handles and switch to the window that is **not equal to the parent**, then verify the title.

---

### Selenium Code Logic

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

### Tips
- Always store **parent window handle before clicking**
- `getWindowHandles()` returns **all window IDs**
- Switch to the window that is **not equal to the parent**
- Interviewers focus on **logic and clarity**, not full runnable code

  ---

  ## Round 2 – Scenario 3: iframe Handling

### Scenario

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

### Question
How will you automate this payment flow using Selenium?

---

### Expected Answer (Approach)

- Since the element is inside an iframe, I use `driver.switchTo().frame()` to shift control to that frame before interacting with any elements inside it.  
- Once I’m done, I use `driver.switchTo().defaultContent()` to return to the main HTML context.

---

### Selenium Code Logic

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

### Tips
- Selenium cannot access iframe elements without switching
- Prefer switching by **id or name** if available
- Always switch back using `defaultContent()` after iframe actions

 ---

 ## Round 2 – Scenario 4: Button Color Change using FluentWait (Apple Style)

### Scenario
On product or internal dashboards:

- A button initially appears **blue**
- After some backend processing, it turns **green**
- You need to wait for the color change and then validate it

---

### Given DOM Structure

```html
<button id="submitBtn" style="background-color: blue;">
    Submit
</button>
```

After processing:

```html
<button id="submitBtn" style="background-color: green;">
    Submit
</button>
```

---

### Question
How will you validate that the button color changes from blue to green using Selenium?

---

### Selenium Code (Interview-Level – Yes, this is the scary part 😄)

```java
WebElement submitBtn = driver.findElement(By.id("submitBtn"));

Wait<WebDriver> wait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(10))
        .pollingEvery(Duration.ofSeconds(1))
        .ignoring(Exception.class);

wait.until(driver ->
        submitBtn.getCssValue("background-color").equals("green")
);
```

---

### Human Explanation (How to Say It in Interview)

> “Here the button is already visible, but its color changes after some processing.  
> I use FluentWait so Selenium keeps checking the button’s color until it becomes green, instead of waiting blindly.”

---

### Why FluentWait? (Simple, Human Answer)

- I **don’t use Implicit wait** because it applies everywhere and doesn’t fit dynamic behavior  
- I **don’t prefer Explicit wait here** because I need to keep checking a changing property  
- I **use FluentWait** because it lets me repeatedly check the button color until it changes. Because the property changes dynamically, FluentWait lets me keep checking until it updates

---

### Memory Tip 🧠 (DO NOT MEMORIZE CODE — Remember This Instead)

FluentWait = **3 things only**

- **Timeout** → how long to wait  
  (`withTimeout(Duration.ofSeconds())`)
- **Polling** → how often to check  
  (`pollingEvery(Duration.ofSeconds())`)
- **Custom Condition** → what to wait for  
  (`wait.until(condition)`)

---

### Interview Tip
Interviewers care more about **why** you chose FluentWait than whether you remember the exact syntax.


---

### Short Note: What is Polling in FluentWait? (Interview Friendly)

#### Question  
**What do you mean by polling in FluentWait?**

#### Simple Answer  
Polling means **checking a condition again and again at fixed intervals until it becomes true or timeout happens**.

---

#### Example (Button Color Change Scenario)

```java
.withTimeout(Duration.ofSeconds(10))
.pollingEvery(Duration.ofSeconds(1))
```

#### What this means (Human Explanation)

- Selenium will **check the condition every 1 second**
- It will **keep checking for a maximum of 10 seconds**
- In this case, Selenium checks every second whether the button color has changed to green
- If the color becomes green within 10 seconds → ✅ test passes  
- If the color does not change even after 10 seconds → ❌ test fails due to timeout

---

#### Easy Way to Remember 🧠

- **Timeout** → how long to wait (10 seconds)  
- **Polling** → how often to check (every 1 second)  
- **Condition** → what to check (color becomes green)

> Polling never runs forever — **timeout always stops it**.


---
## Round 2 – Scenario 5: JavaScriptExecutor for Hidden / Off-Screen Element (Amazon / Apple)

### Interview Scenario
On e-commerce or product dashboards:

- The element is **present in the DOM**
- But it is:
  - outside the visible screen, or
  - overlapped by another element
- Normal `click()` fails

In such cases, Selenium is expected to use **JavaScriptExecutor**.

---

### Given DOM Structure

```html
<div style="height:1200px"></div>

<button id="buyNowBtn">
   Buy Now
</button>
```

---

### Interview Question
How will you click the **Buy Now** button using Selenium?

---

### Expected Interview Answer (Approach)

- When normal Selenium click does not work because the element is off-screen or blocked, I use **JavaScriptExecutor**.  
- I scroll to the element and then click it directly using browser commands.

---

### Selenium Code Logic (Interview-Level)

```java
WebElement buyNowBtn = driver.findElement(By.id("buyNowBtn"));

JavascriptExecutor js = (JavascriptExecutor) driver;

// Scroll to the element
js.executeScript("arguments[0].scrollIntoView(true);", buyNowBtn);

// Click the element using JavaScript
js.executeScript("arguments[0].click();", buyNowBtn);
```

---

### Human Explanation (How to Say It in Interview)

> “Here the element is present but Selenium is unable to click it normally.  
> So I use JavaScriptExecutor to scroll to the element and click it directly.”

---

### Why JavaScriptExecutor? (Simple Reason)

- Normal click may fail if the element is off-screen or blocked  
- JavaScriptExecutor forces the browser to perform the action  
- It is useful only when normal Selenium actions do not work

---
