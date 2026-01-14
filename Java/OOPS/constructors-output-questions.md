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

---

## Question 2: What will be the output?

```java
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
```
Output:
Parent constructor
Child constructor

Reason:
Constructor execution depends on object creation, not reference type. Since a Child object is created, the parent constructor runs first, followed by the child constructor.

---

## Question 3: What will be the output?

```java
class Parent {
    Parent() {
        show();
    }

    void show() {
        System.out.println("Parent show");
    }
}

class Child extends Parent {
    void show() {
        System.out.println("Child show");
    }
}

public class Test {
    public static void main(String[] args) {
        new Child();
    }
}

Output:
Child show

Reason:
During object creation, the parent constructor runs first. The show() method is overridden in the child, so at runtime the child’s version is called.


---

## Question 4: What will be the output?

```java
class Parent {
    Parent() {
        System.out.println("Parent constructor");
    }

    void show() {
        System.out.println("Parent show");
    }
}

class Child extends Parent {
    Child() {
        System.out.println("Child constructor");
    }

    void show() {
        System.out.println("Child show");
    }
}

public class Test {
    public static void main(String[] args) {
        Parent p = new Child();
        p.show();
    }
}

Output:
Parent constructor
Child constructor
Child show

Reason:
Constructors run based on object creation. Method calls depend on the actual object at runtime, so the child’s overridden method is executed.

---

## Question 5: What will be the output?

```java
class Parent {
    Parent() {
        show();
    }

    void show() {
        System.out.println("Parent show");
    }
}

class Child extends Parent {
    int x = 10;

    void show() {
        System.out.println(x);
    }
}

public class Test {
    public static void main(String[] args) {
        new Child();
    }
}

Output:
0

Reason:
During parent constructor execution, child variables are not yet initialized. So x has its default value 0.
