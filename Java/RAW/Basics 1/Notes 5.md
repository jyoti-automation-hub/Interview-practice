
BDD - Behavior Driven Development
application behavior is described in simple, human-readable language so that developers, testers, and business stakeholders can understand the requirements.

2. What is Cucumber?

Cucumber is a BDD automation tool used to execute tests written in Gherkin language.

It connects: Feature File → Step Definitions → Automation Code

3. What is a Feature File?

A feature file contains scenarios written in Gherkin syntax.
Extension:  .feature


4. What are Step Definitions?

Step definitions are Java methods that implement steps written in the feature file.
Example:

Feature file: Given user is on login page

Step definition:
@Given("user is on login page")
public void openLoginPage() {
    driver.get("url");
}

5. Scenario vs Scenario Outline

Scenario	Scenario Outline
Runs once	Runs multiple times
Fixed data	Multiple datasets

6. What is Background in Cucumber?

Background is used to define common steps that run before every scenario in a feature file.

It helps avoid repeating the same steps.

Feature: Login

Background:
Given user launches the application
And user is on login page

Scenario: Valid login
When user enters valid credentials
Then user should login successfully

7. Hooks
Hooks are used to execute setup or teardown logic before or after scenarios.Common use cases include driver initialization, closing browser, taking screenshots on failure, and test cleanup.

8. How do you handle reusable steps?
Best practices:
*   Generic step definitions
*   Page Object Model
*   Utility classes

8. How do you integrate Cucumber with TestNG?
- Using Cucumber TestNG Runner.

9. What are Tags in Cucumber?
- Tags are used to group scenarios and control which tests should run.

@smoke
@regression

10. How do you take screenshots on test failure?
- Usually implemented inside Hooks.

@After
public void takeScreenshot(Scenario scenario) {
    if (scenario.isFailed()) {
        // capture screenshot logic
    }
}
// Screenshots help in debugging failed tests.



