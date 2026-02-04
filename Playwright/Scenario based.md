***🎤 Scenario 1***
---
You have 200 Playwright tests, and each test requires login.
How would you design authentication so the test suite is fast and stable?
---

If I have a large test suite, I avoid logging in before every test because it’s slow and flaky.
I log in once, save the authentication using Playwright’s storageState, and reuse it across tests.



---
***🎤 Scenario 1***
---
