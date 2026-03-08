# Handling Exceptions in Selenium Scripts

## 9. How do you handle exceptions in Selenium scripts?

In Selenium, exceptions occur when elements are **not found**, **not clickable**, or the **page is not fully loaded**.

---

## Common Exceptions

| Exception | Reason |
|----------|--------|
| NoSuchElementException | Element not found |
| TimeoutException | Wait exceeded |
| StaleElementReferenceException | DOM refreshed |
| ElementNotInteractableException | Element hidden |

---

# 1️⃣ Try-Catch Block

Used to handle exceptions when an element is not available.

```java
try {
    driver.findElement(By.id("login")).click();
} 
catch (NoSuchElementException e) {
    System.out.println("Element not found");
}
```

---

# 2️⃣ Using Waits (Best Practice)

Explicit waits help prevent many Selenium exceptions.

```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

wait.until(ExpectedConditions.elementToBeClickable(locator));
```

✔ Prevents many exceptions.

---

# 3️⃣ Retry Mechanism (TestNG)

Used for **flaky tests** that might fail temporarily.

Example:

```java
@RetryAnalyzer(Retry.class)
```

---

# 4️⃣ Logging & Screenshot

When an exception happens:

- Capture screenshot
- Log the error
