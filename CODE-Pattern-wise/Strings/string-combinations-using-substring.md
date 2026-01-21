# Print All Combinations of a String (Using substring)

## Interview Question
Given a string `"abc"`, print all possible combinations:
a, ab, abc, b, bc, c

---

## Java Code

```java
public class StringCombinations {

    public static void main(String[] args) {

        String s = "abc";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.println(s.substring(i, j));
            }
        }
    }
}
```

---

## Explanation (How It Works)

- The **outer loop (`i`)** decides the starting index.
- The **inner loop (`j`)** decides the ending index.
- `substring(i, j)` extracts characters from index `i` **inclusive** to `j` **exclusive**.
- The loops generate combinations; `substring()` only extracts them.

---

## Important Rule (Interview Must-Know)

```
substring(startIndex, endIndex)
```

- startIndex → INCLUDED  
- endIndex → EXCLUDED  

---

## Dry Run

String: `"abc"`

Index mapping:
```
0 → a
1 → b
2 → c
```

### i = 0
- j = 1 → substring(0,1) → a
- j = 2 → substring(0,2) → ab
- j = 3 → substring(0,3) → abc

### i = 1
- j = 2 → substring(1,2) → b
- j = 3 → substring(1,3) → bc

### i = 2
- j = 3 → substring(2,3) → c

---

## Final Output
```
a
ab
abc
b
bc
c
```

---

## Common Interview Trap

❌ Wrong: substring generates combinations  
✅ Correct: loops generate combinations, substring only extracts

---

## One-Line Interview Answer
The outer loop selects the start index, the inner loop selects the end index, and substring extracts each combination.

---

## Time Complexity
O(n²)
