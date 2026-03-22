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
👉 So they are **hidden, not overridden**

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
