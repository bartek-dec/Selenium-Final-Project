Feature: User can delete his address
  Scenario: User deletes recently created address
    Given user logged in to account having first address already defined
    And user creates another address
    When user deletes recent address
    Then alert showing Address successfully deleted! appears
    And user quits browser