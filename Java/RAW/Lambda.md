## Q. Explain this Lambda line technically

```java
wait.until(driver -> driver.findElement(By.id("x")).isDisplayed());
```

### Explanation

- The **Lambda takes a WebDriver object as input**.  
- The word `driver` before the arrow represents that input parameter.  
- The arrow symbol `->` is only a separator — it is **not part of the input**.

### Structure of a Lambda

```
input -> action
```

Here:

- **Input** → WebDriver object (`driver`)  
- **Action** → find the element and check if it is displayed

### What it Returns

- `isDisplayed()` returns **true or false**  
- `wait.until()` keeps polling until the Lambda returns **true**

---

### Key Interview Lines

- The Lambda receives **WebDriver as input**  
- It returns the **boolean result** of `isDisplayed()`  
- `wait.until()` uses that boolean to decide when to stop waiting
