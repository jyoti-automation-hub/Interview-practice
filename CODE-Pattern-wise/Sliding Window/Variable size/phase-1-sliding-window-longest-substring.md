
***🔹 Longest Substring Without Repeating Characters***

***Given a string s, find the length of the longest substring without repeating characters.***

***A substring must be continuous.***

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
