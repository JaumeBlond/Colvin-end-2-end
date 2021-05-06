@MothersDay
Feature: Delivery promise

  Scenario Outline: Delivery promise works on collections page
    Given Setup the browser
    And Hit "thecolvinco.com/" on your browser in "<Country>"
    And Accept the cookies
    When I click on collection
    Then DP is shown
    When I enter a valid "<CP>" and date
    Then I get a delivery promise output

    Examples:
      | Country | CP    |
      |  it     | 20089 |
      |  de     | 10179 |

  Scenario Outline: Delivery promise on same day collections
    Given Setup the browser
    And Hit "thecolvinco.com/" on your browser in "<Country>"
    And Accept the cookies
    When I click on collection
    Then DP is shown
    When I enter a valid "<CP>" and date today
    Then I get a delivery promise output

    Examples:
      | Country | CP    |
      |  it     | 20089 |
      |  it     | 25100 |

  Scenario Outline: Delivery promise works on product page
    Given Setup the browser
    And Hit "thecolvinco.com/" on your browser in "<Country>"
    And Accept the cookies
    When I click on collection
    Then DP is shown
    And I select a product
    Then The product page loads
    When I enter a valid "<CP>" and date for the product
    Then I get a delivery promise output

    Examples:
      | Country | CP    |
      |  it     | 20089 |
      |  de     | 10179 |
