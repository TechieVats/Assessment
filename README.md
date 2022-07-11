## API and UI Assessment

This README would normally document whatever steps are necessary to get your application up and running.


## Set up

clone the repository into Intellij IDEA using version control

## Execution
Use TestRunner to execute the test and to generate the reports

### What is this repository for? ###
Assessment for DATACOM

1. BNZ UI Automation
   Test scenarios has been mentioned in the feature file named Bnz.feature,
   implementation for the same is available in: src/test/java/stepdefinition/BnzClient.java
   path for feature file : src/test/resources/features/Bnz.feature
   Browser independent- It can work on any browser- currently working functionality has been coded.
   How to change browser? - Go to Environment.properties files -> Browser=Chrome.
   Docker Implementation : Done, use the selection as DOCKER_CHROME--> Docker Desktop need to be installed into the local machine to run the same.
   Browser Compatible:
   Chrome: Version 103+ (Official Build) (64-bit)
   Firefox: 102.0.1 (64-bit)

2 . JsonPlaceHolder API Automation
Test scenarios has been mentioned in the feature file named APIUsers.feature,
implementation for the same in available in WeatherAPI: src/test/java/StepDefinitions/APIUser.java
path for feature file : src/test/resources/features/APIUsers.feature


## Validations performed

1. Status code validation for each call
2. headers validation for each call
3. Message validation for response wherever required.
4. Applicable assertions has been placed using AssertJ.

## Scnearios Coverage
1. All the scenarios that have been mentioned in the assessment have been completed for both UI and API.


## Coding Standards

1.Reusable functions: Reusable functions has been defined in the "utils" package under "APIUtility.java" and TestingUtility for API and UI automation respectively. To decrease the
complexity of the code.
2.Clean code: to make sure the code should look clean and will be easy to maintain , all the functions has been
named meaningfully to avoid unnecessary comments within the code.

## Logging

log4j2 has been used to perform logging in the framework to showcase the flow the tests which are running.

## Report
report for test execution has been present in report directory under the name Execution.html.

## Configuration
This directory has been created to declare variables globally

## Tools
UI Automation : Selenium
API Automation : Rest Assured
Reporting: Extent Reports
Build Tool: Maven
BDD: Cucumber
IDE: Intellij IDEA
Testing Framework: Junit
Assertion Library: AssertJ
Language : Java
Logging  : log4j2
Browser Support: Chrome,FireFox
CICD: CircleCI
Docker: Implemented

