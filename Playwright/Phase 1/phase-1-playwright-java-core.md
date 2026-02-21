# Phase 1 – Playwright Java Core Foundations
---

# Step 1 – Core Objects in Playwright Java

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
