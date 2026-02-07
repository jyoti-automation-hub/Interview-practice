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


















