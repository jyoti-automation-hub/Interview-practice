# Behavioral Interview Questions – QA / SDET

---

## 1. Tell me about a conflict with a developer

**Answer:**

Once I raised a defect which the developer initially didn’t agree with, as they couldn’t reproduce it.  
In our daily sync meeting, I walked them through the exact steps and shared my screen with evidence.

I showed the issue live and clarified the expected behavior with PM and QA present.  
After following the correct steps, the developer was able to reproduce and accepted the defect.

This taught me the importance of clear steps, proper evidence, and collaborative discussion instead of arguments.

---

## 2. A bug you missed – what did you do?

**Answer:**

Yes, I had a case where we missed a bug for a *Pencil device* in a repair platform.  
In lower environments we had data for laptop, desktop, watch and other major products, but not for Pencil, so that particular flow was not tested.

When the issue came from production, I first reproduced it in PROD to confirm and checked other products where it was working fine.  
I informed my manager about the data gap in UAT and logged a defect immediately.

After that, we improved our process by requesting data for maximum product types and added this scenario to our regression suite.  
This taught me the importance of data coverage, not just test case coverage.

---

## 3. How do you handle deadline pressure?

**Answer:**

To handle deadline pressure, I plan work from day one by focusing on priority and complexity.  
I attend daily syncs to track progress and identify any blockers early.

I make sure to:
- check my execution status every day  
- report defects and observations transparently to the manager  
- highlight risks if any area is getting delayed  

I aim to complete core testing 1–2 days before the deadline so I have buffer time for functional and exploratory testing.  
This planning and communication help me deliver quality even under tight timelines.

---

## 4. Tell me about a production escape

**Answer:**

There was a production escape where a specific device flow was not tested due to data unavailability in lower environments.  
When the issue was reported from PROD, I first reproduced it to confirm the behavior and verified that other product flows were working fine.

I immediately logged the defect, informed the manager, and performed root cause analysis.  
The main gap identified was limited test data and missing scenario in regression.

As an improvement, I helped in expanding test data coverage and added this flow to the regression suite.  
This experience reinforced the need for end-to-end data and scenario coverage.

---

## 5. How do you handle changing requirements?

**Answer:**

If requirements change in the middle of a sprint, first I inform my manager and the team so everyone is on the same page.  
I review what was already tested based on the old requirement and identify impacted areas.

Then I:
- update test cases according to the new requirement  
- reprioritize execution based on remaining time  
- focus on critical flows first  

I also communicate any risk to the timeline so quality is not compromised.  
This flexibility helps me adapt without missing coverage.

---

### Key Behavioral Principles I Follow

- Ownership instead of blaming  
- Evidence over opinions  
- Clear communication with stakeholders  
- Continuous process improvement  
- Focus on quality even under pressure
