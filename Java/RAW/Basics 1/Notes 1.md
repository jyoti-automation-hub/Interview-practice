
# Final Method vs Final Class (Important Difference)

## 1️⃣ Final Variable

You said correctly.

✔ **Value cannot be changed once assigned.**

### Example

```java
final int MAX_USERS = 10;
```

---

## 2️⃣ Final Method

A **final method cannot be overridden**, but it **CAN be inherited**.

This is the key point.

### Example

```java
class Parent {

    final void show() {
        System.out.println("Hello");
    }

}

class Child extends Parent {

    // ❌ Cannot override show()

}
```

### Explanation

- Child class **inherits the method**
- But **cannot override it**

So the method **still exists in the child class**, but **its implementation cannot change**.

✔ Inherited  
❌ Cannot override

## 3️⃣ Final Class

A **final class cannot be inherited at all.**

### Example

```java
final class Parent {

}

class Child extends Parent {   // ❌ Compilation error

}
```

### Example from Java

- `String` class is **final**

### Reason

Java designers wanted **String behavior to remain unchanged.**

---

# Interview One-Line Answer

You can say:

- **final variable** → value cannot change  
- **final method** → cannot be overridden but can be inherited  
- **final class** → cannot be inherited

