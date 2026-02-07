# 🔥 **Abstraction – Notes (SDET Focused)** 

---
Objects are created for classes, not for methods.
One object can access multiple methods.
---
## **Q1. What is Abstraction?**

**Answer :**  
Abstraction means hiding the implementation details and showing only the essential features.

In my automation framework, I don’t write locators directly in the test class.  
Tests call high-level methods like `enterUsername()` and `enterPassword()` from the Page class.  
The actual locator logic stays inside the Page class, and interaction happens through objects.  
So test knows *what to do*, not *how it is done.*

---

## **Q2. Can we create an object of an abstract class?**

**Answer:**  
No. We cannot create an object of an abstract class.

```java
Vehicle v = new Vehicle();   // ERROR
```

Abstract class is only a blueprint; object must be created from concrete child class.

---

## **Q3. If a subclass extends an abstract class, must it implement all abstract methods?**

**Answer:**  
Yes. If parent has methods without a body, the child must provide the body.

```java
abstract class Vehicle {
    abstract void start();
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car starts with key");
    }
}


Vehicle v = new Car();        1️⃣ Parent Reference → Child Object (Polymorphism)
v.fuel();     // allowed
v.start();    // allowed

or


Car c = new Car();             2️⃣ Child Reference → Child Object
c.fuel();     // allowed
c.start();    // allowed


```
Vehicle v = new Vehicle();   // **NOT allowed**

---

## **Q4. Do subclasses inherit concrete methods from abstract class?**

**Answer:**  
Yes. If parent has normal methods with body, child gets them automatically.

```java
abstract class Vehicle {
    abstract void start();

    void fuel() {
        System.out.println("Filling fuel");
    }
}

class Bike extends Vehicle {
    void start() {
        System.out.println("Bike starts with kick");
    }
}

Vehicle v = new Bike();        1️⃣ Parent Reference → Child Object (Polymorphism)
v.fuel();     // allowed
v.start();    // allowed

or


Bike c = new Bike();             2️⃣ Child Reference → Child Object
c.fuel();     // allowed
c.start();    // allowed

```

Child didn’t write `fuel()` but still used it because it was already implemented.

---

## **Q5. Can abstract methods be private?**

**Answer:**  
No. Abstract methods cannot be private because subclasses must override them, and private members are not visible to child classes.

---

## **Q6. Can abstract methods be final?**

**Answer:**  
No. Abstract methods cannot be final because final blocks overriding, and abstract methods require overriding.

---

## **Q7. Can abstract methods be static?**

**Answer:**  
No. Static belongs to the class, while abstract needs object-level implementation.  
So abstract + static is not allowed.

---

## **Q8. Abstract Class vs Interface (Simple Difference)**

**Answer:**  
- Abstract class can have both abstract methods and normal methods with body.  
- Interface mainly defines methods without body (before Java 8).  
- Abstract class is used when some common code already exists.

---

# **Tricky Areas Check**

### Trap A – Object Creation

```java
Vehicle v = new Vehicle();   // NOT allowed
```

### Trap B – Modifiers Not Allowed

- abstract + private ❌  
- abstract + final ❌  
- abstract + static ❌

### Trap C – Concrete Methods Inherited

1. Child can directly use implemented methods from abstract class without rewriting.
2. A child class CAN modify (override) a concrete method of an abstract class

```java
abstract class Vehicle {
    abstract void start();

    void fuel() {
        System.out.println("Fueling vehicle");
    }
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car starts");
    }

    // overriding concrete method → ALLOWED
    void fuel() {
        System.out.println("Fueling car");
    }
}
```

---

## **One-Line Summary**

Abstraction = hiding “how it works” and exposing only “what to use.”

---

# Abstraction – Important Edge Cases

---

## If a Child Class Does NOT Implement All Abstract Methods

If a child class does not implement all abstract methods of its parent abstract class, **the child class itself must be declared abstract**.  
The responsibility of implementing the abstract methods then passes to the **next concrete child class**.

### Example

```java
abstract class Vehicle {
    abstract void start();
}

abstract class Car extends Vehicle {
    // start() not implemented here
}

class ElectricCar extends Car {
    void start() {
        System.out.println("Starts silently");
    }
}
```
### Why need to do the above thing?
In real projects, a parent abstract class may have multiple abstract methods, but a child class may need only one of them based on its requirement. Instead of forcing the child to implement the unused method and duplicate code, Java allows the child class to remain abstract and implement the other method only when it is actually needed.


---
# Abstract Class with ZERO Abstract Methods

Yes. An abstract class can have zero abstract methods.  
We usually do this to prevent object creation and to act as a base class with shared behavior.

---
# Overriding a Concrete Method from an Abstract Class

Yes, a child class can override a concrete method.  
We do this when the existing concrete method needs some modification to match the requirement.  
If the child class wants to write customized code for a specific requirement, then it can override the concrete method.
