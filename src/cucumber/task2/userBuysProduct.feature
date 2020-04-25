Feature: User buys product
  Scenario Outline: Logged in user buys sweater
    Given user logged in to account
    When user goes to all products
    And user chooses product name <productName>
    And discount is 20%
    And user chooses product size <size>
    And user chooses quantity <quantity> of products
    And user adds products to the basket
    And user goes to shopping card
    And user goes to checkout
    And user confirms address
    And user chooses pick up method as pick up in store
    And user chooses payment method as Pay by Check
    And user agrees to the terms of service
    And user chooses order with an obligation to pay option
    And user does a print screen
    And user goes to order history
    Then order status is Awaiting check payment
    And products price conform to price from the basket
    And user logs out from account
    And user close the browser

    Examples:
    |productName                |size|quantity|
    |Hummingbird Printed Sweater|M   |2       |
#    |Hummingbird Printed Sweater|S   |3       |
    |Hummingbird Printed Sweater|L   |2       |
#    |Hummingbird Printed Sweater|XL  |2       |