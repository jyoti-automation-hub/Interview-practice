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
---

## Q. Write Lambda implementation for this interface

```java
interface Shape {
    void draw();
}
```

### Correct Lambda Code

```java
Shape s = () -> System.out.println("Rectangle");

s.draw();
```

### Explanation

- `Shape s` → variable of the functional interface  
- `()` → no parameters because draw() has no parameters  
- `->` → separates input and action  
- `System.out.println("Rectangle")` → implementation of draw() method  
- `s.draw()` → calls the Lambda implementation

### Why This Works

- Shape is a **Functional Interface** (one abstract method)  
- Lambda provides implementation for that single method  
- No class or object creation is required


---

## Q5. Convert Old Runnable Code to Lambda

### Old Java 7 Style

```java
Runnable r = new Runnable() {
    public void run() {
        System.out.println("Hi");
    }
};

r.run();
```

### Lambda Style (Java 8)

```java
Runnable r = () -> System.out.println("Hi");

r.run();
```

### Why This Works

- Runnable is a **Functional Interface** (only one abstract method → run())
- Lambda directly provides implementation for that single method
- No need to create an anonymous class

### Key Interview Points

- Lambda does **not** create a Thread  
- It only provides implementation of `run()`  
- Thread creation is separate:

```java
new Thread(r).start();
```

---

## Q6. Functional Interface Rules

### Can a Functional Interface have:

1. **default methods?** → ✅ YES  
2. **static methods?** → ✅ YES  
3. **more than one abstract method?** → ❌ NO

### One-Line Explanation

- If more than one abstract method exists → it is **NOT** a functional interface and Lambda will not work.

### Perfect Interview Answer

> A functional interface can contain default and static methods, but it must contain **exactly one abstract method**. Otherwise, Lambda expressions cannot be used with it.
