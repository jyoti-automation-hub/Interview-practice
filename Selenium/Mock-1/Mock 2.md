# SDET Interview Preparation – Core Behavioral & Technical Questions

---

## 1️⃣ Can you describe your experience with automation testing and the tools you’ve used?

I have around 3+ years of QA experience, with hands-on automation experience using **Selenium with Java and TestNG**.

I worked on restructuring and maintaining the automation framework based on the **Page Object Model (POM)** design pattern. My responsibilities included:

- Creating and maintaining page classes  
- Writing and updating regression test cases  
- Handling locator changes due to UI updates  
- Fixing failed test scripts and stabilizing execution  

Most of my work focused on regression automation to ensure stable releases.

We integrated our automation suite with **Jenkins**, so test execution was triggered automatically on code commits.

Additionally, we used:
- **Git** for version control  
- **Maven** for build and dependency management  

---

## 2️⃣ How do you approach creating an optimal test strategy for automation?

My approach is **risk-based and value-driven**.

### Step 1: Understand the Application
- Review application architecture  
- Identify critical business flows  

### Step 2: Select Automation Candidates
I prioritize test cases that are:
- Stable  
- Repetitive  
- High business impact  

### Step 3: Follow Test Pyramid
- More unit/API tests  
- Limited UI tests (as they are slower and more fragile)  

### Additional Considerations:
- Proper framework structure (POM or layered architecture)  
- Reusable utilities  
- Data-driven testing where applicable  
- CI integration from the beginning  

Most importantly, automation should remain maintainable. Over-automation without maintainability increases long-term cost.

---

## 3️⃣ Can you explain your experience with CI/CD and how it impacts testing?

I have worked with **Jenkins pipelines** where automation suites are triggered on every commit or pull request.

### Typical CI Flow:
1. Developer pushes code to Git  
2. Jenkins triggers the build  
3. Maven compiles the project  
4. Automated test suite executes  
5. Reports are generated  
6. Build is marked pass/fail  

### Impact on Testing:
- Early defect detection  
- Faster regression cycles  
- Continuous validation of changes  
- Improved release confidence  

CI/CD enables a **shift-left testing approach**, reducing last-minute surprises.

---

## 4️⃣ What methodologies do you follow in your testing process?

I have primarily worked in **Agile (Scrum)** environments.

### Agile Practices Followed:
- Sprint planning  
- Daily standups  
- Sprint review  
- Retrospective meetings  

Testing is continuous and not treated as a separate phase.

### My Approach:
- Review user stories during backlog grooming  
- Clarify acceptance criteria early  
- Prepare test scenarios in advance  
- Follow risk-based testing  
- Maintain an automation-first mindset for regression  

The goal is close collaboration with developers and early defect identification.

---

# End of Document
