# **Interface – SDET Interview Notes**

---

## **Q1. What is an Interface?**

**Answer:**  
Interface is a contract that defines **WHAT to do**, not **HOW to do**.  
It contains method declarations, and the implementing class provides the body.

---

## **Q2. Where have you used Interface in Automation?**

**Answer:**  
The best example is Selenium:

```java
WebDriver driver = new ChromeDriver();
```

- WebDriver → interface  
- ChromeDriver → implementation class  

This allows us to switch browsers without changing test code.

---

## **Q3. What is Loose Coupling?**

**Answer – One Line:**  
Loose coupling means **my code depends on an interface, not on a concrete class**, so implementation can change without changing the test.

**Example:**

```java
WebDriver driver = new FirefoxDriver();   // tomorrow
WebDriver driver = new EdgeDriver();      // no test change
```

Tests remain the same → only implementation changes → this is loose coupling.

---

## **Q4. Interface vs Abstract Class (Simple)**

| Interface | Abstract Class |
|---|---|
| Only contract / declarations | Can have concrete methods |
| Supports multiple inheritance | Single inheritance |
| No constructors | Can have constructors |

---

## **Q5. Multiple Inheritance using Interface**

**Answer:**

```java
interface A {}
interface B {}

class C implements A, B {}   // allowed
```

Classes → single inheritance  
Interfaces → multiple inheritance allowed.

---

## **Q6. Can we create object of Interface?**

**Answer:**  
No.

```java
WebDriver d = new WebDriver(); // ❌ not allowed
```

---

## **Q7. Can Interface have constructor?**

**Answer:**  
No, interface cannot have constructors.

---

## **Q8. Can Interface have variables?**

**Answer:**  
Yes, but they are always:

- public  
- static  
- final

```java
int x = 10;   // implicitly public static final
```

---

## **Q9. Default Method in Interface**

```java
interface Payment {
    default void log() {
        System.out.println("payment log");
    }
}
```

- Has body  
- Child may or may not override.

---

## **Q10. Static Methods in Interface – Important Rule**

**Answer:**  
Static methods inside an interface are **NOT inherited** by implementing classes. They must always be called using the **interface name**, not the class name.

```java
interface Util {
    static void show() {
        System.out.println("Hello from Interface");
    }
}

class Test implements Util {
}
```

❌ **Not Allowed**

```java
Test.show();   // compile-time error – static method not inherited
```

✔ **Correct Way**

```java
Util.show();   // call using interface name
```

**Explanation:**  
Static methods in interfaces belong only to the interface itself and do not become part of the implementing class. They do not participate in inheritance and cannot be overridden. This is different from static methods in normal classes, which are inherited but still cannot be overridden.

# **Tricky Interview Questions**

### T1. Why interface instead of concrete class?

Because interface gives:
- loose coupling  
- browser independence  
- easy mocking & maintenance.

---

### T2. implements vs extends?

- class → extends class  
- class → implements interface  
- interface → extends interface

---

### T3. Can interface method be private/final/static?

- private ❌  
- final ❌  
- static ✔ (but not overridden)

---

### T4. Real Automation Answer

> We use WebDriver interface so our framework is not tied to ChromeDriver.  
> Tomorrow we can switch to FirefoxDriver without touching test logic.

---

## **30-Second Interview Answer**

Interface is a contract that defines what to do without implementation.  
In Selenium we use WebDriver interface to achieve loose coupling and browser independence.  
Interface supports multiple inheritance and helps build flexible frameworks.
