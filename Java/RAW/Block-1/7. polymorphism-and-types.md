# **Polymorphism – Method Overloading & Method Overriding**

---

## **Polymorphism – Concept**

**Polymorphism means one thing having many forms.**

### Two Types of Polymorphism in Java

① **Compile-time Polymorphism → Method Overloading**
- Same method name  
- Different parameters  
- Decided by compiler  

② **Runtime Polymorphism → Method Overriding**
- Child class replaces parent’s method  
- Decision happens at runtime  
- Uses inheritance  

So polymorphism is basically the umbrella concept that covers both.

---

# **Method Overloading**

Method overloading means using the same method name but with different parameter lists.

The difference can be in:
- the number of parameters,  
- the type of parameters, or  
- the order of parameters.

Java decides which method to call at compile time based on these parameter differences.

In my automation framework, I used method overloading in my WaitUtility class.  
For example, I created multiple versions of waitForElement() — one that accepts a WebElement, one that accepts a By locator, and one that accepts a locator plus a custom timeout.

This gives flexibility because I can call the same method name with different inputs depending on what I need.

### **Q1. Does method overloading happen in the same class or different classes?**

Method overloading happens inside the same class.  
The methods must share the same name but have different parameter lists.

### **Q2. Can return type alone differentiate overloaded methods?**

No. Return type alone cannot differentiate overloaded methods.  
Overloading is based only on the number, type, or order of parameters.

### **Q3. Which polymorphism does overloading represent?**

Method overloading represents compile-time polymorphism because the method resolution happens during compilation.

### **Q4. How does Java choose which overloaded method to call?**

Java chooses the method based on the parameter list — the number, type, and order of the arguments passed into the method call.

### **Sample Code – Overloading**

```java
class WaitUtil {

    void waitForElement(By locator) {
    }

    void waitForElement(By locator, int timeout) {
    }
}
```

---

# **Method Overriding**

When a child class replaces the parent’s method with its own version — that’s method overriding.

### **Why would a child class replace the parent’s method?**

Because sometimes the parent’s version is not enough or needs improvement.

Think of it like:

“I like your method, but I need to customize it for my needs.”

This is ALL method overriding is.

### **When do we need to override a method?**

When we want to:

✔ Add extra logic  
✔ Change the default behavior  
✔ Improve the parent’s method  
✔ Specialize the method for a specific use case  

### **Q1. Why is overriding an example of runtime polymorphism?**

Overriding is runtime polymorphism because the method that actually runs (parent’s or child’s) is decided at runtime based on the object.

### **Q2. Can private methods be overridden? Why?**

No, private methods cannot be overridden because they are not visible to child classes.

### **Q3. Can a static method be overridden?**

No, static methods cannot be overridden. They belong to the class, not the object.  
Overriding works only on object methods.

### **Sample Code – Overriding**

```java
class Vehicle {
    void run(int a) {
    }
}

class Car extends Vehicle {
    @Override
    void run(int a) {
    }
}
```

---

# **Selenium Polymorphism Example**

```java
WebDriver driver = new ChromeDriver();
```

WebDriver is an interface and ChromeDriver is its implementation — this is runtime polymorphism.  
This allows cross-browser execution without changing test logic.
One interface → many browser implementations → same code works for all.

---

# **Edge Interview Questions**

- **Can we override a final method?** → No  
- **Can we overload static methods?** → Yes  
- **Can constructors be overloaded?** → Yes
