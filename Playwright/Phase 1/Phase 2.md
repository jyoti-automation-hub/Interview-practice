***🎤 Interview Question***
---
***You have 200 Playwright tests. All require login.
How would you handle authentication efficiently?***
---
Solution (storageState idea):
	1.	Login once.
	2.	Save the login session (cookies + storage) to a file.
	3.	For all other tests, start the browser using that saved session.
	4.	Tests start already logged in.

No repeated login.

---

