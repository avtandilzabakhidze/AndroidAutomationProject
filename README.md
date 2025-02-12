# MobileTestAutomation

This repository contains an Android automation testing project developed using **Appium** and **Selenium** with **Java**. The project is designed to automate testing for an APK.

## Tools & Technologies Used

- **Appium**: For Android application automation
- **Selenium**: For web interaction automation
- **Java**: Programming language for writing test scripts
- **TestNG**: Test execution framework
- **Allure Report**: For test result visualization

## Prerequisites

To set up the project, ensure the following are installed on your machine:

- **Java Development Kit (JDK)** 17
- **Appium Server**
- **Android SDK**
- **Node.js** (for Appium server dependency)
- **Maven** for project dependency management

Ensure that the Android device or emulator is set up and accessible through `adb`.

## Test Structure

Test cases follow the Page Object Model for better maintainability.
- **Page Classes:** Contain methods related to UI interactions.
- **Test Classes:** Include test cases with assertions.

## Appium Inspector Configuration
```json
{
  "platformName": "Android",
  "appium:platformVersion": "14.0",
  "appium:deviceName": "Android Emulator",
  "appium:app": "C:\\Users\\123\\StudioProjects\\AndroidAutomationProject\\apk\\demo.apk",
  "appium:automationName": "UiAutomator2",
  "appium:appPackage": "com.swaglabsmobileapp",
  "appium:appActivity": "com.swaglabsmobileapp.SplashActivity",
  "appium:appWaitActivity": "com.swaglabsmobileapp.*",
  "appium:appWaitDuration": 30000
}
