# **final Keyword – Output & Interview Questions**

---

## **Q1 – Final Class**

```java
final class A {}

class B extends A {}
```

**Answer:**  
Compile-time error.  
A final class cannot be inherited or extended.

---

## **Q2 – Final Method Overriding**

```java
class A {
   final void show() {
      System.out.println("A");
   }
}

class B extends A {
   void show() {
      System.out.println("B");
   }
}
```

**Answer:**  
Compile-time error.  
Final methods cannot be overridden in child class.

---

## **Q3 – Final Method Calling**

```java
class A {
   final void show() {
      System.out.println("Hello");
   }
}

class B extends A {
   void test() {
      show();
   }
}
```

**Answer:**  
Allowed.  
Output → **Hello**  
Final methods can be inherited and called, just not overridden.

---

## **Q4 – Final Variable Reassignment**

```java
final int x = 10;
x = 20;
System.out.println(x);
```

**Answer:**  
Compile-time error.  
Final variable value cannot be changed once assigned.

---

## **Q5 – Final Method Overloading**

```java
class A {
   final void add(int a) {}
   final void add(int a, int b) {}
}
```

**Answer:**  
Allowed.  
Final methods can be overloaded because overloading depends on parameters, not overriding.

---

## **Q6 – Constructor with final Keyword**

```java
class A {
   final A() {}
}
```

**Answer:**  
Compile-time error.  
Constructors cannot be final because constructors are never overridden.

---

## **Q7 – Calling Final Method via Object**

```java
class A {
   final void show() {
      System.out.println("A");
   }
}

A obj = new A();
obj.show();
```

**Answer:**  
Output → **A**  
Final method can be called normally using object.

---

## **Q8 – Extending String Class**

```java
String s = "hi";

class MyString extends String {}
```

**Answer:**  
Compile-time error.  
String is a final class and cannot be extended.

---

## **Q9 – Constructor Overloading**

```java
class A {
   A() {}
   A(int x) {}
}
```

**Answer:**  
Allowed.  
Constructors can be overloaded by changing parameters.

---

## **Q10 – Constructor Overriding**

```java
class Parent {
   Parent() {}
}

class Child extends Parent {
   Parent() {}
}
```

**Answer:**  
Not overriding.  
Constructors are not inherited, so overriding constructors is not possible.

---

## **Q11 – final Method + Overloading Mix**

```java
class A {
   final void test() {}
   void test(int a) {}
}
```

**Answer:**  
Allowed.  
One method is final, the other is overloaded with different parameters.

---

## **Q12 – final Variable in Constructor**

```java
class A {
   final int x;

   A() {
      x = 10;
   }
}
```

**Answer:**  
Valid code.  
Final variable can be initialized inside constructor once.

---

# **Important Constructor Questions**

### **Can constructors be overloaded?**
Yes. Constructors can be overloaded by changing the parameter list.

**Example:**

```java
class A {
   A() {}
   A(int x) {}
}
```

---

### **Can constructors be overridden?**
No. Constructors cannot be overridden because they are not inherited by child classes.
