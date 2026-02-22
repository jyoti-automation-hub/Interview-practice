# Phase 1 – Playwright Java Core Foundations
---
## 🧱 Architecture & Isolation

1. What is the difference between Browser, BrowserContext, and Page?

2. What happens when we use `browser.newPage()`?

3. When would you manually create a BrowserContext?

4. Can two pages in the same context simulate two users? Why?

---

## ⏳ Waiting & Stability

5. What is auto-wait in Playwright?

6. Why should we avoid `Thread.sleep()` or `waitForTimeout()`?

7. When would you use `waitForSelector()`?

---

## 🎯 Locators

8. What locator types do you commonly use in Playwright?

9. When would you use `getByRole()` instead of CSS?

10. How are Playwright locators different from Selenium locators?

---

## 🔧 Basic Validation & Actions

11. How do you validate that login was successful?

12. How does Playwright handle synchronization differently from Selenium?

---
---
# Step 1 – Core Objects in Playwright Java

***Explain Browser, BrowserContext, and Page in interview language.***
---
Browser represents the actual browser instance like Chromium or Firefox.
BrowserContext represents an isolated session inside the browser, similar to an incognito window.
Page represents a single tab inside that context where we perform actions like click and fill.

---

***What happens when we use browser.newPage()?***
---
It creates a new Page inside a default BrowserContext. If no context exists, Playwright creates one internally.

---

# Stage 1 – BrowserContex

***❓ Question***
***When would you manually create a BrowserContext?***

---

## ✅ Answer

I manually create a BrowserContext when I need session isolation, such as simulating multiple users or handling separate login states. It allows control over cookies, storage, and permissions.

---

## 🛒 Example (Amazon Scenario)

If I need to simulate:

- Customer user browsing products
- Admin user approving orders

I create two separate BrowserContexts so both users have independent login sessions and data.

Using the same context would share cookies and session, making them behave as the same user.

---
# Stage 1 – Question 4

## ❓ Question
Can two pages in the same BrowserContext simulate two users? Why?

---

## ❌ Answer

No. Two pages in the same BrowserContext share the same cookies, storage, and login session, so they behave as the same user.

To simulate independent users, we must create separate BrowserContexts.

---

# Stage 1 – Question 5

## ❓ Question
What is auto-wait in Playwright?

---

## ✅ Answer

Auto-wait is an in-built mechanism in Playwright that automatically waits for an element to be ready before performing actions like click or fill.

This reduces the need for manual waits such as `Thread.sleep()`.

---
# Stage 1 – Question 6

## ❓ Question
Why should we avoid `Thread.sleep()` or `waitForTimeout()`?

---

## ✅ Answer

`Thread.sleep()` or `waitForTimeout()` uses a fixed wait time. It may wait longer than necessary or not enough, which makes tests slower and potentially flaky.

---

# Stage 1 – Question 7

## ❓ Question
When would you use `waitForSelector()`?

---

## ✅ Answer

I use `waitForSelector()` when I need to explicitly wait for an element to appear or disappear, especially in scenarios where auto-wait is not sufficient.

---

# Stage 1 – Question 8

## ❓ Question
What locator types do you commonly use in Playwright?

---

## ✅ Answer

I commonly use CSS selectors when ID or class is available, `text=` for selecting elements by visible text, and `getByRole()` for stable, accessibility-based selection. I use `locator()` in Page Object Model for better reusability.

---

# Stage 1 – Question 9

## ❓ Question
When would you use `getByRole()` instead of CSS?

---

## ✅ Answer

I use `getByRole()` for interactive elements like buttons, links, or inputs because it is accessibility-based and more stable than CSS. It reduces dependency on DOM structure or class names.

---

# Stage 1 – Question 10

## ❓ Question
How are Playwright locators different from Selenium locators?

---

## ✅ Answer

Playwright locators have built-in auto-waiting and support user-visible attributes like text and roles. Unlike Selenium, which often relies on XPath and explicit waits, Playwright encourages more stable and readable selectors.

---


# Stage 1 – Question 11

## ❓ Question
How does Playwright handle synchronization differently from Selenium?

---

## ✅ Answer

Playwright has built-in auto-waiting for actions like click and fill, so we don’t need to manage explicit waits as much as in Selenium. Selenium relies more on implicit and explicit waits, which increases complexity.

---

***What is auto-wait in Playwright?***
---


## Architecture

Playwright → Browser → BrowserContext → Page

## Example

```java
Playwright playwright = Playwright.create();
Browser browser = playwright.chromium().launch(); //This creates an isolated session (like incognito).

// Creates a default BrowserContext internally
Page page = browser.newPage();

page.navigate("https://example.com");
```
---

# Phase 1 – Step 2  
# Basic Element Interaction (Playwright Java)

---

## 1️⃣ Click a Button (id = loginBtn)

### ✅ Playwright Java

```java
page.click("#loginBtn");
```
---

> 🔁 Selenium Equivalent

```java
driver.findElement(By.cssSelector("#loginBtn")).click();
```

🎤 Interview Note

Playwright automatically waits for elements to be visible and actionable before performing actions like click() or fill().

There is usually no need for Thread.sleep().
