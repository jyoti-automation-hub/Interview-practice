# CI/CD Notes (SDET – Product Company Level)

---

## 1️⃣ Explain the CI/CD pipeline used in your project

**Answer:**

We used Jenkins for CI/CD. After pushing code to GitHub, we triggered the Jenkins pipeline. Jenkins pulled the latest code from the configured branch, built the project, ran automation tests, and marked the build pass or fail based on results.

---

## 2️⃣ What were the stages in your Jenkins pipeline?

**Meaning:**  
Step by step, what happens when Jenkins runs your job.

---

### Jenkins Pipeline Stages (Plain English)

#### ✅ 1. Checkout Stage
- Jenkins pulls the latest code from GitHub  
- From the configured branch  
- Nothing else happens here  

**Meaning:** Get the code

---

#### ✅ 2. Build Stage
- Jenkins builds the project  
- For Java projects, Maven checks:
  - Code compiles
  - Dependencies are correct  

**Meaning:** Make sure the code is buildable

---

#### ✅ 3. Test Stage
- Jenkins runs automation tests  
- Selenium / API / unit tests execute  
- If tests fail → build fails  

**Meaning:** Verify the code using tests

---

## Example: Branch and Jenkins Job Connection

- Code is pushed to the `daily-production` branch  
- A Jenkins job named `daily-production` is created  

**What happens next:**
1. Jenkins job `daily-production` is triggered  
2. Jenkins:
   - Pulls code from the `daily-production` branch (checkout)
   - Builds the project using Maven (build)
   - Runs tests configured for that job (test)

---

## 3️⃣ How did you integrate automation tests into the Jenkins pipeline?

**Answer:**

We push our automation code to GitHub. Jenkins pulls the code and runs the tests using a Maven command. After execution, Jenkins shows the test report and build status.

---

### How does Jenkins run the tests?

**Answer:**

Using a Maven command like `mvn test`.

---

## 4️⃣ What happens if automation tests fail in Jenkins?

**Answer:**

If automation tests fail, Jenkins marks the build as failed and shows the failure in the reports.
