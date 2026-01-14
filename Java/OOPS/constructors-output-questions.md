
# Java OOPS – Constructor Output Based Interview Questions

These are output-based Java OOPS questions focused on constructors,
inheritance, and method overriding. Prepared for SDET interviews.

Question 1:
What will be the output?

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

Reason:
When a child object is created, the parent constructor runs first,
followed by the child constructor.

--------------------------------------------------

Question 2:
What will be the output?

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

Reason:
Even though the reference is Parent, the object created is Child.
Constructor execution depends on object creation, not reference type.

--------------------------------------------------

Question 3:
What will be the output?

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
Overridden methods are resolved at runtime based on the object type.
Since the object created is Child, the child’s show() method executes
even though the call is made from the parent constructor.
