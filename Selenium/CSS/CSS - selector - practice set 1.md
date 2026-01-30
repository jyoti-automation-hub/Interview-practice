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




















