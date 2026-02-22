# Stage 1 – Locator Practice (Real DOM Example)

---

## 🧪 Practice DOM

```html
<input id="username" type="text" />
<input id="password" type="password" />
<button>Login</button>
```

---

# 🎯 Task
>	1.	Fill username
>	2.	Fill password
>	3.	Click Login

---
***Ans***
```html
page.fill("#username", "admin");
page.fill("#password", "password123");
page.click("text=Login");
```

---

# Stage 1 – Locator Practice (Placeholder + Text)

## 🧪 Practice DOM

```html
<input type="text" placeholder="Enter email" />
<button>Continue</button>
```

---

# 🎯 Task
>	1.	Type "test@gmail.com" into the input field
>	2.	Click the Continue button

---
page.fill("[placeholder='Enter email']", "test@gmail.com");
page.click("text=Continue");

---
