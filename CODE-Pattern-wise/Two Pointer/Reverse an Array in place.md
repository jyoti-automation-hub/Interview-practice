## 🔥 Two Pointers – Reverse an Array in place
---

```java
public class ReverseArray {

 public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverse(arr);

        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
```
---
Problem

Reverse the array without using extra space.

Approach (Two Pointers)
	•	Left pointer at start
	•	Right pointer at end
	•	Swap → move inward


	---
# Reverse a string (without using built-in reverse)
---

	```java
public class Reverse {

    public static void main(String[] args) {

        String s = "Java123";

        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        System.out.println(new String(arr));
    }
}
```
---

***We needed to modify characters.***
---
>Since:
	>•	String is immutable
	>•	We cannot change characters directly

>We had to convert:
char[] arr = s.toCharArray();
---
Because arrays are mutable.
---
	
