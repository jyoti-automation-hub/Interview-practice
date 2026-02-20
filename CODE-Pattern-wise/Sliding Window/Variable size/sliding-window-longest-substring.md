
***🔹 Longest Substring Without Repeating Characters***

***Given a string s, find the length of the longest substring without repeating characters.***

***A substring must be continuous.***


***Input: s = "eceba", k = 2  
Output: 3  
Explanation: "ece" is the longest substring with 2 distinct characters.***


---
'''java 

import java.util.*;

public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {

        String s = "abcabcbb";

        int left = 0;
        int max = 0;

        Set<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }

        System.out.println("Longest length: " + max);
    }
}

'''



***When exactly do you move left?***
>👉 We move left inside a while loop when the set already contains the current right character.
>We keep moving left until the duplicate is removed.

>That “while duplicate exists” part is important.

***When do we update max length?***
>👉 After the window becomes valid (no duplicates), update maxLength = max(maxLength, right - left + 1).

***Time complexity***
>👉 O(n)
Because:
	•	Each character is added once
	•	Each character is removed at most once
Left and right both move only forward.
