# Colvin-end-2-end instructions

## Pre-requisites

These are the pre-requisites for the project setup. You will also need to have your workstation setup accordingly. [This](https://confluence.bskyb.com/pages/viewpage.action?spaceKey=UASG&title=Workstation+Setup) this a useful resource if you are working on a Mac.
- **IntellIj** 
- **Java 11** 
- **Maven**  
- **Lombok Plugin** for your IDE (https://plugins.jetbrains.com/plugin/6317-lombok if using IntelliJ)

# Running Tests
Tests can be executed within your IDE using a TestNG, this has been choose for this technical test only.
Ideally it should be configured using JUNIT and maven.

In order to run the test can be done by configure the test runner within the ide choosing the TestNg
and choosing the test runner class.

It can be also RUN by right clicking at testNG.xml and then click RUN on the option menu

Finally, from the feature file it can be run by clicking the run icon on the left side of the scenario declarations
 
# Tech decisions

##Why Selenium instead of Cypress

In QA is important to identify the different types of testing can be made, and depending on which is the goal of it, so for this decision
we will take in count what are we testing and who typically performs these test in particular the integration testing, and the end-2-end testing

###Types of Test
It is important to define and specify the difference between this kind of test as it changes the technologies and the strategies

####end2end test
The goal of the end 2 end testing is to verify that all the components and elements that are used
within the interaction of the user works

####Integration test
The goal for the integration test is to verify that the integration of something new within the component is working.
Typically, in a software companies when a new development is completed the Devs add their Unit test, which verifies that
the element works, but not as an all, so the scope for the integration is to check the correct "Integration" of it.


As the goal of this test was to develop a test for a flow of my choose I decide that using selenium, which is a framework
focused on testers was the best choice overall.

Selenium has a huge community, and good documentation to build a proper and sustainable framework with the desired language.
Although the learning curve is harder that cypress, any new QA can learn by shadowing a bit from someone more senior.
Even Selenium has some flaky test sometimes this can be solved by maintaining a good page objects declaration

Cypress is a good framework, but it is more focused on the dev side of the QA, meaning that is more suitable to add
that test as an integration test, allowing that either devs or QA engineers can develop easily test within the component.

In the document attached I give a high level overview of both capabilities and specs.

Also working with selenium allows the framework to be suitable for app testing by adding appium.
##Cucumber

The importance of the use of cucumber nowadays relies on the possibility to speak the same language that the business
stakeholders allowing discussing if the test are covering all the necessities and be all at the same page.
Also, it is focused to BDD testing, allowing us to mock the user interactions properly. Besides, is the framework most widely used
within the QA community

Cucumber also provides an internal reporting tool where we can identify why the test has failed.

##JAVA
This decision was taken thinking on the test, and the velocity I can get it running, but can be built using several languages 
such as Python, C#, Java, Python, Ruby, JavaScript. The language decision can be changed as long as the framework skeleton for any
test suite can be the same.

##TEST SUITE ARCHITECTURE

This kind of architecture is scalable as long as everytime something is added or changed as the development is page-oriented
meaning for each page that the website/app has it exist diferent classes defining which steps are done there, which actions can be taken
which elements are inside. This allows us to encapsulate the code and be highly reusable for the future test.

In this test is not developed but Cucumber allows us to build it inside several CI tools and external utils such as report portals or dockers