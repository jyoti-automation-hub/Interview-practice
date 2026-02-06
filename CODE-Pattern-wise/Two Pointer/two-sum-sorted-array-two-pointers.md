# Pair With Given Sum (Two Pointers – Sorted Array)

## Problem
Given a **sorted array**, return the indices (1-based) of two numbers such that they add up to a given target.

---

## Approach (Two Pointers)

Since the array is sorted:

- Start one pointer at the beginning (`low`)
- Start one pointer at the end (`high`)
- Calculate sum of both
- Move pointers based on comparison

Time Complexity: **O(n)**  
Space Complexity: **O(1)**  

---

## Code

```java
class Solution {

    public int[] twoSum(int[] numbers, int target) {

        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {

            if (numbers[low] + numbers[high] == target) {
                return new int[] {low + 1, high + 1};
            }
            else if (numbers[low] + numbers[high] > target) {
                high--;
            }
            else {
                low++;
            }
        }

        return new int[] {};
    }
}

```

---
