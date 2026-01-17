# **final Keyword – Interview Notes (SDET Level)**

---

## **What is final keyword?**

final keyword is used when we want something to be untouched and not modified.

---

## **1. final Class**

👉 A final class is meant to be completely locked —  
no modifications allowed, no child classes allowed.

### Rule
- A **final class cannot be inherited**.  
- If we try to extend it → **compile-time error**.

### Example

```java
final class A {
    void print() {
        System.out.println("A");
    }
}

class B extends A {   // compile-time error
}
```

### Common Examples in Java
- String  
- Integer  
- Double

They are final to prevent someone from extending and breaking them.

---

## **2. final Method**

### Rule
- A **final method can be inherited**  
- But it **cannot be overridden**  
- We can use it as it is, but cannot change its behavior.

### Example

```java
class Parent {
    final void show() {
        System.out.println("Hello");
    }
}

class Child extends Parent {

    // void show() {}   // NOT allowed – overriding final method

    void test() {
        show();   // allowed – just calling inherited method
    }
}
```

👉 Meaning:  
We can USE the final method,  
but we cannot REPLACE the final method.

---

## **3. final Variable**

### Rule
- A **final variable value cannot be changed once assigned**.

```java
final int x = 10;
x = 20;   // compile-time error
```

---

## **Automation Usage**

In automation, we mark constants, utility behavior, or core framework classes as final to prevent accidental modification.

---

# **Important Interview Q&A**

### **Q1. Can final method be overridden?**
No. Final methods cannot be overridden.

---

### **Q2. Can final method be overloaded?**
Yes. Final methods can be overloaded because overloading depends on parameters, not overriding.

---

### **Q3. Difference between final variable and final method?**

- Final variable → value cannot be changed once assigned.  
- Final method → cannot be overridden but can be inherited.

---

### **Q4. Why is String class final?**

String is final to protect security and immutability.  
If String was extendable, someone could change its behavior and break hashing, passwords, and core Java logic.

---

### **Q5. Can constructor be final? Why?**

No, constructors cannot be final because:
- constructors are not inherited  
- constructors cannot be overridden  
- final is used to prevent overriding, which does not apply to constructors.

---

## **One Line Memory**

- **Final class blocks inheritance**  
- **Final method blocks overriding**  
- **Final variable blocks reassignment**
