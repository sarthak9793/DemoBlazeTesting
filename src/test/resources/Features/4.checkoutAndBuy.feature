
Feature: Checkout Functionality

  Scenario: User clicks on place order button with an empty cart
    Given User clicks on the cart button
    When User clicks on the place order button
    Then Place Order popup should not appear

  Scenario: Verify place order popup opens if cart is not empty
    Given User is on product details page
    And User adds a product to the cart
    And User accepts the alert
    And User clicks on the cart button
    When User clicks on the place order button
    Then Place Order popup should appear

  Scenario: User tries to complete purchase with all fields empty
    Given User is on product details page
    And User adds a product to the cart
    And User accepts the alert
    And User clicks on the cart button
    And User clicks on the place order button
    When User clicks on the purchase button
    Then purchase should not be completed

  Scenario: User tries to complete purchase with all fields filled
    Given User is on product details page
    And User adds a product to the cart
    And User accepts the alert
    And User clicks on the cart button
    And User clicks on the place order button
    And User fills all the fields
    When User clicks on the purchase button
    Then purchase should be completed

  Scenario: User tries to complete purchase with only name and credit card
    Given User is on product details page
    And User adds a product to the cart
    And User accepts the alert
    And User clicks on the cart button
    And User clicks on the place order button
    And User only fills name and credit card
    When User clicks on the purchase button
    Then purchase should not be completed

  Scenario: Cart should be empty after completing purchase
    Given User is on product details page
    And User adds a product to the cart
    And User accepts the alert
    And User clicks on the cart button
    And User clicks on the place order button
    And User fills all the fields
    And User clicks on the purchase button
    And purchase should be completed
    And click on OK button on the purchase confirmation dialog
    When User clicks on the cart button
    Then Cart should be empty