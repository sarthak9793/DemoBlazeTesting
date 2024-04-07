
Feature: Visibility of product list
  Scenario: User visits the website and sees the first page of "All Products"
    Then User sees products

  Scenario: Viewing the second page of "All Products"
    When User clicks on the next button
    Then User sees products

  Scenario Outline: Viewing products by category
    When User clicks on the "<category>" category
    Then User sees products

    Examples:
      | category |
      | Phones   |
      | Laptops  |
      | Monitors |