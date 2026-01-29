# 🔵 Scenario 3 – Payment iFrame Handling (Amazon / Flipkart / Razorpay)

## 🎯 Interview Scenario

On an e-commerce website like **Amazon / Flipkart / Myntra**:

- User clicks **Pay Now**
- Payment form loads inside a **third-party iframe** (Razorpay / Stripe)
- Card details are inside the iframe
- Selenium cannot access iframe elements directly

**Task:**  
Automate entering card details inside an iframe and return back to the main page.

---

## 🧩 Product-Accurate DOM Structure

```html
<button id="pay-now">Pay Now</button>

<iframe id="payment-frame" name="razorpay-frame">
  <input id="card-number" type="text" />
  <input id="expiry" type="text" />
  <input id="cvv" type="password" />
</iframe>
```

---

Since the payment form is inside an iframe, I switch to the iframe before interacting with card fields. After completing the payment steps, I switch back to the main page.

### ✅ Selenium Code (Interview-Level)

```java
// Click on Pay Now
driver.findElement(By.id("pay-now")).click();

// Explicit wait for iframe and switch to it
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
        By.id("payment-frame")
));

// Enter card details inside iframe
driver.findElement(By.id("card-number")).sendKeys("4111111111111111");
driver.findElement(By.id("expiry")).sendKeys("12/26");
driver.findElement(By.id("cvv")).sendKeys("123");

// Switch back to main page
driver.switchTo().defaultContent();

```

---


