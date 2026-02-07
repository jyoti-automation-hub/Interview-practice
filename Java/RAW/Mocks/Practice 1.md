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
