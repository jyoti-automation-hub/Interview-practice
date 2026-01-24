# Two Sum (Using HashMap)

```java
import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int required = target - nums[i];

            if (map.containsKey(required)) {
                return new int[] { map.get(required), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println(result[0] + ", " + result[1]);
    }
}
```

## 🧠 Core Idea

- Use a **HashMap** where:
  - **Key** → number from the array  
  - **Value** → index of that number
- For every element, calculate the value needed to reach the target:
  ```
  required = target - currentValue
  ```
- If `required` is already present in the map, the solution is found.
- Otherwise, store the current number with its index in the map.

---

## 🧠 Explanation

- We traverse the array only once.
- At each step, we check whether the complementary number needed to reach the target
  has already appeared earlier.
- HashMap provides **O(1)** lookup, making the solution efficient.

---

## 🔍 Dry Run (Step-by-Step)

**Input:**  
`nums = [2, 7, 11, 15]`  
`target = 9`

### Iteration 1
- **Index:** 0  
- **Current Value:** 2  
- **Required Value:** 9 − 2 = 7  
- **Map before check:** `{}`  
- **Is 7 in map?** ❌ No  
- **Action:** Store `(2 → 0)`  

Map after iteration:
```
{2=0}
```

---

### Iteration 2
- **Index:** 1  
- **Current Value:** 7  
- **Required Value:** 9 − 7 = 2  
- **Map before check:** `{2=0}`  
- **Is 2 in map?** ✅ Yes  
- **Action:** Return indices `[0, 1]`

---

## ⏱ Complexity

- **Time Complexity:** O(n)  
- **Space Complexity:** O(n)

---

## 👉 Interview Takeaway

- Two Sum is a classic **HashMap lookup problem**
- Avoid nested loops by storing previously seen elements
- One-pass solution is preferred in interviews
