***🎤 What is the difference between HashMap and ConcurrentHashMap?***

---
HashMap is not thread-safe, meaning if multiple threads modify it at the same time, it can lead to data inconsistency. ConcurrentHashMap is designed to handle concurrent access safely.

> Also, ConcurrentHashMap does not allow null keys or null values, while HashMap allows one null key and multiple null values.
---

***🎤What is the difference between ArrayList and LinkedList?***

---
ArrayList is better for frequent reads because it provides O(1) random access. LinkedList is preferred when there are frequent insertions or deletions, especially in the middle of the list.

---

***🎤 What is the difference between equals() and == in Java?***

---
== compares object references, meaning whether two variables point to the same object. equals() compares the content or logical equality of the objects.

---

***🎤What is the difference between throw and throws in Java?***

---
throw is used inside a method to actually throw an exception. throws is used in the method signature to declare that the method may throw a checked exception.

>  throw is used to throw an exception, and throws is required only when the method declares a checked exception.
---

***🎤 What is the difference between checked and unchecked exceptions in Java?***

---
Checked exceptions are checked at compile time and must be handled or declared using throws, like IOException. Unchecked exceptions occur at runtime and do not need to be explicitly handled, like NullPointerException.

---
***🎤 What is an immutable class in Java?
Can you give an example?***

---

An immutable class is a class whose state cannot be changed once the object is created. A common example is the String class.

> "How do you make a class immutable?”
	•	Make the class final
	•	Make fields private final
	•	Do not provide setters

---

***🎤 What is the difference between String, StringBuilder, and StringBuffer?***

---
String is immutable, meaning once created, its value cannot change. StringBuilder and StringBuffer are mutable, meaning their values can be modified without creating new objects. The main difference is that StringBuffer is thread-safe, while StringBuilder is not.

---

***🎤 How does HashMap work internally?***

---
HashMap works using hashing. When we put a key, it uses hashCode to decide which bucket to store it in. If two different keys go to the same bucket, HashMap stores them together and uses equals() to find the correct key during retrieval.

> 🎤 What happens if two keys have the same hashCode?

> If two keys have the same hashCode, HashMap stores them in the same bucket and uses equals() to differentiate them. 


---

***Why do we need both hashCode() and equals() in HashMap?
Why isn’t hashCode alone enough?***

---
hashCode() is used to decide the bucket where the key should be stored. equals() is used to compare keys inside the same bucket when there is a collision, to identify the correct key.

---

1️⃣ HashMap uses hashCode() to decide the bucket
2️⃣ If two keys go to the same bucket, it’s called a collision
3️⃣ equals() is used to find the correct key inside that bucket

---
***🎤What is method overloading and method overriding?***

---
***🎤 What is the difference between abstraction and encapsulation?***

---
***🎤 What is the difference between an interface and an abstract class?***

---
An abstract class can have both abstract and concrete methods. An interface mainly defines method contracts, and the implementing class provides the implementation.

>A class can extend only one abstract class, but it can implement multiple interfaces.

---
***🎤 What is the difference between final, finally, and finalize?***

---
> final is a keyword used to prevent modification. A final variable cannot be changed, a final method cannot be overridden, and a final class cannot be extended.

> finally is a block used in exception handling that always executes.

> finalize is a method called by the garbage collector before an object is destroyed.

---

***🎤What is the difference between List, Set, and Map?***

---
List is used when we want to maintain insertion order and allow duplicates. Set is used when we want to avoid duplicate elements. Map is used to store data in key-value pairs, where keys must be unique.

---
***🎤What is polymorphism? And what is the difference between compile-time and runtime polymorphism?***

---
Polymorphism means one object having multiple forms. Compile-time polymorphism happens through method overloading, and runtime polymorphism happens through method overriding.

---
***🎤Can we override a static method in Java? Why or why not?***

---
No, static methods cannot be overridden because they belong to the class, not the object. They are resolved at compile time, so overriding does not apply to them.

---

***🎤What is the difference between this and super keyword?***

---
this refers to the current class object. It is mainly used to differentiate instance variables from constructor parameters when they have the same name. super refers to the parent class and is used to access parent class variables, methods, or constructors.

---

***🎤 Multithreading – Question 1***

***What is a thread in Java?***

---

> A thread allows a program to perform multiple tasks at the same time.























