## Two Pointers – Reverse an Array in place
---

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

---
Problem

Reverse the array without using extra space.

Approach (Two Pointers)
	•	Left pointer at start
	•	Right pointer at end
	•	Swap → move inward
