# 🎧 TestNG Listeners (ITestListener)

## 📌 Listeners in TestNG
Listeners in TestNG are used to monitor and respond to test execution events during the lifecycle of a test.

---

## ❓ Why do we use Listeners?
We use listeners to:
- 📸 Capture screenshots on test failure
- 📝 Log test execution status
- 📊 Generate customized reports

---

## 🔔 Common Methods in ITestListener
Some important methods are:
- ▶️ `onTestStart()` → Executes when a test starts
- ✅ `onTestSuccess()` → Executes when a test passes
- ❌ `onTestFailure()` → Executes when a test fails
- ⏭️ `onTestSkipped()` → Executes when a test is skipped
- 🏁 `onFinish()` → Executes after all tests are completed

---

## 🧪 Example Use Case
- 📸 Capture a screenshot inside `onTestFailure()`
- 📝 Log test name in `onTestStart()`

---

## 🧩 ITestListener Explanation
ITestListener is basically an interface in TestNG which has some predefined methods.  
Based on the test event, these methods get triggered automatically.

For example, if I want to capture a screenshot when a test fails, I use the `onTestFailure` method.  
Similarly, there are methods for test start and test success.

We just implement this interface in a class and override the required methods.
