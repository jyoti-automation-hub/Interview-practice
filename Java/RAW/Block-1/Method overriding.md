# 🚗 Java Method Overriding – Calling Parent vs Child Method

## ❓ Question
For the below code, how can we:
1. Call the **parent version** of the `fuel()` method?
2. Call the **child (overridden) version** of the `fuel()` method?

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

    void fuel() {
        System.out.println("Fueling car");
    }
}

```
---

# 🔁 Calling Parent vs Child Method (Using `super`)

To call the **parent class version** of an overridden method, use the `super` keyword **inside the child class**.

```java
class Car extends Vehicle {

    void fuel() {
        super.fuel();   // calls parent (Vehicle) version
        System.out.println("Fueling car");
    }
}
```
---
> 📌 super is the only way to access the parent implementation of an overridden method.


---
## ✅ Calling Child (Overridden) Version of `fuel()`

### ▶️ Way 1: Using Parent Reference
```java
Vehicle v = new Car();
v.fuel();   // calls child (Car) overridden version
```
---
### ▶️ Way 2: Using Child Object
```java
Car c = new Car();
c.fuel();   // calls child (Car) version

```
### ✌🏻 Important Rules of super (Must Remember ⭐)
	> super can be used only inside the child class
	> super cannot be used from outside the child class
	> super is the only way to call the parent version of an overridden method

