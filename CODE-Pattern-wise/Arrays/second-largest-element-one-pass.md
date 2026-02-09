# Second Largest Element in an Array

## Problem

Given an integer array, return the **second largest unique element**.

If it does not exist, print a message accordingly.

---

## Example

Input:
```
[3, 1, 5, 2, 4]
```

Output:
```
Second Largest: 4
```

---

## Java Code

```java
public class Main {
    public static void main(String[] args) {

        int[] arr = {3, 1, 5, 2, 4};

        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {

            if (num > max) {
                second = max;
                max = num;
            } 
            else if (num != max && num > second) {
                second = num;
            }
        }

        if (second == Integer.MIN_VALUE) {
            System.out.println("Second largest does not exist");
        } else {
            System.out.println("Second Largest: " + second);
        }
    }
}
```

---

## Output

```
Second Largest: 4
```

---

## Time Complexity
```
O(n)
```

## Space Complexity
```
O(1)
```
