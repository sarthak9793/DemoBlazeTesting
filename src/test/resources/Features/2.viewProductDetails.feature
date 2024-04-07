
Feature: Visibility of product detail
  Scenario Outline: Clicking on products on the first page to see product details
    When User clicks on product <product_number>
    Then Product details for product <product_number> should be visible

    Examples:
      | product_number |
      | 1              |
      | 2              |
      | 3              |
      | 4              |
      | 5              |
      | 6              |
      | 7              |
      | 8              |
      | 9              |
  Scenario Outline: Clicking on products on the second page to see product details
    Given User clicks on the next button
    When User clicks on product <product_number>
    Then Product details for product <product_number> should be visible

    Examples:
      | product_number  |
      | 10              |
      | 11              |
      | 12              |
      | 13              |
      | 14              |
      | 15              |