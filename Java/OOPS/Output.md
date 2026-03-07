x++  → post-increment (use value first, then increase)
++x  → pre-increment  (increase first, then use value)

---

> literal + literal → compile-time → same pool object
> variable + literal → runtime → new object

---


> Integer cache range = -128 to 127

---

Static blocks run when the class is loaded
before the main method executes.

---

final → value cannot be reassigned

---

widening conversions:
int → long
int → float
int → double

---

int → Integer ( autoboxing )

---

Object is the parent of all classes, but Java still chooses the most specific method.

---

If both operands are numbers → arithmetic addition
If one operand is String → string concatenation

***System.out.println(10 + 20 + "Java" + 10 + 20);
