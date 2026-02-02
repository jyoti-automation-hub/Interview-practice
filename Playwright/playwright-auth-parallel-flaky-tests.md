# 🎭 Playwright Basics – Advanced Questions

---

## 🎤 How would you handle authentication in Playwright for a large test suite?

### ✅ What it means by “authentication”

They mean:
- Login
- Session handling
- Avoiding repeated login in every test

So yes 👉 storageState.

For a large test suite, I handle authentication by logging in once and saving the authentication state using storageState.  
This state is then reused across tests so we avoid repeated logins and keep tests fast and stable.

---

## 🎤 How does Playwright support parallel execution, and how does it avoid test interference?

Playwright runs tests in parallel using multiple workers.  

It avoids interference by running each test in an isolated BrowserContext with a clean user state.

---

## 🎤 How do you handle flaky tests in Playwright?

I handle flaky tests by relying on Playwright’s auto-waits and improving locators and assertions.  

If needed, I use Playwright’s built-in waits.

---

## 🎤 What is the difference between page.waitForTimeout() and Playwright auto-waits?

Playwright auto-wait means Playwright waits until the element appears and is usable before clicking or typing.  

page.waitForTimeout() waits for a fixed time and should be avoided because it causes slow and flaky tests.

---

## 🎤 How do you handle multiple tabs or pop-ups in Playwright?

When an action opens a new tab or popup, Playwright automatically detects it.  

I wait for that new page and then continue my test on that page instead of switching windows manually.
