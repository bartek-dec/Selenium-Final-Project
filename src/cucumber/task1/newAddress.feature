Feature: Logged in user adds new address and deletes it
  Scenario Outline: Logged in user adds new address and removes it

    Given user logged in to account with first address already defined
    When user goes to Addresses page
    And user clicks Create new address
    And user provides <alias>, <address>, <city>, <postCode>, <country>, <phone> into the form
    And user saves data
    And user deletes recent address
    Then recent address has been removed
    And user logs out
    And user close browser

    Examples:
    |alias|address  |city   |postCode  |country  |phone    |
    |Janek|Address 3|Warsaw |98765     |17       |123456789|