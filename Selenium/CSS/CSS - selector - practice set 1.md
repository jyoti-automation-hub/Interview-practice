## 🎯 CSS Selectors 

---

## ✅ Question 1 — ID Selector

### Rule
- **`#` is used for `id`**
- `id` values are **unique** on a page

### 🌐 DOM Structure
```html
<input id="username">
```
---
- #username
- Select the element whose id is username.

---
## ✅ Question 2 — Class Selector (CSS)

### 📜 Rule
- `.` (dot) is used for **class selectors**
- Multiple elements can share the same class

---

### 🌐 DOM Structure
```html
<button class="loginButton">Login</button>
```
---
- .loginButton
- Selects all elements whose class attribute is loginButton.

---

## ✅ Question 3 — Multiple Classes (CSS Selector)

### 📜 Rule
- When an element has **multiple classes**, they are written **space-separated** in HTML.
- In CSS selector:
  - Use **dot (`.`) before each class**
  - **No space** between class names in the selector

---

### 🌐 DOM Structure
```html
<div class="card highlighted">Product Card</div>
```
---
- .card.highlighted

- When an element has multiple classes, I chain them using dots without spaces.
.card.highlighted means the element must have both classes, not just one.

---
## ✅ Question 4 — Tag + Class Selector (CSS)

### 📜 Rule
- A **tag + class selector** is used when you want to be **more specific**
- Format: tag.className

---

### 🌐 DOM Structure
```html
<button class="primaryBtn">Submit</button>
```
---
- button.primaryBtn
---

## ✅ Understanding Tags (Elements) vs Attributes (CSS / XPath Basics)

### ✔ What are Tags / Elements?
Tags (also called **elements**) are the **HTML keywords** that define the structure of the page.

---
### 🌐 Example DOM
```html
<div class="form-block">
  <label for="username">Username</label>
  <input type="text" id="username">
</div>
```
Examples of tag names:
- `div`
- `label`
- `input`

👉 These are the **actual HTML elements**  
👉 They are **NOT written with `@` in XPath**

---

### ✔ What are Attributes?
Attributes provide **additional information** about an element.  
They are written **inside the opening tag** in the format:
-  Attributes Identified
  - div has attribute → class="form-block"
  - label has attribute → for="username"
  - input has attributes → type="text" and id="username"

---

## 🧠 Easy Memory Rule — CSS Attribute Selectors

### 🔑 Symbols You Must Remember

| Symbol | Meaning   | When to Use |
|------|-------------|-------------------------------------------------|
| `=`  | Exact match | When attribute value is fixed                   |
| `*=` | Contains    | When attribute is dynamic but has a stable part |
| `^=` | Starts with | When attribute always starts with same prefix   |
| `$=` | Ends with.  | When attribute always ends with same suffix     |

---

### 📌 Quick Examples

```css
input[id='username']        /* exact match */
input[id*='search']         /* contains */
div[id^='prod']             /* starts with */
span[id$='error']           /* ends with */
```
---

## ✅ Q5 — CSS Attribute Contains Selector (`*=`)
---
### 📜 Rule / Format

```css
tag[attribute*='value']
```
---
- tag → HTML element (recommended for clarity)
- attribute → id, class, name, type, etc.
- 	*= → contains
 -  alue → stable part of the attribute

### 🌐 Example DOM
```html
<input id="search-input-987">
```
---

input[id*='search']

---










