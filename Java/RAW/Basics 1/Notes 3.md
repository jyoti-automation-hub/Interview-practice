## RetryAnalyzer (TestNG)

- `RetryAnalyzer` is a **TestNG feature**.
- It **reruns a failed test automatically**.
- We create a **separate class** (for example `RetryAnalyzer.java`) that implements `IRetryAnalyzer`.

# Data-Driven Testing (TestNG)

## 1️⃣ What is Data-Driven Testing?

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

In TestNG, we use DataProvider to implement data-driven testing. It returns data in the form of Object arrays, where each row contains a set of test data, and TestNG passes each row as parameters to the test method.


Object[][] is used because it can hold multiple data types and pass them as parameters to the test method.

## ❓ What will happen if the number of parameters in your test method does NOT match the data returned by DataProvider?

- TestNG will throw an exception at runtime  
- The test will fail due to parameter mismatch  
- Common error: MethodMatcherException
  
## ❓ Can we use DataProvider to run tests in parallel? If yes, how?

- Yes, we can run tests in parallel using DataProvider  

- We set parallel = true in DataProvider  

```java
@DataProvider(parallel = true)
```

---

In my framework, I used data-driven testing mainly in two ways.
First, using TestNG DataProvider, where I passed multiple sets of input data like login credentials to a single test method.
Second, In BDD, I used Scenario Outline to pass different test data from the feature file.

---

## 📌 BDD Scenario Outline (Gherkin Example)

### 🔹 Scenario Outline Example

```gherkin
Feature: Product Repair Selection

Scenario Outline: Select product and repair type
  Given I am on the product page
  When I select product "<product>"
  And I select repair type "<repairType>"
  Then I should see the repair details

Examples:
  | product | repairType |
  | iPhone  | Camera     |
  | iPhone  | Screen     |
  | Samsung | Battery    |
```

---

## 🔹 What’s happening here

- <product> and <repairType> are placeholders  
- Values are provided in the Examples table  
- Each row runs the scenario once with different data  
- This is how data-driven testing is achieved in BDD  

---

## 🔹 How to explain in interview

- Scenario Outline is used in BDD to run the same test with multiple data sets  
- We define placeholders in the steps and provide test data in the Examples table  
- Each row is executed as a separate test case

---

