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
Solution (storageState idea):
	1.	Login once.
	2.	Save the login session (cookies + storage) to a file.
	3.	For all other tests, start the browser using that saved session.
	4.	Tests start already logged in.

No repeated login.

---

// Step 1: Login once
loginWithValidUser();

// Step 2: Save session
context.saveStorageState("auth.json");

// Step 3: Reuse in other tests
context = browser.newContext(withStorageState("auth.json"));
page = context.newPage();

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















