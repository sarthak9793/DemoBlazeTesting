
Feature: To check functionality of cart
  Scenario: Opening the cart
    Given The cart button is clickable
    When User clicks on the cart button
    Then Cart page should be opened

  Scenario: Adding product to cart
    Given User is on product details page
    When User adds a product to the cart
    And User accepts the alert
    And User clicks on the cart button
    Then Added product should be visible in the cart

  Scenario: Removing product from cart
    Given User is on product details page
    And User adds a product to the cart
    And User accepts the alert
    And User clicks on the cart button
    When User clicks on delete button of respective product
    Then Product should be removed from cart

  Scenario: Products in cart should not disappear when moving from back and forth from cart to homepage
    Given User is on product details page
    And User adds a product to the cart
    And User accepts the alert
    When User clicks on Home page
    And User clicks on the cart button
    Then Added product should be visible in the cart