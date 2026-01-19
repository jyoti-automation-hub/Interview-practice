# 🔒 Encapsulation – SDET Interview Notes (Level 1 & Level 2)

---

## Q1. What is Encapsulation in Java? Explain in simple words and relate it to your automation framework.

Encapsulation means protecting data by making variables **private** and exposing them only through **controlled methods** like getters, setters, or page methods.

In my framework:  
- locators are kept private inside Page classes  
- test classes interact only through page methods  
- so no one can modify locators directly.

This is Encapsulation in real automation design.

---

## Q2. Why do we keep locators private in Page Object Model?  
### How is this Encapsulation?

We keep locators private in POM so test classes **cannot access or modify them directly**.  
Tests interact only through high-level page methods.

If a locator changes, we update only the **page class instead of all tests** —  
that is Encapsulation: hiding data and exposing controlled access.

---

## Q3. “Encapsulation is only getters and setters” – True or False?

**False.**

Encapsulation is about:
- protecting data  
- giving controlled access

In my framework:
- locators are private in Page classes  
- tests access them only through methods  
- we are not creating getters and setters  
- but still following Encapsulation.

---

## Q4. Where would you actually use getters & setters in automation?

In real time I used getters and setters for:
- config data  
- test data  
- setting username and password  
- setting browser value

This keeps those values private and accessed in a controlled way.

### Example Code

```java
class User {
    private String username;

    public void setUsername(String u) {
        username = u;
    }

    public String getUsername() {
        return username;
    }
}
```

Explanation:
- `username` is private → direct access blocked  
- `setUsername()` → controlled modification  
- `getUsername()` → controlled reading  

This is classic Encapsulation.

---

## Q5. If a variable is private and we do NOT use getters/setters,  
### how can another class still use that data?

Even without getters/setters, other classes use the data through **page methods**, which act as a controlled interface.

Example:  
Test → calls → `loginPage.login()`  
Not → `loginPage.username`

That is Encapsulation.

---

## Q6. Difference between Abstraction and Encapsulation (Practical)

- **Abstraction** → hiding implementation details and showing only what user needs  
- **Encapsulation** → protecting data and giving controlled access  

Getters/setters are one way to achieve Encapsulation,  
but in POM we often use **page methods** instead.

---

## Q7. How does Encapsulation help in framework maintenance?

Encapsulation helps maintenance because:

- locators and logic stay inside Page classes  
- they are not directly exposed to tests  
- if a locator changes → update only page class  
- test cases remain untouched

This makes the framework **stable and maintainable**.

---

## Q8. What happens if locators are public instead of private?

If locators are public:

- any test can access and modify them directly  
- breaks Encapsulation and POM design  
- increases risk of accidental changes  
- locator updates would require changes in multiple tests

Instead of one page class → huge rework.

---

## Q9. How does Encapsulation reduce impact of locator changes?

Because locators are private inside Page classes:

- tests never use them directly  
- change happens at one place only  
- all tests continue to work

Without Encapsulation:

- same locator would be scattered across tests  
- major maintenance effort.

---

### Final Interview Summary

Encapsulation in Automation =  

> Private data + controlled access through page methods  
> → safer framework  
> → single point change  
> → clean POM design.
