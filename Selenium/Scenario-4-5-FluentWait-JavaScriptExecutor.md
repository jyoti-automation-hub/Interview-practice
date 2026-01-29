
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
