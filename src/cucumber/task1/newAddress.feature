Feature: Logged in user adds new address and deletes it
  Scenario Outline: Logged in user adds new address and removes it

    Given user logged in to account with first address already defined
    When user goes to Addresses page
    And user clicks Create new address
    And user provides <alias>, <address>, <city>, <postCode>, <country>, <phone> into the form
    And user saves data
    Then recent address contains alias <alias>
    And recent address contains address <address>
    And recent address contains city <city>
    And recent address contains postCode <postCode>
    And recent address contains country <country>
    And recent address contains phone <phone>
    And user close browser

    Examples:
    |alias|address  |city   |postCode  |country        |phone    |
    |Johny|Address 3|Gdansk |98765     |United Kingdom |880012390|