Feature: PersonalPage

  Background: Get colvin page and log in
    Given Setup the browser
    And Hit "thecolvinco.com" on your browser
    And Accept the cookies
    Then a user log-in using valid credentials

  Scenario: Add a date reminder
    When I go to "reminders"
    When i click the "add" button
    And i fill the fields
    And click on submit
    Then the reminder is "added"


  Scenario: Delete a date reminder
    When I go to "reminders"
    When i click the "modify" button
    And i click delete
    Then the reminder is "deleted"

  Scenario: Check my purchases
    When I go to "purchases"
    Then check i don't have purchases
    #If it where a purchase enter, check if data is correct and the order status


  Scenario: Check discounts and use it
    When I go to "discounts"
    And click the use button
    Then i am redirected to the shop with my discount


  Scenario: Recommend colvin using my networks
    When I go to "discounts"
    And click on "twitter" badge
    Then "twitter" is opened


  Scenario: Modify contact information
    When I go to "information"
    And click on modify
    And fill the contact fields
    Then click the save button



  Scenario: Check my subscriptions
    When I go to "subscriptions"
    And Click on subscriptions
    Then i am redirected to the subscription page
    #If it where a subscriptions then enter, check if data is correct and the order status


  Scenario: Close my session
    When I click on sign off
    Then I get to homepage
    When I click on personalpage
    Then the login page is shown





