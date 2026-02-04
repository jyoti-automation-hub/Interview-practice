***🎤 What is Selenium, and what are its main components?***
---
Selenium is an open-source web automation tool used to automate web applications. Its main components are Selenium WebDriver for browser automation, Selenium IDE for record and playback, and Selenium Grid for running tests in parallel across multiple browsers and machines.

---
***🎤What is the difference between Selenium WebDriver and Selenium Grid?***
---
Selenium WebDriver is used to automate browsers and interact with web elements. Selenium Grid is used to run tests in parallel across multiple browsers and machines, which helps reduce execution time and supports cross-browser testing.

---

***🎤What is the difference between findElement() and findElements() in Selenium?***
---
findElement() is used to locate a single web element, and if the element is not found, it throws a NoSuchElementException. findElements() is used to locate multiple elements and returns a list of web elements. If no elements are found, it returns an empty list instead of throwing an exception.

---

***🎤What are implicit wait and explicit wait in Selenium? How are they different?***
---
Implicit wait is applied globally in Selenium it waits for a certain time while locating elements. Explicit wait is used for specific conditions, such as waiting for an element to be visible or clickable before performing an action. 
The main difference is that implicit wait applies to all element searches, while explicit wait is applied only where needed.

---


***🎤Why is Thread.sleep() not recommended in Selenium automation?***
---
Thread.sleep() is not recommended in Selenium because it waits for a fixed amount of time regardless of whether the condition is met earlier. This slows down test execution and can make tests flaky.

> Implicit wait waits up to the given time and continues as soon as the element is found, whereas Thread.sleep always waits for the full time.

---
 Mock 1
 ---
1️⃣ Basics – DONE
2️⃣ Framework & Design ← we start here
3️⃣ Real-world scenarios
4️⃣ Browser & driver management
5️⃣ Wait strategies & exception handling
6️⃣ Parallel execution & stability
7️⃣ Coding / problem-solving
 
