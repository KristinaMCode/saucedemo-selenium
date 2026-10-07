Feature: Cart

  Background:
    Given the user is on the login page
    When the user logs in "standard" with valid password
    Then the inventory page is displayed

  Scenario: Verify the header
    Then the header is displayed

  Scenario: Add item Backpack to the cart
    When user adds "Sauce Labs Backpack" to the cart
    Then the cart badge shows "1"
    When user opens the cart
    Then the cart page is displayed
    And user verifies "Sauce Labs Backpack" is in the cart
    And the cart page header shows "1" item

  Scenario Outline: Add <number> items to the cart
    When user adds "<items>" to the cart
    Then the cart badge shows "<number>"
    When user opens the cart
    Then the cart page is displayed
    And user verifies "<items>" are in the cart
    And the cart page header shows "<number>" item

    Examples:
      | number | items    |
      | 2      |  Sauce Labs Backpack, Sauce Labs Bike Light  |
