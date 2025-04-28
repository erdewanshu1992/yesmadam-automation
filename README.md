YesMadam Automation Testing

YesMadam Automation Testing is a framework built for automating testing for YesMadam services. It supports both web and mobile testing using Selenium WebDriver, Appium, and various tools to ensure smooth functionality of the mobile app and web services.
Project Overview

This project automates testing for the YesMadam application, which provides beauty and wellness services at home. It uses Appium for mobile testing and Selenium WebDriver for web-based testing. This testing framework is designed to be flexible and scalable for continuous integration.
Features

    Automated testing for web and mobile platforms.

    Page Object Model (POM) structure for better code organization and maintainability.

    Support for both Android and Web environments.

    Easy to extend with additional test cases.

Prerequisites

To run this project, you’ll need the following software installed:

    Java 11 or later

    Maven (for project management)

    Appium (for mobile automation)

    Selenium WebDriver

    Android Studio (for Android testing)

    ChromeDriver (for web testing)

Getting Started

Follow the steps below to set up and run the tests locally.
1. Clone the Repository

git clone https://github.com/erdewanshu1992/yesmadam-automation.git

2. Set Up Environment

Ensure that you have the required environment variables set up:

    JAVA_HOME set to your Java installation.

    ANDROID_HOME set to your Android SDK installation.

    PATH should include chromedriver and other necessary tools.

3. Install Dependencies

Navigate to the project directory and run the following command to install all the required dependencies:

mvn clean install

4. Configure the config.properties file

Edit the config.properties file to set the desired platform (web or mobile) and browser name (chrome, mobile_chrome, etc.):

platform=web
browser=chrome
url=http://your-app-url

5. Run the Tests

To run the tests, use the following Maven command:

mvn test

You can also specify the test suite or specific tests to run by adjusting the Maven command or configuration.
Project Structure

Here’s an overview of the project structure:

yesmadam-automation/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── yesmadam/
│   │   │   │   │   ├── automation/
│   │   │   │   │   │   ├── drivers/
│   │   │   │   │   │   │   ├── ChromeDriver.java
│   │   │   │   │   │   │   ├── AndroidDriver.java
│   │   │   │   │   │   │   └── WebDriverFactory.java
│   │   │   │   │   │   ├── factories/
│   │   │   │   │   │   │   └── DriverFactory.java
│   │   │   │   │   │   ├── pages/
│   │   │   │   │   │   │   ├── BasePage.java
│   │   │   │   │   │   │   ├── HomePage.java
│   │   │   │   │   │   │   └── LoginPage.java
│   │   │   │   │   │   ├── tests/
│   │   │   │   │   │   │   ├── BaseTest.java
│   │   │   │   │   │   │   ├── LoginTest.java
│   │   │   │   │   │   │   └── CartTest.java
│   │   │   │   │   │   ├── utils/
│   │   │   │   │   │   │   ├── ConfigReader.java
│   │   │   │   │   │   │   └── WaitUtils.java
│   │   │   │   │   │   ├── config/
│   │   │   │   │   │   │   ├── config.properties
└── pom.xml

Explanation of Folders:

    drivers: Contains classes to initialize and manage web and mobile drivers.

    tests: Contains test classes, organized by platform (web, mobile).

    pages: Page Object Model (POM) classes that represent different pages/screens in the app.

    utils: Utility classes for handling configuration, WebDriver management, etc.

Contributing

Contributions are welcome! If you have any suggestions or improvements, feel free to fork the repository and create a pull request. Please ensure your code follows the existing code style and includes relevant test cases.