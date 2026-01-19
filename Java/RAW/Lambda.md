# Lambda – Interview Questions (SDET 4+ YOE)

---

## Q1. In your projects, where have you actually used Lambda expressions?

### Answer

In my framework I use Lambda mainly in explicit waits.  
Instead of writing long ExpectedCondition classes, I pass the condition directly in:

```java
wait.until(driver -> element.isDisplayed());
```

This made the wait logic shorter and more readable.

---

## Q2. What is a Functional Interface?  
### And why are Lambdas tied only to Functional Interfaces?

### Answer

A Functional Interface is an interface with exactly one abstract method.  
Lambda is tied to it because Lambda provides implementation for that single method, and if there were multiple methods, Lambda wouldn’t know which one to implement.

---

## Q7. Lambda Syntax Recognition

Which of these are valid Lambdas?

A) `() -> System.out.println("hi")`  
B) `(a,b) -> a+b`  
C) `(int a) -> { return a; }`  
D) `(a,b,c) -> System.out.println(a)`

### Answer

All are valid because each follows the Lambda structure:

```
parameters → body
```

Java allows:
- zero parameters  
- one or multiple parameters  
- optional data types

---

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

## Q. Convert Old Runnable Code to Lambda

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

## Q. Functional Interface Rules

### Can a Functional Interface have:

1. **default methods?** → ✅ YES  
2. **static methods?** → ✅ YES  
3. **more than one abstract method?** → ❌ NO

### One-Line Explanation

- If more than one abstract method exists → it is **NOT** a functional interface and Lambda will not work.

### Perfect Interview Answer

> A functional interface can contain default and static methods, but it must contain **exactly one abstract method**. Otherwise, Lambda expressions cannot be used with it.

---

# Lambda Use Case in Selenium – Dropdown Validation

## Scenario

I needed to verify that all values in a dropdown match the expected values from the requirement:

**Expected:**  
Apple, Mango, Banana, Orange

---

## 1. Selenium + Traditional Java (Without Lambda)

```java
// Step 1: Get all dropdown elements
List<WebElement> options = driver.findElements(By.id("fruits"));

// Step 2: Convert WebElements → String using loop
List<String> actual = new ArrayList<>();

for (WebElement e : options) {
    actual.add(e.getText());
}

// Step 3: Expected values from requirement
List<String> expected = Arrays.asList("Apple", "Mango", "Banana", "Orange");

// Step 4: Validation
Assert.assertEquals(actual, expected);
```

### What This Code Does
- Manually loops through each WebElement  
- Extracts text using `getText()`  
- Adds values one by one into a new list  
- Compares with expected list

---

## 2. Selenium + Lambda / Streams (Modern Way)

```java
// Step 1: Get all dropdown elements (Selenium part remains same)
List<WebElement> options = driver.findElements(By.id("fruits"));

// Step 2: Convert using Lambda + Stream
List<String> actual =
        options.stream()                 // converts List<WebElement> → Stream
               .map(e -> e.getText())    // converts each WebElement → String text
               .collect(Collectors.toList()); // collects all texts into List<String>

// Step 3: Expected values
List<String> expected = Arrays.asList("Apple", "Mango", "Banana", "Orange");

// Step 4: Validation
Assert.assertEquals(actual, expected);
```

---

## Line-by-Line Meaning of Lambda Code

### 1. `options.stream()`
- Opens the list as a stream  
- Allows us to process elements one by one in functional style

### 2. `.map(e -> e.getText())`
- For each WebElement `e`  
- call `getText()`  
- Convert: **WebElement → String**

### 3. `.collect(Collectors.toList())`
- Gathers all converted texts  
- Creates a new `List<String>`

---

## What Actually Improved

- Selenium locator part remains the same  
- Lambda only improves the **processing logic**
- Removes manual for-loop and temporary add logic  
- Code expresses **WHAT we want**, not **HOW to loop**

---

## Perfect Interview Explanation

> In dropdown validation, instead of writing a manual loop to extract text from each WebElement, I used Lambda with streams:  
> `options.stream().map(e -> e.getText()).collect(toList())`.  
> This directly converts WebElements to String list, making the validation cleaner and less error-prone.

---
