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
