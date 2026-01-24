# Method Overloading vs Method Overriding

## Core Rule 

- **Method Overloading → Compile-time → Reference type matters**
- **Method Overriding → Runtime → Object type matters**

---

## Method Overloading Example

```java
class Parent {
    void show(int x) {
        System.out.println("Parent show(int)");
    }
}

class Child extends Parent {
    void show(double x) {
        System.out.println("Child show(double)");
    }
}

public class Test {
    public static void main(String[] args) {
        Parent p = new Child();
        p.show(10);
    }
}

```
---
## How Java Decides Method Call (Method Overloading – Interview Notes)

- `Parent p = new Child();`
- **Reference type** = `Parent`
- Method **overloading is resolved at compile time**
- Compiler checks **only the reference type**, NOT the object
- Even though the object is `Child`, compiler does not consider it
- Compiler searches for the matching method **inside Parent**
- So `Parent.show(int)` gets called

---

## Method Overriding Example

```java
class Parent {
    void show() {
        System.out.println("Parent show()");
    }
}

class Child extends Parent {
    void show() {
        System.out.println("Child show()");
    }
}

public class Test {
    public static void main(String[] args) {
        Parent p = new Child();
        p.show();
    }
}

```
---

## How Java Decides Method Call

- `Parent p = new Child();`
- **Object created** = `Child`
- Method **overriding is resolved at runtime**
- JVM checks the **actual object**, not the reference
- Even though the reference type is `Parent`, JVM looks at the object
- Since the object is `Child`, overridden method in `Child` is executed
- So `Child.show()` is called

---

## Final Interview One-Liner

In **method overloading**, Java decides the method at **compile time** using the **reference type**,  
but in **method overriding**, Java decides the method at **runtime** using the **object type**.
