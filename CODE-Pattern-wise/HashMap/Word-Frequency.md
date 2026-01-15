# Word Frequency (Using HashMap)

## 💻 Java Code

```java
import java.util.HashMap;
import java.util.Map;

public class WordFrequency {

    public static void main(String[] args) {

        String sentence = "hello world hello Java";

        String[] words = sentence.split(" ");
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

```
## 🧠 Explanation

- The input is a **full sentence**, not individual words
- To process each word, we first **split the sentence into words**
- `split(" ")` breaks the sentence wherever there is a space
- A **HashMap** is used to store each word and its frequency

**Example:**

"hello world hello Java"  
→ `["hello", "world", "hello", "Java"]`

**Rule to remember:**
- Characters → `toCharArray()`
- Words → `split(" ")`

---
