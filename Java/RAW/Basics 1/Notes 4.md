
## Questions

- How do you select test cases for automation?
- How do you handle flaky tests?
- How do you maintain test data?
- How does Jenkins run your automation?

---

# Handling Flaky Tests
—-
If a test becomes flaky, first I try to understand the reason.  
Most of the time it happens because of **unstable locators** or **synchronization issues**.

So I try to:

- Improve the locator strategy
- Add proper **explicit waits**

If the issue is due to temporary environment problems, then I use **RetryAnalyzer** to rerun the failed test.

---

# Q2 — How do you decide which test cases to automate?

Usually I automate the test cases that are part of **regression** and run frequently.

I also prioritize flows that are **very important for the user**, such as:

- Login
- Checkout
- Payment

If the UI keeps changing frequently, I usually avoid automating those tests because the **maintenance effort becomes very high**.


## Q4 — How does Jenkins run your automation tests?

### Human Answer

Jenkins is used to run our automation tests in a **CI/CD pipeline**.

We create a **Jenkins job** that pulls the latest code from **Git**.  
Then Jenkins executes the automation tests using a build tool like **Maven**.

After execution, Jenkins generates **test reports**, where we can see which tests **passed or failed**

## Q8 — What is your Git workflow while working on automation?

### Answer

Usually we work with **feature branches**.

We create a branch for our automation work, commit the changes, and push it to the **remote repository**.  
After code review, we create a **pull request** and merge it into the **main branch**.

### Flow

```
feature branch → commit → push → pull request → merge
```

