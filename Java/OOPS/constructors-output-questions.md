# Java OOPS – Constructor Output Based Interview Questions

These are output-based Java OOPS questions focused on constructors, inheritance, and method overriding.  
Prepared for **SDET interviews**.

---

## Question 1: What will be the output?

```java
class Parent {
    Parent() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    Child() {
        System.out.println("Child");
    }
}

public class Test {
    public static void main(String[] args) {
        new Child();
    }
}

Output:
Parent
Child

Reason: When a child object is created, the parent constructor runs first, followed by the child constructor.


## Question 1: What will be the output?

class Parent {
    Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {
    Child() {
        System.out.println("Child constructor");
    }
}

public class Test {
    public static void main(String[] args) {
        Parent p = new Child();
    }
}

Output:
Parent constructor
Child constructor

Reason:  Constructor execution depends on object creation, not reference type.
