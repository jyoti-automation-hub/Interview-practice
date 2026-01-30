## ⭐ 3. DROPDOWNS
### 🔥 B. Custom Dropdown

### HTML example (Amazon, Flipkart type):

```html
<div class="dropdown">
    <div class="selected-item">Choose</div>
    <ul class="options">
        <li>iPhone</li>
        <li>Samsung</li>
        <li>Pixel</li>
    </ul>
</div>
```

---

## This is NOT a <select> tag → so Select class will NOT work.
---

```java
// Step 1 — Click the dropdown
driver.findElement(By.xpath("//div[@class='dropdown']")).click();

// Step 2 — Get all dropdown options
List<WebElement> items =
        driver.findElements(By.xpath("//ul[@class='options']/li"));

// Step 3 — Loop and click the required option
for (WebElement el : items) {
    if (el.getText().equals("Samsung")) {
        el.click();
        break;
    }
}
```
---


