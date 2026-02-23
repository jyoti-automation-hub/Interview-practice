# Stage 2 – Playwright Java Scenario Mastery

---

## 🔐 1️⃣ Authentication Handling

**Q:** How do you handle authentication for large test suites?

---

## 👥 2️⃣ Multi-User Simulation

**Q:** How do you simulate multiple users in the same test?

---

## 🗂 3️⃣ Multiple Tabs / Popups

**Q:** How do you handle multiple tabs or popups in Playwright?

---

## 🧪 4️⃣ CI Debugging

**Q:** Tests pass locally but fail in CI. How do you debug?

---

## 🛠 5️⃣ Flaky Test Handling

**Q:** How do you handle flaky tests?

---

## ⚡ 6️⃣ Parallel Execution

**Q:** How does parallel execution work in Playwright?

---

## 🏗 7️⃣ Framework Design

---
## ❓ Question
---
***You have 200 Playwright tests. All require login.
How would you handle authentication efficiently?***
---

If every test performs login:

- ❌ Slower execution
- ❌ Repeated authentication calls
- ❌ Increased flakiness
- ❌ Unnecessary server load

We need a scalable and efficient authentication strategy.

---

# ✅ Solution: Use `storageState`

Playwright allows saving authenticated session state (cookies + localStorage) into a file and reusing it across tests.

---
# 🧠 High-Level Strategy

1. Login once
2. Save authentication session to a file
3. Reuse the saved session in all other tests
4. Tests start already logged in

✔ No repeated login  
✔ Faster execution  
✔ Cleaner test design  

---

# 🛠 Implementation (Java – Playwright)

---

## 🟢 Step 1: Login Once and Save Session

```java
Browser browser = playwright.chromium().launch();
BrowserContext context = browser.newContext();
Page page = context.newPage();

// Perform login
page.navigate("https://example.com/login");
page.fill("#username", "validUser");
page.fill("#password", "password");
page.click("#loginButton");

// Wait for successful login
page.waitForURL("**/dashboard");

// Save authentication state
context.storageState(new BrowserContext.StorageStateOptions()
        .setPath(Paths.get("auth.json")));

browser.close();

```
---

## ❓ Question
---
Think Amazon example.

User A → Customer
User B → Admin

If both are inside the same BrowserContext →
They share cookies → Same session → Same user ❌

---

I create two separate BrowserContexts so each user has an isolated session. Then I create a Page inside each context and perform actions independently.

---

## 🧪 Example Code

```java

// Create first user session
BrowserContext userAContext = browser.newContext();
Page userAPage = userAContext.newPage();
userAPage.navigate("https://app.com/login");
// login as User A

// Create second user session
BrowserContext userBContext = browser.newContext();
Page userBPage = userBContext.newPage();
userBPage.navigate("https://app.com/login");
// login as User B

// Now both users can perform actions independently


```
---


## ❓ Question
How do you handle multiple tabs or popups in Playwright?

---

## ✅ Approach

When a new tab or popup opens, Playwright creates a new `Page` inside the same `BrowserContext`.

We listen for the new page event, capture the new `Page` object, and then perform actions on it.

---

## 🧪 Example Code

```java
// Wait for new tab to open
Page newPage = context.waitForPage(() -> {
    page.click("text=Open New Tab");
});

// Perform actions in the new tab
newPage.click("text=Continue");

```

---


# Stage 2 – CI Failures Debugging (Playwright Java)

## ❓ Question
Tests pass locally but fail in CI. How do you debug?

---

## ✅ Approach

If tests fail in CI but pass locally, I:

- Check for synchronization or timing issues
- Verify that locators are stable
- Enable Playwright Trace Viewer to analyze the failure
- Compare environment differences like browser version or headless execution

---
## 🧠 Key Tool

Playwright **Trace Viewer** helps visually inspect failed tests in CI, including actions, network calls, and screenshots.

# Stage 2 – Handling Flaky Tests (Playwright Java)

## ❓ Question
How do you handle flaky tests?

---

## ✅ Answer

To handle flaky tests, I first check for synchronization issues or unstable locators.  
I avoid fixed waits like `Thread.sleep()` and rely on Playwright’s auto-wait mechanism.  
I also use Trace Viewer to analyze failures and fix the root cause instead of masking the issue.

# Stage 2 – Parallel Execution (Playwright Java)

## ❓ Question
How does parallel execution work in Playwright?

---

## ✅ Answer

Playwright supports parallel execution using multiple workers.  
Each worker runs tests in separate BrowserContexts, ensuring isolation and faster execution.

# Stage 2 – Framework Design (Playwright Java)

## ❓ Question
How would you structure a scalable Playwright framework?

---

## ✅ Answer

I would structure the framework using Page Object Model so that locators and test logic are separated. I’d keep tests, page classes, and utilities in different layers to keep things clean. I’d also centralize things like authentication and browser setup so we don’t repeat code everywhere. The main goal is to keep the framework easy to maintain and scalable as the number of tests grows.












