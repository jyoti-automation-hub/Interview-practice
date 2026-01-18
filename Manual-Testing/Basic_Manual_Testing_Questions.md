# **Basic Manual Testing Questions – Service Repair **

---

## **1. Explain What You Tested in Your Project**

I worked on **Service Repair platform** where customers can purchase genuine parts, rent tools, and perform device repair on their own.  
My role was **Manual and Automation testing** for:
- Ordering flow  
- Compatibility validation  
- Payment processing  
- Return & refund flows  

### Follow-up: *What automation did you do?*

I automated critical regression flows like:
- Serial validation journey  
- Add to cart & checkout  
- Order status tracking  
- Return initiation  

**Tool:** Selenium with Java using Page Object Model.

---

## **2. Tell Me About Your Day-to-Day Activities**

My day-to-day activities were mainly driven by the planned test cases for the release.  
First, I focused on **P1 and high-priority test cases** that cover the end-to-end business flow.

### I validated critical scenarios like:
- User can place a repair order successfully  
- Parts and tools can be added to the cart  
- Pricing is consistent across all pages  
- User is able to create account and proceed to checkout  

If I found any discrepancy:
- I logged defects with proper evidence, screenshots, and logs  
- Tracked defects release-wise in our tracking sheet  
- Followed up with dev until closure  

Along with functional testing, I performed **regression after every build** to ensure existing flows were not impacted.

---

## **3. Tell Me One Critical Defect You Found**

One critical defect I found was in **account creation flow**.  
We use predefined test data like serial numbers, repair IDs, manual IDs, and country-specific user accounts.

During regression:
- I tried creating a new user account instead of existing data  
- System didn’t allow account creation for a specific country locale  
- Raised this as a **P1 defect**

In the same release I also noticed:
- Logout was not working  
- System kept buffering after clicking logout  
- Ordering, pricing, and emails were working fine

---

## **4. How Do You Decide Priority and Severity While Logging a Defect**

**Simple Understanding**
- **Severity = Technical damage**  
- **Priority = Business urgency**

### Approach

- Severity is decided based on how badly the issue impacts the user and application  
- If user is blocked from main action → High Severity  
- Priority is decided from business point of view → how urgently it must be fixed

### Examples

- User not able to create account → **High Severity + High Priority**  
- Logout not working → **Medium Severity + High Priority**  
- UI alignment issue → **Low Severity + Low Priority**

---

## **5. Difference Between Regression and Retesting**

- **Retesting:** Validating the specific defect after fix using same steps and data  
- **Regression:** Testing other related functionalities to ensure the fix has not impacted existing features

---

## **6. How Do You Test a Feature From Scratch**

If I have to test a feature from scratch like **Login**, I first focus on core positive flows.

### Basic Validations
- User can open the login page  
- User can enter valid username and password  
- User is able to login and navigate to home page  

### Negative Scenarios
- Wrong password with correct username  
- Wrong username with correct password  
- Empty fields  
- Button enable/disable behavior  

### Edge & Boundary Cases
- Special characters  
- Max length inputs  
- Session timeout  
- Back button behavior  

**Approach:**  
First confirm core functionality → then negative → then edge cases.

---

## **7. How Do You Write Good Test Cases**

To write good test cases, the first thing is **clear understanding of requirements**.  
Once I understand the requirement deeply, I start identifying scenarios — positive, negative, and edge cases.

### Peer Review Process
- We first discuss requirements as a team  
- Together come up with scenarios  
- Then divide them and write test cases  
- Every 2–3 days we do cross peer review to ensure clarity and coverage  

### Benefits
- Test cases are clear and easy to understand  
- All requirements are covered  
- Everyone is on the same page  

Finally I maintain **traceability** between requirements and test cases so nothing is missed.

---

## **8. How Do You Prioritize Testing When Time Is Less**

When time is less, I prioritize testing based on the **priority of test cases and business impact**.  
In Self Service Repair project we once had a one-week release window for 32 countries.

### Our Approach
- First execute P1 test cases covering core end-to-end flows like ordering, payment, and returns  
- Then cover important P2 scenarios  
- In parallel performed exploratory testing to catch edge cases  

We informed the manager and stakeholders about this plan upfront so everyone was aligned.

Along with manual testing, **existing stable flows were covered through automation**, while new changes were validated manually.

---

## **9. What Do You Do When Requirements Are Not Clear**

When requirements are not clear, the first thing we do is go through the stories in detail as a team.  
Requirements are shared in story format in a common sheet, so we read them together and note down doubts.

### Clarification Process
- Discuss internally with our lead  
- Connect with PM/BA on a call  
- Walk through the doubts and get clarification  

Only after that I start writing scenarios and test cases so there is no misunderstanding.

---

## **10. How Do You Ensure Quality Before Release**

I ensure quality before release by focusing on quality from day one of testing.

### During Execution
- Track defects daily in the tracking sheet  
- Discuss them in sync-up meetings  
- Retest fixes and perform regression  

### Before Release
- Make sure all P1/P2 defects are closed  
- Critical flows are working end-to-end  
- Regression is completed  

Only after that we give **sign-off**.

---

## **11. Explain the Defect Life Cycle**

In our project, defect life cycle starts when I log a defect and assign priority like P1, P2, or P3.

### After Logging
- Defect is assigned to the developer  
- Developer fixes it based on priority  
- Critical defects fixed before release  
- Others may go to next release or hotfix  

Once fixed, the defect comes back to me as the originator.  
I retest it 2–3 times, add evidence and comments, and if everything is fine, I close the defect.

If the issue is still there, I reopen it and assign back to dev.

**Flow:**  
Open → Assigned → Fixed → Retest → Closed / Reopen

---

# **Basic Concepts**

## **12. What is SDLC**

SDLC is the overall process of building software –  
requirement → design → development → testing → release → maintenance.

- Requirement: understanding what user wants  
- Design: planning how the system will be built  
- Development: actual coding  
- Testing: validating the functionality  
- Release: deploying to users  
- Maintenance: support after release

---

## **13. What is STLC**

STLC is the testing part of SDLC.

**Flow:**
1. Understand requirements  
2. Plan testing  
3. Write test cases  
4. Execute tests  
5. Log defects  
6. Closure & sign-off  

---

## **14. What is Manual Testing**

Testing an application without using automation tools,  
verifying features by interacting as a real user.

---

## **15. Black Box Testing**

Black box = testing the application from **user point of view** without looking at code.

---

## **16. White Box Testing**

White box = testing the **internal code and logic**, mostly done by developers.

---

## **17. Regression Testing**

Rechecking existing features to ensure new changes didn’t break them.

---
