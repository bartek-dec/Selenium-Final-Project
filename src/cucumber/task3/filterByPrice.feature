Feature: Filter products by price
  Scenario: User can filter products by price
    Given user is on main page
    When user goes to all products page
    And user chooses USD currency
    And user selects price range between 9.00 and 11.00
    Then all filtered products within price range 9.00 and 11.00
    And user quits website
