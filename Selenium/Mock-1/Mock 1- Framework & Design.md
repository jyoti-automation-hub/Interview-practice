***Can you explain how you design a Selenium automation framework?
What are the main components, and why do you structure it that way?***
---
I design my Selenium framework using the Page Object Model. I keep a Base class that handles WebDriver initialization, browser setup, waits, and common reusable methods. Each page has its own Page class where I define locators and page-level actions, such as LoginPage or HomePage. Test classes contain only test logic and call methods from page classes. I also keep configuration files for environment and browser details, utility classes for common functions, and reporting and logging to make the framework maintainable and scalable.

---
***Why do you prefer Page Object Model over putting locators directly in test classes?***
---

I prefer Page Object Model because it separates test logic from locators and page actions. Locators are maintained in page classes, so if something changes, we update it in one place instead of multiple test classes, which improves maintainability.

---

***How do you handle flaky tests in Selenium?***
---
I handle flaky tests by using stable locators and avoiding hard waits like Thread.sleep. I rely on condition-based explicit waits so actions happen only when elements are ready. I also review synchronization issues and remove timing dependencies.

> synchronization issue - It means checking where the test is running faster than the application.

---

***How do you handle dynamic elements in Selenium?***
---
I handle dynamic elements by avoiding absolute XPaths and using stable locators like relative XPath with contains() or CSS selectors, along with proper waits.

---

***✌🏻How do you handle StaleElementReferenceException in Selenium?***
---
> StaleElementReferenceException - It occurs when the page changes and the previously located element is no longer valid, so Selenium must find it again.
 
> I handle StaleElementReferenceException by re-locating the element and using explicit waits. Since the DOM gets refreshed, I make sure to find the element again before interacting with it.

---

***How do you handle multiple windows or tabs in Selenium?***
---
I handle multiple windows using getWindowHandles() to get all window IDs and then switch to the required window based on a condition. After completing actions, I switch back to the main window.

---

***How do you handle browser and driver management in Selenium?***
---
I make sure tests can run on different browsers and that browser setup is handled before execution, so tests are not hard-coded to one browser.

---
***✌🏻How do you run Selenium tests in parallel, and what challenges have you faced with it?***
---


I use TestNG to enable parallel execution and since WebDriver is not thread-safe, I use ThreadLocal to maintain separate driver instances per thread.


The main challenge in parallel execution is handling shared resources, especially WebDriver, since it is not thread-safe.
To make it thread-safe, I use ThreadLocal so each test thread gets its own independent WebDriver instance and there is no interference between tests.


Instead remember the structure:
	1.	How I enable parallel → TestNG
	2.	What is the problem → Shared resources / WebDriver not thread-safe
	3.	What is the solution → ThreadLocal

> Thread-safe means:

👉 Each test running in parallel uses its own WebDriver instace , so tests don’t interfere with each other.

---

WebDriver is not thread-safe because it maintains a single browser session

---

***If two threads share the same driver and both call driver.get() at the same time, what problem can happen?***

---
unpredictable behavior and session conflicts.

---
# Why This Matters in Selenium (Real-Life Example)

## Scenario

Imagine you run 2 tests in parallel:

- Test A opens **Chrome**
- Test B opens **Firefox**

---

## ❌ Not Thread-Safe Case

- Both tests share the same `WebDriver` variable
- One test closes the browser
- The other test crashes
- Leads to flaky failures

---

## What Actually Happens

1. Test A starts → Opens Chrome  
2. Test B starts → Opens Firefox  
3. Both use the same `WebDriver` reference  
4. One test calls `driver.quit()`  
5. The other test fails unexpectedly  

---
> ✅ Thread-safe case:

    > Each test has its own WebDriver instance
    > Tests run independently
    >  No clashes

---

***Race condition happens when two or more threads try to access and modify the same shared resource at the same time, leading to unpredictable results.***


Now:
	•	Thread 1 → Launches Chrome
	•	Thread 2 → Launches Firefox
	•	Both use same driver reference
	•	Thread 1 calls driver.quit()
	•	Thread 2 is still running

💥 Firefox test crashes.

This is a race condition because:
---

***How do you handle test data in Selenium automation?***
---

I handle test data by keeping it separate from test logic, usually in config or data files. This make tests easier to maintain and allows us to change data without modifying the test code.

---
***✌🏻How do you capture screenshots or logs when a Selenium test fails?***
---
Yes, we can handle screenshots and reporting in the Base class. In some frameworks, hooks or listeners are used instead to automatically trigger this logic on test failure.

---

***How would you wait for an element to be clickable in Selenium?***
---
---


I use an explicit wait to wait until the element is clickable, and then perform the click action. This ensures the element is visible and ready before interacting with it.
