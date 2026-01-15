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

🧠 **Explanation:**

- "Java" is a string literal
- Java stores string literals in the String Constant Pool
- Since both s1 and s2 have the same value "Java", only one object is created
- Both variables point to the same memory location

**So:**
- `s1 == s2` → true (same reference)
- `s1.equals(s2)` → true (same value)

👉 **Interview takeaway:**
- String literals save memory because Java reuses objects from the String pool

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

### 🧠 Explanation

- `new String("Java")` creates a **new object in heap memory every time**
- So `s1` and `s2` point to **different memory locations**
- `==` compares **references**, not values → returns `false`
- `.equals()` compares **content**, and both values are `"Java"` → returns `true`

### 👉 Interview takeaway

- `==` → reference comparison  
- `.equals()` → value comparison  
- `new String()` does **not** use String Constant Pool  
- Prefer **string literals** for memory efficiency
