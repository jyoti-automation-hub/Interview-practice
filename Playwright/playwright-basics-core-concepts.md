# 🎭 Playwright Basics

---

## 🎤 Explain the architecture of Playwright

**Answer:**

Playwright uses a client–server architecture where the test code talks directly to the browser engines (Chromium, Firefox, WebKit) via browser-specific protocols.

Playwright talks directly to the browser, not through WebDriver like Selenium.

Because of this direct connection, it can automatically wait for elements, handle modern JavaScript apps better, and reduce flaky tests.

That’s why Playwright tests are usually faster and more stable.

---

## 🎤 What is the difference between BrowserContext and Page in Playwright?  
### And why do we even need BrowserContext?

**Answer:**

Playwright runs each test in a separate BrowserContext, which is like an incognito browser profile.

This ensures no cookies, storage, or login state is shared between tests.

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
