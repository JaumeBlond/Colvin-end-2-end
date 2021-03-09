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
    Then a new reminder is added


  Scenario: Delete a date reminder
    When I go to "reminders"
    When i click the "modify" button
    And i click delete
    And click on submit
    Then the reminder is deleted

  Scenario: Check my purchases
    When I go to "purchases"
    #If it where a purchase enter, check if data is correct and the order status


  Scenario: Check discounts and use it
    When I go to "discounts"
    And click the use button
    Then i am redirected to the shop with my discount


  Scenario: Recommend colvin using my networks
    When I go to "discounts"
    And click on "twitter" badge
    Then the RRSS is opened


  Scenario: Modify contact information
    When I go to "information"
    And click on modify
    And fill the contact fields
    And click the save button
    Then when i click again the information is updated



  Scenario: Check my subscriptions
    When I go to "subscriptions"
    #If it where a subscriptions then enter, check if data is correct and the order status


  Scenario: Close my session
    When I click on sign off
    And click on personalpage
    Then the login page is shown





