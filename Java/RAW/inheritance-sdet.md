# **Inheritance – SDET Interview Notes**

---

## **Q1. What is inheritance and why do Page classes extend BaseClass?**

**Answer:**
Inheritance allows one class to reuse the variables and methods of another class.  
In my framework, I create a BaseClass that contains WebDriver setup and common utilities like `openUrl()` and waits.  
Page classes extend BaseClass so they inherit driver and reusable methods without rewriting them, which keeps the framework clean and maintainable.

---

## **Q2. Can private variables be inherited? Why?**

**Answer:**
No. Private variables cannot be inherited because their access is limited to the same class only.  
Even if a class extends the parent, private members stay hidden.  
That’s why private locators in POM are only accessible inside the same page class.

---

## **Q3. What keyword is used for inheritance?**

**Answer:**
The keyword used is **extends**.  
One class extends another class to reuse its methods and variables.

---

## **Q4. Why is WebDriver usually protected in the BaseClass?**

**Answer:**
If we make it private, Page classes can’t access it.  
If we make it public, anyone can modify it — which is unsafe.  
So protected gives the right balance between accessibility and security.

---

## **Q5. Can constructors be inherited?**

**Answer:**
No, constructors cannot be inherited.  
They belong to the specific class and are used only to initialize that class’s objects.

---

# **Sample Inheritance Code Example (Interview Demo)**

```java
class BaseClass {
    WebDriver driver;

    void openUrl(String url) {
        driver.get(url);
    }
}

class LoginPage extends BaseClass {

    void login() {
        // using driver inherited from BaseClass
        System.out.println("Login using inherited driver");
    }
}
```
---

**Explanation to Speak in Interview:**
BaseClass contains driver setup and common methods.  
LoginPage extends BaseClass and directly reuses driver and utilities — this is inheritance in my automation framework.
