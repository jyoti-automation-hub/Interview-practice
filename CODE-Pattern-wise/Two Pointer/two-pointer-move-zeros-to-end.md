# Move Zeros to End (Two Pointers)

## 🎯 Problem
Given an integer array, move all `0`s to the end of the array while maintaining the relative order of non-zero elements.

Example:
Input:  [0, 1, 0, 3, 12]  
Output: [1, 3, 12, 0, 0]

---

## 💡 Approach (Two Pointers)

We use two pointers:

- `i` → scans the entire array
- `j` → tracks position where next non-zero should be placed

### Logic:
1. Traverse array using `i`
2. If `nums[i] != 0`
   - Place it at index `j`
   - Increment `j`
3. After traversal, fill remaining positions with `0`

Time Complexity: **O(n)**  
Space Complexity: **O(1)** (in-place)

---

## ✅ Java Implementation

```java
public class MoveZeros {

    static void moveZeros(int[] nums) {
        int j = 0;

        // Step 1: Move non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        // Step 2: Fill remaining positions with 0
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeros(nums);

        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
```

---

## 🧠 Explanation (One-Liner)

"I use a two-pointer approach where one pointer scans the array and the other tracks the position for non-zero elements, then I fill the remaining indices with zeros."

---
