# Exception Handling

## Why try-catch is used?
Try-catch is used to handle runtime exceptions gracefully so that the automation framework does not crash and instead logs the issue properly.

## Where do we use try-catch in automation frameworks?
In our framework, we mainly use try-catch:
- In screenshot handling methods
- In Selenium UI flows, especially while waiting for elements
- While handling dynamic page loading

This helps in preventing runtime failures and improves framework stability.
