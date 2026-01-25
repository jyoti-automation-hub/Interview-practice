# Reverse Each Word in a String (Interview-Safe, No Built-in Reverse)

## ❓ Interview Question
Reverse **each word** in a given string **without changing the word order**.  
Do **not** use built-in reverse methods.

**Input**
I am learning Java

**Output**
I ma gninrael avaJ

---

## ✅ Final Answer (Concept + Code)

### 💡 Core Idea
- Break the sentence into words
- Reverse each word **manually using loops**
- Build the final string efficiently

---

## 💻 Complete Working Java Code

```java
public class ReverseEachWord {

    public static void main(String[] args) {

        String s = "I am learning Java";

        // 1) Split sentence into words
        String[] words = s.split(" ");

        // 2) Use StringBuilder for efficient string creation
        StringBuilder result = new StringBuilder();

        // 3) Reverse each word manually
        for (String word : words) {

            // reverse characters of the word
            for (int i = word.length() - 1; i >= 0; i--) {
                result.append(word.charAt(i));
            }

            // add space after each word
            result.append(" ");
        }

        // 4) Convert to String and remove extra space
        System.out.println(result.toString().trim());
    }
}
```
---

## 🧠 Explanation (Interview-Friendly, Simple)

- **split(" ")**  
  Breaks the sentence into individual words so each word can be processed separately.

- **String[] words**  
  Stores all words from the sentence, making it easy to traverse word by word.

- **StringBuilder**  
  Used because `String` is immutable in Java.  

- **Inner for loop**  
  Reverses each word manually by iterating from the last character to the first.  
  No built-in reverse method is used.

- **append()**  
  Adds characters and spaces step by step to build the final reversed sentence efficiently.

- **toString()**  
  Converts the `StringBuilder` object into a normal `String` for output.

- **trim()**  
  Removes the extra space added at the end while building the result.

---
# 
```java
public class ReverseEachWord {

    public static void main(String[] args) {
        String sentence = "Java is fun";
        System.out.println(reverseWords(sentence));
    }

    static String reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        String result = "";

        for (String word : words) {
            String reversed = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                reversed = reversed + word.charAt(i);
            }
            result = result + reversed + " ";
        }

        return result.trim();
    }
}

```
---
