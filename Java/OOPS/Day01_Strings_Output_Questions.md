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

🧠 Human Explanation
	•	"Java" is a string literal
	•	Java stores string literals in the String Constant Pool
    •	Since both s1 and s2 have the same value "Java", only one object is created in the pool
	•	Both variables point to the same memory location

So:
	•	s1 == s2 → true (same reference)
	•	s1.equals(s2) → true (same value)

👉 Interview takeaway:
String literals save memory because Java reuses objects from the String pool.


---

	## Question 2: new String() vs == and .equals()
	
### Code
```java
public class Test {
    public static void main(String[] args) {
        String s1 = new String("Java");
        String s2 = new String("Java");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}

```

Using new String() creates a new object in heap memory every time.
So s1 and s2 point to different objects, making == return false.
However, .equals() checks only the content, and since both values are “Java”, it returns true.


Key Takeaways
	•	== compares references
	•	.equals() compares values
	•	String literals use String Constant Pool
	•	new String() creates a new object every time

	🧩 Quick Interview Summary 
	•	Why String literals are preferred?
→ They save memory using String Constant Pool.
	•	Difference between == and .equals()?
→ == compares reference, .equals() compares value.
	•	Does new String() use String pool?
→ No, it creates a new heap object every time.

