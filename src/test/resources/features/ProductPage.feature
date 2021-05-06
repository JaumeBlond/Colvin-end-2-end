Feature: PersonalPage

  Scenario Outline: Product page is loaded
    Given Setup the browser
    And Hit "thecolvinco.com/" on your browser in "<Country>"
    And Accept the cookies
    And I click on collection
    Then DP is shown
    When I select a product
    Then The product page loads

    Examples: Country
      | Country |
      |   it    |
      |   de    |



  Scenario Outline: The components loads according business logic
    Given Setup the browser
    And Hit "thecolvinco.com/" on your browser in "<Country>"
    And Accept the cookies
    When I click on collection
    Then DP is shown
    When I select each product
    Then The product page loads

    Examples: Country
      | Country |
      |   it    |
      |   de    |




