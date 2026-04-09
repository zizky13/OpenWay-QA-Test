# Selenium Test Automation Framework

## Overview
This project is a test automation framework built using Java, Selenium, and TestNG.  
It is designed to automate end-to-end testing scenarios for periplus.com web app.

---

## Tech Stack
- Java
- Selenium
- TestNG
- Maven

---

## Prerequisite
- Java (JDK 8+)
- Maven

Verify installation:
```
java -version
mvn -v
```

## Setup Instructions
## Clone the repository
```
git clone https://github.com/zizky13/QA-Test-Periplus.git
cd QA-Test-Periplus
```

## Running Tests
Run all tests:
```
mvn clean test
```
or
```
mvn clean test -DsuiteXmlFile=testng.xml
```

## Configuration
Configuration is managed via a config.properties file.
```
browser=chrome
baseUrl=https://example.com
```

## Notes
•	Ensure stable internet connection when running tests
•	Tests are configured to run on Chrome by default
