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










