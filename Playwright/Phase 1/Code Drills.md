# 💻 Real-Time Coding Question 1 (Login + Assertion)

## Task:
1. Navigate to login page
2. Enter username and password
3. Click Login
4. Validate that login was successful by checking “Dashboard” is visible

---

## DOM

```html
<input id="username" />
<input id="password" />
<button>Login</button>
<h1>Dashboard</h1>
```

---

## Playwright Java Code

```java
page.navigate("https://app.com/login");

page.fill("#username", "person1");
page.fill("#password", "password123");

page.click("text=Login");

assertTrue(page.locator("text=Dashboard").isVisible());
```

---

# 💻 Real-Time Coding Question 2 (Dynamic Element)

## Scenario:

### DOM:

```html
<button id="loadBtn">Load Profile</button>
<div id="profile" style="display:none;">Welcome User</div>
```

---

## Task:
1. Click Load Profile
2. Validate that “Welcome User” becomes visible
3. Do NOT use Thread.sleep()

---

## Answer

```java
page.click("#loadBtn");

// Auto-wait will handle visibility
assertTrue(page.locator("#profile").isVisible());
```

---

# 📝 Note

## When would you use waitForSelector() instead of just isVisible()?

You normally don’t need waitForSelector() because:
• click()
• fill()
• isVisible()
• expect().toBeVisible()

All auto-wait.

---

## So when do we use waitForSelector()?

You use it when:

### 1️⃣ You are not performing an action immediately, but just waiting for something to appear.

Example:
• Waiting for a loader to disappear  
• Waiting for a background API result to render  

---

### 2️⃣ When you want to wait for a specific state:
• visible  
• hidden  
• attached  
• detached  

---
