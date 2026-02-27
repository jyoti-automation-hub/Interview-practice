# 1. HTTP Protocol – Quick Notes?
---
## 1️⃣
HTTP is a protocol used for communication between client and server.

## 2️⃣
An HTTP request consists of: URL, Method, Headers, and optionally Body.

## 3️⃣
The URL can contain path parameters and query parameters.

## 4️⃣
Headers contain metadata like Content-Type and Authorization.

## 5️⃣
Body is mainly used in POST or PUT requests to send JSON data.

---

# 2. Unit Testing vs API Testing

## 1️⃣ Unit Testing
Unit testing is done by developers to test individual methods or functions in isolation.

## 2️⃣ API Testing
API testing is done at service level to validate request-response behavior and business logic.

## 3️⃣ Testing Type
Unit testing is white-box, whereas API testing is mostly black-box.

---

# API – HTTP Response

## Question
What is an HTTP response?

## Short Interview Answer
An HTTP response is the message sent by the server back to the client after processing a request.

It contains a **status code**, **response headers**, and a **response body**.

The status code indicates whether the request was successful, such as 200 for success or 400/500 for errors.

---
# Postman – Adding Validation Points

## Question
How can we add validation points in Postman?

## Short Interview Answer
In Postman, we add validation points inside the **Tests** tab by writing JavaScript using `pm.test()` functions.

After sending the request, Postman executes these validations and shows whether the test passes or fails.

## Example – Validate Status Code 200

```javascript
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

```
---

# API – Server-Side Validation

## Question
What do you understand by server-side validation?

## Short Interview Answer
Server-side validation is the validation performed in the backend after receiving a request from the client.

The server checks whether the input data is valid, complete, and secure before processing it.

If the data is invalid, the server returns an appropriate error response such as 400 Bad Request.

---



