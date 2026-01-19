
# Scope & this Keyword – Practical Output Questions
# Question 1 – Without `this` (Parameter Shadowing)

```java
class Test {
    int x = 10;

    void update(int x) {
        x = 50;
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.update(20);
        System.out.println(t.x);
    }
}
```

**Output**
- 10

**Line by Line Execution**

- Line: `Test t = new Test();`  
  → Object created with instance variable `x = 10`

- Line: `t.update(20);`  
  → Method is called, parameter `x = 20`

- Inside method: `x = 50;`  
  → This updates ONLY the parameter variable  
  → Instance variable `this.x` is NOT touched

- Line: `System.out.println(t.x);`  
  → Prints instance variable which is still 10

**Key Concept**

- Parameter name shadows instance variable  
- Without `this`, Java always picks nearest scope (parameter)

---

## Question 2 – Using `this` to Update Instance Variable

```java
class Test {
    int x = 10;

    void update(int x) {
        this.x = x;
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.update(20);
        System.out.println(t.x);
    }
}
```

**Output**
- 20

**Explanation**

- `this.x` refers to instance variable  
- `x` on right side is method parameter  
- Assignment copies parameter value into object field  
- Therefore object value becomes 20

**Interview Takeaways**

- `x = x` → parameter to parameter (useless)  
- `this.x = x` → parameter → instance (correct setter)  
- Without `this`, object never changes
