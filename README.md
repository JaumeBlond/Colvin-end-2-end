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
we will take into account what are we testing and who typically performs these test in particular the integration testing, and the end-2-end testing

###Types of Test
It is important to define and specify the difference between this kind of test as it changes technologies and strategies

####end-2-end test
The goal of the end-2-end testing is to verify that all the components and elements are
within the interaction of the user works

####Integration test
The goal for the integration test is to verify the integration of something new within the component is working.
Typically, in a software companies when a new development is completed, the Devs add their Unit test, which verifies
the element works, but not as a whole, so the scope for the integration is to check the correct "Integration" of it.

Selenium has a huge community, and good documentation to build a proper and sustainable framework with the desired language.
Although the learning curve is harder that cypress, any new QA can learn by shadowing a bit from someone more senior.
Even Selenium has some flaky test sometimes this can be solved by maintaining a good page objects declaration

Cypress is a good framework, but it is more focused on the dev side of the QA, meaning that is more suitable to add
that test as an integration test, allowing that either devs or QA engineers can develop easily test within the component.

In the document attached I give a high level overview of both capabilities and specs.

As the goal of this test was to develop a test for a flow of my choose, I decide that using selenium, which is a framework
focused on the testing of the UI and QA focused, so it  was the best choice overall. Also working with selenium allows the 
framework to be suitable for app testing by adding appium.

##Cucumber

The importance of the use of cucumber nowadays relies on the possibility to speak the same language that the business
stakeholders, allowing to discuss if the test are covering all the necessities and being all at the same page.
Also, it is focused to BDD testing, which allows us to mock the user interactions properly. Besides, it is the framework most widely 
used within the QA community.

Cucumber also provides an internal reporting tool where we can identify why the test has failed.

##JAVA
This decision was taken thinking on the test, and the velocity I can get it running, but can be built using several languages 
such as C#, Java, Python, Ruby, JavaScript. The language decision can be changed as long as the framework skeleton for any
lang can be the same.

##TEST SUITE ARCHITECTURE

This kind of architecture is scalable as long as everytime something is added or changed, as the development of it is page-oriented,
meaning for each page that the website/app has it exists different classes defining which steps are done there, which actions can be taken
and which elements are inside. This allows us to encapsulate the code and be highly reusable for the future test.

In this test is not developed but Cucumber allows us to build it inside several CI tools and external utils such as report portals or dockers

##WHO CAN WRITE TEST
The test should be written by the QA assigned to the team/development as is not on the tech development, but it is present in the design of it, it can 
be also done by a developer if he has knowledge on how the framework works and how the different layers are organized.

##WHEN WE SHOULD RUN THE TEST
The test can be runned whenever the teams requires to ensure it is working, when a release is coming or whenever they want to see which are the status of the product. Despite
that, following the CI/CD principles, should be run first time in the morning before the shift start, that makes easy for the
company to track the status of the product and identify easily the errors and how to solve them.

##WHAT HAPPENS IF A TEST FAILS
As we mention in the previous section, following the CI/CD principles, the test is run each morning, so what to do if we find an error? Don't worry it's the goal of
the suite, that means that some QA should go to the report portal or the logs and search what happened, for this to be possible is important to refer to the next section

##WHAT INFORMATION WE HAVE
Loggin properly the errors is as much important and having a healthy and clean suite, this means that each time we make some assertion, or if some step can throw an 
exception, this should be reported and be accessible in the reporting. Cucumber logs the error, but we can add as much information as we can.