# Day 1 – Strings | Output-Based Interview Questions

---

## Question 1: String literal vs == vs equals()

### Code
```java
String s1 = "Java";
String s2 = "Java";

System.out.println(s1 == s2);
System.out.println(s1.equals(s2));
```

Output:
true
true

Explanation

Using new String() creates a new object in heap memory every time.
So s1 and s2 point to different objects, making == return false.
However, .equals() checks only the content, and since both values are “Java”, it returns true.


Key Takeaways
	•	== compares references
	•	.equals() compares values
	•	String literals use String Constant Pool
	•	new String() creates a new object every time
