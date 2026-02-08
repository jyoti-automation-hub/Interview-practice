# 📌 Sliding Window – Maximum Sum Subarray of Size K

## ❓ Question

Given an integer array and an integer `k`,  
find the **maximum sum of any contiguous subarray of size k**.

---

## 💡 Approach (Sliding Window)

Instead of calculating sum for every subarray (O(n²)),  
we use **Sliding Window technique** to achieve **O(n)** time.

Steps:

1. Build the first window of size `k`
2. Slide the window one element at a time:
   - Add new element
   - Remove element that goes out of window
3. Track the maximum sum

---

## ✅ Java Code

```java
public class MaxSumSubarrayOfSizeK {

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int windowSum = 0;
        int maxSum = 0;

        // Step 1: Build first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum;

        // Step 2: Slide the window
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i];        // Add new element
            windowSum -= arr[i - k];    // Remove element leaving window
            maxSum = Math.max(maxSum, windowSum);
        }

        System.out.println(maxSum);
    }
}
```

---

## 🧠 How Sliding Works

For input:

```
[2, 1, 5, 1, 3, 2], k = 3
```

Windows:

```
2 + 1 + 5 = 8
1 + 5 + 1 = 7
5 + 1 + 3 = 9   ← Maximum
1 + 3 + 2 = 6
```

Output:

```
9
```

---

## ⏱ Time & Space Complexity

- Time Complexity → **O(n)**
- Space Complexity → **O(1)**
