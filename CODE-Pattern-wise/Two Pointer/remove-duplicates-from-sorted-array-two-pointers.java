# Remove Duplicates from Sorted Array (Two Pointers)

---

## Problem
Given a **sorted array**, remove the duplicates **in-place** and return the length of the array containing only unique elements.

---

```java
public class RemoveDuplicatesFromSortedArray {

    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int j = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4};

        int length = removeDuplicates(nums);

        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

```
