***🎤 Scenario 1***
---
You have 200 Playwright tests, and each test requires login.
How would you design authentication so the test suite is fast and stable?
---

If I have a large test suite, I avoid logging in before every test because it’s slow and flaky.
I log in once, save the authentication using Playwright’s storageState, and reuse it across tests.

---
***🎤 Scenario 2: Multi-User / Multiple Tabs***
---
You’re testing a feature where clicking a link opens a new tab.
The user performs an action in the new tab and then comes back to the original tab.***
---
