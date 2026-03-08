## RetryAnalyzer (TestNG)

- `RetryAnalyzer` is a **TestNG feature**.
- It **reruns a failed test automatically**.
- We create a **separate class** (for example `RetryAnalyzer.java`) that implements `IRetryAnalyzer`.

# Data-Driven Testing (TestNG)

## 1️⃣ What is Data-Driven Testing?

### Short Answer

Data-driven testing is a testing approach where **the same test case is executed multiple times with different sets of input data**.

### Example

Instead of writing 3 separate login tests:

```
loginTest_user1
loginTest_user2
loginTest_user3
```

We write **one test** and supply **different data inputs**.

---

# 2️⃣ Where is Test Data Stored?

### Interview Answer

Test data can be stored in external sources such as:

- Excel (Apache POI)
- JSON
- CSV
- Database
- TestNG DataProvider

These sources supply multiple sets of test data to the same test case.

---

# 3️⃣ How Do You Implement Data-Driven Testing in TestNG?

### Expected Interview Answer

In TestNG, we implement data-driven testing using the **@DataProvider** annotation.

The DataProvider returns a **two-dimensional Object array**, and TestNG runs the test method multiple times using the provided data.

---

# Example Implementation

You do **not have to create a separate class** for `@DataProvider`.  
You can define it **inside the same test class**.

```java
public class LoginTest {

    @DataProvider(name="loginData")
    public Object[][] getData() {

        return new Object[][]{
                {"user1", "pass1"},
                {"user2", "pass2"}
        };

    }

    @Test(dataProvider="loginData")
    public void loginTest(String username, String password){

        System.out.println(username + " " + password);

    }

}
```

---


## Interview One-Line Answer

**DataProvider** returns a **two-dimensional `Object[][]` array** where:

- each **row** represents a **test execution**
- each **column** represents **parameters passed to the test method**
