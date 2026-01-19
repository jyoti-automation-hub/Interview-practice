# **Scenario Based Manual Testing Questions – Self Service Repair**

---

## **QA Response Blueprint (Common Approach)**

Whenever I see any issue, I follow this standard approach:

1. **Reproduce**
- Try 2–3 times to confirm it is not cache or random issue.

2. **Narrow Down**
- Country specific  
- Browser specific  
- Product or scenario specific  

3. **Evidence Collection**
- Logs, screenshots or video  
- Share on Slack for team verification  

4. **Defect Logging**
- Title with environment details  
- Clear summary  
- Steps to reproduce  
- Actual vs Expected result  
- Test data (login ID, serial, card details)  
- Evidence and logs  

---

## **Scenario 1 – Bank Specific Payment Failure**

**Question:**  
Payment is failing only for one specific bank while other banks are working fine. What will you do?

**Answer:**  
- Reproduce with the same bank 2–3 times and verify other banks work fine  
- Confirm it is bank-specific, not random  

**Then I would:**
- Collect logs and screenshots  
- Share observation on Slack for cross verification  
- Log defect mentioning bank name, environment, steps and data  
- Inform lead and follow up until closure  

---

## **Scenario 2 – Price Mismatch Between Cart & Checkout**

**Question:**  
Price on cart page is different from checkout page. What will you do?

**Answer:**  
- Validate price across product page → cart → checkout → confirmation  
- Check whether issue is:
  - product specific  
  - country specific  
  - quantity specific  

**After confirmation:**
- Collect screenshots and logs  
- Inform team on Slack  
- Raise defect with steps and evidence  
- Identify whether it is pricing service or UI issue  

---

## **Scenario 3 – Works in Chrome but Not in Safari**

**Question:**  
Feature works in Chrome but not in Safari. What will you do?

**Answer:**  
- Reproduce 2–3 times in Safari and compare with Chrome  
- Clear cache and try again  

**Then:**
- Note browser and OS details  
- Ask teammates to verify on their machines  
- If reproducible, raise browser-specific defect with evidence  

---

## **Scenario 4 – Cannot Reproduce Prod Issue in QA**

**Question:**  
Customer reports production issue which you cannot reproduce in QA. What will you do?

**Answer:**  
- Understand QA and PROD data can be different  
- Try to reproduce directly in PROD to confirm  

**If reproducible:**
- Log defect immediately  
- Check RTM coverage for this scenario  
- If missed, write new test cases and add to regression suite  
- Perform root cause analysis to avoid future escapes  

---

## **Scenario 5 – OTP Not Received**

**Question:**  
Login works but user is not receiving OTP on mobile/email.

**Answer:**  
- Reproduce 2–3 times to rule out delay  
- Check if issue is:
  - specific user  
  - specific country  
  - all users  

**Then:**
- Check SMS and email channels  
- Collect logs and screenshots  
- Raise defect with user ID, channel and environment  

---

## **Scenario 6 – Order Confirmation Email Not Received**

**Question:**  
After successful payment, confirmation email is not received.

**Answer:**  
- Confirm order success via “Thank you” page and order ID  
- Wait a few seconds and check spam  
- Try with another email domain  

**Then:**
- Narrow by locale or product  
- Collect logs  
- Raise defect with order ID and email details  

---

## **Scenario 7 – Performance Issue During Peak Hours**

**Question:**  
Checkout is very slow only during peak hours.

**Answer:**  
- Confirm from multiple systems it is not local network  
- Note exact time of slowness  
- Check if all users or specific region  

**Then:**
- Collect network logs  
- Raise defect mentioning peak hours  
- Consider gateway/load issue along with UI  

---

## **Scenario 8 – Release Day P1 Bug**

**Question:**  
On release day a P1 bug is found. What will you do?

**Answer:**  
- Reproduce immediately 2–3 times  
- Inform team for parallel verification  

**Then:**
- Check if flow was tested in lower environments  
- Collect logs quickly  
- Inform manager with full impact  

**Decision:**  
Leadership decides → hotfix / defer / stop release  

---

## **Key Mindset Followed**

- Never assume – always reproduce  
- Narrow before concluding  
- Evidence over opinions  
- Team verification before defect  
- Improve coverage after every escape  

---
