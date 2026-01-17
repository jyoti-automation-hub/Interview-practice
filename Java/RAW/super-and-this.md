# **super Keyword – Parent Child Communication in Framework**

---

## **What is super?**

super is a keyword used in inheritance to refer to the parent class.  
It is mainly used when a child class wants to access the parent’s version of:

- variables  
- methods  
- constructor → super()

---

## **super vs this (Simple Difference)**

### 🟠 SUPER – refers to parent class
Used to access parent:
- variables  
- methods  
- constructor using super()

### 🔵 THIS – refers to current class
this keyword is mainly used when constructor or method parameters have the same name as class variables.

Helps distinguish:
- this.driver → class variable  
- driver → parameter

Easy memory: **THIS = My version**

---

## **Sample Code from My Framework**

```java
public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);   // sending driver to parent
    }
}
```

---

## **Simple Explanation (Human Language)**

1. BasePage has a box called driver to keep the browser.  
2. BasePage constructor receives the browser and stores it → this.driver = driver.  
3. LoginPage also receives the browser in its constructor.  
4. super(driver) sends that browser to BasePage.  
5. Now LoginPage can use the same browser stored in BasePage.

**One-line memory:**  
Browser travels → LoginPage → BasePage → stored once → reused everywhere.

---

## **Interview Questions**

### **Q1. Why do we write super(driver) in Page classes?**

super(driver) is used to pass the WebDriver from the child page to the BasePage constructor so that all pages use the same browser session.

---

### **Q2. Can we use super() and this() in the same constructor?**

No. We cannot use both super() and this() in the same constructor because both must be the first statement.

---

### **Q3. What happens if we don’t write super() in a child constructor?**

Java automatically calls the parent’s default constructor.  
But if the parent has only a parameterized constructor, we must explicitly write super().

---

### **Q4. How does super help when a child overrides a parent method?**

super allows the child class to call the parent version of the method even after overriding it.
