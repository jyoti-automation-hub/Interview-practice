# 🎭 Playwright Basics

---

## 🎤 Explain the architecture of Playwright

**Answer:**

Playwright uses a client–server architecture where test code talks directly to browser engines like Chromium, Firefox, and WebKit using browser-specific protocols. Unlike Selenium, it doesn’t use WebDriver. Because of this direct communication, Playwright has built-in auto-waits, handles modern JavaScript applications better, and reduces flaky tests, which makes it faster and more stable.

---

## 🎤 What is the difference between BrowserContext and Page in Playwright?  
### And why do we even need BrowserContext?

**Answer:**

> We use BrowserContext to avoid test interference. It’s like running tests in incognito mode, so no cookies or login details are shared.
> Page represents a single tab where test actions like click and type happen.

In Playwright, each test runs in its own BrowserContext, so even if multiple tests run together, they don’t share cookies, storage, or login state. Inside a BrowserContext, a Page represents the actual tab where actions like clicking or typing happen.

---

## 🎤 How does Playwright handle waits, and why do we usually avoid explicit waits like sleep?

**Answer:**

Playwright handles waits using built-in auto-wait mechanisms.

We avoid explicit waits like sleep because they are fixed, slow, and cause flaky tests.

---

## 🎤 What are Playwright locators, and why are they more reliable than XPath or CSS selectors?

**Answer:**

Playwright locators are used to find and interact with elements, and they are more reliable because they have built-in auto-waits and avoid ambiguous element matches.

---

## 🎤 What is storageState in Playwright, and why would you use it?

**Answer:**

storageState is used to save and reuse authentication state like cookies and storage.

We use it to avoid logging in repeatedly and speed up test execution.

---

### 📝 Notes

storageState = saved login/session data

It stores:
- cookies
- localStorage
- sessionStorage

Basically: **“Already logged-in user state”**

---

### 🔹 Do we actually use it in coding?

👉 Yes — but only for login optimization
