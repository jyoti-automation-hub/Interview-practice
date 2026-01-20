# Selenium Interview Questions – Core Concepts

---

## Q1. How do you decide which locator strategy to use in a dynamic application like Amazon?

**Answer:**
- I avoid absolute XPath and dynamic IDs because they break frequently.  
- I prefer relative XPath using `contains()`, `text()`, and parent–child relations to keep locators stable.  
- If the DOM structure is clean, I choose CSS selectors since they are faster.  
- Final decision is based on uniqueness, readability, and low maintenance.

---

## Q2. Which locator do you prefer first — XPath or CSS, and why?

**Answer:**
- I prefer **CSS selectors** because they are faster and cleaner.  
- If I need text-based search or complex relationships, I switch to **XPath**.

---

## Q3. What will you do if the element has a dynamic ID changing every run?

**Answer:**
- I will not rely on that ID.  
- I’ll use stable attributes like class, text, or parent–child XPath.  
- I can also use `contains()` or `starts-with()` to ignore the changing part.

---

## Q4. Difference between Absolute XPath and Relative XPath?

**Answer:**
- Absolute XPath starts from the root and is very fragile—any UI change breaks it.  
- Relative XPath starts from the element context, so it is more stable and preferred in real projects.

---

## Q5. What is Explicit Wait and why not Thread.sleep?

**Answer:**
- Explicit wait waits for a specific condition like element visible or clickable.  
- I avoid Thread.sleep because it is fixed time, makes tests slow, and causes flaky behavior.

---

## Q6. Difference between Implicit Wait and Explicit Wait?

**Answer:**
- Implicit wait is global and applies to all elements.  
- Explicit wait is condition-based and only waits for a specific element.  
- In real automation, I mostly use explicit wait because it is more reliable.

---

## Q7. Can Selenium handle alerts directly using locators?

**Answer:**
- No, alerts are not part of the DOM, so we cannot use XPath or CSS.  
- We must switch using `switchTo().alert()` and then use accept or dismiss.

---

## Q8. How do you handle multiple windows or tabs in Selenium?

**Answer:**
- I use `getWindowHandles()` to get all window IDs.  
- Then switch using `driver.switchTo().window(handle)`.  
- After actions, I switch back to the parent window.

---

## Q9. Why do we need to switch to an iframe before interacting with elements inside it?

**Answer:**
- Elements inside an iframe belong to a different DOM context.  
- Selenium cannot access them directly, so we must use `switchTo().frame()` first.

---

## Q10. What is Page Object Model and why do we use it?

**Answer:**
- POM is a design pattern where each page has its own class with locators and actions.  
- It makes the framework maintainable, reusable, and easy to manage when UI changes.
