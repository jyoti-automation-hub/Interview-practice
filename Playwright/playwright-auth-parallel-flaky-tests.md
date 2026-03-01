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

---

---
## 🎤 🧠 Core Architecture

1️⃣ What makes Playwright different from Selenium?

## 🎤2️⃣ How does Playwright auto-wait work?

Playwright has a built-in auto-wait mechanism that automatically waits for elements to be visible, stable, and enabled before performing actions like click or fill. This reduces the need for explicit waits and makes tests less flaky.

## 🎤3️⃣ What is the difference between Browser, BrowserContext, and Page?

Browser represents the actual browser instance like Chromium or Firefox.
BrowserContext represents an isolated session within that browser, similar to an incognito window, where cookies and login sessions are not shared.
Page represents a single tab inside that context where we perform actions like click and fill.

## 🎤4️⃣ Why do we use BrowserContext?

We use BrowserContext to create isolated sessions within the same browser. For example, if I need to simulate multiple users like a customer and an admin, I create separate BrowserContexts so their login sessions, cookies, and storage are not shared. This ensures they act as independent users.

## 🎤5️⃣ Can two pages in the same context simulate two users? Why?

No, two pages in the same BrowserContext cannot simulate two users because they share the same cookies, storage, and login session, so they behave as the same user.

⸻

## 🎤🔐 Authentication & Sessions

## 🎤6️⃣ How do you handle authentication for large test suites?

For large test suites, instead of logging in before every test, I log in once and save the authenticated session using storageState. This stores cookies and local storage in a file. Then I reuse that stored state to create new contexts, so tests start already logged in. This improves speed and reduces flakiness.

## 🎤7️⃣ How do you simulate multiple users in the same test?

To simulate multiple users in the same test, I create separate BrowserContext instances. Each context maintains its own cookies and session, so different users like admin and customer can act independently within the same test.

Sample code 

// Create first user session (Customer)
BrowserContext customerContext = browser.newContext();
Page customerPage = customerContext.newPage();
customerPage.navigate("https://app.com/login");
// login as customer

// Create second user session (Admin)
BrowserContext adminContext = browser.newContext();
Page adminPage = adminContext.newPage();
adminPage.navigate("https://app.com/login");
// login as admin

// Now both users can perform actions independently
customerPage.click("text=Place Order");
adminPage.click("text=Approve Order");


## 🎤What’s happening?
	•	customerContext → independent session
	•	adminContext → completely separate session
	•	Cookies, storage, login not shared

Two contexts = two users.

⸻

## 🎤🧪 Stability & Debugging

## 🎤8️⃣ Why should we avoid Thread.sleep()?

We should avoid Thread.sleep() because it uses a fixed wait time. It may wait longer than necessary, making tests slower, or not long enough, causing flakiness. Instead, we should rely on Playwright’s auto-wait mechanism.

## 🎤9️⃣ How do you handle flaky tests?

To handle flaky tests, I first identify the root cause, whether it is due to unstable locators or synchronization issues. I ensure I am using stable selectors and rely on Playwright’s auto-wait instead of fixed waits. I also use Trace Viewer to analyze failures and fix the actual issue rather than masking it.

## 🎤🔟 Tests pass locally but fail in CI. How do you debug?

I first check for synchronization issues or unstable locators. Then I compare environment differences such as headless mode, browser version, or execution speed. I enable Playwright Trace Viewer in CI to analyze the failure and identify the exact root cause.

⸻

## 🎤⚡ Scaling & Execution

## 🎤1️⃣1️⃣ How does parallel execution work in Playwright?

Playwright runs tests in parallel using multiple workers.

Each worker:
	•	Launches its own BrowserContext
	•	Runs tests independently
	•	Keeps sessions isolated

- So tests don’t interfere with each other and execution becomes faster.
        We use parallel execution to reduce total test execution time. 

- Parallel execution is configured at the test runner level. Playwright uses multiple workers, and each worker runs tests in isolated BrowserContexts to prevent session interference.

## 🎤1️⃣2️⃣ How would you structure a scalable Playwright framework?

⸻

## 🎤🧱 Real UI Scenarios

## 🎤1️⃣3️⃣ How do you handle multiple tabs or popups?

You are on Page A.
You click a button.
That button opens Page B (new tab).
Then you perform actions on Page B.


// Step 1: Launch browser
Browser browser = playwright.chromium().launch();

// Step 2: Create a browser context
BrowserContext context = browser.newContext();

// Step 3: Create Page A
Page page = context.newPage();

// Step 4: Navigate to Page A
page.navigate("https://example.com");

// Step 5: Wait for new tab while clicking
Page newPage = context.waitForPage(() -> {  
👉 Means: “Wait until a new tab (Page) is created inside this context.”
    page.click("text=Open Page B");
});

// Step 6: Perform action on Page B
newPage.click("text=Continue");

When a new tab opens, I use context.waitForPage() to capture the new Page object. Then I perform actions on that Page directly. Unlike Selenium, Playwright doesn’t require manual window switching.

## 🎤1️⃣4️⃣ How do you handle dynamic elements without hard waits?

For dynamic elements, I rely on Playwright’s built-in auto-wait instead of using hard waits. It automatically waits for elements to be ready before interaction, and I use stable locators with proper assertions.

## 🎤1️⃣5️⃣ How do you properly validate that login was successful?

After login, I verify that a unique element like the dashboard heading or profile icon is visible using assertions.


