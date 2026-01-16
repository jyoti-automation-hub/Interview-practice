# Collections Output Interview Questions – Day 3

---

## Question 1 – List Size

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list.size());
    }
}
```

**Output**
- 3


**Explanation**
- `size()` method returns number of elements present in the ArrayList  
- We added 3 elements → 10, 20, 30  
- Therefore result is **3**

---

## Question 2 – Printing List

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(10);

        System.out.println(list);
    }
}
```

**Output**
- [10, 20, 10]

**Explanation**
- ArrayList allows duplicate values  
- `System.out.println(list)` internally calls `toString()`  
- Elements are printed in insertion order with brackets

---

## Question 3 – Set Removes Duplicates

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(10);

        System.out.println(set.size());
    }
}
```

**Output**
- 2

**Explanation**
- HashSet does NOT allow duplicate elements  
- Second insertion of 10 is ignored  
- Only {10, 20} remain → size is **2**

---

## Question 4 – Modification During Iteration (IMPORTANT INTERVIEW TRAP)

```java
import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for(Integer i : list) {
            if(i == 2) {
                list.remove(i);
            }
        }

        System.out.println(list);
    }
}
```

**Output**
- Runtime Exception – ConcurrentModificationException

**Explanation**
- We are modifying the list while iterating using enhanced for loop  
- Java iterator is FAIL-FAST  
- Any structural modification during iteration causes  
  → **ConcurrentModificationException**
- Correct approach would be:
  - Use Iterator.remove()  
  - Or collect elements to delete after loop

---

### Key Interview Takeaways

- List → allows duplicates, maintains order  
- Set → no duplicates  
- Printing collection prints values using `toString()`  
- NEVER modify collection directly inside for-each loop
