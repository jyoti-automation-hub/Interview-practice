# Inheritance in Java – Static, Final, Private & Static Variables

---
👉 Java uses:
	•	Object → for instance methods (runtime polymorphism)
	•	Reference → for static methods (compile-time binding)

---

## 🔹 Why NOT object for static methods?

Because static methods belong to the class, not the object

There is actually no polymorphism involved.

---

## ✅ Correct Understanding

#### 👉 “For static methods, Java uses reference type because they are resolved at compile time. For instance methods, it uses object type because of runtime polymorphism.”

---

## 🔹 1. Static Methods

✔ Accessible in child class  
✔ Inherited  
❌ Not overridden (only hidden)

### Example

```java
class Parent {

    static void show() {
        System.out.println("Parent static");
    }

}

class Child extends Parent {

    static void show() {
        System.out.println("Child static");
    }

}
```
### this is method hiding not overriding 

# Inheritance in Java – Static, Final, Private & Static Variables

---

## 🔹 2. Final Methods

✔ Accessible  
❌ Cannot be overridden  

### Example

```java
class Parent {

    final void display() {
        System.out.println("Final method");
    }

}

class Child extends Parent {

    // ❌ Cannot override final method

}
```

👉 You can use it, but **cannot change it**.

---

## 🔹 3. Private Variables & Methods

❌ Not accessible directly in child class  

### Example

```java
class Parent {

    private int x = 10;

}

class Child extends Parent {

    void test() {
        // ❌ Cannot access x directly
    }

}
```

✔ Access possible via:

- Getter methods  
- Public / Protected methods  

---

## 🔹 4. Static Variables

✔ Accessible (if not private)

### Example

```java
class Parent {

    static int a = 10;

}

class Child extends Parent {

    void test() {
        System.out.println(a); // ✔ works
    }

}
```

---

# 🚀 Static Methods in Inheritance (Deep Dive)

---

## 🔹 1. Are static methods inherited?

✔ Yes  

Child class can access static methods of parent.

```java
class Parent {

    static void show() {
        System.out.println("Parent");
    }

}

class Child extends Parent {

    void test() {
        show(); // ✔ allowed
    }

}
```

---

## 🔹 2. Can static methods be overridden?

❌ No  

👉 Static methods belong to **class, not object**  
👉 So they are **hidden, not overridden** if the child defines the same method, it is method hiding.

### Example

```java
class Parent {

    static void show() {
        System.out.println("Parent");
    }

}

class Child extends Parent {

    static void show() {  // ❌ NOT overriding
        System.out.println("Child");
    }

}
```

👉 This is **method hiding**

---

## 🔹 3. Which method gets called?

👉 Depends on **reference type (compile-time binding)**

```java
Parent obj = new Child();
obj.show();   // 👉 Parent method will run
```

---

# ⚡ Final Interview One-Liner

- Static methods → Inherited, **not overridden** (method hiding)  
- Final methods → Inherited, **cannot be overridden**  
- Private members → **Not accessible directly**  
- Static variables → Accessible (if not private)

---

# Method Hiding vs Method Overriding in Java

---

## 🔹 Case 1: Static Method (Method Hiding)

### Example

```java
class Parent {

    static void show() {
        System.out.println("Parent static");
    }

}

class Child extends Parent {

    static void show() {
        System.out.println("Child static");
    }

}
```

### Call

```java
Parent p = new Child();
p.show();
```

### Output

```
Parent static
```

---

## 🔍 What happens step-by-step?

1. Compiler sees: `Parent p`  
2. `show()` is static  
3. Static methods are resolved at **compile time**  
4. So Java binds: `Parent.show()`

✔ Reference type is used  
❌ Object is ignored  

---

## 👉 Another Call

```java
Child c = new Child();
c.show();
```

### Output

```
Child static
```

✔ Because reference type is `Child`

---

# 🔥 Case 2: Non-Static Method (Method Overriding)

### Example

```java
class Parent {

    void show() {
        System.out.println("Parent non-static");
    }

}

class Child extends Parent {

    void show() {
        System.out.println("Child non-static");
    }

}
```

### Call

```java
Parent p = new Child();
p.show();
```

### Output

```
Child non-static
```

---

## 🔍 What happens here?

# Method Execution Flow in Java (Static vs Non-Static)

---

## 🔍 What happens step-by-step? (Non-Static Method)

1. Compiler sees: `Parent p`  
2. Method is **non-static**  
3. Java waits until **runtime**  
4. At runtime → object is `Child`  
5. So Java calls: `Child.show()`

✔ Object type is used  
✔ Runtime decision (**dynamic dispatch**)

---

## 🧠 Final Mental Model (Very Important)

When you see:

```java
Parent p = new Child();
```

### Ask yourself:

### 1️⃣ Is method static?

- YES → Go with **reference type** (`Parent`)

### 2️⃣ Is method non-static?

- YES → Go with **object type** (`Child`)


# Static vs Non-Static Calling Rules (Interview Gold)

---

## ⚡ Important Rule

### ✔ Allowed

- Non-static → can call static  
- Static → can call static  

---

### ❌ Not Allowed

- Static → cannot directly call non-static  

---
